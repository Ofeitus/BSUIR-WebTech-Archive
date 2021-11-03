package com.bsuir.ofeitus.archive.main;

import com.bsuir.ofeitus.archive.client.main.Client;
import com.bsuir.ofeitus.archive.server.main.Server;

public class Main {
    public static void main(String[] args) {
        new Server().start();
        new Client().start();
    }
}
