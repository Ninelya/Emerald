package client.view.moder;

import client.service.ConnectionInvoker;
import client.view.ClientMainScreen;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import commons.commands.moder.ComSaveUser;
import commons.info.User;
import commons.info.status.AccessType;
import commons.view.FrontEnd;
import commons.view.Text;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ModerNew extends JPanel {
    private final JTextField tfName;
    private final JTextField tfEmail;
    private final JTextField tfPassword;
    private final JComboBox<String> cbAccess;
    private final JButton btnSave;

    public ModerNew() {
        tfName = new JTextField();
        tfEmail = new JTextField();
        tfPassword = new JTextField();
        cbAccess = new JComboBox<>();
        btnSave = new JButton();

        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();
        JLabel label1 = new JLabel();
        JLabel label2 = new JLabel();
        JLabel label3 = new JLabel();
        JLabel label4 = new JLabel();
        JLabel label5 = new JLabel();

        //======== this ========
        setLayout(new BorderLayout());

        //======== panel2 ========
        {
            panel2.setBackground(FrontEnd.COLOR_DARK);
            panel2.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 5, 0), 0, 5));

            //---- label1 ----
            label1.setText(Text.bundle.getString(Text.USER_NEW));
            label1.setFont(FrontEnd.FONT_BIG_TITLE);
            label1.setForeground(FrontEnd.COLOR_LIGHT);
            panel2.add(label1, new GridConstraints(0, 0, 1, 1,
                    GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
                    GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                    GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                    null, null, null));
        }
        add(panel2, BorderLayout.NORTH);

        //======== panel3 ========
        {
            panel3.setBackground(Color.white);
            panel3.setLayout(new FlowLayout());

            //======== panel4 ========
            {
                panel4.setBorder(new LineBorder(FrontEnd.COLOR_DARK));
                panel4.setBackground(Color.white);
                panel4.setLayout(new GridLayoutManager(5, 2, new Insets(5, 5, 5, 5), -1, -1));

                //---- label2 ----
                label2.setText(Text.bundle.getString(Text.CLIENT_FULL_NAME));
                label2.setFont(FrontEnd.FONT_BOLD);
                panel4.add(label2, new GridConstraints(0, 0, 1, 1,
                        GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //---- tfName ----
                tfName.setFont(FrontEnd.FONT_NORM);
                tfName.setPreferredSize(FrontEnd.SIZE_TEXT_FIELD);
                panel4.add(tfName, new GridConstraints(0, 1, 1, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //---- label3 ----
                label3.setText(Text.bundle.getString(Text.CLIENT_EMAIL));
                label3.setFont(FrontEnd.FONT_BOLD);
                panel4.add(label3, new GridConstraints(1, 0, 1, 1,
                        GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //---- tfEmail ----
                tfEmail.setFont(FrontEnd.FONT_NORM);
                panel4.add(tfEmail, new GridConstraints(1, 1, 1, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //---- label4 ----
                label4.setText(Text.bundle.getString(Text.CLIENT_PASSWORD));
                label4.setFont(FrontEnd.FONT_BOLD);
                panel4.add(label4, new GridConstraints(2, 0, 1, 1,
                        GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //---- tfPassword ----
                tfPassword.setFont(FrontEnd.FONT_NORM);
                panel4.add(tfPassword, new GridConstraints(2, 1, 1, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //---- label5 ----
                label5.setText(Text.bundle.getString(Text.CLIENT_ACCESS));
                label5.setFont(FrontEnd.FONT_BOLD);
                panel4.add(label5, new GridConstraints(3, 0, 1, 1,
                        GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //---- cbAccess ----
                cbAccess.setBackground(Color.white);
                cbAccess.setFont(FrontEnd.FONT_NORM);
                cbAccess.addItem(Text.bundle.getString(Text.ACCESS_MANAGER));
                cbAccess.addItem(Text.bundle.getString(Text.ACCESS_MARKETER));
                panel4.add(cbAccess, new GridConstraints(3, 1, 1, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //---- btnSave ----
                btnSave.setText(Text.bundle.getString(Text.BUTTON_SAVE));
                btnSave.setBackground(FrontEnd.COLOR_DARK);
                btnSave.setFont(FrontEnd.FONT_BOLD);
                panel4.add(btnSave, new GridConstraints(4, 1, 1, 1,
                        GridConstraints.ANCHOR_NORTH, GridConstraints.FILL_HORIZONTAL,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));
            }
            panel3.add(panel4);
        }
        add(panel3, BorderLayout.CENTER);

        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tfName.getText().isEmpty() ||
                        tfEmail.getText().isEmpty() ||
                        tfPassword.getText().isEmpty())
                    ClientMainScreen.showMessage(
                            Text.bundle.getString(Text.ENTER_ALL_FIELDS));
                else {
                    User user = new User(
                            tfName.getText(),
                            tfEmail.getText(),
                            tfPassword.getText(),
                            getAccess(cbAccess.getSelectedIndex()));

                    ConnectionInvoker.invoke(new ComSaveUser(user));
                }
            }
        });
    }

    private static AccessType getAccess(int selectedIndex) {
        switch (selectedIndex) {
            case FrontEnd.COMBO_ITEM_0:
                return AccessType.manager;
            case FrontEnd.COMBO_ITEM_1:
                return AccessType.marketer;
        }
        return null;
    }
}