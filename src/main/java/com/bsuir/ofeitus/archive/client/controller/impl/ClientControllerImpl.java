package com.bsuir.ofeitus.archive.client.controller.impl;

import com.bsuir.ofeitus.archive.client.controller.ClientController;
import com.bsuir.ofeitus.archive.client.controller.command.ClientCommand;
import com.bsuir.ofeitus.archive.client.controller.command.ClientCommandProvider;

public class ClientControllerImpl implements ClientController {

    @Override
    public String doAction(String request) {
        String commandName;
        commandName = request.split("\\s+")[0];
        ClientCommand command = ClientCommandProvider.getCommand(commandName);
        return command.execute(request);
    }
}
