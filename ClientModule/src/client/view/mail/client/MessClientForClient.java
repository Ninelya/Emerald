package client.view.mail.client;

import client.view.mail.support.MessClient;
import commons.view.Text;

class MessClientForClient extends MessClient {

    public MessClientForClient(String message) {

        taClient.setText(message);
        lblTitle.setText(Text.bundle.getString(Text.YOUR_MESSAGE));
    }
}