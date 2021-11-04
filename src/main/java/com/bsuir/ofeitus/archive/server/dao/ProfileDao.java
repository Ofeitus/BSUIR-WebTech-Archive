package com.bsuir.ofeitus.archive.server.dao;

import com.bsuir.ofeitus.archive.bean.Profile;

public interface ProfileDao {
    Profile loginProfile(String login, String hash) throws ServerDaoException;
}
