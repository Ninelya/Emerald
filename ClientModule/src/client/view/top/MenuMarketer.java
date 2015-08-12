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

public class MenuMarketer extends JPanel {
    private static MenuMarketer instance;

    private final JButton btnHome;
    private final JButton btnLogoff;
    private final JButton btnTariffNew;

    public MenuMarketer() {
        btnHome = new JButton();
        btnLogoff = new JButton();
        btnTariffNew = new JButton();

        //======== this ========
        instance = this;
        setBackground(FrontEnd.COLOR_LIGHT);

        setLayout(new GridLayoutManager(1, 3, new Insets(0, 0, 0, 0), 5, 0));

        //---- btnHome ----
        btnHome.setText(Text.bundle.getString(Text.BUTTON_MAIN));
        btnHome.setFont(FrontEnd.FONT_BOLD);
        btnHome.setBackground(FrontEnd.COLOR_DARK);
        add(btnHome, new GridConstraints(0, 0, 1, 1,
                GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                null, null, null));

        //---- btnTariffNew ----
        btnTariffNew.setText(Text.bundle.getString(Text.BUTTON_NEW_TARIFF));
        btnTariffNew.setFont(FrontEnd.FONT_BOLD);
        btnTariffNew.setBackground(FrontEnd.COLOR_DARK);
        add(btnTariffNew, new GridConstraints(0, 1, 1, 1,
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

        btnHome.addActionListener(new ActionListener() {
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

        btnTariffNew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClientMainScreen.showNewTariff();
            }
        });
    }

    public static void clickBtnHome() {
        instance.btnHome.doClick();
    }
}