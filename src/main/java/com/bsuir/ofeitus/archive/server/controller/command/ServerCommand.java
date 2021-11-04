package com.bsuir.ofeitus.archive.server.controller.command;

import com.bsuir.ofeitus.archive.bean.Profile;

public interface ServerCommand {
    String execute(String request, Profile profile);
}
