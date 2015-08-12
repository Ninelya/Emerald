package client.view.mail.support;

import commons.view.FrontEnd;
import commons.view.Text;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class MessManager extends JPanel {

    protected final JTextArea taManager;
    protected final JLabel lblTitle;

    protected MessManager() {
        lblTitle = new JLabel();
        taManager = new JTextArea();

        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JLabel label2 = new JLabel();
        JScrollPane scrollPane = new JScrollPane();

        //======== this ========
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(new EmptyBorder(5, 5, 5, 5));
        setBackground(FrontEnd.COLOR_LIGHT);

        //======== panel1 ========
        {
            panel1.setBackground(FrontEnd.COLOR_LIGHT);
            panel1.setLayout(new FlowLayout());

            //---- lblTitle ----
            lblTitle.setText(Text.bundle.getString(Text.MANAGER_ANSWER));
            lblTitle.setFont(FrontEnd.FONT_BOLD);
            lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
            panel1.add(lblTitle);
        }
        add(panel1);

        //======== panel2 ========
        {
            panel2.setBackground(FrontEnd.COLOR_LIGHT);
            panel2.setLayout(new BoxLayout(panel2, BoxLayout.X_AXIS));

            //======== scrollPane ========
            {
                //---- taManager ----
                taManager.setRows(5);
                taManager.setColumns(20);
                taManager.setLineWrap(true);
                taManager.setWrapStyleWord(true);
                taManager.setFont(FrontEnd.FONT_NORM);
                scrollPane.setViewportView(taManager);
            }
            panel2.add(scrollPane);

            //---- label2 ----
            label2.setBorder(new EmptyBorder(0, FrontEnd.MESSAGE_GAP, 0, 0));
            panel2.add(label2);
        }
        add(panel2);
    }
}