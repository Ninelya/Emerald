package client.view.request;

import client.service.ConnectionInvoker;
import client.view.ClientMainScreen;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import commons.commands.request.ComSaveRequest;
import commons.info.Request;
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
import java.util.ArrayList;
import java.util.List;

public class RequestNew extends JPanel {
    private static RequestNew instance;
    private Tariff tariff;
    private int credit_id;

    private final JTextField tfSumm;
    private final JLabel lblName;
    private final JLabel lblMin;
    private final JLabel lblMax;
    private final JLabel lblTerm;
    private final JLabel lblMonth;
    private final JLabel lblRate;
    private final JLabel lblDiscount;
    private final JLabel lblResultRate;
    private final JComboBox<String> cbTariffs;
    private String[] tariffNames;
    private final JButton btnSend;
    private final JPanel panel3;

    public RequestNew() {
        credit_id = 0;
        btnSend = new JButton();
        lblResultRate = new JLabel();
        lblDiscount = new JLabel();
        lblRate = new JLabel();
        lblMonth = new JLabel();
        lblTerm = new JLabel();
        lblMax = new JLabel();
        lblMin = new JLabel();
        lblName = new JLabel();
        tfSumm = new JTextField();
        cbTariffs = new JComboBox<>();
        panel3 = new JPanel();

        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel4 = new JPanel();
        JPanel panel5 = new JPanel();
        JPanel panel6 = new JPanel();
        JPanel panel7 = new JPanel();
        JPanel panel8 = new JPanel();
        JPanel panel10 = new JPanel();

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

        //======== this ========
        instance = this;
        setBackground(Color.white);
        setLayout(new BorderLayout());

        //======== panel1 ========
        {
            panel1.setBackground(FrontEnd.COLOR_DARK);
            panel1.setLayout(new FlowLayout());

            //---- label15 ----
            label15.setText(Text.bundle.getString(Text.CREDIT_ORDER));
            label15.setFont(FrontEnd.FONT_BIG_TITLE);
            label15.setForeground(FrontEnd.COLOR_LIGHT);
            panel1.add(label15, new GridConstraints(0, 0, 1, 1,
                    GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
                    GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                    GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                    null, null, null));
        }
        add(panel1, BorderLayout.PAGE_START);

        //======== panel2 ========
        {
            panel2.setBackground(Color.white);
            panel2.setLayout(new FlowLayout());

            //======== panel3 ========
            {
                panel3.setBackground(Color.white);
                panel3.setBorder(new LineBorder(FrontEnd.COLOR_DARK));
                panel3.setLayout(new GridLayoutManager(11, 2, new Insets(5, 5, 5, 5), 5, 2));

                //---- label1 ----
                label1.setText(Text.bundle.getString(Text.CUSTOMER));
                label1.setFont(FrontEnd.FONT_BOLD);
                panel3.add(label1, new GridConstraints(0, 0, 1, 1,
                        GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //---- lblName ----
                lblName.setFont(FrontEnd.FONT_NORM);
                lblName.setBorder(new EmptyBorder(0, 5, 0, 0));
                panel3.add(lblName, new GridConstraints(0, 1, 1, 1,
                        GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //---- label2 ----
                label2.setText(Text.bundle.getString(Text.CREDIT_PROGRAM));
                label2.setFont(FrontEnd.FONT_BOLD);
                panel3.add(label2, new GridConstraints(1, 0, 1, 1,
                        GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //---- cbTariffs ----
                cbTariffs.setBackground(Color.white);
                cbTariffs.setFont(FrontEnd.FONT_NORM);
                cbTariffs.setBorder(new EmptyBorder(0, 5, 0, 0));
                panel3.add(cbTariffs, new GridConstraints(1, 1, 1, 1,
                        GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //---- label3 ----
                label3.setText(Text.bundle.getString(Text.CREDIT_SUM));
                label3.setFont(FrontEnd.FONT_BOLD);
                panel3.add(label3, new GridConstraints(2, 0, 1, 1,
                        GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //======== panel4 ========
                {
                    panel4.setBackground(Color.white);
                    panel4.setLayout(new FlowLayout(FlowLayout.LEFT));

                    //---- label4 ----
                    label4.setText(Text.bundle.getString(Text.FROM));
                    label4.setFont(FrontEnd.FONT_NORM);
                    panel4.add(label4);

                    //---- lblMin ----
                    lblMin.setFont(FrontEnd.FONT_NORM);
                    panel4.add(lblMin);

                    //---- label5 ----
                    label5.setText(Text.bundle.getString(Text.TO));
                    label5.setFont(FrontEnd.FONT_NORM);
                    panel4.add(label5);

                    //---- lblMax ----
                    lblMax.setFont(FrontEnd.FONT_NORM);
                    panel4.add(lblMax);

                    //---- label6 ----
                    label6.setText(Text.bundle.getString(Text.HRN));
                    label6.setFont(FrontEnd.FONT_NORM);
                    panel4.add(label6);
                }
                panel3.add(panel4, new GridConstraints(2, 1, 1, 1,
                        GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //---- label7 ----
                label7.setText(Text.bundle.getString(Text.WANTED_SUM));
                label7.setFont(FrontEnd.FONT_BOLD);
                panel3.add(label7, new GridConstraints(3, 0, 1, 1,
                        GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //---- panel10 ----
                {
                    panel10.setBackground(Color.white);
                    panel10.setLayout(new GridLayoutManager(1, 1, new Insets(0, 5, 0, 0), 5, -1));

                    //---- tfSumm ----
                    tfSumm.setFont(FrontEnd.FONT_NORM);
                    panel10.add(tfSumm, new GridConstraints(0, 0, 1, 1,
                            GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL,
                            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                            null, null, null));
                }
                panel3.add(panel10, new GridConstraints(3, 1, 1, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //---- label8 ----
                label8.setText(Text.bundle.getString(Text.CREDIT_TERM));
                label8.setFont(FrontEnd.FONT_BOLD);
                panel3.add(label8, new GridConstraints(4, 0, 1, 1,
                        GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //======== pOldMessages ========
                {
                    panel5.setBackground(Color.white);
                    panel5.setLayout(new FlowLayout(FlowLayout.LEFT));

                    //---- lblTerm ----
                    lblTerm.setFont(FrontEnd.FONT_NORM);
                    panel5.add(lblTerm);

                    //---- lblMonth ----
                    lblMonth.setFont(FrontEnd.FONT_NORM);
                    panel5.add(lblMonth);
                }
                panel3.add(panel5, new GridConstraints(4, 1, 1, 1,
                        GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //---- label9 ----
                label9.setText(Text.bundle.getString(Text.PERCENT_RATE));
                label9.setFont(FrontEnd.FONT_BOLD);
                panel3.add(label9, new GridConstraints(5, 0, 1, 1,
                        GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //======== panel6 ========
                {
                    panel6.setBackground(Color.white);
                    panel6.setLayout(new FlowLayout(FlowLayout.LEFT));

                    //---- lblRate ----
                    lblRate.setFont(FrontEnd.FONT_NORM);
                    panel6.add(lblRate);

                    //---- label10 ----
                    label10.setText(Text.bundle.getString(Text.PERCENT_SIGN));
                    label10.setFont(FrontEnd.FONT_NORM);
                    panel6.add(label10);
                }
                panel3.add(panel6, new GridConstraints(5, 1, 1, 1,
                        GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //---- label11 ----
                label11.setText(Text.bundle.getString(Text.AVAILABLE_DISCOUNT));
                label11.setFont(FrontEnd.FONT_BOLD);
                panel3.add(label11, new GridConstraints(6, 0, 1, 1,
                        GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //======== panel7 ========
                {
                    panel7.setBackground(Color.white);
                    panel7.setLayout(new FlowLayout(FlowLayout.LEFT));

                    //---- lblDiscount ----
                    lblDiscount.setFont(FrontEnd.FONT_NORM);
                    panel7.add(lblDiscount);

                    //---- label12 ----
                    label12.setText(Text.bundle.getString(Text.PERCENT_SIGN));
                    label12.setFont(FrontEnd.FONT_NORM);
                    panel7.add(label12);
                }
                panel3.add(panel7, new GridConstraints(6, 1, 1, 1,
                        GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //---- label13 ----
                label13.setText(Text.bundle.getString(Text.RESULTING_PERCENT));
                label13.setFont(FrontEnd.FONT_BOLD);
                panel3.add(label13, new GridConstraints(7, 0, 1, 1,
                        GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //======== panel8 ========
                {
                    panel8.setBackground(Color.white);
                    panel8.setLayout(new FlowLayout(FlowLayout.LEFT));

                    //---- lblResultRate ----
                    lblResultRate.setFont(FrontEnd.FONT_NORM);
                    panel8.add(lblResultRate);

                    //---- label14 ----
                    label14.setText(Text.bundle.getString(Text.PERCENT_SIGN));
                    label14.setFont(FrontEnd.FONT_NORM);
                    panel8.add(label14);
                }
                panel3.add(panel8, new GridConstraints(7, 1, 1, 1,
                        GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //---- btnSend ----
                btnSend.setText(Text.bundle.getString(Text.BUTTON_SEND));
                btnSend.setBackground(FrontEnd.COLOR_DARK);
                btnSend.setFont(FrontEnd.FONT_BOLD);
                panel3.add(btnSend, new GridConstraints(8, 1, 1, 1,
                        GridConstraints.ANCHOR_EAST, GridConstraints.FILL_HORIZONTAL,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));
            }
            panel2.add(panel3);
        }
        add(panel2, BorderLayout.CENTER);

        btnSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tfSumm.getText().isEmpty())
                    ClientMainScreen.showMessage(
                            Text.bundle.getString(Text.ENTER_WISHED_SUM)
                    );
                else {
                    int i = ClientMainScreen.showConfirm(
                            Text.bundle.getString(Text.CONFIRM_REQUEST),
                            Text.bundle.getString(Text.ARE_YOU_SURE_REQUEST));
                    if (i == 0)
                        ConnectionInvoker.invoke(new ComSaveRequest(
                                new Request(CurrentUser.client, tariff,
                                        Float.parseFloat(tfSumm.getText())
                                ))
                        );
                }
            }
        });

        cbTariffs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox cb = (JComboBox) e.getSource();
                String name = (String) cb.getSelectedItem();
                if (!name.isEmpty()) {
                    updateTariff(Tariff.getTariffByName(name));
                }
            }
        });
    }

    private static void updateTariff(Tariff tariff) {
        loadTariff(tariff);
        instance.lblName.requestFocusInWindow();
        instance.panel3.updateUI();
    }

    private static void loadTariff(Tariff tariff) {
        instance.tariff = tariff;
        instance.credit_id = tariff.id;
        instance.lblName.setText(CurrentUser.client.name);
        instance.lblMin.setText(String.valueOf(tariff.minSum));
        instance.lblMax.setText(String.valueOf(tariff.maxSum));
        instance.lblTerm.setText(String.valueOf(tariff.termMonth));
        instance.lblMonth.setText(Text.setMonth(tariff.termMonth));
        instance.lblRate.setText(String.valueOf(tariff.rate));
        instance.lblDiscount.setText(String.valueOf(CurrentUser.client.getDiscount(tariff)));
        instance.lblResultRate.setText(String.valueOf(
                tariff.rate - CurrentUser.client.getDiscount(tariff)
        ));
    }

    public static void loadPanel(Tariff tariff) {
        loadTariff(tariff);
        String[] tariffNamesArray = new String[CurrentUser.tariffs.size()];

        List<String> names = new ArrayList<>();
        for (Tariff tar : CurrentUser.tariffs)
            names.add(tar.name);

        instance.tariffNames = names.toArray(tariffNamesArray);

        if (instance.cbTariffs.getItemCount() == 0)
            for (String name : instance.tariffNames)
                if (Tariff.getTariffByName(name).isActive)
                    instance.cbTariffs.addItem(name);

        instance.cbTariffs.setSelectedItem(instance.tariff.name);
    }

    public static void clearSum() {
        instance.tfSumm.setText("");
    }

}