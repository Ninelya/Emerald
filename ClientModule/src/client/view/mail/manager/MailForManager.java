package client.view.mail.manager;


import client.service.ConnectionInvoker;
import client.view.mail.support.MailPanel;
import commons.commands.mail.ComSendMailFromManager;
import commons.info.Client;
import commons.info.Mail;
import commons.view.Text;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MailForManager extends MailPanel {
    private static MailForManager instance;
    private Client client;

    public MailForManager() {
        instance = this;
        lblNew.setText(Text.bundle.getString(Text.NEW_ANSWER));
        btnDown.doClick();

        btnSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ConnectionInvoker.invoke(new ComSendMailFromManager(new Mail(
                        client,
                        instance.taDescript.getText()
                )));
            }
        });
    }

    public static void loadPanel(Client client) {
        instance.client = client;
        instance.lblTitle.setText(
                Text.bundle.getString(Text.MAIL_TO_CLIENT) + " " +
                        Text.bundle.getString(Text.DASH) + " " + client.name
        );
        instance.pOldMessages.removeAll();
        instance.taDescript.setText("");

        for (Mail mail : client.letters) {
            if (mail.status.isAnswer())
                instance.pOldMessages.add(new MessManagerForManager(mail.text));
            else
                instance.pOldMessages.add(new MessClientForManager(mail.text));
        }
        instance.pOldMessages.updateUI();
        instance.btnDown.doClick();
    }
}
