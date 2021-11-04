package com.bsuir.ofeitus.archive.server.controller.impl;

import com.bsuir.ofeitus.archive.bean.Profile;
import com.bsuir.ofeitus.archive.server.controller.ServerController;
import com.bsuir.ofeitus.archive.server.controller.command.ServerCommand;
import com.bsuir.ofeitus.archive.server.controller.command.ServerCommandProvider;

public class StudentServerController implements ServerController {

    @Override
    public String doAction(String request, Profile profile) {
        String commandName;
        commandName = request.split("\\s+")[0];
        ServerCommand command = ServerCommandProvider.getCommand(commandName);
        return command.execute(request, profile);
    }
}
