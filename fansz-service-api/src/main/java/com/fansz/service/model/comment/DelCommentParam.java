package com.fansz.service.model.comment;

import com.fansz.common.provider.model.AbstractToken;
import org.codehaus.jackson.annotate.JsonProperty;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
 * 删除评论时传入参数
 */
public class DelCommentParam extends AbstractToken {

    @NotNull
    @JsonProperty("comment_id")
    private Long commentId;

    @NotBlank
    @JsonProperty("commentator_sn")
    private String currentSn;

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    @Override
    public String getCurrentSn() {
        return currentSn;
    }

    @Override
    public void setCurrentSn(String currentSn) {
        this.currentSn = currentSn;
    }
}
