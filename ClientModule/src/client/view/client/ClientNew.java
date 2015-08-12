package client.view.client;

import client.service.ConnectionInvoker;
import client.view.ClientMainScreen;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import commons.commands.client.ComSaveClient;
import commons.info.Client;
import commons.info.User;
import commons.info.status.AccessType;
import commons.user.CurrentUser;
import commons.view.FrontEnd;
import commons.view.Text;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClientNew extends JPanel {
    private static ClientNew instance;

    private final JTextField tfName;
    private final JTextField tfBirthYear;
    private final JTextField tfEmail;
    private final JTextField tfAddress;
    private final JTextField tfPhone;
    private final JTextField tfIncome;
    private final JTextField tfInn;
    private final JTextField tfPass;
    private final JTextField tfSeniority;
    private final JCheckBox cbGuaranty;
    private final JCheckBox cbIsStudent;
    private final JLabel lblManager;
    private final JButton btnSave;

    public ClientNew() {
        btnSave = new JButton();
        lblManager = new JLabel();
        cbGuaranty = new JCheckBox();
        cbIsStudent = new JCheckBox();
        tfSeniority = new JTextField();
        tfIncome = new JTextField();
        tfPhone = new JTextField();
        tfAddress = new JTextField();
        tfEmail = new JTextField();
        tfBirthYear = new JTextField();
        tfName = new JTextField();
        tfInn = new JTextField();
        tfPass = new JTextField();

        JPanel panel3 = new JPanel();
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JLabel label1 = new JLabel();
        JLabel label2 = new JLabel();
        JLabel label3 = new JLabel();
        JLabel label4 = new JLabel();
        JLabel label5 = new JLabel();
        JLabel label6 = new JLabel();
        JLabel label7 = new JLabel();
        JLabel label8 = new JLabel();
        JLabel label9 = new JLabel();
        JLabel label10 = new JLabel();
        JLabel label11 = new JLabel();
        JLabel label12 = new JLabel();
        JLabel label13 = new JLabel();

        //======== this ========
        instance = this;
        setLayout(new BorderLayout());

        //======== panel3 ========
        {
            panel3.setBackground(FrontEnd.COLOR_DARK);
            panel3.setLayout(new FlowLayout());

            //---- label8 ----
            label8.setText(Text.bundle.getString(Text.CLIENT_NEW));
            label8.setFont(FrontEnd.FONT_BIG_TITLE);
            label8.setForeground(FrontEnd.COLOR_LIGHT);
            panel3.add(label8);
        }
        add(panel3, BorderLayout.PAGE_START);

        //======== panel1 ========
        {
            panel1.setBackground(Color.white);
            panel1.setLayout(new FlowLayout());

            //======== panel2 ========
            {
                panel2.setBackground(Color.white);
                panel2.setBorder(new LineBorder(FrontEnd.COLOR_DARK));
                panel2.setLayout(new GridLayoutManager(13, 2, new Insets(5, 5, 5, 5), -1, -1));

                //---- label1 ----
                label1.setText(Text.bundle.getString(Text.CLIENT_FULL_NAME));
                label1.setFont(FrontEnd.FONT_BOLD);
                panel2.add(label1, new GridConstraints(0, 0, 1, 1,
                        GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //---- tfName ----
                tfName.setPreferredSize(FrontEnd.SIZE_TEXT_FIELD);
                tfName.setFont(FrontEnd.FONT_NORM);
                panel2.add(tfName, new GridConstraints(0, 1, 1, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //---- label11 ----
                label11.setText(Text.bundle.getString(Text.CLIENT_BIRTH_YEAR));
                label11.setFont(FrontEnd.FONT_BOLD);
                panel2.add(label11, new GridConstraints(1, 0, 1, 1,
                        GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //---- tfName ----
                tfBirthYear.setPreferredSize(FrontEnd.SIZE_TEXT_FIELD);
                tfBirthYear.setFont(FrontEnd.FONT_NORM);
                panel2.add(tfBirthYear, new GridConstraints(1, 1, 1, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //---- label2 ----
                label2.setText(Text.bundle.getString(Text.CLIENT_EMAIL));
                label2.setFont(FrontEnd.FONT_BOLD);
                panel2.add(label2, new GridConstraints(2, 0, 1, 1,
                        GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //---- tfEmail ----
                tfEmail.setPreferredSize(FrontEnd.SIZE_TEXT_FIELD);
                tfEmail.setFont(FrontEnd.FONT_NORM);
                panel2.add(tfEmail, new GridConstraints(2, 1, 1, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //---- label10 ----
                label10.setText(Text.bundle.getString(Text.CLIENT_PASSWORD));
                label10.setFont(FrontEnd.FONT_BOLD);
                panel2.add(label10, new GridConstraints(3, 0, 1, 1,
                        GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //---- tfPass ----
                tfPass.setPreferredSize(FrontEnd.SIZE_TEXT_FIELD);
                tfPass.setFont(FrontEnd.FONT_NORM);
                panel2.add(tfPass, new GridConstraints(3, 1, 1, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //---- label3 ----
                label3.setText(Text.bundle.getString(Text.CLIENT_ADDRESS));
                label3.setFont(FrontEnd.FONT_BOLD);
                panel2.add(label3, new GridConstraints(4, 0, 1, 1,
                        GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //---- tfAddress ----
                tfAddress.setPreferredSize(FrontEnd.SIZE_TEXT_FIELD);
                tfAddress.setFont(FrontEnd.FONT_NORM);
                panel2.add(tfAddress, new GridConstraints(4, 1, 1, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //---- label4 ----
                label4.setText(Text.bundle.getString(Text.CLIENT_TEL));
                label4.setFont(FrontEnd.FONT_BOLD);
                panel2.add(label4, new GridConstraints(5, 0, 1, 1,
                        GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //---- tfPhone ----
                tfPhone.setPreferredSize(FrontEnd.SIZE_TEXT_FIELD);
                tfPhone.setFont(FrontEnd.FONT_NORM);
                panel2.add(tfPhone, new GridConstraints(5, 1, 1, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //---- label5 ----
                label5.setText(Text.bundle.getString(Text.CLIENT_INCOME));
                label5.setFont(FrontEnd.FONT_BOLD);
                panel2.add(label5, new GridConstraints(6, 0, 1, 1,
                        GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //---- tfIncome ----
                tfIncome.setPreferredSize(FrontEnd.SIZE_TEXT_FIELD);
                tfIncome.setFont(FrontEnd.FONT_NORM);
                panel2.add(tfIncome, new GridConstraints(6, 1, 1, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //---- label9 ----
                label9.setText(Text.bundle.getString(Text.CLIENT_INN));
                label9.setFont(FrontEnd.FONT_BOLD);
                panel2.add(label9, new GridConstraints(7, 0, 1, 1,
                        GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //---- tfInn ----
                tfInn.setPreferredSize(FrontEnd.SIZE_TEXT_FIELD);
                tfInn.setFont(FrontEnd.FONT_NORM);
                panel2.add(tfInn, new GridConstraints(7, 1, 1, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //---- label12 ----
                label12.setText(Text.bundle.getString(Text.CLIENT_SENIORITY));
                label12.setFont(FrontEnd.FONT_BOLD);
                panel2.add(label12, new GridConstraints(8, 0, 1, 1,
                        GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //---- tfSeniority ----
                tfSeniority.setPreferredSize(FrontEnd.SIZE_TEXT_FIELD);
                tfSeniority.setFont(FrontEnd.FONT_NORM);
                panel2.add(tfSeniority, new GridConstraints(8, 1, 1, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //---- label13 ----
                label13.setText(Text.bundle.getString(Text.CLIENT_IS_STUDENT));
                label13.setFont(FrontEnd.FONT_BOLD);
                panel2.add(label13, new GridConstraints(9, 0, 1, 1,
                        GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //---- cbIsStudent ----
                cbIsStudent.setBackground(Color.white);
                panel2.add(cbIsStudent, new GridConstraints(9, 1, 1, 1,
                        GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //---- label6 ----
                label6.setText(Text.bundle.getString(Text.CLIENT_GUARANTEE));
                label6.setFont(FrontEnd.FONT_BOLD);
                panel2.add(label6, new GridConstraints(10, 0, 1, 1,
                        GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //---- cbGuaranty ----
                cbGuaranty.setBackground(Color.white);
                panel2.add(cbGuaranty, new GridConstraints(10, 1, 1, 1,
                        GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //---- label7 ----
                label7.setText(Text.bundle.getString(Text.CLIENT_MANAGER));
                label7.setFont(FrontEnd.FONT_BOLD);
                panel2.add(label7, new GridConstraints(11, 0, 1, 1,
                        GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //---- lblManager ----
                lblManager.setFont(FrontEnd.FONT_NORM);
                panel2.add(lblManager, new GridConstraints(11, 1, 1, 1,
                        GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //---- btnSave ----
                btnSave.setText(Text.bundle.getString(Text.BUTTON_SAVE));
                btnSave.setBackground(FrontEnd.COLOR_DARK);
                btnSave.setFont(FrontEnd.FONT_BOLD);
                panel2.add(btnSave, new GridConstraints(12, 1, 1, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));
            }
            panel1.add(panel2);
        }
        add(panel1, BorderLayout.CENTER);

        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tfInn.getText().isEmpty() ||
                        tfEmail.getText().isEmpty() ||
                        tfName.getText().isEmpty() ||
                        tfAddress.getText().isEmpty() ||
                        tfPhone.getText().isEmpty() ||
                        tfIncome.getText().isEmpty() ||
                        tfSeniority.getText().isEmpty() ||
                        tfPass.getText().isEmpty())
                    ClientMainScreen.showMessage(Text.bundle.getString(Text.ENTER_ALL_FIELDS));
                else {
                    Client client = new Client(
                            tfInn.getText(),
                            tfEmail.getText(),
                            CurrentUser.manager,
                            tfName.getText(),
                            tfAddress.getText(),
                            Integer.valueOf(tfPhone.getText()),
                            Integer.valueOf(tfIncome.getText()),
                            cbGuaranty.isSelected(),
                            Integer.valueOf(tfBirthYear.getText()),
                            cbIsStudent.isSelected(),
                            Integer.valueOf(tfSeniority.getText())
                    );
                    User user = new User(
                            client.name,
                            client.email,
                            tfPass.getText(),
                            AccessType.client
                    );
                    ConnectionInvoker.invoke(new ComSaveClient(client, user));
                }
            }
        });
    }

    public static void loadPanel() {
        instance.lblManager.setText(CurrentUser.manager.name);
    }
}