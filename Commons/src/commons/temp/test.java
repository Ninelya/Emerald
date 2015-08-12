/*
 * Created by JFormDesigner on Thu Oct 02 05:15:14 EEST 2014
 */

package commons.temp;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

/**
 * @author Nina Gomenyuk
 */
public class test extends JPanel {
    public test() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Nina Gomenyuk
        panel1 = new JPanel();
        lblTitle = new JLabel();
        panel5 = new JPanel();
        panel3 = new JPanel();
        panel2 = new JPanel();
        panel4 = new JPanel();
        label2 = new JLabel();
        lblDate = new JLabel();
        label1 = new JLabel();
        panel6 = new JPanel();
        lblSum = new JLabel();
        label3 = new JLabel();
        label5 = new JLabel();
        panel8 = new JPanel();
        lblPenalty = new JLabel();
        label6 = new JLabel();
        empty11 = new JPanel();
        panel7 = new JPanel();
        label4 = new JLabel();
        lblDate2 = new JLabel();
        label7 = new JLabel();
        panel9 = new JPanel();
        lblSum2 = new JLabel();
        label8 = new JLabel();
        label9 = new JLabel();
        panel10 = new JPanel();
        lblSum4 = new JLabel();
        label10 = new JLabel();
        empty12 = new JPanel();
        panel13 = new JPanel();
        panel16 = new JPanel();
        label14 = new JLabel();
        panel17 = new JPanel();
        label11 = new JLabel();
        panel14 = new JPanel();
        lblCurrentPenalty = new JLabel();
        label12 = new JLabel();
        label13 = new JLabel();
        tfNewSum = new JTextField();
        btnPay = new JButton();

        //======== this ========
        setBackground(Color.white);

