package client.view.mail.manager;

import commons.info.Client;
import commons.info.Mail;
import commons.user.CurrentUser;
import commons.view.FrontEnd;
import commons.view.Text;

import javax.swing.*;
import java.awt.*;

public class MailNewPanel extends JPanel {
    private static MailNewPanel instance;

    private final JPanel pNewMessages;

    public MailNewPanel() {
        pNewMessages = new JPanel();

        JLabel lblTitle = new JLabel();
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();

        //======== this ========
        instance = this;
        setLayout(new BorderLayout());

        //======== panel1 ========
        {
            panel1.setBackground(FrontEnd.COLOR_DARK);
            panel1.setLayout(new FlowLayout());

            //---- lblTitle ----
            lblTitle.setText(Text.bundle.getString(Text.MAIL_LIST));
            lblTitle.setForeground(FrontEnd.COLOR_LIGHT);
            lblTitle.setFont(FrontEnd.FONT_BIG_TITLE);
            panel1.add(lblTitle);

        }
        add(panel1, BorderLayout.NORTH);

        //======== panel2 ========
        {
            panel2.setBackground(Color.white);
            panel2.setLayout(new FlowLayout());
            //======== pNewMessages ========
            {
                pNewMessages.setBackground(Color.white);
                pNewMessages.setLayout(new BoxLayout(pNewMessages, BoxLayout.Y_AXIS));
            }
            panel2.add(pNewMessages);
        }
        add(panel2, BorderLayout.CENTER);
    }

    public static void loadPanel() {
        instance.pNewMessages.removeAll();
        for (Client client : CurrentUser.manager.clients)
            for (Mail mail : client.letters)
                if (mail.status.isPending()) {
                    instance.pNewMessages.add(
                            new MailNewSingle().loadPanel(mail));
                    instance.pNewMessages.add(FrontEnd.emptyPanel());
                }
        instance.pNewMessages.updateUI();
    }
}