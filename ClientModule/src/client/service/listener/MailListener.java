package client.service.listener;

import client.view.ClientMainScreen;
import client.view.mail.client.MailForClient;
import client.view.mail.manager.MailForManager;
import client.view.mail.manager.MailNewPanel;
import client.view.top.MenuManager;
import commons.commands.mail.RespSendMailFromClient;
import commons.commands.mail.RespSendMailFromManager;
import commons.commands.support.Respond;
import commons.info.Client;
import commons.user.CurrentUser;
import commons.view.Text;

public class MailListener {

    public static void confirmSendMailFromManager(Respond respond) {
        RespSendMailFromManager resp = (RespSendMailFromManager) respond;

        if (resp.isConfirmed) {
            ClientMainScreen.showMessage(
                    Text.bundle.getString(Text.MAIL_ANSWER_IS_ACCEPTED));
            Client client = CurrentUser.manager.clients.get(resp.clientId - 1);

            client.letters = resp.mail;
            MailNewPanel.loadPanel();
            MailForManager.loadPanel(client);
            MenuManager.loadMail();
        } else {
            ClientMainScreen.showMessage(
                    Text.bundle.getString(Text.MAIL_IS_NOT_ACCEPTED));
        }
    }

    public static void confirmSendMailFromClient(Respond respond) {
        RespSendMailFromClient resp = (RespSendMailFromClient) respond;

        if (resp.isConfirmed) {
            ClientMainScreen.showMessage(
                    Text.bundle.getString(Text.MAIL_IS_ACCEPTED));
            CurrentUser.client.letters.add(resp.mail);
            MailForClient.loadPanel();
        } else {
            ClientMainScreen.showMessage(
                    Text.bundle.getString(Text.MAIL_IS_NOT_ACCEPTED));
        }
    }
}