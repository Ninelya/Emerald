package client.view.tariff;

import client.service.ConnectionInvoker;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import commons.commands.tariff.ComSaveTariff;
import commons.info.Tariff;
import commons.view.FrontEnd;
import commons.view.Text;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TariffNew extends JPanel {
    private static TariffNew instance;

    private Tariff tariff;

    private final JTextField tfName;
    private final JTextField tfMinSum;
    private final JTextField tfMaxSum;
    private final JTextField tfRate;
    private final JTextField tfTerm;
    private final JTextArea taCond;
    private final JButton btnSave;

    public TariffNew() {
        tfTerm = new JTextField();
        tfRate = new JTextField();
        tfMaxSum = new JTextField();
        tfName = new JTextField();
        tfMinSum = new JTextField();
        taCond = new JTextArea();
        btnSave = new JButton();

        JPanel panelTop = new JPanel();
        JPanel panelFlow = new JPanel();
        JPanel panelGrid = new JPanel();
        JLabel lblTitle = new JLabel();
        JLabel label1 = new JLabel();
        JLabel label2 = new JLabel();
        JLabel label4 = new JLabel();
        JLabel label3 = new JLabel();
        JLabel label6 = new JLabel();
        JLabel label5 = new JLabel();
        JLabel label7 = new JLabel();
        JLabel label8 = new JLabel();
        JLabel label9 = new JLabel();
        JLabel label10 = new JLabel();
        JScrollPane scrollPane1 = new JScrollPane();

        //======== this ========
        setLayout(new BorderLayout());
        instance = this;

        //======== panel1-top, tariff name ========
        {
            panelTop.setBackground(FrontEnd.COLOR_DARK);
            panelTop.setLayout(new FlowLayout());

            //---- lblTitle ----
            lblTitle.setText(Text.bundle.getString(Text.TARIFF_NEW));
            lblTitle.setFont(FrontEnd.FONT_BIG_TITLE);
            lblTitle.setForeground(FrontEnd.COLOR_LIGHT);
            panelTop.add(lblTitle);
        }
        add(panelTop, BorderLayout.NORTH);


        //======== panel3-main Flow ========
        {
            panelFlow.setBackground(Color.white);
            panelFlow.setLayout(new FlowLayout());

            //======== panel2 GridLayoutManager ========
            {
                panelGrid.setBackground(Color.white);
                panelGrid.setLayout(new GridLayoutManager(8, 3, new Insets(5, 5, 5, 5), 5, 1));
                panelGrid.setBorder(BorderFactory.createLineBorder(FrontEnd.COLOR_DARK));

                //---- label1 ----
                label1.setText(Text.bundle.getString(Text.TARIFF_NAME));
                label1.setFont(FrontEnd.FONT_BOLD);
                panelGrid.add(label1, new GridConstraints(0, 0, 1, 1,
                        GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                tfName.setFont(FrontEnd.FONT_NORM);
                tfName.setText("");
                panelGrid.add(tfName, new GridConstraints(0, 1, 1, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, FrontEnd.SIZE_TEXT_FIELD, null));


                //---- label2 ----
                label2.setText(Text.bundle.getString(Text.MIN_CREDIT_SUM));
                label2.setFont(FrontEnd.FONT_BOLD);
                panelGrid.add(label2, new GridConstraints(1, 0, 1, 1,
                        GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                tfMinSum.setFont(FrontEnd.FONT_NORM);
                tfMinSum.setText("");
                panelGrid.add(tfMinSum, new GridConstraints(1, 1, 1, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, FrontEnd.SIZE_TEXT_FIELD, null));

                //---- label4 ----
                label4.setText(Text.bundle.getString(Text.HRN));
                label4.setFont(FrontEnd.FONT_NORM);
                panelGrid.add(label4, new GridConstraints(1, 2, 1, 1,
                        GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //---- label3 ----
                label3.setText(Text.bundle.getString(Text.MAX_CREDIT_SUM));
                label3.setFont(FrontEnd.FONT_BOLD);
                panelGrid.add(label3, new GridConstraints(2, 0, 1, 1,
                        GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                tfMaxSum.setFont(FrontEnd.FONT_NORM);
                tfMaxSum.setText("");
                panelGrid.add(tfMaxSum, new GridConstraints(2, 1, 1, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, FrontEnd.SIZE_TEXT_FIELD, null));

                //---- label6 ----
                label6.setText(Text.bundle.getString(Text.HRN));
                label6.setFont(FrontEnd.FONT_NORM);
                panelGrid.add(label6, new GridConstraints(2, 2, 1, 1,
                        GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //---- label5 ----
                label5.setText(Text.bundle.getString(Text.PERCENT_RATE));
                label5.setFont(FrontEnd.FONT_BOLD);
                panelGrid.add(label5, new GridConstraints(3, 0, 1, 1,
                        GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                tfRate.setFont(FrontEnd.FONT_NORM);
                tfRate.setText("");
                panelGrid.add(tfRate, new GridConstraints(3, 1, 1, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, FrontEnd.SIZE_TEXT_FIELD, null));

                //---- label7 ----
                label7.setText(Text.bundle.getString(Text.PERCENT_SIGN));
                label7.setFont(FrontEnd.FONT_NORM);
                panelGrid.add(label7, new GridConstraints(3, 2, 1, 1,
                        GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //---- label8 ----
                label8.setText(Text.bundle.getString(Text.CREDIT_TERM));
                label8.setFont(FrontEnd.FONT_BOLD);
                panelGrid.add(label8, new GridConstraints(4, 0, 1, 1,
                        GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                tfTerm.setFont(FrontEnd.FONT_NORM);
                tfTerm.setText("");
                panelGrid.add(tfTerm, new GridConstraints(4, 1, 1, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, FrontEnd.SIZE_TEXT_FIELD, null));

                //---- label9 ----
                label9.setText(Text.bundle.getString(Text.MONTH_NEUTRAL));
                label9.setFont(FrontEnd.FONT_NORM);
                panelGrid.add(label9, new GridConstraints(4, 2, 1, 1,
                        GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //---- label10 ----
                label10.setText(Text.bundle.getString(Text.EXTRA_CONDITIONS));
                label10.setFont(FrontEnd.FONT_BOLD);
                panelGrid.add(label10, new GridConstraints(5, 0, 1, 1,
                        GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //======== scrollPane1 ========
                {
                    taCond.setFont(FrontEnd.FONT_NORM);
                    taCond.setText("");
                    taCond.setLineWrap(true);
                    taCond.setWrapStyleWord(true);
                    scrollPane1.setViewportView(taCond);
                }
                panelGrid.add(scrollPane1, new GridConstraints(6, 0, 1, 2,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //---- btnSave ----
                btnSave.setText(Text.bundle.getString(Text.BUTTON_SAVE));
                btnSave.setFont(FrontEnd.FONT_BOLD);
                btnSave.setBackground(FrontEnd.COLOR_DARK);
                panelGrid.add(btnSave, new GridConstraints(7, 1, 1, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));
            }
            panelFlow.add(panelGrid);
        }
        add(panelFlow, BorderLayout.CENTER);

        btnSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {//todo if fields are empty
                tariff = new Tariff(
                        tfName.getText(),
                        Float.valueOf(tfMinSum.getText()),
                        Float.valueOf(tfMaxSum.getText()),
                        Integer.valueOf(tfRate.getText()),
                        Integer.valueOf(tfTerm.getText()),
                        taCond.getText()
                );
                ConnectionInvoker.invoke(new ComSaveTariff(tariff));
            }
        });
    }
}