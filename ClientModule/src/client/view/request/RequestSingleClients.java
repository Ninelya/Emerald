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
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RequestSingleClients extends JPanel {
    private Request request;

    private final JLabel lblTariff;
    private final JLabel lblSum;
    private final JLabel lblDate;
    private final JLabel lblStatus;
    private final JLabel lblReason;
    private final JTextArea taReason;
    private final JButton btnMore;
    private final JScrollPane scrollReason;


    public RequestSingleClients() {
        btnMore = new JButton();
        taReason = new JTextArea();
        scrollReason = new JScrollPane();
        lblReason = new JLabel();
        lblStatus = new JLabel();
        lblDate = new JLabel();
        lblSum = new JLabel();
        lblTariff = new JLabel();

        JPanel panel4 = new JPanel();
        JPanel panel5 = new JPanel();
        JLabel label2 = new JLabel();
        JLabel label3 = new JLabel();
        JLabel label5 = new JLabel();
        JLabel label6 = new JLabel();
        JLabel label7 = new JLabel();
        JLabel label8 = new JLabel();

        //======== this ========
        setBackground(Color.white);
        setBorder(new LineBorder(FrontEnd.COLOR_DARK));
        setLayout(new GridLayoutManager(7, 2, new Insets(0, 0, 0, 0), 5, 0));

        //======== panel4 ========
        {
            panel4.setBackground(FrontEnd.COLOR_LIGHT);
            panel4.setLayout(new GridLayoutManager(1, 2, new Insets(0, 0, 0, 0), 5, 0, true, false));

            //---- label3 ----
            label3.setText(Text.bundle.getString(Text.REQUEST));
            label3.setFont(FrontEnd.FONT_TITLE);
            label3.setForeground(FrontEnd.COLOR_DARK);
            label3.setBorder(new EmptyBorder(0, 5, 0, 0));
            panel4.add(label3, new GridConstraints(0, 0, 1, 1,
                    GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                    GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                    GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                    null, null, null));

            //---- btnMore ----
            btnMore.setText(Text.bundle.getString(Text.BUTTON_MORE));
            btnMore.setBackground(FrontEnd.COLOR_DARK);
            btnMore.setForeground(FrontEnd.COLOR_LIGHT);
            btnMore.setFont(FrontEnd.FONT_BOLD);
            btnMore.setBorder(new MatteBorder(0, 1, 1, 0, FrontEnd.COLOR_DARK));
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

        //---- label5 ----
        label5.setText(Text.bundle.getString(Text.CREDIT_PROGRAM));
        label5.setFont(FrontEnd.FONT_BOLD);
        label5.setBorder(new EmptyBorder(0, 5, 0, 0));
        add(label5, new GridConstraints(1, 0, 1, 1,
                GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                null, null, null));

        //---- lblTariff ----
        lblTariff.setFont(FrontEnd.FONT_NORM);
        lblTariff.setBorder(new EmptyBorder(5, 5, 5, 5));
        add(lblTariff, new GridConstraints(1, 1, 1, 1,
                GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                null, null, null));

        //---- label6 ----
        label6.setText(Text.bundle.getString(Text.WANTED_SUM));
        label6.setFont(FrontEnd.FONT_BOLD);
        label6.setBorder(new EmptyBorder(0, 5, 0, 0));
        add(label6, new GridConstraints(2, 0, 1, 1,
                GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                null, null, null));

        //======== pOldMessages ========
        {
            panel5.setBackground(Color.white);
            panel5.setLayout(new FlowLayout(FlowLayout.LEFT));

            //---- lblSum ----
            lblSum.setFont(FrontEnd.FONT_NORM);
            panel5.add(lblSum);

            //---- label2 ----
            label2.setText(Text.bundle.getString(Text.HRN));
            label2.setFont(FrontEnd.FONT_NORM);
            panel5.add(label2);
        }
        add(panel5, new GridConstraints(2, 1, 1, 1,
                GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                null, null, null));

        //---- label7 ----
        label7.setText(Text.bundle.getString(Text.DATE_OF_GIVING));
        label7.setFont(FrontEnd.FONT_BOLD);
        label7.setBorder(new EmptyBorder(0, 5, 0, 0));
        add(label7, new GridConstraints(3, 0, 1, 1,
                GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                null, null, null));

        //---- lblDate ----
        lblDate.setFont(FrontEnd.FONT_NORM);
        lblDate.setBorder(new EmptyBorder(5, 5, 5, 5));
        add(lblDate, new GridConstraints(3, 1, 1, 1,
                GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                null, null, null));

        //---- label8 ----
        label8.setText(Text.bundle.getString(Text.STATUS));
        label8.setFont(FrontEnd.FONT_BOLD);
        label8.setBorder(new EmptyBorder(0, 5, 0, 0));
        add(label8, new GridConstraints(4, 0, 1, 1,
                GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                null, null, null));

        //---- lblStatus ----
        lblStatus.setFont(FrontEnd.FONT_NORM);
        lblStatus.setBorder(new EmptyBorder(5, 5, 5, 5));
        add(lblStatus, new GridConstraints(4, 1, 1, 1,
                GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                null, null, null));

        //---- lblReason ----
        lblReason.setText(Text.bundle.getString(Text.DENY_REASON));
        lblReason.setFont(FrontEnd.FONT_BOLD);
        lblReason.setBorder(new EmptyBorder(5, 5, 5, 0));
        add(lblReason, new GridConstraints(5, 0, 1, 1,
                GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                null, null, null));

        //======== scrollReason ========
        {
            //---- taReason ----
            taReason.setFont(FrontEnd.FONT_NORM);
            taReason.setLineWrap(true);
            taReason.setWrapStyleWord(true);
            scrollReason.setViewportView(taReason);
        }
        add(scrollReason, new GridConstraints(6, 0, 1, 2,
                GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                null, null, null));

        btnMore.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClientMainScreen.showRequestExpand(request);
            }
        });
    }

    public RequestSingleClients loadPanel(Request request) {
        this.request = request;

        lblTariff.setText(request.tariff.name);
        lblSum.setText(String.valueOf(request.sum));
        lblDate.setText(FrontEnd.showDate(request.createDate));
        lblStatus.setText(String.valueOf(request.status));

        if (request.status.isDenied()) {
            lblReason.setVisible(true);
            scrollReason.setVisible(true);
            taReason.setText(request.denyReason);
        } else {
            lblReason.setVisible(false);
            scrollReason.setVisible(false);
        }
        return this;
    }
}