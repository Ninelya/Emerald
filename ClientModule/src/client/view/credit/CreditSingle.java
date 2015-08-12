package client.view.credit;

import client.view.ClientMainScreen;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import commons.info.Credit;
import commons.view.FrontEnd;
import commons.view.Text;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreditSingle extends JPanel {
    private Credit credit;

    private final JLabel lblSum;
    private final JLabel lblRate;
    private final JLabel lblLeftDebt;
    private final JButton btnMore;

    public CreditSingle() {
        btnMore = new JButton();
        lblLeftDebt = new JLabel();
        lblRate = new JLabel();
        lblSum = new JLabel();

        JPanel panel2 = new JPanel();
        JPanel panel4 = new JPanel();
        JPanel panel5 = new JPanel();
        JPanel panel7 = new JPanel();

        JLabel label0 = new JLabel();
        JLabel label1 = new JLabel();
        JLabel label2 = new JLabel();
        JLabel label5 = new JLabel();
        JLabel label6 = new JLabel();
        JLabel label11 = new JLabel();
        JLabel label12 = new JLabel();

        //======== this ========
        setBorder(new LineBorder(FrontEnd.COLOR_DARK));
        setBackground(Color.white);
        setLayout(new GridLayoutManager(4, 2, new Insets(0, 0, 0, 0), 5, 0));

        //======== panel4 ========
        {
            panel4.setBackground(FrontEnd.COLOR_LIGHT);
            panel4.setLayout(new GridLayoutManager(1, 2, new Insets(0, 0, 0, 0), 0, 0, true, false));

            //---- label0 ----
            label0.setText(Text.bundle.getString(Text.CREDIT));
            label0.setFont(FrontEnd.FONT_TITLE);
            label0.setForeground(FrontEnd.COLOR_DARK);
            label0.setBorder(new EmptyBorder(0, 5, 0, 0));
            panel4.add(label0, new GridConstraints(0, 0, 1, 1,
                    GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                    GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                    GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                    null, null, null));

            //---- btnMore ----
            btnMore.setText(Text.bundle.getString(Text.BUTTON_MORE));
            btnMore.setBackground(FrontEnd.COLOR_DARK);
            btnMore.setForeground(FrontEnd.COLOR_LIGHT);
            btnMore.setBorder(new MatteBorder(0, 1, 1, 0, FrontEnd.COLOR_DARK));
            btnMore.setFont(FrontEnd.FONT_BOLD);
            panel4.add(btnMore, new GridConstraints(0, 1, 1, 1,
                    GridConstraints.ANCHOR_EAST, GridConstraints.FILL_BOTH,
                    GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                    GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                    null, null, null));
        }
        add(panel4, new GridConstraints(0, 0, 1, 2,
                GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                null, null, null));

        //---- label1 ----
        label1.setText(Text.bundle.getString(Text.CREDIT_SUM));
        label1.setFont(FrontEnd.FONT_BOLD);
        label1.setBorder(new EmptyBorder(0, 5, 0, 0));
        add(label1, new GridConstraints(1, 0, 1, 1,
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
        add(panel2, new GridConstraints(1, 1, 1, 1,
                GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                null, null, null));

        //---- label11 ----
        label11.setText(Text.bundle.getString(Text.PERCENT));
        label11.setFont(FrontEnd.FONT_BOLD);
        label11.setBorder(new EmptyBorder(0, 5, 0, 0));
        add(label11, new GridConstraints(2, 0, 1, 1,
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
        add(panel7, new GridConstraints(2, 1, 1, 1,
                GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                null, null, null));

        //---- label5 ----
        label5.setText(Text.bundle.getString(Text.LEFT_DEBT));
        label5.setBorder(new EmptyBorder(0, 5, 0, 0));
        label5.setFont(FrontEnd.FONT_BOLD);
        add(label5, new GridConstraints(3, 0, 1, 1,
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
        add(panel5, new GridConstraints(3, 1, 1, 1,
                GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                null, null, null));

        btnMore.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClientMainScreen.showCreditExpand(credit);
            }
        });
    }

    public CreditSingle loadPanel(Credit credit) {
        this.credit = credit;
        lblSum.setText(String.valueOf(credit.sum));
        lblRate.setText(String.valueOf(credit.percent));
        lblLeftDebt.setText(String.valueOf(credit.getFullSum() - credit.getPaymentSum()));
        return this;
    }
}