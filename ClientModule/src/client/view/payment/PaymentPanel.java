package client.view.payment;

import client.service.ConnectionInvoker;
import client.view.ClientMainScreen;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import commons.commands.payment.ComSavePayment;
import commons.info.Credit;
import commons.info.Payment;
import commons.user.CurrentUser;
import commons.view.FrontEnd;
import commons.view.Text;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PaymentPanel extends JPanel {
    public static PaymentPanel instance;
    private Credit credit;

    private JPanel oldPaymentsPanel;
    private JPanel newPaymentPanel;
    private JPanel emptyPanel;
    private JLabel lblTitle;
    private JLabel lblCurrentPenalty;
    private JTextField tfNewSum;
    private JButton btnPay;
    private JButton btnCredit;


    public PaymentPanel() {
        lblTitle = new JLabel();
        oldPaymentsPanel = new JPanel();
        newPaymentPanel = new JPanel();
        lblCurrentPenalty = new JLabel();
        tfNewSum = new JTextField();
        btnPay = new JButton();
        btnCredit = new JButton();
        emptyPanel = FrontEnd.emptyPanel();

        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panel5 = new JPanel();
        JPanel panel6 = new JPanel();
        JPanel panel7 = new JPanel();

        JLabel label1 = new JLabel();
        JLabel label2 = new JLabel();
        JLabel label3 = new JLabel();
        JLabel label4 = new JLabel();

        //======== this ========
        instance = this;
        setBackground(Color.white);
        setLayout(new BorderLayout());

        //======== panel1 ========
        {
            panel1.setBackground(FrontEnd.COLOR_DARK);
            panel1.setLayout(new FlowLayout());

            //---- lblTitle ----
            lblTitle.setText(Text.bundle.getString(Text.PAYMENTS));
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
                panel3.setBackground(Color.white);
                panel3.setLayout(new BoxLayout(panel3, BoxLayout.Y_AXIS));

                //======== newPaymentPanel ========
                {
                    newPaymentPanel.setBackground(Color.white);
                    newPaymentPanel.setBorder(new LineBorder(FrontEnd.COLOR_DARK));
                    newPaymentPanel.setLayout(new GridLayoutManager(2, 1, new Insets(0, 0, 0, 0), 5, 0));

                    //======== panel5 ========
                    {
                        panel5.setBackground(FrontEnd.COLOR_LIGHT);
                        panel5.setLayout(new GridLayoutManager(1, 2, new Insets(0, 0, 0, 0), 0, 0, true, false));

                        //---- label0 ----
                        label2.setText(Text.bundle.getString(Text.NEW_PAYMENT));
                        label2.setFont(FrontEnd.FONT_TITLE);
                        label2.setForeground(FrontEnd.COLOR_DARK);
                        label2.setBorder(new EmptyBorder(0, 5, 0, 0));
                        panel5.add(label2, new GridConstraints(0, 0, 1, 1,
                                GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                                null, null, null));

                        //---- btnCredit ----
                        btnCredit.setText(Text.bundle.getString(Text.BUTTON_CREDIT));
                        btnCredit.setBackground(FrontEnd.COLOR_DARK);
                        btnCredit.setForeground(FrontEnd.COLOR_LIGHT);
                        btnCredit.setBorder(new MatteBorder(0, 1, 1, 0, FrontEnd.COLOR_DARK));
                        btnCredit.setFont(FrontEnd.FONT_BOLD);
                        panel5.add(btnCredit, new GridConstraints(0, 1, 1, 1,
                                GridConstraints.ANCHOR_EAST, GridConstraints.FILL_BOTH,
                                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                                null, null, null));
                    }
                    newPaymentPanel.add(panel5, new GridConstraints(0, 0, 1, 1,
                            GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL,
                            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                            null, null, null));

                    //======== panel6 ========
                    {
                        panel6.setBackground(Color.white);
                        panel6.setLayout(new GridLayoutManager(3, 2, new Insets(5, 5, 5, 5), 5, 5));

                        //---- label1 ----
                        label1.setText(Text.bundle.getString(Text.CURRENT_PENALTY));
                        label1.setFont(FrontEnd.FONT_BOLD);
                        panel6.add(label1, new GridConstraints(0, 0, 1, 1,
                                GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                                null, null, null));

                        //======== panel7 ========
                        {
                            panel7.setBackground(Color.white);
                            panel7.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));

                            //---- lblCurrentPenalty ----
                            lblCurrentPenalty.setFont(FrontEnd.FONT_NORM);
                            panel7.add(lblCurrentPenalty);

                            //---- label3 ----
                            label3.setText(Text.bundle.getString(Text.HRN));
                            label3.setBorder(new EmptyBorder(0, 5, 0, 0));
                            label3.setFont(FrontEnd.FONT_NORM);
                            panel7.add(label3);
                        }
                        panel6.add(panel7, new GridConstraints(0, 1, 1, 1,
                                GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                                null, null, null));

                        //---- label4 ----
                        label4.setText(Text.bundle.getString(Text.SUM_TO_PAY));
                        label4.setFont(FrontEnd.FONT_BOLD);
                        panel6.add(label4, new GridConstraints(1, 0, 1, 1,
                                GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                                null, null, null));

                        //---- tfNewSum ----
                        tfNewSum.setFont(FrontEnd.FONT_NORM);
                        panel6.add(tfNewSum, new GridConstraints(1, 1, 1, 1,
                                GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL,
                                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                                null, null, null));

                        //---- btnPay ----
                        btnPay.setText(Text.bundle.getString(Text.BUTTON_PAY));
                        btnPay.setBackground(FrontEnd.COLOR_LIGHT);
                        btnPay.setFont(FrontEnd.FONT_BOLD);
                        panel6.add(btnPay, new GridConstraints(2, 1, 1, 1,
                                GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
                                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                                null, null, null));
                    }
                    newPaymentPanel.add(panel6, new GridConstraints(1, 0, 1, 1,
                            GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
                            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                            null, null, null));
                }
                panel3.add(newPaymentPanel);
                panel3.add(emptyPanel);

                //======== oldPaymentsPanel ========
                {
                    oldPaymentsPanel.setBackground(Color.white);
                    oldPaymentsPanel.setLayout(new BoxLayout(oldPaymentsPanel, BoxLayout.Y_AXIS));
                }
                panel3.add(oldPaymentsPanel);
            }
            panel2.add(panel3);
        }
        add(panel2, BorderLayout.CENTER);

        btnCredit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClientMainScreen.showCreditExpand(credit);
            }
        });

        btnPay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tfNewSum.getText().isEmpty())
                    ClientMainScreen.showMessage(Text.bundle.getString(Text.ENTER_ALL_FIELDS));
                else {
                    Payment payment = new Payment(
                            Float.valueOf(tfNewSum.getText()),
                            instance.credit.getLastPenalty(),
                            instance.credit
                    );
                    ConnectionInvoker.invoke(new ComSavePayment(payment));
                }
            }
        });
    }

    public static void loadPanel(Credit credit) {
        instance.credit = credit;
        instance.lblCurrentPenalty.setText(String.valueOf(credit.getCurrentPenalty()));
        instance.oldPaymentsPanel.removeAll();
        instance.newPaymentPanel.setVisible(CurrentUser.isManager());
        instance.emptyPanel.setVisible(CurrentUser.isManager());
        for (Payment payment : credit.payments) {
            instance.oldPaymentsPanel.add(new PaymentSingle().load(payment));
            instance.oldPaymentsPanel.add(FrontEnd.emptyPanel());
        }
    }
}