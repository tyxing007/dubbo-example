package com.fansz.access.server;

import com.fansz.access.rpc.RpcInvoker;
import com.fansz.http.server.support.BasicHttpResponder;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpMethod;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.util.Attribute;
import io.netty.util.AttributeKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.net.URI;
import java.nio.charset.Charset;

/**
 * Created by allan on 15/12/5.
 */
@Component
@Sharable
public class HttpRequestRouter extends SimpleChannelInboundHandler<FullHttpRequest> {

    private final String ERROR = "{\"header\": {},\"response\": [{\"method\": \"\",\"status\": \"10008\",\"message\": \"Error parameter format\",\"result\": {}}]}";

    @Resource(name = "dynaDubboInvoker")
    private RpcInvoker rpcInvoker;

    private final AttributeKey<RpcStatistics> STATISTICS = AttributeKey.valueOf("STATISTICS");

    private static final Logger LOG = LoggerFactory.getLogger(HttpRequestRouter.class);

    public HttpRequestRouter() {

    }

    private void initChannelContext(ChannelHandlerContext ctx) {
        Attribute<RpcStatistics> connAttr = ctx.attr(STATISTICS);
        connAttr.set(new RpcStatistics(System.currentTimeMillis()));
    }

    /**
     * 处理接收到的HTTP请求，并进行分发
     *
     * @param ctx
     * @param request HTTP请求对象
     * @throws Exception
     */
    @Override
    public void channelRead0(ChannelHandlerContext ctx, FullHttpRequest request) throws Exception {
        initChannelContext(ctx);
        BasicHttpResponder responder = new BasicHttpResponder(ctx.channel(), HttpHeaders.isKeepAlive(request));
        if (HttpMethod.HEAD.equals(request.getMethod()) || HttpMethod.OPTIONS.equals(request.getMethod())) {
            // HTTP HEAD请求:1、只请求资源的首部；2、检查超链接的有效性；3、检查网页是否被修改；目前主要用于支持nginx的健康检测
            // HTTP OPTIONS请求：1、获取服务器支持的HTTP请求方法。
            // 2、用来检查服务器的性能。例如：AJAX进行跨域请求时的预检，需要向另外一个域名的资源发送一个HTTP OPTIONS请求头，用以判断实际发送的请求是否安全;

            responder.sendStatus(HttpResponseStatus.NO_CONTENT);
        } else {
            // 不支持GET方法
            if (request.getMethod().equals(HttpMethod.GET)) {
                responder.sendStatus(HttpResponseStatus.FORBIDDEN);
            }

            String url = URI.create(request.getUri()).normalize().toString();
            String body = request.content().toString(Charset.forName("UTF-8"));
            String response = rpcInvoker.invoke(url, body);
            responder.sendJson(HttpResponseStatus.OK, response);
        }
    }


    /**
     * 异常时，执行该方法，返回错误信息并关闭连接
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        if (ctx.channel() != null) {
            LOG.error("channel encounters error", cause);
            if (ctx.channel().isActive()) {
                Attribute<RpcStatistics> connAttr = ctx.attr(STATISTICS);
                RpcStatistics statistics = connAttr.get();
                if (statistics != null) {
                    Long received = statistics.getReceived();
                    Long finished = System.currentTimeMillis();
                    LOG.error("received request at {},finished at {},token {} ms", new Object[]{received, finished, finished - received});
                }
                BasicHttpResponder responder = new BasicHttpResponder(ctx.channel(), false);
                responder.sendJson(HttpResponseStatus.OK, ERROR);
            } else {
                ctx.close();
            }
        }
    }

    /**
     * 处理timeout
     */
    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if (IdleStateEvent.class.isAssignableFrom(evt.getClass())) {
            IdleStateEvent event = (IdleStateEvent) evt;
            LOG.warn("close channel for {}", event);
            ctx.close();
        }

    }
}
