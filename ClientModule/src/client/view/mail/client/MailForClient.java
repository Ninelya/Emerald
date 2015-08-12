package client.view.mail.client;

import client.service.ConnectionInvoker;
import client.view.mail.support.MailPanel;
import commons.commands.mail.ComSendMailFromClient;
import commons.info.Mail;
import commons.user.CurrentUser;
import commons.view.Text;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MailForClient extends MailPanel {

    private static MailForClient instance;

    public MailForClient() {
        instance = this;
        lblTitle.setText(Text.bundle.getString(Text.MAIL_TO_MANAGER));
        lblNew.setText(Text.bundle.getString(Text.NEW_CLAIM));


        btnSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ConnectionInvoker.invoke(new ComSendMailFromClient(new Mail(
                        CurrentUser.client.id,
                        instance.taDescript.getText()
                )));
            }
        });
    }

    public static void loadPanel() {
        instance.pOldMessages.removeAll();
        instance.taDescript.setText("");
        for (Mail mail : CurrentUser.client.letters) {
            if (mail.status.isAnswer())
                instance.pOldMessages.add(new MessManagerForClient(mail.text));
            else
                instance.pOldMessages.add(new MessClientForClient(mail.text));
        }
        instance.btnDown.doClick();
    }
}