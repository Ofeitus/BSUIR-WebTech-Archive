package com.bsuir.ofeitus.archive.server.service.impl;

import com.bsuir.ofeitus.archive.bean.Profile;
import com.bsuir.ofeitus.archive.bean.Rights;
import com.bsuir.ofeitus.archive.server.dao.ServerDaoException;
import com.bsuir.ofeitus.archive.server.dao.StudentDaoFactory;
import com.bsuir.ofeitus.archive.server.service.ProfileServerService;
import com.bsuir.ofeitus.archive.server.service.ServerServiceException;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class ProfileServerServiceImpl implements ProfileServerService {
    @Override
    public Profile loginProfile(String login, String password) throws ServerServiceException {
        try {
            return StudentDaoFactory.getInstance().getProfileDAO().loginProfile(login, getHash(password));
        } catch (ServerDaoException | NoSuchAlgorithmException e) {
            throw new ServerServiceException(e);
        }
    }

    public static String getHash(String password) throws NoSuchAlgorithmException {
        final MessageDigest digest = MessageDigest.getInstance("SHA-256");
        final byte[] hash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
        final StringBuilder hexString = new StringBuilder();
        for (byte b : hash) {
            final String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1)
                hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
