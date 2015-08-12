package client;

import client.view.ClientMainScreen;

import javax.swing.*;

class ClientApplication {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ClientMainScreen().render();
            }
        });
    }
}