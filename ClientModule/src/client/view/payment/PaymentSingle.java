package client.view.payment;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import commons.info.Payment;
import commons.view.FrontEnd;
import commons.view.Text;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;

public class PaymentSingle extends JPanel {

    private Payment payment;
    private JLabel lblDate;
    private JLabel lblSum;
    private JLabel lblPenalty;

    public PaymentSingle() {
        lblDate = new JLabel();
        lblSum = new JLabel();
        lblPenalty = new JLabel();

        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();

        JLabel label2 = new JLabel();
        JLabel label1 = new JLabel();
        JLabel label3 = new JLabel();
        JLabel label5 = new JLabel();
        JLabel label4 = new JLabel();


        //======== this ========
        {
            setBackground(Color.white);
            setBorder(new LineBorder(FrontEnd.COLOR_DARK));
            setLayout(new GridLayoutManager(3, 2, new Insets(5, 5, 5, 0), 5, 3, false, true));

            //---- label2 ----
            label2.setText(Text.bundle.getString(Text.PAYMENT_DATE));
            label2.setFont(FrontEnd.FONT_BOLD);
            add(label2, new GridConstraints(0, 0, 1, 1,
                    GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                    GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                    GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                    null, null, null));

            //---- lblDate ----
            lblDate.setFont(FrontEnd.FONT_NORM);
            lblDate.setBorder(new EmptyBorder(0, 0, 0, 5));
            add(lblDate, new GridConstraints(0, 1, 1, 1,
                    GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                    GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                    GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                    null, null, null));

            //---- label1 ----
            label1.setText(Text.bundle.getString(Text.PAYMENT_SUM));
            label1.setFont(FrontEnd.FONT_BOLD);
            add(label1, new GridConstraints(1, 0, 1, 1,
                    GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                    GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                    GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                    null, null, null));

            //======== panel1 ========
            {
                panel1.setBackground(Color.white);
                panel1.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));

                //---- lblSum ----
                lblSum.setFont(FrontEnd.FONT_NORM);
                panel1.add(lblSum);

                //---- label3 ----
                label3.setText(Text.bundle.getString(Text.HRN));
                label3.setBorder(new EmptyBorder(0, 5, 0, 5));
                label3.setFont(FrontEnd.FONT_NORM);
                panel1.add(label3);
            }
            add(panel1, new GridConstraints(1, 1, 1, 1,
                    GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                    GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                    GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                    null, null, null));

            //---- label5 ----
            label5.setText(Text.bundle.getString(Text.PAYMENT_PENALTY));
            label5.setFont(FrontEnd.FONT_BOLD);
            add(label5, new GridConstraints(2, 0, 1, 1,
                    GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                    GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                    GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                    null, null, null));

            //======== panel2 ========
            {
                panel2.setBackground(Color.white);
                panel2.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));

                //---- lblPenalty ----
                lblPenalty.setFont(FrontEnd.FONT_NORM);
                panel2.add(lblPenalty);

                //---- label4 ----
                label4.setText(Text.bundle.getString(Text.HRN));
                label4.setBorder(new EmptyBorder(0, 5, 0, 5));
                label4.setFont(FrontEnd.FONT_NORM);
                panel2.add(label4);
            }
            add(panel2, new GridConstraints(2, 1, 1, 1,
                    GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                    GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                    GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                    null, null, null));
        }
    }

    public PaymentSingle load(Payment payment) {
        this.payment = payment;
        lblDate.setText(FrontEnd.showDate(payment.date));
        lblSum.setText(String.valueOf(payment.sum));
        lblPenalty.setText(String.valueOf(payment.penalty));
        return this;
    }
}