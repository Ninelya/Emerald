package client.view.top;

import client.service.ConnectionInvoker;
import client.view.ClientMainScreen;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import commons.commands.login.ComGetLogin;
import commons.user.CurrentUser;
import commons.view.FrontEnd;
import commons.view.Text;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuLogOff extends JPanel {
    private static MenuLogOff instance;

    private final JButton btnMain;
    private final JButton btnEnter;
    private final JTextField tfLogin;
    private final JPasswordField pfPass;
    private final JComboBox<String> cbLang;

    public MenuLogOff() {
        pfPass = new JPasswordField();
        tfLogin = new JTextField();
        btnEnter = new JButton();
        btnMain = new JButton();
        cbLang = new JComboBox<>();

        JLabel lblLogin = new JLabel();
        JLabel lblPass = new JLabel();

        //======== this ========
        instance = this;
        setBackground(FrontEnd.COLOR_LIGHT);
        setLayout(new GridLayoutManager(2, 5, new Insets(0, 0, 0, 0), 5, 0));

        //---- btnMain ----
        btnMain.setText(Text.bundle.getString(Text.BUTTON_MAIN));
        btnMain.setBackground(FrontEnd.COLOR_DARK);
        btnMain.setFont(FrontEnd.FONT_BOLD);
        add(btnMain, new GridConstraints(0, 0, 2, 1,
                GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                null, null, null));

        //---- cbLang ----
        cbLang.setFont(FrontEnd.FONT_NORM);
        cbLang.setBackground(FrontEnd.COLOR_LIGHT);
        cbLang.addItem(Text.bundle.getString(Text.LANG_TITLE));
        cbLang.addItem(Text.bundle.getString(Text.LANG_UKR));
        cbLang.addItem(Text.bundle.getString(Text.LANG_RUS));
        cbLang.addItem(Text.bundle.getString(Text.LANG_ENG));
        add(cbLang, new GridConstraints(0, 1, 2, 1,
                GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                null, null, null));

        //---- lblLogin ----
        lblLogin.setText(Text.bundle.getString(Text.LOGIN));
        lblLogin.setFont(FrontEnd.FONT_NORM);
        lblLogin.setHorizontalAlignment(SwingConstants.RIGHT);
        add(lblLogin, new GridConstraints(0, 2, 1, 1,
                GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                GridConstraints.SIZEPOLICY_FIXED,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                null, null, null));

        tfLogin.setFont(FrontEnd.FONT_NORM);
        add(tfLogin, new GridConstraints(0, 3, 1, 1,
                GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                null, FrontEnd.SIZE_TEXT_FIELD, null));

        //---- lblPass ----
        lblPass.setText(Text.bundle.getString(Text.PASSWORD));
        lblPass.setFont(FrontEnd.FONT_NORM);
        lblPass.setHorizontalAlignment(SwingConstants.RIGHT);
        add(lblPass, new GridConstraints(1, 2, 1, 1,
                GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                GridConstraints.SIZEPOLICY_FIXED,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                null, null, null));

        pfPass.setFont(FrontEnd.FONT_NORM);
        add(pfPass, new GridConstraints(1, 3, 1, 1,
                GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                null, FrontEnd.SIZE_TEXT_FIELD, null));

        //---- btnEnter ----
        btnEnter.setText(Text.bundle.getString(Text.BUTTON_ENTER));
        btnEnter.setBackground(FrontEnd.COLOR_DARK);
        btnEnter.setFont(FrontEnd.FONT_BOLD);
        add(btnEnter, new GridConstraints(0, 4, 2, 1,
                GridConstraints.ANCHOR_EAST, GridConstraints.FILL_NONE,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                null, null, null));

        btnEnter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = tfLogin.getText();
                String pass = new String(pfPass.getPassword());
                if (email.isEmpty() || pass.isEmpty())
                    ClientMainScreen.showMessage(
                            Text.bundle.getString(Text.ENTER_LOGIN_AND_PASS));
                else
                    ConnectionInvoker.invoke(new ComGetLogin(email, pass));
                if (CurrentUser.isNotAdmin())
                    btnMain.doClick();
            }
        });

        cbLang.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox cb = (JComboBox) e.getSource();
                int index = cb.getSelectedIndex();
                Text.setBundle(index);
                tfLogin.requestFocusInWindow();
                cb.setSelectedIndex(FrontEnd.COMBO_ITEM_0);
                ClientMainScreen.instance.update();
            }
        });

        btnMain.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClientMainScreen.loadLogoffMainCard();
            }
        });
    }

    public static void clearFields() {
        instance.tfLogin.setText("");
        instance.pfPass.setText("");
    }
}
