package com.fansz.db.model;

import com.fansz.db.entity.User;

/**
 * Created by allan on 15/12/28.
 */
public class FriendInfo extends User{

    private String relationship;

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }
}
