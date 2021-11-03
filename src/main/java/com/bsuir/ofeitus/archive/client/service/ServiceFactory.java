package com.bsuir.ofeitus.archive.client.service;


import com.bsuir.ofeitus.archive.client.service.impl.StudentClientService;

public class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();

    private final ClientService clientService = new StudentClientService();

    private ServiceFactory() {
    }

    public ClientService getClientService() {
        return clientService;
    }

    public static ServiceFactory getInstance() {
        return instance;
    }
}
