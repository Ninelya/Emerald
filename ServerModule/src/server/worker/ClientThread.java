package server.worker;

import commons.commands.support.Command;
import server.service.CommandsService;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientThread implements Runnable {
    private final Socket clientSocket;

    public ClientThread(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try (ObjectInputStream inputStream =
                     new ObjectInputStream(new BufferedInputStream(clientSocket.getInputStream()));
             ObjectOutputStream outputStream =
                     new ObjectOutputStream(new BufferedOutputStream(clientSocket.getOutputStream()))
        ) {
            Command command = (Command) inputStream.readObject();

            Object result = CommandsService.handleCommand(command);

            outputStream.writeObject(result);
            outputStream.flush();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}