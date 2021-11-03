package com.bsuir.ofeitus.archive.server.controller.command.impl;

import com.bsuir.ofeitus.archive.bean.Student;
import com.bsuir.ofeitus.archive.server.controller.command.ServerCommand;
import com.bsuir.ofeitus.archive.server.service.ServerService;
import com.bsuir.ofeitus.archive.server.service.ServerServiceException;
import com.bsuir.ofeitus.archive.server.service.ServerServiceFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetByIdCommand implements ServerCommand {
    @Override
    public String execute(String request) {
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
            String id = params.get("id");
            if (id == null) {
                return "Invalid command parameters\n";
            }
            List<Student> students = serverService.get(id);
            if (students.size() == 0) {
                return "No student with id = " + id + "\n";
            } else {
                for (Student student : serverService.get(id)) {
                    response.append(student.toString()).append("\n");
                }
            }
        } catch (ServerServiceException e) {
            response = new StringBuilder(e.getMessage()).append("\n");
        }

        return response.toString();
    }
}
