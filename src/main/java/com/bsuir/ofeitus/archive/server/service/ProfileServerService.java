package com.bsuir.ofeitus.archive.server.service;

import com.bsuir.ofeitus.archive.bean.Profile;

public interface ProfileServerService {
    Profile loginProfile(String login, String password) throws ServerServiceException;
}
