package client.view.mail.support;

import commons.view.FrontEnd;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class MessClient extends JPanel {

    protected final JLabel lblTitle;
    protected final JTextArea taClient;

    protected MessClient() {
        taClient = new JTextArea();
        lblTitle = new JLabel();

        JLabel label2 = new JLabel();
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JScrollPane scrollPane1 = new JScrollPane();

        //======== this ========
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(new EmptyBorder(5, 5, 5, 5));
        setBackground(FrontEnd.COLOR_LIGHT);

        //======== panel1 ========
        {
            panel1.setBackground(FrontEnd.COLOR_LIGHT);
            panel1.setLayout(new FlowLayout());

            //---- lblTitle ----
            lblTitle.setFont(FrontEnd.FONT_BOLD);
            lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
            panel1.add(lblTitle);
        }
        add(panel1);

        //======== panel2 ========
        {
            panel2.setBackground(FrontEnd.COLOR_LIGHT);
            panel2.setLayout(new BoxLayout(panel2, BoxLayout.X_AXIS));

            //---- label2 ----
            label2.setBorder(new EmptyBorder(0, FrontEnd.MESSAGE_GAP, 0, 0));
            panel2.add(label2);

            //======== scrollPane1 ========
            {
                //---- taClient ----
                taClient.setRows(5);
                taClient.setColumns(20);
                taClient.setLineWrap(true);
                taClient.setWrapStyleWord(true);
                taClient.setFont(FrontEnd.FONT_NORM);
                scrollPane1.setViewportView(taClient);
            }
            panel2.add(scrollPane1);
        }
        add(panel2);
    }
}