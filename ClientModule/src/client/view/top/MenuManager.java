package client.view.top;

import client.service.listener.LoginListener;
import client.view.ClientMainScreen;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import commons.info.Client;
import commons.info.Mail;
import commons.info.Request;
import commons.info.status.MailStatus;
import commons.info.status.RequestStatus;
import commons.user.CurrentUser;
import commons.view.FrontEnd;
import commons.view.Text;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuManager extends JPanel {
    private static MenuManager instance;

    private final JButton btnRequest;
    private final JButton btnMyClients;
    private final JButton btnLogoff;
    private final JButton btnMail;
    private final JButton btnNewClient;
    private final JButton btnToMain;

    private final JLabel lblRequest = new JLabel();
    private final JLabel lblMail = new JLabel();

    public MenuManager() {
        btnToMain = new JButton();
        btnNewClient = new JButton();
        btnMail = new JButton();
        btnLogoff = new JButton();
        btnMyClients = new JButton();
        btnRequest = new JButton();

        JPanel panel2 = new JPanel();
        JPanel panel1 = new JPanel();

        //======== this ========
        instance = this;
        setBackground(FrontEnd.COLOR_LIGHT);
        setLayout(new GridLayoutManager(2, 3, new Insets(0, 0, 0, 0), 5, 0));

        //======== panel2 ========
        {
            panel2.setBackground(FrontEnd.COLOR_LIGHT);
            panel2.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 1));

            //---- btnRequest ----
            btnRequest.setText(Text.bundle.getString(Text.BUTTON_REQUESTS));
            btnRequest.setBackground(FrontEnd.COLOR_DARK);
            btnRequest.setFont(FrontEnd.FONT_BOLD);
            panel2.add(btnRequest);

            //---- lblRequest ----
            lblRequest.setBorder(new EmptyBorder(0, 5, 0, 0));
            lblRequest.setFont(FrontEnd.FONT_BOLD);
            panel2.add(lblRequest);
        }
        add(panel2, new GridConstraints(0, 0, 1, 1,
                GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                null, null, null));

        //---- btnMyClients ----
        btnMyClients.setText(Text.bundle.getString(Text.BUTTON_MY_CLIENTS));
        btnMyClients.setFont(FrontEnd.FONT_BOLD);
        btnMyClients.setBackground(FrontEnd.COLOR_DARK);
        add(btnMyClients, new GridConstraints(0, 1, 1, 1,
                GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                null, null, null));

        //---- btnLogoff ----
        btnLogoff.setText(Text.bundle.getString(Text.BUTTON_LOGOFF));
        btnLogoff.setFont(FrontEnd.FONT_BOLD);
        btnLogoff.setBackground(FrontEnd.COLOR_DARK);
        add(btnLogoff, new GridConstraints(0, 2, 1, 1,
                GridConstraints.ANCHOR_EAST, GridConstraints.FILL_NONE,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                null, null, null));

        //======== panel1 ========
        {
            panel1.setBackground(FrontEnd.COLOR_LIGHT);
            panel1.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 1));

            //---- btnMail ----
            btnMail.setText(Text.bundle.getString(Text.BUTTON_MAIL));
            btnMail.setFont(FrontEnd.FONT_BOLD);
            btnMail.setBackground(FrontEnd.COLOR_DARK);
            panel1.add(btnMail);

            //---- lblMail ----
            lblMail.setFont(FrontEnd.FONT_BOLD);
            lblMail.setBorder(new EmptyBorder(0, 5, 0, 0));
            panel1.add(lblMail);
        }
        add(panel1, new GridConstraints(1, 0, 1, 1,
                GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                null, null, null));

        //---- btnNewClient ----
        btnNewClient.setText(Text.bundle.getString(Text.BUTTON_NEW_CLIENT));
        btnNewClient.setFont(FrontEnd.FONT_BOLD);
        btnNewClient.setBackground(FrontEnd.COLOR_DARK);
        add(btnNewClient, new GridConstraints(1, 1, 1, 1,
                GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                null, null, null));

        //---- btnToMain ----
        btnToMain.setText(Text.bundle.getString(Text.BUTTON_MAIN));
        btnToMain.setFont(FrontEnd.FONT_BOLD);
        btnToMain.setBackground(FrontEnd.COLOR_DARK);
        add(btnToMain, new GridConstraints(1, 2, 1, 1,
                GridConstraints.ANCHOR_EAST, GridConstraints.FILL_NONE,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                null, null, null));

        btnRequest.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClientMainScreen.showRequestPanel();
            }
        });

        btnMyClients.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClientMainScreen.showClientPanel();
            }
        });

        btnLogoff.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginListener.confirmLogOff();
            }
        });

        btnMail.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClientMainScreen.showMailNewPanel();
            }
        });

        btnNewClient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClientMainScreen.showClientNew();
            }
        });

        btnToMain.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClientMainScreen.loadLogoffMainCard();
            }
        });
    }

    public static void loadMailAndRequests() {
        loadRequests();
        loadMail();
    }

    public static void loadRequests() {
        int requests = 0;
        for (Client client : CurrentUser.manager.clients)
            for (Request request : client.requests)
                if (request.status == RequestStatus.pending)
                    requests++;
        instance.lblRequest.setText(String.valueOf(requests));
    }

    public static void loadMail() {
        int mails = 0;
        for (Client client : CurrentUser.manager.clients)
            for (Mail mail : client.letters)
                if (mail.status == MailStatus.pending)
                    mails++;
        instance.lblMail.setText(String.valueOf(mails));
    }
}