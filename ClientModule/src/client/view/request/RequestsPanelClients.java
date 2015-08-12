package client.view.request;

import client.view.ClientMainScreen;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import commons.info.Client;
import commons.info.Request;
import commons.user.CurrentUser;
import commons.view.FrontEnd;
import commons.view.Text;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class RequestsPanelClients extends JPanel {

    private static RequestsPanelClients instance;

    private Client client;

    private final JLabel lblTitle;
    private final JPanel RequestsPanel;
    private final JButton btnProfile;

    public RequestsPanelClients() {
        RequestsPanel = new JPanel();
        lblTitle = new JLabel();
        btnProfile = new JButton();

        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();

        //======== this ========
        instance = this;
        setBackground(Color.white);
        setLayout(new BorderLayout());

        //======== panel1 ========
        {
            panel1.setBackground(FrontEnd.COLOR_DARK);
            panel1.setLayout(new GridLayoutManager(2, 1, new Insets(0, 0, 0, 0), 0, 5, true, false));

            //---- lblTitle ----
            lblTitle.setFont(FrontEnd.FONT_BIG_TITLE);
            lblTitle.setForeground(FrontEnd.COLOR_LIGHT);
            lblTitle.setFont(FrontEnd.FONT_BIG_TITLE);
            lblTitle.setForeground(FrontEnd.COLOR_LIGHT);

            panel1.add(lblTitle, new GridConstraints(0, 0, 1, 1,
                    GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
                    GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                    GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                    null, null, null));

            //======== panel2 ========
            {
                panel2.setBackground(FrontEnd.COLOR_DARK);
                panel2.setLayout(new GridLayoutManager(1, 2, new Insets(0, 0, 5, 0), 0, 0));

                //---- btnProfile ----
                btnProfile.setText(Text.bundle.getString(Text.BUTTON_PROFILE));
                btnProfile.setBackground(FrontEnd.COLOR_LIGHT);
                btnProfile.setFont(FrontEnd.FONT_BOLD);

                panel2.add(btnProfile, new GridConstraints(0, 1, 1, 1,
                        GridConstraints.ANCHOR_EAST, GridConstraints.FILL_NONE,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));
            }
            panel1.add(panel2, new GridConstraints(1, 0, 1, 1,
                    GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
                    GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                    GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                    null, null, null));
        }
        add(panel1, BorderLayout.PAGE_START);

        //======== panel3 ========
        {
            panel3.setLayout(new FlowLayout());
            panel3.setBackground(Color.white);

            //======== RequestsPanel ========
            {
                RequestsPanel.setBackground(Color.white);
                RequestsPanel.setLayout(new BoxLayout(RequestsPanel, BoxLayout.Y_AXIS));
            }
            panel3.add(RequestsPanel);
        }
        add(panel3, BorderLayout.CENTER);

        btnProfile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClientMainScreen.showClientEdit(client);
            }
        });
    }

    private static void setLblTitle(String name) {
        if (CurrentUser.isClient()) {
            instance.btnProfile.setVisible(false);
            instance.lblTitle.setText(Text.bundle.getString(Text.REQUEST_LIST));
        } else {
            instance.btnProfile.setVisible(true);
            instance.lblTitle.setText(Text.bundle.getString(Text.HISTORY_REQUESTS) +
                    " " + Text.bundle.getString(Text.DASH) + " " + name);
        }
    }

    public static void loadPanel(Client client) {
        instance.client = client;
        setLblTitle(client.name);
        instance.RequestsPanel.removeAll();
        for (Request request : client.requests) {
            instance.RequestsPanel.add(
                    new RequestSingleClients().loadPanel(request));
            instance.RequestsPanel.add(FrontEnd.emptyPanel());
        }
    }
}