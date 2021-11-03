package com.bsuir.ofeitus.archive.server.service;


import com.bsuir.ofeitus.archive.server.service.impl.StudentServerService;

public class ServerServiceFactory {
    private static final ServerServiceFactory instance = new ServerServiceFactory();

    private final ServerService serverService = new StudentServerService();

    private ServerServiceFactory() {
    }

    public ServerService getServerService() {
        return serverService;
    }

    public static ServerServiceFactory getInstance() {
        return instance;
    }
}
