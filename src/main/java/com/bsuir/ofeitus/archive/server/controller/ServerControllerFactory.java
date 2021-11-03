package com.bsuir.ofeitus.archive.server.controller;

import com.bsuir.ofeitus.archive.server.controller.impl.StudentServerController;

public class ServerControllerFactory {
    private static final ServerControllerFactory instance = new ServerControllerFactory();

    private final ServerController serverController = new StudentServerController();

    private ServerControllerFactory() {
    }

    public ServerController getServerController() {
        return serverController;
    }

    public static ServerControllerFactory getInstance() {
        return instance;
    }
}
