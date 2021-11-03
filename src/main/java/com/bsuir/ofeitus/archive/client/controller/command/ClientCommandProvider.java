package com.bsuir.ofeitus.archive.client.controller.command;

import com.bsuir.ofeitus.archive.client.controller.command.impl.*;

import java.util.HashMap;
import java.util.Map;

public class ClientCommandProvider {
    private static final Map<String, ClientCommand> commands = new HashMap<>() {{
        put("connect", new ConnectCommand());
        put("getAll", new GetAllCommand());
        put("get", new GetByIdCommand());
        put("add", new AddCommand());
        put("edit", new EditCommand());
    }};

    private ClientCommandProvider() {

    }

    public static ClientCommand getCommand(String commandName) {
        return commands.get(commandName);
    }
}
