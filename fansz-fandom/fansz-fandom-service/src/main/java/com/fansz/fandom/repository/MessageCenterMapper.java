package com.fansz.fandom.repository;

import com.fansz.fandom.model.messagecenter.MessageCenterResult;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

/**
 * Created by dell on 2015/12/11.
 */
@MapperScan
public interface MessageCenterMapper {

    PageList<MessageCenterResult> getMessageByMemberSn(@Param("memberSn") String memberSn, PageBounds pageBounds);

}
