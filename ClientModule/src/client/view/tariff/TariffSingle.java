package client.view.tariff;


import client.view.ClientMainScreen;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import commons.info.Tariff;
import commons.view.FrontEnd;
import commons.view.Text;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TariffSingle extends JPanel {
    private Tariff tariff;

    private final JLabel lblTitle;
    private final JLabel lblMinSum;
    private final JLabel lblMaxSum;
    private final JLabel lblRate;
    private final JLabel lblTerm;
    private final JLabel lblMonth;
    private final JLabel lblInActive;

    final JButton btnMore;

    public TariffSingle() {
        lblMonth = new JLabel();
        lblTerm = new JLabel();
        lblRate = new JLabel();
        lblMaxSum = new JLabel();
        lblMinSum = new JLabel();
        lblTitle = new JLabel();
        btnMore = new JButton();

        JPanel panelTitle = new JPanel();

        JPanel panelSum = new JPanel();
        JLabel label2 = new JLabel();
        JLabel label3 = new JLabel();
        JLabel label4 = new JLabel();
        JLabel label5 = new JLabel();

        JPanel panelRate = new JPanel();
        JLabel label7 = new JLabel();
        JLabel label8 = new JLabel();

        JPanel panelTerm = new JPanel();
        JLabel label10 = new JLabel();

        JPanel panelInactive = new JPanel();
        lblInActive = new JLabel();


        //======== this ========
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBackground(Color.white);
        this.setBorder(new LineBorder(FrontEnd.COLOR_DARK));

        //======== panelTitle ========
        {
            panelTitle.setLayout(new GridLayoutManager(1, 2, new Insets(0, 0, 0, 0), 0, 0, true, true));
            panelTitle.setBackground(FrontEnd.COLOR_LIGHT);

            //---- lblTitle ----
            lblTitle.setFont(FrontEnd.FONT_TITLE);
            lblTitle.setForeground(FrontEnd.COLOR_DARK);
            lblTitle.setBorder(new EmptyBorder(0, 5, 0, 0));
            panelTitle.add(lblTitle, new GridConstraints(0, 0, 1, 1,
                    GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                    GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                    GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                    null, null, null));

            //---- btnMore ----
            btnMore.setFont(FrontEnd.FONT_BOLD);
            btnMore.setBackground(FrontEnd.COLOR_DARK);
            btnMore.setForeground(FrontEnd.COLOR_LIGHT);
            btnMore.setBorder(BorderFactory.createMatteBorder(0, 1, 1, 0, FrontEnd.COLOR_DARK));
            btnMore.setText(Text.bundle.getString(Text.BUTTON_MORE));
            panelTitle.add(btnMore, new GridConstraints(0, 1, 1, 1,
                    GridConstraints.ANCHOR_WEST, GridConstraints.FILL_BOTH,
                    GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                    GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                    null, null, null));
        }
        add(panelTitle);

        //======== panelSum ========
        {
            panelSum.setBackground(Color.white);
            panelSum.setAlignmentX(Component.RIGHT_ALIGNMENT);
            panelSum.setLayout(new FlowLayout(FlowLayout.LEFT));

            //---- label2 ----
            label2.setFont(FrontEnd.FONT_BOLD);
            label2.setText(Text.bundle.getString(Text.CREDIT_SUM));
            panelSum.add(label2);

            //---- label3 ----
            label3.setText(Text.bundle.getString(Text.FROM));
            label3.setFont(FrontEnd.FONT_NORM);
            panelSum.add(label3);

            //---- lblMinSum ----
            lblMinSum.setFont(FrontEnd.FONT_NORM);
            panelSum.add(lblMinSum);

            //---- label4 ----
            label4.setFont(FrontEnd.FONT_NORM);
            label4.setText(Text.bundle.getString(Text.TO));
            panelSum.add(label4);

            //---- lblMaxSum ----
            lblMaxSum.setFont(FrontEnd.FONT_NORM);
            panelSum.add(lblMaxSum);

            //---- label5 ----
            label5.setFont(FrontEnd.FONT_NORM);
            label5.setText(Text.bundle.getString(Text.HRN));
            panelSum.add(label5);
        }
        add(panelSum);

        //======== panelRate ========
        {
            panelRate.setLayout(new FlowLayout(FlowLayout.LEFT));
            panelRate.setBackground(Color.white);
            panelRate.setAlignmentX(Component.RIGHT_ALIGNMENT);

            //---- label7 ----
            label7.setFont(FrontEnd.FONT_BOLD);
            label7.setText(Text.bundle.getString(Text.PERCENT_RATE));
            panelRate.add(label7);

            //---- lblRate ----
            lblRate.setFont(FrontEnd.FONT_NORM);
            panelRate.add(lblRate);

            //---- label8 ----
            label8.setFont(FrontEnd.FONT_NORM);
            label8.setText(Text.bundle.getString(Text.PERCENT_SIGN));
            panelRate.add(label8);
        }
        add(panelRate);

        //======== panelTerm ========
        {
            panelTerm.setBackground(Color.white);
            panelTerm.setAlignmentX(Component.RIGHT_ALIGNMENT);
            panelTerm.setLayout(new FlowLayout(FlowLayout.LEFT));

            //---- label10 ----
            label10.setFont(FrontEnd.FONT_BOLD);
            label10.setText(Text.bundle.getString(Text.CREDIT_TERM));
            panelTerm.add(label10);

            //---- lblTerm ----
            lblTerm.setFont(FrontEnd.FONT_NORM);
            panelTerm.add(lblTerm);

            //---- lblMonth ----
            lblMonth.setFont(FrontEnd.FONT_NORM);
            panelTerm.add(lblMonth);
        }
        add(panelTerm);

        //======== panelInactive ========
        {
            panelInactive.setBackground(Color.white);
            panelInactive.setAlignmentX(Component.LEFT_ALIGNMENT);
            panelInactive.setLayout(new FlowLayout(FlowLayout.LEFT));

            //---- lblInActive ----
            lblInActive.setFont(FrontEnd.FONT_BOLD);
            lblInActive.setText(Text.bundle.getString(Text.CREDIT_INACTIVE));
            panelInactive.add(lblInActive);
        }
        add(panelInactive);

        btnMore.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClientMainScreen.showTariffExpand(tariff);
            }
        });
    }

    public TariffSingle loadPanel(Tariff tariff) {
        this.tariff = tariff;
        lblTitle.setText(tariff.name);
        lblMinSum.setText(String.valueOf(tariff.minSum));
        lblMaxSum.setText(String.valueOf(tariff.maxSum));
        lblRate.setText(String.valueOf(tariff.rate));
        lblTerm.setText(String.valueOf(tariff.termMonth));
        lblMonth.setText(Text.setMonth(tariff.termMonth));
        lblInActive.setVisible(!tariff.isActive);
        return this;
    }
}