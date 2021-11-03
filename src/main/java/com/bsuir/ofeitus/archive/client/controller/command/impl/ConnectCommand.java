package com.bsuir.ofeitus.archive.client.controller.command.impl;

import com.bsuir.ofeitus.archive.client.controller.command.ClientCommand;
import com.bsuir.ofeitus.archive.client.service.ClientService;
import com.bsuir.ofeitus.archive.client.service.ServiceException;
import com.bsuir.ofeitus.archive.client.service.ServiceFactory;

public class ConnectCommand implements ClientCommand {
    @Override
    public String execute(String request) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        ClientService clientService = serviceFactory.getClientService();

        String response;

        try {
            response = clientService.connect(request);
        } catch (ServiceException e) {
            response = e.getMessage();
        }

        return response;
    }
}
