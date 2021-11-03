package com.bsuir.ofeitus.archive.client.service;

public interface ClientService {
    String connect(String request) throws ServiceException;

    void sendRequest(String request) throws ServiceException;

    String getResponse() throws ServiceException;
}
