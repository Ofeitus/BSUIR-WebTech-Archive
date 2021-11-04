package com.bsuir.ofeitus.archive.server.service;

import com.bsuir.ofeitus.archive.bean.Profile;
import com.bsuir.ofeitus.archive.server.service.impl.ProfileServerServiceImpl;
import com.bsuir.ofeitus.archive.server.service.impl.StudentServerService;

public class ServerServiceFactory {
    private static final ServerServiceFactory instance = new ServerServiceFactory();

    private final ServerService serverService = new StudentServerService();
    private final ProfileServerService profileServerService = new ProfileServerServiceImpl();

    private ServerServiceFactory() {
    }

    public ServerService getServerService() {
        return serverService;
    }

    public ProfileServerService getProfileServerService() {
        return profileServerService;
    }

    public static ServerServiceFactory getInstance() {
        return instance;
    }
}
