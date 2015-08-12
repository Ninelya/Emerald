package client.view.request;

import client.view.ClientMainScreen;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import commons.info.Request;
import commons.view.FrontEnd;
import commons.view.Text;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RequestExpand extends JPanel {
    private static RequestExpand instance;
    private Request request;

    private final JLabel lblProgramName;
    private final JLabel lblSum;
    private final JLabel lblTerm;
    private final JLabel lblMonth;
    private final JLabel lblRate;
    private final JLabel lblDiscount;
    private final JLabel lblResultRate;
    private final JLabel lblGivingDate;
    private final JLabel lblState;
    private final JLabel lblReason;
    private final JTextArea taDenyReason;
    private final JScrollPane scrollReason;
    private final JButton btnProgram;

    public RequestExpand() {
        btnProgram = new JButton();
        taDenyReason = new JTextArea();
        lblState = new JLabel();
        lblGivingDate = new JLabel();
        lblResultRate = new JLabel();
        lblDiscount = new JLabel();
        lblRate = new JLabel();
        lblMonth = new JLabel();
        lblTerm = new JLabel();
        lblSum = new JLabel();
        lblProgramName = new JLabel();
        scrollReason = new JScrollPane();
        lblReason = new JLabel();

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
        JLabel label2 = new JLabel();
        JLabel label3 = new JLabel();
        JLabel label4 = new JLabel();
        JLabel label5 = new JLabel();
        JLabel label7 = new JLabel();
        JLabel label8 = new JLabel();
        JLabel label9 = new JLabel();
        JLabel label10 = new JLabel();
        JLabel label11 = new JLabel();
        JLabel label12 = new JLabel();
        JLabel label13 = new JLabel();
        JLabel label15 = new JLabel();

        //======== this ========
        instance = this;
        setLayout(new BorderLayout());

        //======== panel4 ========
        {
            panel4.setBackground(FrontEnd.COLOR_DARK);
            panel4.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 5));

            //---- lblTitle ----
            lblTitle.setText(Text.bundle.getString(Text.REQUEST_EXPAND));
            lblTitle.setFont(FrontEnd.FONT_BIG_TITLE);
            lblTitle.setForeground(FrontEnd.COLOR_LIGHT);
            panel4.add(lblTitle);
        }
        add(panel4, BorderLayout.PAGE_START);

        //======== panel8 ========
        {
            panel8.setBackground(Color.white);
            panel8.setLayout(new FlowLayout());

            //======== panel5 ========
            {
                panel5.setBorder(new LineBorder(FrontEnd.COLOR_DARK));
                panel5.setBackground(Color.white);
                panel5.setLayout(new GridLayoutManager(13, 2, new Insets(0, 5, 5, 5), 5, 0));

                //---- label3 ----
                label3.setText(Text.bundle.getString(Text.CREDIT_PROGRAM));
                label3.setFont(FrontEnd.FONT_BOLD);
                panel5.add(label3, new GridConstraints(0, 0, 1, 1,
                        GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //---- lblProgramName ----
                lblProgramName.setFont(FrontEnd.FONT_NORM);
                lblProgramName.setBorder(new EmptyBorder(5, 5, 5, 5));
                panel5.add(lblProgramName, new GridConstraints(0, 1, 1, 1,
                        GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //---- label2 ----
                label2.setText(Text.bundle.getString(Text.WANTED_SUM));
                label2.setFont(FrontEnd.FONT_BOLD);
                panel5.add(label2, new GridConstraints(1, 0, 1, 1,
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

                    //---- label4 ----
                    label4.setText(Text.bundle.getString(Text.HRN));
                    label4.setFont(FrontEnd.FONT_NORM);
                    panel2.add(label4);
                }
                panel5.add(panel2, new GridConstraints(1, 1, 1, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //---- label15 ----
                label15.setText(Text.bundle.getString(Text.CREDIT_TERM));
                label15.setFont(FrontEnd.FONT_BOLD);
                panel5.add(label15, new GridConstraints(2, 0, 1, 1,
                        GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //======== panel7 ========
                {
                    panel7.setBackground(Color.white);
                    panel7.setLayout(new FlowLayout(FlowLayout.LEFT));

                    //---- lblTerm ----
                    lblTerm.setFont(FrontEnd.FONT_NORM);
                    panel7.add(lblTerm);

                    //---- lblMonth ----
                    lblMonth.setText(Text.setMonth(3));
                    lblMonth.setFont(FrontEnd.FONT_NORM);
                    panel7.add(lblMonth);
                }
                panel5.add(panel7, new GridConstraints(2, 1, 1, 1,
                        GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //---- label9 ----
                label9.setText(Text.bundle.getString(Text.PERCENT_RATE));
                label9.setFont(FrontEnd.FONT_BOLD);
                panel5.add(label9, new GridConstraints(3, 0, 1, 1,
                        GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //======== panel9 ========
                {
                    panel9.setBackground(Color.white);
                    panel9.setLayout(new FlowLayout(FlowLayout.LEFT));

                    //---- lblRate ----
                    lblRate.setFont(FrontEnd.FONT_NORM);
                    panel9.add(lblRate);

                    //---- label12 ----
                    label12.setText(Text.bundle.getString(Text.PERCENT_SIGN));
                    label12.setFont(FrontEnd.FONT_NORM);
                    panel9.add(label12);
                }
                panel5.add(panel9, new GridConstraints(3, 1, 1, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //---- label8 ----
                label8.setText(Text.bundle.getString(Text.AVAILABLE_DISCOUNT));
                label8.setFont(FrontEnd.FONT_BOLD);
                panel5.add(label8, new GridConstraints(4, 0, 1, 1,
                        GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //======== panel6 ========
                {
                    panel6.setBackground(Color.white);
                    panel6.setLayout(new FlowLayout(FlowLayout.LEFT));

                    //---- lblDiscount ----
                    lblDiscount.setFont(FrontEnd.FONT_NORM);
                    panel6.add(lblDiscount);

                    //---- label10 ----
                    label10.setText(Text.bundle.getString(Text.PERCENT_SIGN));
                    label10.setFont(FrontEnd.FONT_NORM);
                    panel6.add(label10);
                }
                panel5.add(panel6, new GridConstraints(4, 1, 1, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //---- label5 ----
                label5.setText(Text.bundle.getString(Text.RESULTING_PERCENT));
                label5.setFont(FrontEnd.FONT_BOLD);
                panel5.add(label5, new GridConstraints(5, 0, 1, 1,
                        GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //======== panel3 ========
                {
                    panel3.setBackground(Color.white);
                    panel3.setLayout(new FlowLayout(FlowLayout.LEFT));

                    //---- lblResultRate ----
                    lblResultRate.setFont(FrontEnd.FONT_NORM);
                    panel3.add(lblResultRate);

                    //---- label7 ----
                    label7.setText(Text.bundle.getString(Text.PERCENT_SIGN));
                    label7.setFont(FrontEnd.FONT_NORM);
                    panel3.add(label7);
                }
                panel5.add(panel3, new GridConstraints(5, 1, 1, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //---- label11 ----
                label11.setText(Text.bundle.getString(Text.DATE_OF_GIVING));
                label11.setFont(FrontEnd.FONT_BOLD);
                panel5.add(label11, new GridConstraints(6, 0, 1, 1,
                        GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //---- lblGivingDate ----
                lblGivingDate.setFont(FrontEnd.FONT_NORM);
                lblGivingDate.setBorder(new EmptyBorder(5, 5, 5, 5));
                panel5.add(lblGivingDate, new GridConstraints(6, 1, 1, 1,
                        GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //---- label13 ----
                label13.setText(Text.bundle.getString(Text.STATUS));
                label13.setFont(FrontEnd.FONT_BOLD);
                panel5.add(label13, new GridConstraints(7, 0, 1, 1,
                        GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //---- lblState ----
                lblState.setFont(FrontEnd.FONT_NORM);
                lblState.setBorder(new EmptyBorder(5, 5, 5, 5));
                panel5.add(lblState, new GridConstraints(7, 1, 1, 1,
                        GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //---- lblReason ----
                lblReason.setText(Text.bundle.getString(Text.DENY_REASON));
                lblReason.setFont(FrontEnd.FONT_BOLD);
                panel5.add(lblReason, new GridConstraints(8, 0, 1, 1,
                        GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //======== scrollReason ========
                {
                    taDenyReason.setFont(FrontEnd.FONT_NORM);
                    taDenyReason.setLineWrap(true);
                    taDenyReason.setWrapStyleWord(true);
                    scrollReason.setViewportView(taDenyReason);
                }
                panel5.add(scrollReason, new GridConstraints(9, 0, 3, 2,
                        GridConstraints.ANCHOR_WEST, GridConstraints.FILL_BOTH,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //======== panel1 ========
                {
                    panel1.setBackground(Color.white);
                    panel1.setBorder(new EmptyBorder(5, 0, 0, 0));
                    panel1.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));

                    //---- btnProgram ----
                    btnProgram.setText(Text.bundle.getString(Text.BUTTON_PROGRAM));
                    btnProgram.setBackground(FrontEnd.COLOR_LIGHT);
                    btnProgram.setFont(FrontEnd.FONT_BOLD);
                    panel1.add(btnProgram);
                }
                panel5.add(panel1, new GridConstraints(12, 1, 1, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));
            }
            panel8.add(panel5);
        }
        add(panel8, BorderLayout.CENTER);

        btnProgram.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClientMainScreen.showTariffExpand(request.tariff);
            }
        });
    }

    public static void loadPanel(Request request) {
        instance.request = request;
        instance.lblProgramName.setText(request.tariff.name);
        instance.lblSum.setText(String.valueOf(request.sum));
        instance.lblTerm.setText(String.valueOf(request.tariff.termMonth));
        instance.lblMonth.setText(Text.setMonth(request.tariff.termMonth));
        instance.lblRate.setText(String.valueOf(request.tariff.rate));
        instance.lblDiscount.setText(String.valueOf(request.client.getDiscount(request.tariff)));
        instance.lblResultRate.setText(String.valueOf(request.tariff.rate - request.client.getDiscount(request.tariff)));
        instance.lblGivingDate.setText(FrontEnd.showDate(request.createDate));
        instance.lblState.setText(String.valueOf(request.status));
        if (request.status.isDenied()) {
            instance.lblReason.setVisible(true);
            instance.scrollReason.setVisible(true);
            instance.taDenyReason.setText(request.denyReason);
        } else {
            instance.scrollReason.setVisible(false);
            instance.lblReason.setVisible(false);
        }
    }
}