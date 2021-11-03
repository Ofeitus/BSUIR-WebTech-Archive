package com.bsuir.ofeitus.archive.server.controller.command.impl;

import com.bsuir.ofeitus.archive.bean.Student;
import com.bsuir.ofeitus.archive.server.controller.command.ServerCommand;
import com.bsuir.ofeitus.archive.server.service.ServerService;
import com.bsuir.ofeitus.archive.server.service.ServerServiceException;
import com.bsuir.ofeitus.archive.server.service.ServerServiceFactory;

import java.util.List;

public class GetAllCommand implements ServerCommand {
    @Override
    public String execute(String request) {
        ServerServiceFactory serviceFactory = ServerServiceFactory.getInstance();
        ServerService serverService = serviceFactory.getServerService();

        StringBuilder response = new StringBuilder();

        try {
            List<Student> students = serverService.getAll();
            if (students.size() == 0) {
                return "No students found\n";
            } else {
                for (Student student : students) {
                    response.append(student.toString()).append("\n");
                }
            }
        } catch (ServerServiceException e) {
            response.append(e.getMessage()).append("\n");
        }

        return response.toString();
    }
}
