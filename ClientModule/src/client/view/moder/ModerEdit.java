package client.view.moder;

import client.service.ConnectionInvoker;
import client.view.ClientMainScreen;
import client.view.top.MenuAdmin;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import commons.commands.moder.ComDelManager;
import commons.commands.moder.ComDelUser;
import commons.commands.moder.ComEditUser;
import commons.info.User;
import commons.user.CurrentUser;
import commons.view.FrontEnd;
import commons.view.Text;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ModerEdit extends JPanel {
    private User user;
    private static ModerEdit instance;

    private final JTextField tfName;
    private final JTextField tfEmail;
    private final JTextField tfPassword;
    private final JButton btnDelete;
    private final JButton btnSave;
    private final JLabel lblAccess;
    private final JLabel label6;
    private final JComboBox<String> cbNewManager;
    private boolean denyDeletion = false;

    public ModerEdit() {
        tfName = new JTextField();
        tfEmail = new JTextField();
        tfPassword = new JTextField();
        lblAccess = new JLabel();
        btnSave = new JButton();
        btnDelete = new JButton();
        label6 = new JLabel();
        cbNewManager = new JComboBox<>();

        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();
        JLabel label1 = new JLabel();
        JLabel label2 = new JLabel();
        JLabel label3 = new JLabel();
        JLabel label4 = new JLabel();
        JLabel label5 = new JLabel();

        //======== this ========
        instance = this;
        setLayout(new BorderLayout());

        //======== panel2 ========
        {
            panel2.setBackground(FrontEnd.COLOR_DARK);
            panel2.setLayout(new FlowLayout());

            //---- label1 ----
            label1.setText(Text.bundle.getString(Text.USER_EDIT));
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
                panel4.setLayout(new GridLayoutManager(7, 2, new Insets(5, 5, 5, 5), 0, 5, true, false));

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

                //---- lblAccess ----
                lblAccess.setFont(FrontEnd.FONT_NORM);
                panel4.add(lblAccess, new GridConstraints(3, 1, 1, 1,
                        GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //---- label6 ----
                label6.setText(Text.bundle.getString(Text.NEW_MANAGER));
                label6.setFont(FrontEnd.FONT_BOLD);
                panel4.add(label6, new GridConstraints(4, 0, 1, 1,
                        GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //---- cbNewManager ----
                cbNewManager.setFont(FrontEnd.FONT_NORM);
                cbNewManager.setBackground(Color.white);
                panel4.add(cbNewManager, new GridConstraints(4, 1, 1, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //---- btnSave ----
                btnSave.setText(Text.bundle.getString(Text.BUTTON_SAVE));
                btnSave.setBackground(FrontEnd.COLOR_DARK);
                btnSave.setFont(FrontEnd.FONT_BOLD);
                panel4.add(btnSave, new GridConstraints(5, 1, 1, 1,
                        GridConstraints.ANCHOR_NORTH, GridConstraints.FILL_HORIZONTAL,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //---- btnDelete ----
                btnDelete.setText(Text.bundle.getString(Text.BUTTON_DELETE));
                btnDelete.setBackground(FrontEnd.COLOR_LIGHT);
                btnDelete.setFont(FrontEnd.FONT_BOLD);
                panel4.add(btnDelete, new GridConstraints(6, 1, 1, 1,
                        GridConstraints.ANCHOR_SOUTH, GridConstraints.FILL_HORIZONTAL,
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
                User mod = new User(
                        user.id,
                        tfName.getText(),
                        tfEmail.getText(),
                        tfPassword.getText(),
                        user.access);

                CurrentUser.users.remove(CurrentUser.users.indexOf(user));
                CurrentUser.users.add(mod);
                user = mod;
                ConnectionInvoker.invoke(new ComEditUser(mod));
            }
        });

        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (user.access.isClient() || denyDeletion)
                    ClientMainScreen.showMessage(
                            Text.bundle.getString(Text.EDIT_BAN_DELETE_CLIENT));
                else {
                    int i = ClientMainScreen.showConfirm(
                            Text.bundle.getString(Text.CONFIRM_DELETION),
                            Text.bundle.getString(Text.ARE_YOU_SURE_MODER));
                    if (i == 0) {
                        if (user.access.isManager())
                            ConnectionInvoker.invoke(new ComDelManager(
                                    user.id,
                                    String.valueOf(cbNewManager.getSelectedItem())
                            ));
                        else
                            ConnectionInvoker.invoke(new ComDelUser(user.id));

                        CurrentUser.users.remove(CurrentUser.users.indexOf(user));
                        MenuAdmin.clickBtnUsers();
                    }
                }
            }
        });
    }

    public static void loadPanel(User user) {
        instance.user = user;
        instance.tfName.setText(user.name);
        instance.tfEmail.setText(user.email);
        instance.tfPassword.setText(user.password);
        instance.lblAccess.setText(String.valueOf(user.access));
        instance.label6.setVisible(user.access.isManager());
        instance.cbNewManager.setVisible(user.access.isManager());
        instance.denyDeletion = true;
        for (User us : CurrentUser.users)
            if (us.access.isManager() && !us.email.equals(user.email)) {
                instance.cbNewManager.addItem(us.email);
                instance.denyDeletion = false; //if there is one more manager, then you can delete current
            }
    }
}