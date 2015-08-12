package client.view.settings;

import client.service.listener.SettingsListener;
import client.view.ClientMainScreen;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import commons.info.Props;
import commons.view.FrontEnd;
import commons.view.Text;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsEdit extends JPanel {
    private static SettingsEdit instance;
    private Props properties;

    private final JTextField tfPort;
    private final JTextField tfThread;
    private final JTextField tfHost;
    private final JTextField tfDbUrl;
    private final JTextField tfUserLogin;
    private final JTextField tfPassword;
    private final JButton btnSave;
    private final JButton btnRestore;

    public SettingsEdit() {
        tfPort = new JTextField();
        tfThread = new JTextField();
        tfHost = new JTextField();
        tfDbUrl = new JTextField();
        tfUserLogin = new JTextField();
        tfPassword = new JTextField();
        btnSave = new JButton();
        btnRestore = new JButton();

        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();
        JPanel panel5 = new JPanel();
        JPanel panel6 = new JPanel();
        JPanel panel7 = new JPanel();
        JPanel panel8 = new JPanel();
        JPanel panel9 = new JPanel();

        JLabel lblTitle = new JLabel();
        JLabel label1 = new JLabel();
        JLabel label2 = new JLabel();
        JLabel label3 = new JLabel();
        JLabel label4 = new JLabel();
        JLabel label8 = new JLabel();
        JLabel label5 = new JLabel();
        JLabel label6 = new JLabel();
        JLabel label7 = new JLabel();

        //======== this ========
        instance = this;
        setBackground(Color.white);
        setLayout(new BorderLayout());

        //======== panel1 ========
        {
            panel1.setBackground(FrontEnd.COLOR_DARK);
            panel1.setLayout(new FlowLayout());

            //---- lblTitle ----
            lblTitle.setText(Text.bundle.getString(Text.SETTINGS_EDIT));
            lblTitle.setForeground(FrontEnd.COLOR_LIGHT);
            lblTitle.setFont(FrontEnd.FONT_BIG_TITLE);
            panel1.add(lblTitle);
        }
        add(panel1, BorderLayout.NORTH);

        //======== panel2 ========
        {
            panel2.setBackground(Color.white);
            panel2.setLayout(new FlowLayout());

            //======== panel3 ========
            {
                panel3.setBorder(new LineBorder(FrontEnd.COLOR_DARK));
                panel3.setBackground(Color.white);
                panel3.setLayout(new GridLayoutManager(6, 2, new Insets(0, 0, 0, 0), 0, 0));

                //======== panel4 ========
                {
                    panel4.setBackground(FrontEnd.COLOR_LIGHT);
                    panel4.setLayout(new GridLayoutManager(1, 1, new Insets(2, 5, 2, 0), 0, 0));

                    //---- label1 ----
                    label1.setText(Text.bundle.getString(Text.HEAD_CONNECT));
                    label1.setFont(FrontEnd.FONT_TITLE);
                    label1.setForeground(FrontEnd.COLOR_DARK);
                    panel4.add(label1, new GridConstraints(0, 0, 1, 1,
                            GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                            null, null, null));
                }
                panel3.add(panel4, new GridConstraints(0, 0, 1, 2,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //======== panel5 ========
                {
                    panel5.setBackground(Color.white);
                    panel5.setLayout(new GridLayoutManager(3, 1, new Insets(5, 5, 5, 5), 5, 10));

                    //---- label4 ----
                    label4.setText(Text.bundle.getString(Text.HOST_ADDRESS));
                    label4.setFont(FrontEnd.FONT_BOLD);
                    panel5.add(label4, new GridConstraints(0, 0, 1, 1,
                            GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                            null, null, null));

                    //---- label2 ----
                    label2.setText(Text.bundle.getString(Text.PORT_NUMBER));
                    label2.setFont(FrontEnd.FONT_BOLD);
                    panel5.add(label2, new GridConstraints(1, 0, 1, 1,
                            GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                            null, null, null));

                    //---- label3 ----
                    label3.setText(Text.bundle.getString(Text.THREAD_COUNT));
                    label3.setFont(FrontEnd.FONT_BOLD);
                    panel5.add(label3, new GridConstraints(2, 0, 1, 1,
                            GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                            null, null, null));
                }
                panel3.add(panel5, new GridConstraints(1, 0, 1, 1,
                        GridConstraints.ANCHOR_NORTH, GridConstraints.FILL_HORIZONTAL,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //======== panel6 ========
                {
                    panel6.setBackground(Color.white);
                    panel6.setLayout(new GridLayoutManager(3, 1, new Insets(5, 5, 5, 5), 5, 5));

                    //---- tfHost ----
                    tfHost.setFont(FrontEnd.FONT_NORM);
                    tfHost.setPreferredSize(FrontEnd.SIZE_BUTTON);
                    panel6.add(tfHost, new GridConstraints(0, 0, 1, 1,
                            GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
                            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                            null, null, null));

                    //---- tfPort ----
                    tfPort.setFont(FrontEnd.FONT_NORM);
                    tfPort.setPreferredSize(FrontEnd.SIZE_BUTTON);
                    panel6.add(tfPort, new GridConstraints(1, 0, 1, 1,
                            GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
                            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                            null, FrontEnd.SIZE_TEXT_FIELD, null));

                    //---- tfThread ----
                    tfThread.setFont(FrontEnd.FONT_NORM);
                    tfThread.setPreferredSize(FrontEnd.SIZE_BUTTON);
                    panel6.add(tfThread, new GridConstraints(2, 0, 1, 1,
                            GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
                            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                            null, null, null));
                }
                panel3.add(panel6, new GridConstraints(1, 1, 1, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //======== panel7 ========
                {
                    panel7.setBackground(FrontEnd.COLOR_LIGHT);
                    panel7.setBorder(new MatteBorder(1, 0, 0, 0, FrontEnd.COLOR_DARK));
                    panel7.setLayout(new GridLayoutManager(1, 1, new Insets(2, 5, 2, 0), 0, 0));

                    //---- label8 ----
                    label8.setText(Text.bundle.getString(Text.HEAD_DATABASE));
                    label8.setFont(FrontEnd.FONT_TITLE);
                    label8.setForeground(FrontEnd.COLOR_DARK);
                    panel7.add(label8, new GridConstraints(0, 0, 1, 1,
                            GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                            null, null, null));
                }
                panel3.add(panel7, new GridConstraints(2, 0, 1, 2,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //======== panel8 ========
                {
                    panel8.setBackground(Color.white);
                    panel8.setLayout(new GridLayoutManager(3, 1, new Insets(5, 5, 5, 5), 5, 10));

                    //---- label5 ----
                    label5.setText(Text.bundle.getString(Text.DB_ADDRESS));
                    label5.setFont(FrontEnd.FONT_BOLD);
                    panel8.add(label5, new GridConstraints(0, 0, 1, 1,
                            GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                            null, null, null));

                    //---- label6 ----
                    label6.setText(Text.bundle.getString(Text.DB_LOGIN));
                    label6.setFont(FrontEnd.FONT_BOLD);
                    panel8.add(label6, new GridConstraints(1, 0, 1, 1,
                            GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                            null, null, null));

                    //---- label7 ----
                    label7.setText(Text.bundle.getString(Text.DB_PASSWORD));
                    label7.setFont(FrontEnd.FONT_BOLD);
                    panel8.add(label7, new GridConstraints(2, 0, 1, 1,
                            GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                            null, null, null));
                }
                panel3.add(panel8, new GridConstraints(3, 0, 1, 1,
                        GridConstraints.ANCHOR_NORTH, GridConstraints.FILL_HORIZONTAL,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //======== panel9 ========
                {
                    panel9.setBackground(Color.white);
                    panel9.setLayout(new GridLayoutManager(5, 2, new Insets(5, 5, 5, 5), 5, 5));

                    //---- tfDbUrl ----
                    tfDbUrl.setFont(FrontEnd.FONT_NORM);
                    tfDbUrl.setPreferredSize(FrontEnd.SIZE_BUTTON);
                    panel9.add(tfDbUrl, new GridConstraints(0, 0, 1, 1,
                            GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
                            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                            null, null, null));

                    //---- tfUserLogin ----
                    tfUserLogin.setFont(FrontEnd.FONT_NORM);
                    tfUserLogin.setPreferredSize(FrontEnd.SIZE_BUTTON);
                    panel9.add(tfUserLogin, new GridConstraints(1, 0, 1, 1,
                            GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
                            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                            null, null, null));

                    //---- tfPassword ----
                    tfPassword.setFont(FrontEnd.FONT_NORM);
                    tfPassword.setPreferredSize(FrontEnd.SIZE_BUTTON);
                    panel9.add(tfPassword, new GridConstraints(2, 0, 1, 1,
                            GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
                            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                            null, null, null));

                    //---- btnSave ----
                    btnSave.setText(Text.bundle.getString(Text.BUTTON_SAVE));
                    btnSave.setFont(FrontEnd.FONT_BOLD);
                    btnSave.setBackground(FrontEnd.COLOR_DARK);
                    panel9.add(btnSave, new GridConstraints(3, 0, 1, 1,
                            GridConstraints.ANCHOR_EAST, GridConstraints.FILL_HORIZONTAL,
                            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                            null, null, null));

                    //---- btnSave ----
                    btnRestore.setText(Text.bundle.getString(Text.BUTTON_SETTINGS_DEFAULT));
                    btnRestore.setFont(FrontEnd.FONT_BOLD);
                    btnRestore.setBackground(FrontEnd.COLOR_LIGHT);
                    btnRestore.setToolTipText(Text.bundle.getString(Text.TOOLTIP_BTN_RESTORE));
                    panel9.add(btnRestore, new GridConstraints(4, 0, 1, 1,
                            GridConstraints.ANCHOR_EAST, GridConstraints.FILL_HORIZONTAL,
                            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                            null, null, null));
                }
                panel3.add(panel9, new GridConstraints(3, 1, 1, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));
            }
            panel2.add(panel3);
        }
        add(panel2, BorderLayout.CENTER);

        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Props props;
                int i;
                if (Integer.valueOf(tfPort.getText()) == properties.port &&
                        Integer.valueOf(tfThread.getText()) == properties.clientsCount &&
                        tfHost.getText().equals(properties.host) &&
                        tfDbUrl.getText().equals(properties.dbUrl) &&
                        tfUserLogin.getText().equals(properties.user) &&
                        tfPassword.getText().equals(properties.password))
                    return;
                i = ClientMainScreen.showConfirm(
                        Text.bundle.getString(Text.CONFIRM_SETTINGS),
                        Text.bundle.getString(Text.ARE_YOU_SURE_SETTINGS));
                if (i == 0) {
                    props = new Props(
                            Integer.valueOf(tfPort.getText()),
                            Integer.valueOf(tfThread.getText()),
                            tfHost.getText(),
                            tfDbUrl.getText(),
                            tfUserLogin.getText(),
                            tfPassword.getText()
                    );
                    SettingsListener.loadSettings(props);
                }
            }

        });

        btnRestore.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadPanel();
            }

        });
    }

    public static void loadPanel() {
        instance.properties = new Props();

        instance.tfPort.setText(String.valueOf(instance.properties.port));
        instance.tfThread.setText(String.valueOf(instance.properties.clientsCount));
        instance.tfHost.setText(instance.properties.host);

        instance.tfUserLogin.setText(instance.properties.user);
        instance.tfPassword.setText(instance.properties.password);
        instance.tfDbUrl.setText(instance.properties.dbUrl);
        instance.tfDbUrl.setCaretPosition(0);
    }
}