package com.fansz.db.entity;


import javax.persistence.*;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;


@Entity
@org.hibernate.annotations.Entity(dynamicInsert = true, dynamicUpdate = true)
@Table(name = "newsfeeds_member_post")
public class NewsfeedsPost implements java.io.Serializable {

    private static final long serialVersionUID = -1709498155978129259L;
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "member_sn")
    private String memberSn;

    @Column(name = "post_content")
    private String postContent;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "post_time")
    private Date postTime;

    @Column(name = "post_title")
    private String postTitle;

    @Column(name = "source_from")
    private String sourceFrom;

    @Column(name = "source_post_id")
    private Long sourcePostId;

    @Column(name = "source_post_type")
    private String sourcePostType;

    @Column(name = "source_fandom_name")
    private String sourceFandomName;

    @Column(name = "source_fandom_avatar_url")
    private String sourceFandomAvatarUrl;

    public NewsfeedsPost() {
    }

    public NewsfeedsPost(String memberSn, String postContent, Date postTime, String postTitle, String sourceFrom, Long sourcePostId) {
        this.memberSn = memberSn;
        this.postContent = postContent;
        this.postTime = postTime;
        this.postTitle = postTitle;
        this.sourceFrom = sourceFrom;
        this.sourcePostId = sourcePostId;
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getMemberSn() {
        return this.memberSn;
    }

    public void setMemberSn(String memberSn) {
        this.memberSn = memberSn;
    }


    public String getPostContent() {
        return this.postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    public Date getPostTime() {
        return this.postTime;
    }

    public void setPostTime(Date postTime) {
        this.postTime = postTime;
    }


    public String getPostTitle() {
        return this.postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }


    public String getSourceFrom() {
        return sourceFrom;
    }

    public void setSourceFrom(String sourceFrom) {
        this.sourceFrom = sourceFrom;
    }

    public Long getSourcePostId() {
        return sourcePostId;
    }

    public void setSourcePostId(Long sourcePostId) {
        this.sourcePostId = sourcePostId;
    }

    public String getSourcePostType() {
        return sourcePostType;
    }

    public void setSourcePostType(String sourcePostType) {
        this.sourcePostType = sourcePostType;
    }

    public String getSourceFandomName() {
        return sourceFandomName;
    }

    public void setSourceFandomName(String sourceFandomName) {
        this.sourceFandomName = sourceFandomName;
    }

    public String getSourceFandomAvatarUrl() {
        return sourceFandomAvatarUrl;
    }

    public void setSourceFandomAvatarUrl(String sourceFandomAvatarUrl) {
        this.sourceFandomAvatarUrl = sourceFandomAvatarUrl;
    }
}


