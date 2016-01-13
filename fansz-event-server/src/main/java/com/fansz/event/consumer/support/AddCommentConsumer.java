package com.fansz.event.consumer.support;

import com.alibaba.fastjson.JSON;
import com.fansz.db.entity.PushComment;
import com.fansz.db.entity.PushPost;
import com.fansz.db.repository.PushCommentDAO;
import com.fansz.event.model.AddCommentEvent;
import com.fansz.event.model.PublishPostEvent;
import com.fansz.event.type.AsyncEventType;
import com.fansz.pub.constant.InformationSource;
import com.fansz.pub.utils.BeanTools;
import com.fansz.pub.utils.DateTools;
import com.fansz.redis.RelationTemplate;
import com.fansz.redis.model.CountListResult;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;

/**
 * 添加评论消费者
 */
@Component("addCommentConsumer")
public class AddCommentConsumer implements IEventConsumer {
    @Autowired
    private PushCommentDAO pushCommentDAO;

    @Resource(name = "relationTemplate")
    private RelationTemplate relationTemplate;

    @Override
    public void onEvent(ConsumerRecord<String, String> record) {
        final AddCommentEvent addCommentEvent = JSON.parseObject(record.value(), AddCommentEvent.class);
        if (InformationSource.NEWSFEEDS.equals(addCommentEvent.getSource())) {//朋友圈的评论
            CountListResult<String> friendList = relationTemplate.listFriend(addCommentEvent.getMemberSn(), 0, FRIEND_LIMIT);
            if (friendList.getTotalCount() == 0) {
                return;
            }
            //推送给朋友
            Date now = DateTools.getSysDate();
            for (String friendSn : friendList.getResult()) {//将回复推送到好友
                PushComment pushComment = new PushComment();
                pushComment.setMemberSn(friendSn);
                pushComment.setPostId(addCommentEvent.getPostId());
                pushComment.setCommentId(addCommentEvent.getCommentId());
                pushComment.setCreatetime(now);
                pushCommentDAO.save(pushComment);
            }

        }
    }

    @Override
    public AsyncEventType getEventType() {
        return AsyncEventType.ADD_COMMENT;
    }
}
