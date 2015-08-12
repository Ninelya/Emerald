package server.service;

import commons.service.ConnectionProps;
import server.view.ServerMainScreen;
import server.worker.ClientThread;

import java.io.Closeable;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ConnectionsManager implements Closeable {

    private final ExecutorService executor = Executors.newFixedThreadPool(ConnectionProps.getClients());
    private boolean isClosed = false;

    public void listenConnections() throws Exception {
        listenConnections(ConnectionProps.getPort());
    }

    void listenConnections(int port) throws Exception {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (!isClosed) {
                ServerMainScreen.log(String.format("Waiting for a client on port '%d'...", port));
                Socket client = serverSocket.accept();
                ServerMainScreen.log("Client is detected!");

                executor.execute(new ClientThread(client));

            }
        } finally {
            executor.awaitTermination(1, TimeUnit.MINUTES);
        }
    }

    @Override
    public void close() throws IOException {
        this.isClosed = true;
    }
}