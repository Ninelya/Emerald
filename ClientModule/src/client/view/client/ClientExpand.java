package client.view.client;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import commons.info.Client;
import commons.view.FrontEnd;
import commons.view.Text;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;


public class ClientExpand extends JPanel {
    private static ClientExpand instance;

    private final JLabel lblName;
    private final JLabel lblBirthYear;
    private final JLabel lblEmail;
    private final JLabel lblAddress;
    private final JLabel lblInn;
    private final JLabel lblPhone;
    private final JLabel lblIncome;
    private final JLabel lblManager;
    private final JLabel lblWithEmerald;
    private final JCheckBox cbGuarantee;
    private final JCheckBox cbIsStudent;
    private final JLabel lblYears;
    private final JLabel lblSeniority;
    private final JLabel lblSenYears;

    public ClientExpand() {
        cbGuarantee = new JCheckBox();
        cbIsStudent = new JCheckBox();
        lblManager = new JLabel();
        lblIncome = new JLabel();
        lblPhone = new JLabel();
        lblInn = new JLabel();
        lblAddress = new JLabel();
        lblEmail = new JLabel();
        lblName = new JLabel();
        lblBirthYear = new JLabel();
        lblWithEmerald = new JLabel();
        lblYears = new JLabel();
        lblSeniority = new JLabel();
        lblSenYears = new JLabel();

        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panelIncome = new JPanel();
        JLabel lblManagerTitle = new JLabel();
        JLabel panelWithEmerald = new JLabel();
        JPanel panelSeniority = new JPanel();
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

        //======== this ========
        instance = this;
        setBackground(Color.white);
        setLayout(new BorderLayout());

        //======== panel3 ========
        {
            panel3.setBackground(FrontEnd.COLOR_DARK);
            panel3.setLayout(new FlowLayout());

            //---- lblName ----
            lblName.setFont(FrontEnd.FONT_BIG_TITLE);
            lblName.setForeground(FrontEnd.COLOR_LIGHT);
            panel3.add(lblName);
        }
        add(panel3, BorderLayout.NORTH);

        //======== panel1 ========
        {
            panel1.setBackground(Color.white);
            panel1.setLayout(new FlowLayout());


            //======== panel2 ========
            {
                panel2.setBackground(Color.white);
                panel2.setBorder(new LineBorder(FrontEnd.COLOR_DARK));
                panel2.setLayout(new GridLayoutManager(11, 2, new Insets(5, 5, 5, 5), -1, -1));

                //---- label9 ----
                label9.setText(Text.bundle.getString(Text.CLIENT_BIRTH_YEAR));
                label9.setFont(FrontEnd.FONT_BOLD);
                panel2.add(label9, new GridConstraints(0, 0, 1, 1,
                        GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //---- lblBirthYear ----
                lblBirthYear.setFont(FrontEnd.FONT_NORM);
                panel2.add(lblBirthYear, new GridConstraints(0, 1, 1, 1,
                        GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //---- label2 ----
                label2.setText(Text.bundle.getString(Text.CLIENT_EMAIL));
                label2.setFont(FrontEnd.FONT_BOLD);
                panel2.add(label2, new GridConstraints(1, 0, 1, 1,
                        GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //---- lblEmail ----
                lblEmail.setFont(FrontEnd.FONT_NORM);
                panel2.add(lblEmail, new GridConstraints(1, 1, 1, 1,
                        GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //---- label3 ----
                label3.setText(Text.bundle.getString(Text.CLIENT_ADDRESS));
                label3.setFont(FrontEnd.FONT_BOLD);
                panel2.add(label3, new GridConstraints(2, 0, 1, 1,
                        GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //---- lblAddress ----
                lblAddress.setFont(FrontEnd.FONT_NORM);
                panel2.add(lblAddress, new GridConstraints(2, 1, 1, 1,
                        GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //---- label4 ----
                label4.setText(Text.bundle.getString(Text.CLIENT_TEL));
                label4.setFont(FrontEnd.FONT_BOLD);
                panel2.add(label4, new GridConstraints(3, 0, 1, 1,
                        GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //---- lblPhone ----
                lblPhone.setFont(FrontEnd.FONT_NORM);
                panel2.add(lblPhone, new GridConstraints(3, 1, 1, 1,
                        GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //---- label8 ----
                label8.setText(Text.bundle.getString(Text.CLIENT_INN));
                label8.setFont(FrontEnd.FONT_BOLD);
                panel2.add(label8, new GridConstraints(4, 0, 1, 1,
                        GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //---- lblInn ----
                lblInn.setFont(FrontEnd.FONT_NORM);
                panel2.add(lblInn, new GridConstraints(4, 1, 1, 1,
                        GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //---- label5 ----
                label5.setText(Text.bundle.getString(Text.CLIENT_INCOME));
                label5.setFont(FrontEnd.FONT_BOLD);
                panel2.add(label5, new GridConstraints(5, 0, 1, 1,
                        GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //======== panelIncome ========
                {
                    panelIncome.setBackground(Color.white);
                    panelIncome.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

                    //---- lblIncome ----
                    lblIncome.setFont(FrontEnd.FONT_NORM);
                    panelIncome.add(lblIncome);

                    //---- label7 ----
                    label7.setFont(FrontEnd.FONT_NORM);
                    label7.setText(Text.bundle.getString(Text.HRN_MONTHLY));
                    label7.setBorder(new EmptyBorder(0, 5, 0, 0));
                    panelIncome.add(label7);
                }
                panel2.add(panelIncome, new GridConstraints(5, 1, 1, 1,
                        GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //---- label6 ----
                label6.setText(Text.bundle.getString(Text.CLIENT_GUARANTEE));
                label6.setFont(FrontEnd.FONT_BOLD);
                panel2.add(label6, new GridConstraints(6, 0, 1, 1,
                        GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //---- cbGuarantee ----
                cbGuarantee.setBackground(Color.white);
                cbGuarantee.setEnabled(false);
                panel2.add(cbGuarantee, new GridConstraints(6, 1, 1, 1,
                        GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //---- label12 ----
                label12.setText(Text.bundle.getString(Text.CLIENT_IS_STUDENT));
                label12.setFont(FrontEnd.FONT_BOLD);
                panel2.add(label12, new GridConstraints(7, 0, 1, 1,
                        GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //---- cbIsStudent ----
                cbIsStudent.setBackground(Color.white);
                cbIsStudent.setEnabled(false);
                panel2.add(cbIsStudent, new GridConstraints(7, 1, 1, 1,
                        GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //---- label11 ----
                label11.setText(Text.bundle.getString(Text.CLIENT_SENIORITY));
                label11.setFont(FrontEnd.FONT_BOLD);
                panel2.add(label11, new GridConstraints(8, 0, 1, 1,
                        GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //======== panelSeniority ========
                {
                    panelSeniority.setBackground(Color.white);
                    panelSeniority.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

                    //---- lblSeniority ----
                    lblSeniority.setFont(FrontEnd.FONT_NORM);
                    panelSeniority.add(lblSeniority);

                    //---- lblYears ----
                    lblSenYears.setFont(FrontEnd.FONT_NORM);
                    lblSenYears.setBorder(new EmptyBorder(0, 5, 0, 0));
                    panelSeniority.add(lblSenYears);
                }
                panel2.add(panelSeniority, new GridConstraints(8, 1, 1, 1,
                        GridConstraints.ANCHOR_WEST, GridConstraints.FILL_BOTH,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //---- lblManagerTitle ----
                lblManagerTitle.setText(Text.bundle.getString(Text.CLIENT_MANAGER));
                lblManagerTitle.setFont(FrontEnd.FONT_BOLD);
                panel2.add(lblManagerTitle, new GridConstraints(9, 0, 1, 1,
                        GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //---- lblManager ----
                lblManager.setFont(FrontEnd.FONT_NORM);
                panel2.add(lblManager, new GridConstraints(9, 1, 1, 1,
                        GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //---- label10 ----
                label10.setText(Text.bundle.getString(Text.CLIENT_WITH_EMERALD));
                label10.setFont(FrontEnd.FONT_BOLD);
                panel2.add(label10, new GridConstraints(10, 0, 1, 1,
                        GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //======== panelWithEmerald ========
                {
                    panelWithEmerald.setBackground(Color.white);
                    panelWithEmerald.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

                    //---- lblWithEmerald ----
                    lblWithEmerald.setFont(FrontEnd.FONT_NORM);
                    panelWithEmerald.add(lblWithEmerald);

                    //---- lblYears ----
                    lblYears.setFont(FrontEnd.FONT_NORM);
                    lblYears.setBorder(new EmptyBorder(0, 5, 0, 0));
                    panelWithEmerald.add(lblYears);
                }
                panel2.add(panelWithEmerald, new GridConstraints(10, 1, 1, 1,
                        GridConstraints.ANCHOR_WEST, GridConstraints.FILL_BOTH,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));
            }
            panel1.add(panel2);
        }
        add(panel1, BorderLayout.CENTER);
    }

    public static void loadPanel(Client client) {

        instance.lblName.setText(client.name);
        instance.lblBirthYear.setText(String.valueOf(client.birthYear));
        instance.lblEmail.setText(client.email);
        instance.lblAddress.setText(client.address);
        instance.lblInn.setText(client.inn);
        instance.lblPhone.setText(String.valueOf(client.telephone));
        instance.lblIncome.setText(String.valueOf(client.income));
        instance.cbGuarantee.setSelected(client.hasGuarantee);
        instance.cbIsStudent.setSelected(client.isStudent);
        instance.lblSeniority.setText(String.valueOf(client.seniority));
        instance.lblSenYears.setText(Text.setYear(client.seniority));
        instance.lblManager.setText(client.manager.name);
        if (client.withEmerald() == 0) {
            instance.lblWithEmerald.setText(Text.bundle.getString(Text.CLIENT_FIRST_YEAR));
            instance.lblYears.setText("");
        } else {
            instance.lblWithEmerald.setText(String.valueOf(client.withEmerald()));
            instance.lblYears.setText(Text.setYear(client.withEmerald()));
        }
    }
}