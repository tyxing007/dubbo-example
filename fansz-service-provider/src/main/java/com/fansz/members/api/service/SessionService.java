package com.fansz.members.api.service;

import com.fansz.members.api.entity.UserEntity;
import com.fansz.members.api.model.SessionModel;

import java.util.Map;

/**
 * Created by allan on 15/12/14.
 */
public interface SessionService {

    SessionModel getSession(String accessToken);

    void saveSession(String accessToken, UserEntity user);

    void invalidateSession(String accessToken);
}