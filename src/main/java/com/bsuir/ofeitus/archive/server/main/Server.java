package com.bsuir.ofeitus.archive.server.main;

import com.bsuir.ofeitus.archive.server.controller.ServerController;
import com.bsuir.ofeitus.archive.server.controller.ServerControllerFactory;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Thread{

    public void run() {
        ServerSocket server;
        final int port = 7777;
        try {
            server = new ServerSocket(port);
            while (true){
                Socket socket = server.accept();
                ServerThread thread = new ServerThread(socket);
                thread.start();
            }
        } catch (IOException e){
            System.out.println(e.getMessage());
        }

    }
}

class ServerThread extends Thread{
    private final DataOutputStream outputStream;
    private final DataInputStream inputStream;

    public ServerThread(Socket socket) throws IOException {
        outputStream = new DataOutputStream(socket.getOutputStream());
        inputStream = new DataInputStream(socket.getInputStream());
    }

    public  void run() {
        ServerControllerFactory controllerFactory = ServerControllerFactory.getInstance();
        ServerController serverController = controllerFactory.getServerController();

        while (true) {
            try {
                String request;
                request = inputStream.readUTF();
                outputStream.writeUTF(serverController.doAction(request));
            } catch (IOException e) {
                System.out.println(e.getMessage());
                break;
            } finally {
                this.interrupt();
            }
        }
    }
}