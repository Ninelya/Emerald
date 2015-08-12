package client.view.top;

import client.service.listener.LoginListener;
import client.view.ClientMainScreen;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import commons.info.Credit;
import commons.user.CurrentUser;
import commons.view.FrontEnd;
import commons.view.Text;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MenuClient extends JPanel {
    private static MenuClient instance;

    private final JLabel lblDebt;
    private final JComboBox<String> cbHistory;
    private final JButton btnMail;
    private final JButton btnToMain;
    private final JButton btnLogoff;
    private final JButton btnProfile;
    private final JPanel panel1;

    public MenuClient() {
        panel1 = new JPanel();
        btnProfile = new JButton();
        btnLogoff = new JButton();
        btnToMain = new JButton();
        btnMail = new JButton();
        lblDebt = new JLabel();
        cbHistory = new JComboBox<>();

        JLabel label3 = new JLabel();
        JLabel label5 = new JLabel();

        //======== this ========
        instance = this;
        setBackground(FrontEnd.COLOR_LIGHT);
        setLayout(new GridLayoutManager(2, 3, new Insets(0, 0, 0, 0), 5, 0));

        //---- btnMail ----
        btnMail.setText(Text.bundle.getString(Text.BUTTON_WRITE_MANAGER));
        btnMail.setFont(FrontEnd.FONT_BOLD);
        btnMail.setBackground(FrontEnd.COLOR_DARK);
        add(btnMail, new GridConstraints(0, 0, 1, 1,
                GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                null, null, null));

        //---- btnToMain ----
        btnToMain.setText(Text.bundle.getString(Text.BUTTON_MAIN));
        btnToMain.setFont(FrontEnd.FONT_BOLD);
        btnToMain.setBackground(FrontEnd.COLOR_DARK);
        add(btnToMain, new GridConstraints(0, 1, 1, 1,
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
            panel1.setLayout(new GridLayoutManager(1, 3, new Insets(0, 0, 0, 0), -1, -1));
            panel1.setBorder(new EmptyBorder(0, 5, 0, 0));

            //---- label3 ----
            label3.setText(Text.bundle.getString(Text.TOTAL_DEBT));
            label3.setFont(FrontEnd.FONT_NORM);
            panel1.add(label3, new GridConstraints(0, 0, 1, 1,
                    GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
                    GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                    GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                    null, null, null));

            //---- lblDebt ----
            lblDebt.setFont(FrontEnd.FONT_BIG);
            panel1.add(lblDebt, new GridConstraints(0, 1, 1, 1,
                    GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
                    GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                    GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                    null, null, null));

            //---- label5 ----
            label5.setText(Text.bundle.getString(Text.HRN));
            label5.setFont(FrontEnd.FONT_NORM);
            panel1.add(label5, new GridConstraints(0, 2, 1, 1,
                    GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
                    GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                    GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                    null, null, null));
        }
        add(panel1, new GridConstraints(1, 0, 1, 1,
                GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                null, null, null));

        //---- cbHistory ----

        cbHistory.setBackground(FrontEnd.COLOR_LIGHT);
        cbHistory.setFont(FrontEnd.FONT_NORM);
        cbHistory.addItem(Text.bundle.getString(Text.HISTORY_CLIENT));
        cbHistory.addItem(Text.bundle.getString(Text.HISTORY_CREDITS));
        cbHistory.addItem(Text.bundle.getString(Text.HISTORY_REQUESTS));
        add(cbHistory, new GridConstraints(1, 1, 1, 1,
                GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                null, null, null));

        //---- btnProfile ----
        btnProfile.setText(Text.bundle.getString(Text.BUTTON_PROFILE));
        btnProfile.setFont(FrontEnd.FONT_BOLD);
        btnProfile.setBackground(FrontEnd.COLOR_DARK);
        add(btnProfile, new GridConstraints(1, 2, 1, 1,
                GridConstraints.ANCHOR_EAST, GridConstraints.FILL_NONE,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                null, null, null));

        btnMail.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClientMainScreen.showMailForClient();
            }
        });

        btnToMain.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClientMainScreen.loadLogoffMainCard();
            }
        });

        btnLogoff.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginListener.confirmLogOff();
            }
        });

        btnProfile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClientMainScreen.showClientExpand(CurrentUser.client);
            }
        });

        cbHistory.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox cb = (JComboBox) e.getSource();
                int index = cb.getSelectedIndex();
                switch (index) {
                    case FrontEnd.COMBO_ITEM_1:
                        ClientMainScreen.showCreditHistoryPanel(CurrentUser.client);
                        break;
                    case FrontEnd.COMBO_ITEM_2:
                        ClientMainScreen.showRequestPanelClient(CurrentUser.client);
                        break;
                    default:
                        break;
                }
                cb.setSelectedIndex(FrontEnd.COMBO_ITEM_0);
                lblDebt.requestFocusInWindow();
                panel1.updateUI();
            }
        });
    }

    public static void loadPanel() {
        float fullDebt = 0;
        float payedDebt = 0;

        for (Credit credit : CurrentUser.client.credits) {
            fullDebt += credit.getFullSum();
            payedDebt += credit.getPaymentSum();
        }
        instance.lblDebt.setText(String.valueOf(fullDebt - payedDebt));
    }
}