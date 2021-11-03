package com.bsuir.ofeitus.archive.server.controller.command;

import com.bsuir.ofeitus.archive.server.controller.command.impl.*;

import java.util.HashMap;
import java.util.Map;

public class ServerCommandProvider {
    private static final Map<String, ServerCommand> commands = new HashMap<>() {{
        put("getAll", new GetAllCommand());
        put("get", new GetByIdCommand());
        put("add", new AddCommand());
        put("edit", new EditCommand());
    }};

    private ServerCommandProvider() {

    }

    public static ServerCommand getCommand(String commandName) {
        return commands.get(commandName);
    }
}
