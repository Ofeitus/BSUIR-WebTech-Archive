package com.bsuir.ofeitus.archive.server.controller.command.impl;

import com.bsuir.ofeitus.archive.bean.Profile;
import com.bsuir.ofeitus.archive.server.controller.command.ServerCommand;
import com.bsuir.ofeitus.archive.server.service.ProfileServerService;
import com.bsuir.ofeitus.archive.server.service.ServerServiceException;
import com.bsuir.ofeitus.archive.server.service.ServerServiceFactory;

public class LoginCommand implements ServerCommand {
    @Override
    public String execute(String request, Profile profile) {
        ServerServiceFactory serviceFactory = ServerServiceFactory.getInstance();
        ProfileServerService profileServerService = serviceFactory.getProfileServerService();

        StringBuilder response = new StringBuilder();

        try {
            if (request.split(" ").length < 3) {
                return "Invalid command parameters\n";
            }
            String login = request.split(" ")[1];
            String password = request.split(" ")[2];
            Profile newProfile = profileServerService.loginProfile(login, password);
            profile.setLogin(newProfile.getLogin());
            profile.setPassword(newProfile.getPassword());
            profile.setRights(newProfile.getRights());
            return "Logged in as " + login + ", rights: " + profile.getRights().toString();
        } catch (ServerServiceException e) {
            response.append(e.getMessage()).append("\n");
        }

        return response.toString();
    }
}
