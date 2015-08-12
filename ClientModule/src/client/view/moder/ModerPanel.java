package client.view.moder;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import commons.info.User;
import commons.user.CurrentUser;
import commons.view.FrontEnd;
import commons.view.Text;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ModerPanel extends JPanel {
    private static ModerPanel instance;

    private final JComboBox<String> cbAccess;
    private final JPanel usersPanel;
    private final JLabel lblTitle;


    public ModerPanel() {
        cbAccess = new JComboBox<>();
        usersPanel = new JPanel();
        lblTitle = new JLabel();

        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();

        //======== this ========
        instance = this;
        setLayout(new BorderLayout());

        //======== panel2 ========
        {
            panel2.setBackground(FrontEnd.COLOR_DARK);
            panel2.setLayout(new GridLayoutManager(2, 1, new Insets(0, 0, 5, 0), 0, 5));

            //---- lblTitle ----
            lblTitle.setText(Text.bundle.getString(Text.USER_LIST));
            lblTitle.setFont(FrontEnd.FONT_BIG_TITLE);
            lblTitle.setForeground(FrontEnd.COLOR_LIGHT);
            panel2.add(lblTitle, new GridConstraints(0, 0, 1, 1,
                    GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
                    GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                    GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                    null, null, null));

            //---- cbAccess ----
            cbAccess.setBackground(FrontEnd.COLOR_LIGHT);
            cbAccess.setFont(FrontEnd.FONT_NORM);
            cbAccess.addItem(Text.bundle.getString(Text.ACCESS_TYPE));
            cbAccess.addItem(Text.bundle.getString(Text.ACCESS_CLIENT));
            cbAccess.addItem(Text.bundle.getString(Text.ACCESS_MANAGER));
            cbAccess.addItem(Text.bundle.getString(Text.ACCESS_MARKETER));
            cbAccess.addItem(Text.bundle.getString(Text.ACCESS_ADMIN));
            cbAccess.addItem(Text.bundle.getString(Text.ACCESS_ALL));
            panel2.add(cbAccess, new GridConstraints(1, 0, 1, 1,
                    GridConstraints.ANCHOR_EAST, GridConstraints.FILL_NONE,
                    GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                    GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                    null, null, null));
        }
        add(panel2, BorderLayout.NORTH);

        //======== panel1 ========
        panel1.setBackground(Color.white);
        panel1.setLayout(new FlowLayout());
        {
            //======== usersPanel ========
            {
                usersPanel.setBackground(Color.white);
                usersPanel.setLayout(new BoxLayout(usersPanel, BoxLayout.Y_AXIS));
            }
            panel1.add(usersPanel);
        }
        add(panel1, BorderLayout.CENTER);

        cbAccess.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox cb = (JComboBox) e.getSource();
                int index = cb.getSelectedIndex();
                if (index == FrontEnd.COMBO_ITEM_5)
                    loadPanel();
                else
                    filterUsers(cb.getSelectedIndex());

                cb.setSelectedIndex(FrontEnd.COMBO_ITEM_0);
                lblTitle.requestFocusInWindow();
                updateUI();
            }
        });
    }

    public static void loadPanel() {
        instance.usersPanel.removeAll();
        for (User user : CurrentUser.users) {
            instance.usersPanel.add(new ModerSingle().loadPanel(user));
            instance.usersPanel.add(FrontEnd.emptyPanel());
        }
    }

    private static void filterUsers(int accessValue) {
        instance.usersPanel.removeAll();
        for (User user : CurrentUser.users)
            if (user.access.getValue() == accessValue) {
                instance.usersPanel.add(new ModerSingle().loadPanel(user));
                instance.usersPanel.add(FrontEnd.emptyPanel());
            }
    }
}