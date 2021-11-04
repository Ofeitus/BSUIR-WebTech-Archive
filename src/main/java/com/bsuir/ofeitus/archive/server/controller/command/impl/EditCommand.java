package com.bsuir.ofeitus.archive.server.controller.command.impl;

import com.bsuir.ofeitus.archive.bean.Profile;
import com.bsuir.ofeitus.archive.bean.Rights;
import com.bsuir.ofeitus.archive.bean.Student;
import com.bsuir.ofeitus.archive.server.controller.command.ServerCommand;
import com.bsuir.ofeitus.archive.server.service.ServerService;
import com.bsuir.ofeitus.archive.server.service.ServerServiceException;
import com.bsuir.ofeitus.archive.server.service.ServerServiceFactory;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

public class EditCommand implements ServerCommand {
    @Override
    public String execute(String request, Profile profile) {
        if (profile.getRights() == Rights.GUEST) {
            return "Not authorized";
        } else if (profile.getRights() != Rights.ADMIN) {
            return "Not enough rights";
        }

        ServerServiceFactory serviceFactory = ServerServiceFactory.getInstance();
        ServerService serverService = serviceFactory.getServerService();

        Map<String, String> params = new HashMap<>();
        for (String param : request.split("\\s+")) {
            String[] keyValue = param.split("=");
            if (keyValue.length == 2) {
                params.put(keyValue[0], keyValue[1].replaceAll("\"", ""));
            }
        }

        StringBuilder response = new StringBuilder();

        try {
            serverService.edit(new Student(params));
            return "Student edited\n";
        } catch (ServerServiceException | ParseException e) {
            response.append(e.getMessage()).append("\n");
        }

        return response.toString();
    }
}
