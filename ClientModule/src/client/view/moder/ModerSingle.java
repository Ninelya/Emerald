package client.view.moder;


import client.view.ClientMainScreen;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import commons.info.User;
import commons.view.FrontEnd;
import commons.view.Text;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ModerSingle extends JPanel {
    private User user;

    private final JLabel lblName;
    private final JLabel lblEmail;
    private final JLabel lblPassword;
    private final JLabel lblAccess;
    private final JButton btnEdit;

    public ModerSingle() {
        lblName = new JLabel();
        lblAccess = new JLabel();
        lblEmail = new JLabel();
        lblPassword = new JLabel();
        btnEdit = new JButton();

        JLabel label1 = new JLabel();
        JLabel label2 = new JLabel();
        JLabel label3 = new JLabel();
        JLabel label4 = new JLabel();
        JLabel label5 = new JLabel();
        JPanel panelTitle = new JPanel();

        //======== this ========
        {
            setBorder(new LineBorder(FrontEnd.COLOR_DARK));
            setBackground(Color.white);
            setLayout(new GridLayoutManager(5, 3, new Insets(0, 0, 0, 0), 0, 5));


            //======== panelTitle ========
            {
                panelTitle.setBackground(FrontEnd.COLOR_LIGHT);
                panelTitle.setLayout(new GridLayoutManager(1, 2, new Insets(0, 0, 0, 0), 5, 0, true, true));

                //---- label1 ----
                label1.setText(Text.bundle.getString(Text.USER_TEXT));
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
                btnEdit.setForeground(FrontEnd.COLOR_LIGHT);
                btnEdit.setFont(FrontEnd.FONT_BOLD);
                btnEdit.setPreferredSize(FrontEnd.SIZE_BUTTON);
                btnEdit.setBorder(new MatteBorder(0, 1, 1, 0, FrontEnd.COLOR_DARK));
                add(btnEdit, new GridConstraints(0, 1, 1, 1,
                        GridConstraints.ANCHOR_EAST, GridConstraints.FILL_BOTH,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));
            }
            add(panelTitle, new GridConstraints(0, 0, 1, 2,
                    GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
                    GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                    GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                    null, null, null));

            //---- label2 ----
            label2.setText(Text.bundle.getString(Text.CLIENT_FULL_NAME));
            label2.setFont(FrontEnd.FONT_BOLD);
            label2.setBorder(new EmptyBorder(0, 5, 0, 5));
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
            label3.setText(Text.bundle.getString(Text.CLIENT_EMAIL));
            label3.setFont(FrontEnd.FONT_BOLD);
            label3.setBorder(new EmptyBorder(0, 5, 0, 5));
            add(label3, new GridConstraints(2, 0, 1, 1,
                    GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                    GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                    GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                    null, null, null));

            //---- lblEmail ----
            lblEmail.setFont(FrontEnd.FONT_NORM);
            add(lblEmail, new GridConstraints(2, 1, 1, 1,
                    GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                    GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                    GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                    null, null, null));

            //---- label4 ----
            label4.setText(Text.bundle.getString(Text.CLIENT_PASSWORD));
            label4.setFont(FrontEnd.FONT_BOLD);
            label4.setBorder(new EmptyBorder(0, 5, 0, 5));
            add(label4, new GridConstraints(3, 0, 1, 1,
                    GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                    GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                    GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                    null, null, null));

            //---- lblPassword ----
            lblPassword.setFont(FrontEnd.FONT_NORM);
            add(lblPassword, new GridConstraints(3, 1, 1, 1,
                    GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                    GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                    GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                    null, null, null));

            //---- label5 ----
            label5.setText(Text.bundle.getString(Text.CLIENT_ACCESS));
            label5.setFont(FrontEnd.FONT_BOLD);
            label5.setBorder(new EmptyBorder(0, 5, 5, 5));
            add(label5, new GridConstraints(4, 0, 1, 1,
                    GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                    GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                    GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                    null, null, null));

            //---- lblAccess ----
            lblAccess.setFont(FrontEnd.FONT_NORM);
            lblAccess.setBorder(new EmptyBorder(0, 0, 5, 0));
            add(lblAccess, new GridConstraints(4, 1, 1, 1,
                    GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                    GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                    GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                    null, null, null));

            btnEdit.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (user.access.isAdmin())
                        ClientMainScreen.showMessage(
                                Text.bundle.getString(Text.EDIT_BAN_ADMIN));
                    else
                        ClientMainScreen.showModerEdit(user);
                }
            });
        }
    }

    public ModerSingle loadPanel(User user) {
        this.user = user;
        lblName.setText(user.name);
        lblAccess.setText(String.valueOf(user.access));
        lblEmail.setText(user.email);
        lblPassword.setText(user.password);
        return this;
    }
}