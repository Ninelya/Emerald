package client.service;

import client.view.ClientMainScreen;
import commons.commands.support.Command;
import commons.commands.support.Respond;
import commons.service.ConnectionProps;
import commons.view.Text;

import java.io.*;
import java.net.Socket;

public class ConnectionInvoker {

    public static void invoke(Command command) {
        try (Socket fromServer = new Socket(ConnectionProps.getHost(), ConnectionProps.getPort());
             ObjectOutputStream outputStream = new ObjectOutputStream(new BufferedOutputStream(
                     fromServer.getOutputStream()));
             BufferedInputStream bufferedInputStream = new BufferedInputStream(
                     fromServer.getInputStream())) {
            outputStream.writeObject(command);
            outputStream.flush();


            //wait for answer from server
            ObjectInputStream inputStream = new ObjectInputStream(bufferedInputStream);
            Respond respond = (Respond) inputStream.readObject();
            ConnectionListener.process(respond);
        } catch (IOException | ClassNotFoundException e) {
            ClientMainScreen.showMessage(
                    Text.bundle.getString(Text.FAILED_CONNECTION));
            e.printStackTrace();
        }
    }
}