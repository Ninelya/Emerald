package client.view.mail.support;


import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import commons.info.Mail;
import commons.view.FrontEnd;
import commons.view.Text;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MailPanel extends JPanel {

    private Mail mail;

    protected final JTextArea taDescript;
    protected final JButton btnSend;
    protected final JButton btnDown;
    private final JButton btnUp;
    protected final JLabel lblTitle;
    protected final JLabel lblNew;
    protected final JPanel pOldMessages;
    private final JPanel pContent;
    private final JPanel pTitle;

    protected MailPanel() {
        pTitle = new JPanel();
        pContent = new JPanel();
        pOldMessages = new JPanel();
        lblNew = new JLabel();
        lblTitle = new JLabel();
        btnUp = new JButton();
        btnDown = new JButton();
        btnSend = new JButton();
        taDescript = new JTextArea();

        JPanel panel6 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panel7 = new JPanel();
        JPanel panel8 = new JPanel();
        JScrollPane scrollPane2 = new JScrollPane();
        JSeparator separator1 = new JSeparator();

        //======== this ========
        setLayout(new BorderLayout());

        //======== pTitle ======== title
        {
            pTitle.setBackground(FrontEnd.COLOR_DARK);
            pTitle.setLayout(new FlowLayout());

            //---- lblTitle ----
            lblTitle.setFont(FrontEnd.FONT_BIG_TITLE);
            lblTitle.setForeground(FrontEnd.COLOR_LIGHT);
            pTitle.add(lblTitle);
        }
        add(pTitle, BorderLayout.NORTH);

        //======== pContent ========
        {
            pContent.setLayout(new BorderLayout());

            //======== panel3 ======== panel with navigation buttons
            {
                panel3.setBackground(Color.white);
                panel3.setLayout(new GridLayoutManager(2, 1, new Insets(4, 4, 4, 0), -1, 0));

                //---- btnDown ----
                btnDown.setText(Text.bundle.getString(Text.BUTTON_DOWN));
                btnDown.setBackground(FrontEnd.COLOR_LIGHT);
                btnDown.setFont(FrontEnd.FONT_BOLD);
                panel3.add(btnDown, new GridConstraints(0, 0, 1, 1,
                        GridConstraints.ANCHOR_NORTH, GridConstraints.FILL_HORIZONTAL,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //---- btnUp ----
                btnUp.setText(Text.bundle.getString(Text.BUTTON_UP));
                btnUp.setBackground(FrontEnd.COLOR_LIGHT);
                btnUp.setFont(FrontEnd.FONT_BOLD);
                panel3.add(btnUp, new GridConstraints(1, 0, 1, 1,
                        GridConstraints.ANCHOR_SOUTH, GridConstraints.FILL_HORIZONTAL,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));
            }
            pContent.add(panel3, BorderLayout.WEST);

            //======== panel6 ======== main area
            {
                panel6.setBackground(Color.white);
                panel6.setLayout(new FlowLayout());

                //======== panel7 ========
                {
                    panel7.setLayout(new BoxLayout(panel7, BoxLayout.Y_AXIS));
                    panel7.setBorder(new LineBorder(FrontEnd.COLOR_DARK));

                    //======== pOldMessages ======== messages
                    {
                        pOldMessages.setLayout(new BoxLayout(pOldMessages, BoxLayout.Y_AXIS));
                    }
                    panel7.add(pOldMessages);

                    //======== panel8 ======== new message
                    {
                        panel8.setBackground(FrontEnd.COLOR_LIGHT);
                        panel8.setLayout(new GridLayoutManager(5, 1, new Insets(5, 5, 5, 5), -1, -1));
                        panel8.add(separator1, new GridConstraints(0, 0, 1, 1,
                                GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL,
                                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                                null, null, null));

                        //---- lblNew ----
                        lblNew.setFont(FrontEnd.FONT_BOLD);
                        lblNew.setBorder(new EmptyBorder(0, 5, 0, 0));
                        panel8.add(lblNew, new GridConstraints(2, 0, 1, 1,
                                GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                                null, null, null));

                        //======== scrollPane2 ========
                        {
                            //---- taDescript ----
                            taDescript.setRows(5);
                            taDescript.setFont(FrontEnd.FONT_NORM);
                            taDescript.setLineWrap(true);
                            taDescript.setWrapStyleWord(true);
                            scrollPane2.setViewportView(taDescript);
                        }
                        panel8.add(scrollPane2, new GridConstraints(3, 0, 1, 1,
                                GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
                                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                                null, null, null));

                        //---- btnSend ----
                        btnSend.setText(Text.bundle.getString(Text.BUTTON_SEND));
                        btnSend.setBackground(FrontEnd.COLOR_DARK);
                        btnSend.setFont(FrontEnd.FONT_BOLD);
                        panel8.add(btnSend, new GridConstraints(4, 0, 1, 1,
                                GridConstraints.ANCHOR_EAST, GridConstraints.FILL_NONE,
                                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                                null, null, null));
                    }
                    panel7.add(panel8);
                }
                panel6.add(panel7);
            }
            pContent.add(panel6, BorderLayout.CENTER);
        }
        add(pContent, BorderLayout.CENTER);

        btnDown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int height = (int) pContent.getPreferredSize().getHeight();
                Rectangle rect = new Rectangle(0, height, 1, 1);
                pContent.scrollRectToVisible(rect);
                taDescript.requestFocusInWindow();
            }
        });

        btnUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int height = (int) pTitle.getPreferredSize().getHeight();
                Rectangle rect = new Rectangle(0, -height, 1, 1);
                pContent.scrollRectToVisible(rect);
            }
        });
    }
}