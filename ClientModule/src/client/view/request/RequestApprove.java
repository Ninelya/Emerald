package client.view.request;

import client.service.ConnectionInvoker;
import client.view.ClientMainScreen;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import commons.commands.request.ComApproveRequest;
import commons.commands.request.ComDenyRequest;
import commons.info.Request;
import commons.view.FrontEnd;
import commons.view.Text;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RequestApprove extends JPanel {
    private static RequestApprove instance;
    private Request request;

    private final JCheckBox cbGuarantee;
    private final JLabel lblName;
    private final JLabel lblSalary;
    private final JLabel lblProgram;
    private final JLabel lblWantedSum;
    private final JLabel lblMonth2;
    private final JLabel lblTerm;
    private final JLabel lblMonth;
    private final JLabel lblAvailDiscount;
    private final JLabel lblResultRate;
    private final JLabel lblInactive;
    private final JLabel lblSeniority;
    private final JLabel lblSenYears;
    private final JTextArea taDenyReason;
    private final JButton btnProfile;
    private final JButton btnProgram;
    private final JButton btnApprove;
    private final JButton btnDeny;

    public RequestApprove() {
        btnDeny = new JButton();
        btnApprove = new JButton();
        btnProgram = new JButton();
        btnProfile = new JButton();
        taDenyReason = new JTextArea();
        lblResultRate = new JLabel();
        lblAvailDiscount = new JLabel();
        lblMonth = new JLabel();
        lblTerm = new JLabel();
        lblMonth2 = new JLabel();
        lblWantedSum = new JLabel();
        lblProgram = new JLabel();
        lblName = new JLabel();
        lblSalary = new JLabel();
        lblInactive = new JLabel();
        lblSeniority = new JLabel();
        lblSenYears = new JLabel();
        cbGuarantee = new JCheckBox();

        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();
        JPanel panel5 = new JPanel();
        JPanel panel6 = new JPanel();
        JPanel panel7 = new JPanel();
        JPanel panel8 = new JPanel();
        JPanel panel9 = new JPanel();
        JPanel panel10 = new JPanel();
        JSeparator separator1 = new JSeparator();
        JScrollPane jScrollPane = new JScrollPane();
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
        JLabel label14 = new JLabel();

        //======== this ========
        instance = this;
        setBackground(Color.white);
        setLayout(new BorderLayout());

        //======== panel1 ========
        {
            panel1.setBackground(FrontEnd.COLOR_DARK);
            panel1.setLayout(new FlowLayout());

            //---- label9 ----
            label9.setText(Text.bundle.getString(Text.CREDIT_APPROVE));
            label9.setFont(FrontEnd.FONT_BIG_TITLE);
            label9.setForeground(FrontEnd.COLOR_LIGHT);
            panel1.add(label9);
        }
        add(panel1, BorderLayout.NORTH);

        //======== panel2 ========
        {
            panel2.setBackground(Color.white);
            panel2.setLayout(new FlowLayout());

            //======== panel3 ========
            {
                panel3.setBackground(Color.white);
                panel3.setBorder(new LineBorder(FrontEnd.COLOR_DARK));
                panel3.setLayout(new GridLayoutManager(13, 3, new Insets(5, 5, 5, 5), 5, 2, false, false));

                //---- label10 ----
                label10.setText(Text.bundle.getString(Text.CUSTOMER));
                label10.setFont(FrontEnd.FONT_BOLD);
                panel3.add(label10, new GridConstraints(0, 0, 1, 1,
                        GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //---- lblName ----
                lblName.setFont(FrontEnd.FONT_NORM);
                lblName.setBorder(new EmptyBorder(5, 5, 5, 5));
                panel3.add(lblName, new GridConstraints(0, 1, 1, 1,
                        GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //---- btnProfile ----
                btnProfile.setText(Text.bundle.getString(Text.BUTTON_PROFILE));
                btnProfile.setBackground(FrontEnd.COLOR_LIGHT);
                btnProfile.setFont(FrontEnd.FONT_BOLD);
                panel3.add(btnProfile, new GridConstraints(0, 2, 1, 1,
                        GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //---- label11 ----
                label11.setText(Text.bundle.getString(Text.CLIENT_INCOME));
                label11.setFont(FrontEnd.FONT_BOLD);
                panel3.add(label11, new GridConstraints(1, 0, 1, 1,
                        GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //======== panel8 ========
                {
                    panel8.setBackground(Color.white);
                    panel8.setLayout(new FlowLayout(FlowLayout.LEFT));

                    //---- lblSalary ----
                    lblSalary.setFont(FrontEnd.FONT_NORM);
                    panel8.add(lblSalary);

                    //---- label13 ----
                    label13.setText(Text.bundle.getString(Text.HRN_MONTHLY));
                    label13.setFont(FrontEnd.FONT_NORM);
                    panel8.add(label13);
                }
                panel3.add(panel8, new GridConstraints(1, 1, 1, 1,
                        GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //---- label1 ----
                label1.setText(Text.bundle.getString(Text.CLIENT_GUARANTEE));
                label1.setFont(FrontEnd.FONT_BOLD);
                panel3.add(label1, new GridConstraints(2, 0, 1, 1,
                        GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //---- cbGuarantee ----
                cbGuarantee.setBackground(Color.white);
                cbGuarantee.setSelected(true);
                cbGuarantee.setEnabled(false);
                panel3.add(cbGuarantee, new GridConstraints(2, 1, 1, 1,
                        GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //---- label14 ----
                label14.setText(Text.bundle.getString(Text.CLIENT_SENIORITY));
                label14.setFont(FrontEnd.FONT_BOLD);
                panel3.add(label14, new GridConstraints(3, 0, 1, 1,
                        GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //======== panel10 ========
                {
                    panel10.setBackground(Color.white);
                    panel10.setLayout(new FlowLayout(FlowLayout.LEFT));

                    //---- lblSeniority ----
                    lblSeniority.setFont(FrontEnd.FONT_NORM);
                    panel10.add(lblSeniority);

                    //---- lblYears ----
                    lblSenYears.setFont(FrontEnd.FONT_NORM);
                    lblSenYears.setBorder(new EmptyBorder(0, 5, 0, 0));
                    panel10.add(lblSenYears);
                }
                panel3.add(panel10, new GridConstraints(3, 1, 1, 1,
                        GridConstraints.ANCHOR_WEST, GridConstraints.FILL_BOTH,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                panel3.add(separator1, new GridConstraints(4, 0, 1, 3,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //---- label2 ----
                label2.setText(Text.bundle.getString(Text.TARIFF_PROGRAM));
                label2.setFont(FrontEnd.FONT_BOLD);
                panel3.add(label2, new GridConstraints(5, 0, 1, 1,
                        GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //---- lblProgram ----
                lblProgram.setFont(FrontEnd.FONT_NORM);
                lblProgram.setBorder(new EmptyBorder(0, 5, 0, 0));
                panel3.add(lblProgram, new GridConstraints(5, 1, 1, 1,
                        GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //---- btnProgram ----
                btnProgram.setBackground(FrontEnd.COLOR_LIGHT);
                btnProgram.setFont(FrontEnd.FONT_BOLD);
                btnProgram.setText(Text.bundle.getString(Text.BUTTON_PROGRAM));
                panel3.add(btnProgram, new GridConstraints(5, 2, 1, 1,
                        GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //---- label3 ----
                label3.setText(Text.bundle.getString(Text.WANTED_SUM));
                label3.setFont(FrontEnd.FONT_BOLD);
                panel3.add(label3, new GridConstraints(6, 0, 1, 1,
                        GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //======== panel7 ========
                {
                    panel7.setBackground(Color.white);
                    panel7.setLayout(new FlowLayout(FlowLayout.LEFT));

                    //---- lblWantedSum ----
                    lblWantedSum.setFont(FrontEnd.FONT_NORM);
                    panel7.add(lblWantedSum);

                    //---- lblMonth2 ----
                    lblMonth2.setText(Text.bundle.getString(Text.HRN));
                    lblMonth2.setFont(FrontEnd.FONT_NORM);
                    panel7.add(lblMonth2);
                }
                panel3.add(panel7, new GridConstraints(6, 1, 1, 1,
                        GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //---- lblInactive ----
                lblInactive.setFont(FrontEnd.FONT_BOLD);
                lblInactive.setText(Text.bundle.getString(Text.CREDIT_INACTIVE));
                panel3.add(lblInactive, new GridConstraints(6, 2, 1, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //---- label4 ----
                label4.setText(Text.bundle.getString(Text.CREDIT_TERM));
                label4.setFont(FrontEnd.FONT_BOLD);
                panel3.add(label4, new GridConstraints(7, 0, 1, 1,
                        GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //======== panel4 ========
                {
                    panel4.setBackground(Color.white);
                    panel4.setLayout(new FlowLayout(FlowLayout.LEFT));

                    //---- lblTerm ----
                    lblTerm.setFont(FrontEnd.FONT_NORM);
                    panel4.add(lblTerm);

                    //---- lblMonth ----
                    lblMonth.setFont(FrontEnd.FONT_NORM);
                    panel4.add(lblMonth);
                }
                panel3.add(panel4, new GridConstraints(7, 1, 1, 1,
                        GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //---- label5 ----
                label5.setText(Text.bundle.getString(Text.AVAILABLE_DISCOUNT));
                label5.setFont(FrontEnd.FONT_BOLD);
                panel3.add(label5, new GridConstraints(8, 0, 1, 1,
                        GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //======== pOldMessages ========
                {
                    panel5.setBackground(Color.white);
                    panel5.setLayout(new FlowLayout(FlowLayout.LEFT));

                    //---- lblAvailDiscount ----
                    lblAvailDiscount.setFont(FrontEnd.FONT_NORM);
                    panel5.add(lblAvailDiscount);

                    //---- label6 ----
                    label6.setText(Text.bundle.getString(Text.PERCENT_SIGN));
                    label6.setFont(FrontEnd.FONT_NORM);
                    panel5.add(label6);
                }
                panel3.add(panel5, new GridConstraints(8, 1, 1, 1,
                        GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //---- label7 ----
                label7.setText(Text.bundle.getString(Text.RESULTING_PERCENT));
                label7.setFont(FrontEnd.FONT_BOLD);
                panel3.add(label7, new GridConstraints(9, 0, 1, 1,
                        GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //======== panel6 ========
                {
                    panel6.setBackground(Color.white);
                    panel6.setLayout(new FlowLayout(FlowLayout.LEFT));

                    //---- lblResultRate ----
                    lblResultRate.setFont(FrontEnd.FONT_NORM);
                    panel6.add(lblResultRate);

                    //---- label8 ----
                    label8.setText(Text.bundle.getString(Text.PERCENT_SIGN));
                    label8.setFont(FrontEnd.FONT_NORM);
                    panel6.add(label8);
                }
                panel3.add(panel6, new GridConstraints(9, 1, 1, 1,
                        GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //---- btnApprove ----
                btnApprove.setText(Text.bundle.getString(Text.BUTTON_APPROVE));
                btnApprove.setBackground(FrontEnd.COLOR_DARK);
                btnApprove.setFont(FrontEnd.FONT_BOLD);
                panel3.add(btnApprove, new GridConstraints(9, 2, 1, 1,
                        GridConstraints.ANCHOR_EAST, GridConstraints.FILL_HORIZONTAL,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //---- label12 ----
                label12.setText(Text.bundle.getString(Text.DENY_REASON));
                label12.setFont(FrontEnd.FONT_BOLD);
                panel3.add(label12, new GridConstraints(10, 0, 1, 1,
                        GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //---- taDenyReason ----
                taDenyReason.setFont(FrontEnd.FONT_NORM);
                taDenyReason.setWrapStyleWord(true);
                taDenyReason.setLineWrap(true);
                jScrollPane.setViewportView(taDenyReason);
                panel3.add(jScrollPane, new GridConstraints(11, 0, 2, 2,
                        GridConstraints.ANCHOR_WEST, GridConstraints.FILL_BOTH,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //======== panel9 ========
                {
                    panel9.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 1, 0), 0, 0));
                    panel9.setBackground(Color.white);

                    //---- btnDeny ----
                    btnDeny.setText(Text.bundle.getString(Text.BUTTON_DENY));
                    btnDeny.setBackground(FrontEnd.COLOR_LIGHT);
                    btnDeny.setFont(FrontEnd.FONT_BOLD);
                    panel9.add(btnDeny, new GridConstraints(0, 0, 1, 1,
                            GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL,
                            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                            null, null, null));
                }
                panel3.add(panel9, new GridConstraints(12, 2, 1, 1,
                        GridConstraints.ANCHOR_SOUTH, GridConstraints.FILL_HORIZONTAL,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));
            }
            panel2.add(panel3);
        }
        add(panel2, BorderLayout.CENTER);

        btnProfile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClientMainScreen.showClientEdit(request.client);
            }
        });

        btnProgram.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClientMainScreen.showTariffExpand(request.tariff);
            }
        });

        btnApprove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ConnectionInvoker.invoke(new ComApproveRequest(request));
            }
        });

        btnDeny.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (taDenyReason.getText().isEmpty())
                    ClientMainScreen.showMessage(
                            Text.bundle.getString(Text.ENTER_DENY_REASON));
                else {
                    request.denyReason = taDenyReason.getText();
                    ConnectionInvoker.invoke(new ComDenyRequest(request));
                }
            }
        });
    }

    public static void loadPanel(Request request) {
        instance.request = request;

        instance.lblName.setText(request.client.name);
        instance.lblSalary.setText(String.valueOf(request.client.income));
        instance.cbGuarantee.setSelected(request.client.hasGuarantee);
        instance.lblSeniority.setText(String.valueOf(request.client.seniority));
        instance.lblSenYears.setText(Text.setYear(request.client.seniority));

        instance.lblProgram.setText(request.tariff.name);
        instance.lblWantedSum.setText(String.valueOf(request.sum));
        instance.lblTerm.setText(String.valueOf(request.tariff.termMonth));
        instance.lblMonth.setText(Text.setMonth(request.tariff.termMonth));
        instance.lblAvailDiscount.setText(String.valueOf(request.client.getDiscount(request.tariff)));
        instance.lblResultRate.setText(String.valueOf(
                request.tariff.rate - request.client.getDiscount(request.tariff)
        ));
        instance.taDenyReason.setText(request.isApprovable() ? "" : request.getDenyReason());

        instance.lblInactive.setVisible(!request.tariff.isActive);

        instance.btnApprove.setEnabled(request.isApprovable());
    }
}