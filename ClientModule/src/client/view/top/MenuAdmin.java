package client.view.top;

import client.service.listener.LoginListener;
import client.view.ClientMainScreen;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import commons.view.FrontEnd;
import commons.view.Text;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuAdmin extends JPanel {
    private static MenuAdmin instance;

    private final JButton btnUsers;
    private final JButton btnNewModer;
    private final JButton btnExit;
    private final JButton btnSystem;

    public MenuAdmin() {
        btnUsers = new JButton();
        btnNewModer = new JButton();
        btnExit = new JButton();
        btnSystem = new JButton();

        //======== this ========
        instance = this;
        setBackground(FrontEnd.COLOR_LIGHT);
        setLayout(new GridLayoutManager(1, 4, new Insets(0, 0, 0, 0), 0, 0, false, false));

        //---- btnUsers ----
        btnUsers.setText(Text.bundle.getString(Text.BUTTON_USERS));
        btnUsers.setBackground(FrontEnd.COLOR_DARK);
        btnUsers.setFont(FrontEnd.FONT_BOLD);
        add(btnUsers, new GridConstraints(0, 0, 1, 1,
                GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                null, null, null));

        //---- btnNewModer ----
        btnNewModer.setText(Text.bundle.getString(Text.BUTTON_NEW_MODER));
        btnNewModer.setBackground(FrontEnd.COLOR_DARK);
        btnNewModer.setFont(FrontEnd.FONT_BOLD);
        add(btnNewModer, new GridConstraints(0, 1, 1, 1,
                GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                null, null, null));

        //---- btnSystem ----
        btnSystem.setText(Text.bundle.getString(Text.BUTTON_SYSTEM));
        btnSystem.setBackground(FrontEnd.COLOR_DARK);
        btnSystem.setFont(FrontEnd.FONT_BOLD);
        add(btnSystem, new GridConstraints(0, 2, 1, 1,
                GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                null, null, null));

        //---- btnExit ----
        btnExit.setText(Text.bundle.getString(Text.BUTTON_LOGOFF));
        btnExit.setBackground(FrontEnd.COLOR_DARK);
        btnExit.setFont(FrontEnd.FONT_BOLD);
        add(btnExit, new GridConstraints(0, 3, 1, 1,
                GridConstraints.ANCHOR_EAST, GridConstraints.FILL_NONE,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                null, null, null));

        btnUsers.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClientMainScreen.showModerPanel();
            }
        });

        btnNewModer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClientMainScreen.showModerNew();
            }
        });

        btnSystem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClientMainScreen.showSettingsEdit();
            }
        });

        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginListener.confirmLogOff();
            }
        });
    }

    public static void clickBtnUsers() {
        instance.btnUsers.doClick();
    }
}