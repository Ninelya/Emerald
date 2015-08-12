package client.view.tariff;

import client.service.ConnectionInvoker;
import client.view.ClientMainScreen;
import client.view.top.MenuMarketer;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import commons.commands.tariff.ComDelTariff;
import commons.info.Tariff;
import commons.user.CurrentUser;
import commons.view.FrontEnd;
import commons.view.Text;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TariffExpand extends JPanel {

    private static TariffExpand instance;
    private Tariff tariff;

    private final JLabel lblTariffName;
    private final JLabel lblMinSum;
    private final JLabel lblMaxSum;
    private final JLabel lblRate;
    private final JLabel lblTerm;
    private final JLabel lblMonth;
    private final JLabel lblInactive;
    private final JTextArea taConditions;
    private final JButton btnGetTariff;
    private final JButton btnEdit;
    private final JButton btnDel;

    public TariffExpand() {
        lblMonth = new JLabel();
        lblTerm = new JLabel();
        lblRate = new JLabel();
        lblMaxSum = new JLabel();
        lblMinSum = new JLabel();
        lblTariffName = new JLabel();
        taConditions = new JTextArea();
        btnDel = new JButton();
        btnEdit = new JButton();
        btnGetTariff = new JButton();
        lblInactive = new JLabel();

        JPanel panel4 = new JPanel();
        JPanel panel8 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel7 = new JPanel();
        JPanel panel5 = new JPanel();
        JPanel panel6 = new JPanel();
        JPanel panel1 = new JPanel();
        JPanel panel9 = new JPanel();
        JScrollPane scrollPane1 = new JScrollPane();
        JLabel label1 = new JLabel();
        JLabel label2 = new JLabel();
        JLabel label4 = new JLabel();
        JLabel label6 = new JLabel();
        JLabel label5 = new JLabel();
        JLabel label7 = new JLabel();
        JLabel label8 = new JLabel();
        JLabel label9 = new JLabel();
        JLabel label10 = new JLabel();

        //======== this ========
        instance = this;
        setLayout(new BorderLayout());

        //======== panel4 ========
        {
            panel4.setBackground(FrontEnd.COLOR_DARK);
            panel4.setLayout(new FlowLayout());

            //---- label1 ----
            label1.setText(Text.bundle.getString(Text.TARIFF_PROGRAM));
            label1.setFont(FrontEnd.FONT_BIG_TITLE);
            label1.setForeground(FrontEnd.COLOR_LIGHT);
            panel4.add(label1);

            //---- lblTariffName ----
            lblTariffName.setFont(FrontEnd.FONT_BIG_TITLE);
            lblTariffName.setForeground(FrontEnd.COLOR_LIGHT);
            panel4.add(lblTariffName);
        }
        add(panel4, BorderLayout.NORTH);

        //======== panel8 ========
        {
            panel8.setBackground(Color.white);
            panel8.setLayout(new FlowLayout());

            //======== panel3 ========
            {
                panel3.setBorder(new LineBorder(FrontEnd.COLOR_DARK));
                panel3.setBackground(Color.white);
                panel3.setLayout(new GridLayoutManager(10, 2, new Insets(0, 5, 5, 5), 5, 0));

                //---- label2 ----
                label2.setText(Text.bundle.getString(Text.MIN_CREDIT_SUM));
                label2.setFont(FrontEnd.FONT_BOLD);
                panel3.add(label2, new GridConstraints(0, 0, 1, 1,
                        GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //======== panel2 ========
                {
                    panel2.setBackground(Color.white);
                    panel2.setLayout(new FlowLayout(FlowLayout.LEFT));

                    //---- lblMinSum ----
                    //lblMinSum.setText("1000");
                    lblMinSum.setFont(FrontEnd.FONT_NORM);
                    panel2.add(lblMinSum);

                    //---- label4 ----
                    label4.setText(Text.bundle.getString(Text.HRN));
                    label4.setFont(FrontEnd.FONT_NORM);
                    panel2.add(label4);
                }
                panel3.add(panel2, new GridConstraints(0, 1, 1, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //---- label6 ----
                label6.setText(Text.bundle.getString(Text.MAX_CREDIT_SUM));
                label6.setFont(FrontEnd.FONT_BOLD);
                panel3.add(label6, new GridConstraints(1, 0, 1, 1,
                        GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //======== panel7 ========
                {
                    panel7.setBackground(Color.white);
                    panel7.setLayout(new FlowLayout(FlowLayout.LEFT));

                    //---- lblMaxSum ----
                    //lblMaxSum.setText("3000");
                    lblMaxSum.setFont(FrontEnd.FONT_NORM);
                    panel7.add(lblMaxSum);

                    //---- label5 ----
                    label5.setText(Text.bundle.getString(Text.HRN));
                    label5.setFont(FrontEnd.FONT_NORM);
                    panel7.add(label5);
                }
                panel3.add(panel7, new GridConstraints(1, 1, 1, 1,
                        GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //---- label7 ----
                label7.setText(Text.bundle.getString(Text.PERCENT_RATE));
                label7.setFont(FrontEnd.FONT_BOLD);
                panel3.add(label7, new GridConstraints(2, 0, 1, 1,
                        GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //======== panel5 ========
                {
                    panel5.setBackground(Color.white);
                    panel5.setLayout(new FlowLayout(FlowLayout.LEFT));

                    //---- lblRate ----
                    //lblRate.setText("12");
                    lblRate.setFont(FrontEnd.FONT_NORM);
                    panel5.add(lblRate);

                    //---- label8 ----
                    label8.setText(Text.bundle.getString(Text.PERCENT_SIGN));
                    label8.setFont(FrontEnd.FONT_NORM);
                    panel5.add(label8);
                }
                panel3.add(panel5, new GridConstraints(2, 1, 1, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //---- label9 ----
                label9.setText(Text.bundle.getString(Text.CREDIT_TERM));
                label9.setFont(FrontEnd.FONT_BOLD);
                panel3.add(label9, new GridConstraints(3, 0, 1, 1,
                        GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //======== panel6 ========
                {
                    panel6.setBackground(Color.white);
                    panel6.setLayout(new FlowLayout(FlowLayout.LEFT));

                    //---- lblTerm ----
                    //lblTerm.setText("3");
                    lblTerm.setFont(FrontEnd.FONT_NORM);
                    panel6.add(lblTerm);

                    //---- lblMonth ----
                    //lblMonth.setText("місяця");
                    lblMonth.setFont(FrontEnd.FONT_NORM);
                    panel6.add(lblMonth);
                }
                panel3.add(panel6, new GridConstraints(3, 1, 1, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //---- label10 ----
                label10.setText(Text.bundle.getString(Text.EXTRA_CONDITIONS));
                label10.setBorder(new EmptyBorder(0, 0, 5, 0));
                label10.setFont(FrontEnd.FONT_BOLD);
                panel3.add(label10, new GridConstraints(4, 0, 1, 1,
                        GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //======== scrollPane1 ========
                {
                    //---- taFullDescript ----
                    taConditions.setFont(FrontEnd.FONT_NORM);
                    taConditions.setLineWrap(true);
                    taConditions.setWrapStyleWord(true);
                    scrollPane1.setViewportView(taConditions);
                }
                panel3.add(scrollPane1, new GridConstraints(5, 0, 1, 2,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //======== panel9 ========
                {
                    panel9.setBackground(Color.white);
                    panel9.setLayout(new FlowLayout(FlowLayout.RIGHT));

                    //---- lblTerm ----
                    lblInactive.setFont(FrontEnd.FONT_BOLD);
                    lblInactive.setText(Text.bundle.getString(Text.CREDIT_INACTIVE));
                    panel9.add(lblInactive);
                }
                panel3.add(panel9, new GridConstraints(6, 1, 1, 1,
                        GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //======== panel1 ========
                {
                    panel1.setBorder(new EmptyBorder(5, 0, 0, 0));
                    panel1.setBackground(Color.white);
                    panel1.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), 0, 0));

                    //---- btnGetTariff ----
                    btnGetTariff.setText(Text.bundle.getString(Text.BUTTON_GET));
                    btnGetTariff.setFont(FrontEnd.FONT_BOLD);
                    btnGetTariff.setBackground(FrontEnd.COLOR_DARK);
                    panel1.add(btnGetTariff, new GridConstraints(0, 0, 1, 1,
                            GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
                            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                            null, null, null));
                }
                panel3.add(panel1, new GridConstraints(7, 1, 1, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //---- btnEdit ----
                btnEdit.setText(Text.bundle.getString(Text.BUTTON_EDIT));
                btnEdit.setBackground(FrontEnd.COLOR_LIGHT);
                btnEdit.setFont(FrontEnd.FONT_BOLD);
                panel3.add(btnEdit, new GridConstraints(8, 1, 1, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //---- btnDel ----
                btnDel.setText(Text.bundle.getString(Text.BUTTON_DELETE));
                btnDel.setBackground(FrontEnd.COLOR_LIGHT);
                btnDel.setFont(FrontEnd.FONT_BOLD);
                panel3.add(btnDel, new GridConstraints(9, 1, 1, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));
            }
            panel8.add(panel3);
        }
        add(panel8, BorderLayout.CENTER);

        btnGetTariff.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClientMainScreen.showRequestNew(instance.tariff);
            }
        });

        btnEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClientMainScreen.showTariffEdit(instance.tariff);
            }
        });

        btnDel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = ClientMainScreen.showConfirm(
                        Text.bundle.getString(Text.CONFIRM_DELETION),
                        Text.bundle.getString(Text.ARE_YOU_SURE_TARIFF));
                if (i == 0) {
                    ConnectionInvoker.invoke(new ComDelTariff(tariff.id));
                    MenuMarketer.clickBtnHome();
                }
            }
        });
    }

    public static void loadPanel(Tariff tariff) {
        instance.tariff = tariff;
        instance.lblTariffName.setText(Text.bundle.getString(Text.QUOTE_LEFT) +
                tariff.name +
                Text.bundle.getString(Text.QUOTE_RIGHT));
        instance.lblMinSum.setText(String.valueOf(tariff.minSum));
        instance.lblMaxSum.setText(String.valueOf(tariff.maxSum));
        instance.lblRate.setText(String.valueOf(tariff.rate));
        instance.lblTerm.setText(String.valueOf(tariff.termMonth));
        instance.lblMonth.setText(Text.setMonth(tariff.termMonth));
        instance.taConditions.setText(tariff.conditions);

        instance.btnEdit.setVisible(false);
        instance.btnDel.setVisible(false);
        instance.btnGetTariff.setVisible(false);
        instance.lblInactive.setVisible(false);

        if (tariff.isActive) {
            if (CurrentUser.isClient()) {
                instance.btnGetTariff.setVisible(true);
            } else if (CurrentUser.isMarketer()) {
                instance.btnEdit.setVisible(true);
                instance.btnDel.setVisible(true);
            }
        } else {
            instance.lblInactive.setVisible(true);
        }
    }
}