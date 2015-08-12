package client.view.mail.manager;

import client.view.mail.support.MessClient;
import commons.view.Text;

class MessClientForManager extends MessClient {

    public MessClientForManager(String message) {

        taClient.setText(message);
        lblTitle.setText(Text.bundle.getString(Text.CLIENT_CLAIM));
    }
}