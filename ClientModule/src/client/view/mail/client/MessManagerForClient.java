package client.view.mail.client;

import client.view.mail.support.MessManager;
import commons.view.Text;

class MessManagerForClient extends MessManager {

    public MessManagerForClient(String message) {

        lblTitle.setText(Text.bundle.getString(Text.MANAGER_ANSWER));
        taManager.setText(message);
    }
}