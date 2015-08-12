package client.view.mail.manager;

import client.view.mail.support.MessManager;
import commons.view.Text;

class MessManagerForManager extends MessManager {

    public MessManagerForManager(String message) {

        lblTitle.setText(Text.bundle.getString(Text.YOUR_ANSWER));
        taManager.setText(message);
    }
}