        // JFormDesigner evaluation mark
        setBorder(new javax.swing.border.CompoundBorder(
                new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                        "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                        javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                        java.awt.Color.red), getBorder()));
        addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent e) {
                if ("border".equals(e.getPropertyName())) throw new RuntimeException();
            }
        });

        setLayout(new BorderLayout());

        //======== panel1 ========
        {
            panel1.setBackground(new Color(0, 204, 0));
            panel1.setLayout(new FlowLayout());

            //---- lblTitle ----
            lblTitle.setText("\u041f\u043b\u0430\u0442\u0435\u0436\u0456 \u043f\u043e \u043a\u0440\u0435\u0434\u0438\u0442\u0443");
            lblTitle.setForeground(new Color(204, 255, 204));
            lblTitle.setFont(lblTitle.getFont().deriveFont(lblTitle.getFont().getStyle() | Font.BOLD, lblTitle.getFont().getSize() + 14f));
            panel1.add(lblTitle);
        }
        add(panel1, BorderLayout.NORTH);

        //======== panel5 ========
        {
            panel5.setBackground(Color.white);
            panel5.setLayout(new FlowLayout());

            //======== panel3 ========
            {
                panel3.setBackground(Color.white);
                panel3.setLayout(new BoxLayout(panel3, BoxLayout.Y_AXIS));

                //======== panel2 ========
                {
                    panel2.setBackground(Color.white);
                    panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));

                    //======== panel4 ========
                    {
                        panel4.setBackground(Color.white);
                        panel4.setBorder(new LineBorder(new Color(51, 153, 0)));
                        panel4.setLayout(new GridLayoutManager(3, 2, new Insets(5, 5, 5, 0), 5, 3, false, true));

                        //---- label2 ----
                        label2.setText("\u0414\u0430\u0442\u0430 \u043f\u043b\u0430\u0442\u0435\u0436\u0443:");
                        label2.setFont(label2.getFont().deriveFont(label2.getFont().getStyle() | Font.BOLD));
                        label2.setHorizontalAlignment(SwingConstants.LEFT);
                        panel4.add(label2, new GridConstraints(0, 0, 1, 1,
                                GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                                null, null, null));

                        //---- lblDate ----
                        lblDate.setText("10.11.2013");
                        lblDate.setHorizontalAlignment(SwingConstants.LEFT);
                        panel4.add(lblDate, new GridConstraints(0, 1, 1, 1,
                                GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                                null, null, null));

                        //---- label1 ----
                        label1.setText("\u0421\u0443\u043c\u0430 \u043f\u043b\u0430\u0442\u0435\u0436\u0443:");
                        label1.setFont(label1.getFont().deriveFont(label1.getFont().getStyle() | Font.BOLD));
                        label1.setHorizontalAlignment(SwingConstants.LEFT);
                        panel4.add(label1, new GridConstraints(1, 0, 1, 1,
                                GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                                null, null, null));

                        //======== panel6 ========
                        {
                            panel6.setBackground(Color.white);
                            panel6.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));

                            //---- lblSum ----
                            lblSum.setText("100");
                            panel6.add(lblSum);

                            //---- label3 ----
                            label3.setText("\u0433\u0440\u043d");
                            panel6.add(label3);
                        }
                        panel4.add(panel6, new GridConstraints(1, 1, 1, 1,
                                GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                                null, null, null));

                        //---- label5 ----
                        label5.setText("\u0428\u0442\u0440\u0430\u0444:");
                        label5.setFont(label5.getFont().deriveFont(label5.getFont().getStyle() | Font.BOLD));
                        label5.setHorizontalAlignment(SwingConstants.LEFT);
                        panel4.add(label5, new GridConstraints(2, 0, 1, 1,
                                GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                                null, null, null));

                        //======== panel8 ========
                        {
                            panel8.setBackground(Color.white);
                            panel8.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));

                            //---- lblPenalty ----
                            lblPenalty.setText("10");
                            panel8.add(lblPenalty);

                            //---- label6 ----
                            label6.setText("\u0433\u0440\u043d");
                            panel8.add(label6);
                        }
                        panel4.add(panel8, new GridConstraints(2, 1, 1, 1,
                                GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                                null, null, null));
                    }
                    panel2.add(panel4);

                    //======== empty11 ========
                    {
                        empty11.setBackground(Color.white);
                        empty11.setLayout(new FlowLayout());
                    }
                    panel2.add(empty11);

                    //======== panel7 ========
                    {
                        panel7.setBackground(Color.white);
                        panel7.setBorder(new LineBorder(new Color(51, 153, 0)));
                        panel7.setLayout(new GridLayoutManager(3, 2, new Insets(5, 5, 5, 0), 5, 3, false, true));

                        //---- label4 ----
                        label4.setText("\u0414\u0430\u0442\u0430 \u043f\u043b\u0430\u0442\u0435\u0436\u0443:");
                        label4.setFont(label4.getFont().deriveFont(label4.getFont().getStyle() | Font.BOLD));
                        label4.setHorizontalAlignment(SwingConstants.LEFT);
                        panel7.add(label4, new GridConstraints(0, 0, 1, 1,
                                GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                                null, null, null));

                        //---- lblDate2 ----
                        lblDate2.setText("10.11.2013");
                        lblDate2.setHorizontalAlignment(SwingConstants.LEFT);
                        panel7.add(lblDate2, new GridConstraints(0, 1, 1, 1,
                                GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                                null, null, null));

                        //---- label7 ----
                        label7.setText("\u0421\u0443\u043c\u0430 \u043f\u043b\u0430\u0442\u0435\u0436\u0443:");
                        label7.setFont(label7.getFont().deriveFont(label7.getFont().getStyle() | Font.BOLD));
                        label7.setHorizontalAlignment(SwingConstants.LEFT);
                        panel7.add(label7, new GridConstraints(1, 0, 1, 1,
                                GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                                null, null, null));

                        //======== panel9 ========
                        {
                            panel9.setBackground(Color.white);
                            panel9.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));

                            //---- lblSum2 ----
                            lblSum2.setText("100");
                            panel9.add(lblSum2);

                            //---- label8 ----
                            label8.setText("\u0433\u0440\u043d");
                            panel9.add(label8);
                        }
                        panel7.add(panel9, new GridConstraints(1, 1, 1, 1,
                                GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                                null, null, null));

                        //---- label9 ----
                        label9.setText("\u0428\u0442\u0440\u0430\u0444:");
                        label9.setFont(label9.getFont().deriveFont(label9.getFont().getStyle() | Font.BOLD));
                        label9.setHorizontalAlignment(SwingConstants.LEFT);
                        panel7.add(label9, new GridConstraints(2, 0, 1, 1,
                                GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                                null, null, null));

                        //======== panel10 ========
                        {
                            panel10.setBackground(Color.white);
                            panel10.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));

                            //---- lblSum4 ----
                            lblSum4.setText("10");
                            panel10.add(lblSum4);

                            //---- label10 ----
                            label10.setText("\u0433\u0440\u043d");
                            panel10.add(label10);
                        }
                        panel7.add(panel10, new GridConstraints(2, 1, 1, 1,
                                GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                                null, null, null));
                    }
                    panel2.add(panel7);

                    //======== empty12 ========
                    {
                        empty12.setBackground(Color.white);
                        empty12.setLayout(new FlowLayout());
                    }
                    panel2.add(empty12);
                }
                panel3.add(panel2);

                //======== panel13 ========
                {
                    panel13.setBackground(Color.white);
                    panel13.setBorder(new LineBorder(new Color(51, 204, 0)));
                    panel13.setLayout(new GridLayoutManager(2, 1, new Insets(0, 0, 0, 0), 5, 0));

                    //======== panel16 ========
                    {
                        panel16.setBackground(new Color(204, 255, 204));
                        panel16.setLayout(new GridLayoutManager(1, 1, new Insets(0, 5, 0, 0), 0, 0));

                        //---- label14 ----
                        label14.setText("\u0412\u043d\u0435\u0441\u0435\u043d\u043d\u044f \u043d\u043e\u0432\u043e\u0433\u043e \u043f\u043b\u0430\u0442\u0435\u0436\u0443");
                        label14.setFont(label14.getFont().deriveFont(label14.getFont().getStyle() | Font.BOLD, label14.getFont().getSize() + 4f));
                        label14.setForeground(new Color(51, 153, 0));
                        panel16.add(label14, new GridConstraints(0, 0, 1, 1,
                                GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                                null, null, null));
                    }
                    panel13.add(panel16, new GridConstraints(0, 0, 1, 1,
                            GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL,
                            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                            null, null, null));

                    //======== panel17 ========
                    {
                        panel17.setBackground(Color.white);
                        panel17.setLayout(new GridLayoutManager(3, 2, new Insets(5, 5, 5, 5), 5, 5));

                        //---- label11 ----
                        label11.setText("\u041f\u043e\u0442\u043e\u0447\u043d\u0438\u0439 \u0448\u0442\u0440\u0430\u0444:");
                        label11.setFont(label11.getFont().deriveFont(label11.getFont().getStyle() | Font.BOLD));
                        label11.setHorizontalAlignment(SwingConstants.LEFT);
                        panel17.add(label11, new GridConstraints(0, 0, 1, 1,
                                GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                                null, null, null));

                        //======== panel14 ========
                        {
                            panel14.setBackground(Color.white);
                            panel14.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));

                            //---- lblCurrentPenalty ----
                            lblCurrentPenalty.setText("10");
                            panel14.add(lblCurrentPenalty);

                            //---- label12 ----
                            label12.setText("\u0433\u0440\u043d");
                            panel14.add(label12);
                        }
                        panel17.add(panel14, new GridConstraints(0, 1, 1, 1,
                                GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                                null, null, null));

                        //---- label13 ----
                        label13.setText("\u0421\u0443\u043c\u0430 \u0434\u043e \u0441\u043f\u043b\u0430\u0442\u0438, \u0433\u0440\u043d:");
                        label13.setFont(label13.getFont().deriveFont(label13.getFont().getStyle() | Font.BOLD));
                        label13.setHorizontalAlignment(SwingConstants.LEFT);
                        panel17.add(label13, new GridConstraints(1, 0, 1, 1,
                                GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                                null, null, null));
                        panel17.add(tfNewSum, new GridConstraints(1, 1, 1, 1,
                                GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL,
                                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                                null, null, null));

                        //---- btnPay ----
                        btnPay.setText("\u0421\u043f\u043b\u0430\u0442\u0438\u0442\u0438");
                        btnPay.setBackground(new Color(102, 204, 0));
                        btnPay.setFont(btnPay.getFont().deriveFont(btnPay.getFont().getStyle() | Font.BOLD));
                        panel17.add(btnPay, new GridConstraints(2, 1, 1, 1,
                                GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
                                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                                null, null, null));
                    }
                    panel13.add(panel17, new GridConstraints(1, 0, 1, 1,
                            GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
                            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                            null, null, null));
                }
                panel3.add(panel13);
            }
            panel5.add(panel3);
        }
        add(panel5, BorderLayout.CENTER);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Nina Gomenyuk
    private JPanel panel1;
    private JLabel lblTitle;
    private JPanel panel5;
    private JPanel panel3;
    private JPanel panel2;
    private JPanel panel4;
    private JLabel label2;
    private JLabel lblDate;
    private JLabel label1;
    private JPanel panel6;
    private JLabel lblSum;
    private JLabel label3;
    private JLabel label5;
    private JPanel panel8;
    private JLabel lblPenalty;
    private JLabel label6;
    private JPanel empty11;
    private JPanel panel7;
    private JLabel label4;
    private JLabel lblDate2;
    private JLabel label7;
    private JPanel panel9;
    private JLabel lblSum2;
    private JLabel label8;
    private JLabel label9;
    private JPanel panel10;
    private JLabel lblSum4;
    private JLabel label10;
    private JPanel empty12;
    private JPanel panel13;
    private JPanel panel16;
    private JLabel label14;
    private JPanel panel17;
    private JLabel label11;
    private JPanel panel14;
    private JLabel lblCurrentPenalty;
    private JLabel label12;
    private JLabel label13;
    private JTextField tfNewSum;
    private JButton btnPay;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
