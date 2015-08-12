package client.view.client;

import client.view.ClientMainScreen;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import commons.info.Client;
import commons.view.FrontEnd;
import commons.view.Text;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClientSingle extends JPanel {
    private Client client;

    private final JLabel lblName;
    private final JLabel lblRequestCount;
    private final JLabel lblPhone;
    private final JLabel lblEmail;
    private final JButton btnRequest;
    private final JButton btnCredit;
    private final JButton btnEdit;

    public ClientSingle() {
        btnRequest = new JButton();
        btnCredit = new JButton();
        btnEdit = new JButton();
        lblEmail = new JLabel();
        lblPhone = new JLabel();
        lblRequestCount = new JLabel();
        lblName = new JLabel();

        JLabel label1 = new JLabel();
        JLabel label2 = new JLabel();
        JLabel label3 = new JLabel();
        JLabel label4 = new JLabel();
        JLabel label5 = new JLabel();
        JPanel panelTitle = new JPanel();
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();

        //======== this ========
        setBackground(Color.white);
        setBorder(new LineBorder(FrontEnd.COLOR_DARK));
        setLayout(new GridLayoutManager(5, 3, new Insets(0, 0, 0, 0), 5, 3, true, false));

        //======== panelTitle ========
        {
            panelTitle.setBackground(FrontEnd.COLOR_LIGHT);
            panelTitle.setLayout(new GridLayoutManager(1, 2, new Insets(0, 0, 0, 0), 5, 0, true, true));

            //---- label1 ----
            label1.setText(Text.bundle.getString(Text.CLIENT_TEXT));
            label1.setFont(FrontEnd.FONT_TITLE);
            label1.setForeground(FrontEnd.COLOR_DARK);
            label1.setPreferredSize(FrontEnd.SIZE_TEXT_FIELD);
            label1.setBorder(new EmptyBorder(0, 5, 0, 5));
            panelTitle.add(label1, new GridConstraints(0, 0, 1, 1,
                    GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL,
                    GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                    GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                    null, null, null));

            //---- btnEdit ----
            btnEdit.setText(Text.bundle.getString(Text.BUTTON_EDIT));
            btnEdit.setBackground(FrontEnd.COLOR_DARK);
            btnEdit.setFont(FrontEnd.FONT_BOLD);
            btnEdit.setForeground(FrontEnd.COLOR_LIGHT);
            btnEdit.setPreferredSize(FrontEnd.SIZE_BUTTON);
            btnEdit.setBorder(new MatteBorder(0, 1, 1, 0, FrontEnd.COLOR_DARK));
            add(btnEdit, new GridConstraints(0, 2, 1, 1,
                    GridConstraints.ANCHOR_EAST, GridConstraints.FILL_BOTH,
                    GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                    GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                    null, null, null));
        }
        add(panelTitle, new GridConstraints(0, 0, 1, 3,
                GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                null, null, null));

        //---- label2 ----
        label2.setText(Text.bundle.getString(Text.CLIENT_FULL_NAME));
        label2.setBorder(new EmptyBorder(0, 5, 0, 5));
        label2.setFont(FrontEnd.FONT_BOLD);
        add(label2, new GridConstraints(1, 0, 1, 1,
                GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                null, null, null));

        //---- lblName ----
        lblName.setFont(FrontEnd.FONT_NORM);
        add(lblName, new GridConstraints(1, 1, 1, 1,
                GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                null, null, null));

        //---- label3 ----
        label3.setText(Text.bundle.getString(Text.REQUESTS_COUNT));
        label3.setBorder(new EmptyBorder(0, 5, 0, 5));
        label3.setFont(FrontEnd.FONT_BOLD);
        add(label3, new GridConstraints(2, 0, 1, 1,
                GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                null, null, null));

        //---- lblRequestCount ----
        lblRequestCount.setFont(FrontEnd.FONT_NORM);
        add(lblRequestCount, new GridConstraints(2, 1, 1, 1,
                GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                null, null, null));

        //---- label4 ----
        label4.setText(Text.bundle.getString(Text.CLIENT_TEL));
        label4.setBorder(new EmptyBorder(0, 5, 0, 5));
        label4.setFont(FrontEnd.FONT_BOLD);
        add(label4, new GridConstraints(3, 0, 1, 1,
                GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                null, null, null));

        //---- lblPhone ----
        lblPhone.setFont(FrontEnd.FONT_NORM);
        add(lblPhone, new GridConstraints(3, 1, 1, 1,
                GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                null, null, null));

        //---- label5 ----
        label5.setText(Text.bundle.getString(Text.CLIENT_EMAIL));
        label5.setBorder(new EmptyBorder(0, 5, 5, 5));
        label5.setFont(FrontEnd.FONT_BOLD);
        add(label5, new GridConstraints(4, 0, 1, 1,
                GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                null, null, null));

        //---- lblEmail ----
        lblEmail.setBorder(new EmptyBorder(0, 0, 5, 0));
        lblEmail.setFont(FrontEnd.FONT_NORM);
        add(lblEmail, new GridConstraints(4, 1, 1, 1,
                GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                null, null, null));

        //======== panel1 ========
        {
            panel1.setLayout(new GridLayoutManager(1, 1, new Insets(3, 0, 5, 5), 0, 0));
            panel1.setBackground(Color.white);

            //---- btnCredit ----
            btnCredit.setText(Text.bundle.getString(Text.BUTTON_CREDITS));
            btnCredit.setBackground(FrontEnd.COLOR_LIGHT);
            btnCredit.setFont(FrontEnd.FONT_BOLD);
            panel1.add(btnCredit, new GridConstraints(0, 0, 1, 1,
                    GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
                    GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                    GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                    null, null, null));
        }
        add(panel1, new GridConstraints(1, 2, 2, 1,
                GridConstraints.ANCHOR_NORTH, GridConstraints.FILL_HORIZONTAL,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                null, null, null));


        //======== panel2 ========
        {
            panel2.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 5, 5), 0, 0));
            panel2.setBackground(Color.white);

            //---- btnRequest ----
            btnRequest.setText(Text.bundle.getString(Text.BUTTON_REQUESTS));
            btnRequest.setBackground(FrontEnd.COLOR_LIGHT);
            btnRequest.setFont(FrontEnd.FONT_BOLD);
            panel2.add(btnRequest, new GridConstraints(0, 0, 1, 1,
                    GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
                    GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                    GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                    null, null, null));
        }
        add(panel2, new GridConstraints(3, 2, 2, 1,
                GridConstraints.ANCHOR_SOUTH, GridConstraints.FILL_HORIZONTAL,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                null, null, null));

        btnEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClientMainScreen.showClientEdit(client);
            }
        });

        btnRequest.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClientMainScreen.showRequestPanelClient(client);
            }
        });

        btnCredit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClientMainScreen.showCreditHistoryPanel(client);
            }
        });
    }

    public ClientSingle loadPanel(Client client) {
        this.client = client;
        lblName.setText(client.name);
        lblRequestCount.setText(String.valueOf(client.requestCount));
        lblPhone.setText(String.valueOf(client.telephone));
        lblEmail.setText(client.email);
        return this;
    }
}