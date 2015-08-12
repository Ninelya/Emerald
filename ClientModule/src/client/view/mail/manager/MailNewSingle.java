package client.view.mail.manager;

import client.service.ConnectionInvoker;
import client.view.ClientMainScreen;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import commons.commands.mail.ComSendMailFromManager;
import commons.info.Mail;
import commons.view.FrontEnd;
import commons.view.Text;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MailNewSingle extends JPanel {
    private static MailNewSingle instance;
    private Mail mail;

    private final JLabel lblName;
    private final JButton btnMore;
    private final JButton btnSend;
    private final JTextArea taClient;
    private final JTextArea taAnswer;

    public MailNewSingle() {
        taAnswer = new JTextArea();
        taClient = new JTextArea();
        btnSend = new JButton();
        btnMore = new JButton();
        lblName = new JLabel();

        JPanel panel1 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panel6 = new JPanel();
        JPanel panel7 = new JPanel();
        JScrollPane scrollPane2 = new JScrollPane();
        JScrollPane scrollPane3 = new JScrollPane();
        JLabel label1 = new JLabel();
        JLabel label2 = new JLabel();

        //======== this ========
        instance = this;
        setBorder(new LineBorder(FrontEnd.COLOR_DARK));
        setBackground(Color.white);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        //======== panel3 ========
        {
            panel3.setBackground(FrontEnd.COLOR_LIGHT);
            panel3.setLayout(new GridLayoutManager(1, 2, new Insets(0, 0, 0, 0), 5, 0, true, false));

            //---- lblName ----
            lblName.setForeground(FrontEnd.COLOR_DARK);
            lblName.setFont(FrontEnd.FONT_TITLE);
            lblName.setBorder(new EmptyBorder(0, 5, 0, 0));
            panel3.add(lblName, new GridConstraints(0, 0, 1, 1,
                    GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                    GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                    GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                    null, null, null));

            //---- btnMore ----
            btnMore.setText(Text.bundle.getString(Text.BUTTON_MORE_LETTERS));
            btnMore.setBackground(FrontEnd.COLOR_DARK);
            btnMore.setForeground(FrontEnd.COLOR_LIGHT);
            btnMore.setBorder(new MatteBorder(0, 1, 1, 0, FrontEnd.COLOR_DARK));
            btnMore.setFont(FrontEnd.FONT_BOLD);
            panel3.add(btnMore, new GridConstraints(0, 1, 1, 1,
                    GridConstraints.ANCHOR_EAST, GridConstraints.FILL_BOTH,
                    GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                    GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                    null, null, null));
        }
        add(panel3);

        //======== panel6 ========
        {
            panel6.setBackground(Color.white);
            panel6.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 5));

            //---- label1 ----
            label1.setText(Text.bundle.getString(Text.LAST_CLAIM));
            label1.setBorder(new EmptyBorder(0, 5, 0, 0));
            label1.setFont(FrontEnd.FONT_BOLD);
            label1.setHorizontalAlignment(SwingConstants.CENTER);
            panel6.add(label1);
        }
        add(panel6);

        //======== scrollPane2 ========
        {
            //---- taClient ----
            taClient.setBorder(null);
            taClient.setRows(5);
            taClient.setColumns(25);
            taClient.setLineWrap(true);
            taClient.setWrapStyleWord(true);
            taClient.setFont(FrontEnd.FONT_NORM);
            scrollPane2.setViewportView(taClient);
        }
        add(scrollPane2);

        //======== panel7 ========
        {
            panel7.setBackground(Color.white);
            panel7.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 5));

            //---- label2 ----
            label2.setText(Text.bundle.getString(Text.ANSWER));
            label2.setBorder(new EmptyBorder(0, 5, 0, 0));
            label2.setFont(FrontEnd.FONT_BOLD);
            label2.setHorizontalAlignment(SwingConstants.CENTER);
            panel7.add(label2);
        }
        add(panel7);

        //======== scrollPane3 ========
        {
            //---- taAnswer ----
            taAnswer.setBorder(null);
            taAnswer.setRows(5);
            taAnswer.setColumns(25);
            taAnswer.setLineWrap(true);
            taAnswer.setWrapStyleWord(true);
            taAnswer.setFont(FrontEnd.FONT_NORM);
            scrollPane3.setViewportView(taAnswer);
        }
        add(scrollPane3);

        //======== panel1 ========
        {
            panel1.setBackground(Color.white);
            panel1.setBorder(new EmptyBorder(5, 0, 5, 5));
            panel1.setLayout(new FlowLayout(FlowLayout.RIGHT, 0, 0));

            //---- btnSend ----
            btnSend.setText(Text.bundle.getString(Text.BUTTON_SEND));
            btnSend.setBackground(FrontEnd.COLOR_LIGHT);
            btnSend.setFont(FrontEnd.FONT_BOLD);
            panel1.add(btnSend);
        }
        add(panel1);

        btnMore.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClientMainScreen.showMailForManager(mail.client);
            }
        });

        btnSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ConnectionInvoker.invoke(new ComSendMailFromManager(new Mail(
                        mail.client,
                        instance.taAnswer.getText()
                )));
            }
        });
    }

    public MailNewSingle loadPanel(Mail mail) {
        this.mail = mail;
        lblName.setText(mail.client.name);
        taClient.setText(mail.text);
        return this;
    }
}