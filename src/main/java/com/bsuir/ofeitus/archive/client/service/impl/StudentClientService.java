package com.bsuir.ofeitus.archive.client.service.impl;

import com.bsuir.ofeitus.archive.client.service.ClientService;
import com.bsuir.ofeitus.archive.client.service.ServiceException;

import java.io.*;
import java.net.Socket;

public class StudentClientService implements ClientService {
    private DataOutputStream outputStream;
    private DataInputStream inputStream;

    public StudentClientService() {
    }

    public void sendRequest(String request) throws ServiceException {
        try {
            outputStream.writeUTF(request);
        } catch (IOException e) {
            throw new ServiceException();
        }
    }

    public String getResponse() throws ServiceException {
        try {
            return inputStream.readUTF();
        } catch (IOException e) {
            throw new ServiceException();
        }
    }

    @Override
    public String connect(String request) throws ServiceException {
        try {
            Socket socket = new Socket("localhost", 7777);
            outputStream = new DataOutputStream(socket.getOutputStream());
            inputStream = new DataInputStream(socket.getInputStream());
            return "Connected to localhost, port 7777";
        } catch (IOException e) {
            throw new ServiceException(e);
        }
    }
}
