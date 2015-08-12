package client.view.credit;

import client.view.ClientMainScreen;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import commons.info.Credit;
import commons.user.CurrentUser;
import commons.view.FrontEnd;
import commons.view.Text;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreditExpand extends JPanel {
    private Credit credit;
    public static CreditExpand instance;

    private final JLabel lblSum;
    private final JLabel lblRate;
    private final JLabel lblPenalty;
    private final JLabel lblFullDebt;
    private final JLabel lblPaymentSum;
    private final JLabel lblLeftDebt;
    private final JLabel lblGivingDate;
    private final JLabel lblFinishDate;
    private final JLabel lblMonthsLate;
    private final JLabel lblWithoutPenalty;

    private final JButton btnProfile;
    private final JButton btnRequest;
    private final JButton btnPayment;

    public CreditExpand() {
        btnRequest = new JButton();
        btnProfile = new JButton();
        btnPayment = new JButton();

        lblMonthsLate = new JLabel();
        lblFinishDate = new JLabel();
        lblGivingDate = new JLabel();
        lblLeftDebt = new JLabel();
        lblPaymentSum = new JLabel();
        lblFullDebt = new JLabel();
        lblPenalty = new JLabel();
        lblRate = new JLabel();
        lblSum = new JLabel();
        lblWithoutPenalty = new JLabel();

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
        JPanel panel11 = new JPanel();
        JPanel pCreditPanel = new JPanel();

        JLabel lblTitle = new JLabel();
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
        JLabel label15 = new JLabel();
        JLabel label16 = new JLabel();

        //======== this ========
        instance = this;
        setLayout(new BorderLayout());

        //======== panel1 ========
        {
            panel1.setBackground(FrontEnd.COLOR_DARK);
            panel1.setForeground(FrontEnd.COLOR_LIGHT);
            panel1.setLayout(new FlowLayout());

            //---- label1 ----
            lblTitle.setFont(FrontEnd.FONT_BIG_TITLE);
            lblTitle.setForeground(FrontEnd.COLOR_LIGHT);
            lblTitle.setText(Text.bundle.getString(Text.CREDIT_INFO));
            panel1.add(lblTitle);
        }
        add(panel1, BorderLayout.NORTH);

        //======== panel4 ========
        {
            panel4.setLayout(new FlowLayout());
            panel4.setBackground(Color.white);

            //======== pCreditPanel ========
            {
                pCreditPanel.setBorder(new LineBorder(FrontEnd.COLOR_DARK));
                pCreditPanel.setBackground(Color.white);
                pCreditPanel.setLayout(new GridLayoutManager(13, 2, new Insets(0, 0, 0, 0), 5, 0, false, false));

                //---- label1 ----
                label1.setText(Text.bundle.getString(Text.CREDIT_SUM));
                label1.setFont(FrontEnd.FONT_BOLD);
                label1.setBorder(new EmptyBorder(0, 5, 0, 0));
                pCreditPanel.add(label1, new GridConstraints(0, 0, 1, 1,
                        GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //======== panel2 ========
                {
                    panel2.setBackground(Color.white);
                    panel2.setLayout(new FlowLayout(FlowLayout.LEFT));

                    //---- lblSum ----
                    lblSum.setFont(FrontEnd.FONT_NORM);
                    panel2.add(lblSum);

                    //---- label2 ----
                    label2.setText(Text.bundle.getString(Text.HRN));
                    label2.setFont(FrontEnd.FONT_NORM);
                    panel2.add(label2);
                }
                pCreditPanel.add(panel2, new GridConstraints(0, 1, 1, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //---- label11 ----
                label11.setText(Text.bundle.getString(Text.PERCENT));
                label11.setFont(FrontEnd.FONT_BOLD);
                label11.setBorder(new EmptyBorder(0, 5, 0, 0));
                pCreditPanel.add(label11, new GridConstraints(1, 0, 1, 1,
                        GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //======== panel7 ========
                {
                    panel7.setBackground(Color.white);
                    panel7.setLayout(new FlowLayout(FlowLayout.LEFT));

                    //---- lblRate ----
                    lblRate.setFont(FrontEnd.FONT_NORM);
                    panel7.add(lblRate);

                    //---- label12 ----
                    label12.setText(Text.bundle.getString(Text.PERCENT_SIGN));
                    label12.setFont(FrontEnd.FONT_NORM);
                    panel7.add(label12);
                }
                pCreditPanel.add(panel7, new GridConstraints(1, 1, 1, 1,
                        GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //---- label7 ----
                label7.setText(Text.bundle.getString(Text.PENALTY));
                label7.setFont(FrontEnd.FONT_BOLD);
                label7.setBorder(new EmptyBorder(0, 5, 0, 0));
                pCreditPanel.add(label7, new GridConstraints(2, 0, 1, 1,
                        GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //======== panel6 ========
                {
                    panel6.setBackground(Color.white);
                    panel6.setLayout(new FlowLayout(FlowLayout.LEFT));

                    //---- lblPenalty ----
                    lblPenalty.setFont(FrontEnd.FONT_NORM);
                    panel6.add(lblPenalty);

                    //---- label8 ----
                    label8.setText(Text.bundle.getString(Text.HRN));
                    label8.setFont(FrontEnd.FONT_NORM);
                    panel6.add(label8);
                }
                pCreditPanel.add(panel6, new GridConstraints(2, 1, 1, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //---- label3 ----
                label3.setText(Text.bundle.getString(Text.TOTAL_DEBT));
                label3.setBorder(new EmptyBorder(0, 5, 0, 0));
                label3.setFont(FrontEnd.FONT_BOLD);
                pCreditPanel.add(label3, new GridConstraints(3, 0, 1, 1,
                        GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //======== panel3 ========
                {
                    panel3.setBackground(Color.white);
                    panel3.setLayout(new FlowLayout(FlowLayout.LEFT));

                    //---- lblFullDebt ----
                    lblFullDebt.setFont(FrontEnd.FONT_NORM);
                    panel3.add(lblFullDebt);

                    //---- label4 ----
                    label4.setText(Text.bundle.getString(Text.HRN));
                    label4.setFont(FrontEnd.FONT_NORM);
                    panel3.add(label4);
                }
                pCreditPanel.add(panel3, new GridConstraints(3, 1, 1, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //---- label16 ----
                label16.setText(Text.bundle.getString(Text.PAYMENTS_SUM));
                label16.setBorder(new EmptyBorder(0, 5, 0, 0));
                label16.setFont(FrontEnd.FONT_BOLD);
                pCreditPanel.add(label16, new GridConstraints(4, 0, 1, 1,
                        GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //======== panel9 ========
                {
                    panel9.setBackground(Color.white);
                    panel9.setLayout(new FlowLayout(FlowLayout.LEFT));

                    //---- lblPaymentSum ----
                    lblPaymentSum.setFont(FrontEnd.FONT_NORM);
                    panel9.add(lblPaymentSum);

                    //---- label15 ----
                    label15.setText(Text.bundle.getString(Text.HRN));
                    label15.setFont(FrontEnd.FONT_NORM);
                    panel9.add(label15);
                }
                pCreditPanel.add(panel9, new GridConstraints(4, 1, 1, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //---- label5 ----
                label5.setText(Text.bundle.getString(Text.LEFT_DEBT));
                label5.setBorder(new EmptyBorder(0, 5, 0, 0));
                label5.setFont(FrontEnd.FONT_BOLD);
                pCreditPanel.add(label5, new GridConstraints(5, 0, 1, 1,
                        GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //======== panel5 ========
                {
                    panel5.setBackground(Color.white);
                    panel5.setLayout(new FlowLayout(FlowLayout.LEFT));

                    //---- lblLeftDebt ----
                    lblLeftDebt.setFont(FrontEnd.FONT_NORM);
                    panel5.add(lblLeftDebt);

                    //---- label6 ----
                    label6.setText(Text.bundle.getString(Text.HRN));
                    label6.setFont(FrontEnd.FONT_NORM);
                    panel5.add(label6);
                }
                pCreditPanel.add(panel5, new GridConstraints(5, 1, 1, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //---- label9 ----
                label9.setText(Text.bundle.getString(Text.CREDIT_GIVING_DATE));
                label9.setFont(FrontEnd.FONT_BOLD);
                label9.setBorder(new EmptyBorder(0, 5, 0, 0));
                pCreditPanel.add(label9, new GridConstraints(6, 0, 1, 1,
                        GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //---- lblGivingDate ----
                lblGivingDate.setFont(FrontEnd.FONT_NORM);
                lblGivingDate.setBorder(new EmptyBorder(5, 5, 5, 5));
                pCreditPanel.add(lblGivingDate, new GridConstraints(6, 1, 1, 1,
                        GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //---- label10 ----
                label10.setText(Text.bundle.getString(Text.PAYING_FINISH_DATE));
                label10.setFont(FrontEnd.FONT_BOLD);
                label10.setBorder(new EmptyBorder(5, 5, 5, 0));
                pCreditPanel.add(label10, new GridConstraints(7, 0, 1, 1,
                        GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //---- lblFinishDate ----
                lblFinishDate.setFont(FrontEnd.FONT_NORM);
                lblFinishDate.setBorder(new EmptyBorder(5, 5, 5, 5));
                pCreditPanel.add(lblFinishDate, new GridConstraints(7, 1, 1, 1,
                        GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //---- label13 ----
                label13.setText(Text.bundle.getString(Text.MONTHS_LATE));
                label13.setFont(FrontEnd.FONT_BOLD);
                label13.setBorder(new EmptyBorder(0, 5, 0, 0));
                pCreditPanel.add(label13, new GridConstraints(8, 0, 1, 1,
                        GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //---- lblMonthsLate ----
                lblMonthsLate.setFont(FrontEnd.FONT_NORM);
                lblMonthsLate.setBorder(new EmptyBorder(5, 5, 5, 5));
                pCreditPanel.add(lblMonthsLate, new GridConstraints(8, 1, 1, 1,
                        GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //---- label14 ----
                label14.setText(Text.bundle.getString(Text.WITHOUT_PENALTY));
                label14.setFont(FrontEnd.FONT_BOLD);
                label14.setBorder(new EmptyBorder(0, 5, 0, 0));
                pCreditPanel.add(label14, new GridConstraints(9, 0, 1, 1,
                        GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //---- lblWithoutPenalty ----
                lblWithoutPenalty.setFont(FrontEnd.FONT_NORM);
                lblWithoutPenalty.setBorder(new EmptyBorder(5, 5, 5, 5));
                pCreditPanel.add(lblWithoutPenalty, new GridConstraints(9, 1, 1, 1,
                        GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //======== panel11 ========
                {
                    panel11.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 5, 5), 0, 0));
                    panel11.setBackground(Color.white);

                    //---- btnProfile ----
                    btnProfile.setText(Text.bundle.getString(Text.BUTTON_PROFILE));
                    btnProfile.setBackground(FrontEnd.COLOR_LIGHT);
                    btnProfile.setFont(FrontEnd.FONT_BOLD);
                    panel11.add(btnProfile, new GridConstraints(0, 0, 1, 1,
                            GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL,
                            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                            null, null, null));
                }
                pCreditPanel.add(panel11, new GridConstraints(10, 1, 1, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //======== panel8 ========
                {
                    panel8.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 5, 5), 0, 0));
                    panel8.setBackground(Color.white);

                    //---- btnPayment ----
                    btnPayment.setText(Text.bundle.getString(Text.BUTTON_PAYMENT));
                    btnPayment.setBackground(FrontEnd.COLOR_LIGHT);
                    btnPayment.setFont(FrontEnd.FONT_BOLD);
                    panel8.add(btnPayment, new GridConstraints(0, 0, 1, 1,
                            GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL,
                            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                            null, null, null));
                }
                pCreditPanel.add(panel8, new GridConstraints(11, 1, 1, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //======== panel10 ========
                {
                    panel10.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 5, 5), 0, 0));
                    panel10.setBackground(Color.white);

                    //---- btnRequest ----
                    btnRequest.setText(Text.bundle.getString(Text.BUTTON_REQUEST));
                    btnRequest.setBackground(FrontEnd.COLOR_LIGHT);
                    btnRequest.setFont(FrontEnd.FONT_BOLD);
                    panel10.add(btnRequest, new GridConstraints(0, 0, 1, 1,
                            GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL,
                            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                            null, null, null));
                }
                pCreditPanel.add(panel10, new GridConstraints(12, 1, 1, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));


            }
            panel4.add(pCreditPanel);
        }
        add(panel4, BorderLayout.CENTER);

        btnPayment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClientMainScreen.showPaymentPanel(credit);
            }
        });

        btnProfile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClientMainScreen.showClientEdit(credit.client);
            }
        });

        btnRequest.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClientMainScreen.showRequestExpand(credit.request);
            }
        });
    }

    public static void loadPanel(Credit credit) {
        instance.credit = credit;
        instance.lblSum.setText(String.valueOf(credit.sum));
        instance.lblRate.setText(String.valueOf(credit.percent));
        instance.lblPenalty.setText(String.valueOf(credit.getCurrentPenalty()));
        instance.lblFullDebt.setText(String.valueOf(credit.getFullSum()));
        instance.lblPaymentSum.setText(String.valueOf(credit.getPaymentSum()));
        instance.lblLeftDebt.setText(String.valueOf(credit.getFullSum() - credit.getPaymentSum()));
        instance.lblGivingDate.setText(FrontEnd.showDate(credit.dateApplication));
        instance.lblFinishDate.setText(credit.datePayed == null ? "-" : FrontEnd.showDate(credit.datePayed));
        instance.lblMonthsLate.setText(String.valueOf(credit.getMonthsLate()));
        instance.lblWithoutPenalty.setText(String.valueOf(credit.getMonthsWithoutPenalty()));

        instance.btnProfile.setVisible(CurrentUser.isManager());
        instance.btnRequest.setVisible(!CurrentUser.isManager());
    }
}