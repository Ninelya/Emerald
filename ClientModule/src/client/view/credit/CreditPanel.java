package client.view.credit;

import commons.info.Client;
import commons.info.Credit;
import commons.user.CurrentUser;
import commons.view.FrontEnd;
import commons.view.Text;

import javax.swing.*;
import java.awt.*;

public class CreditPanel extends JPanel {
    private static CreditPanel instance;

    private Client client;

    private final JPanel pCreditPanel;
    private final JLabel lblTitle;

    public CreditPanel() {

        pCreditPanel = new JPanel();
        lblTitle = new JLabel();

        JPanel panel1 = new JPanel();
        JPanel panel3 = new JPanel();

        //======== this ========
        instance = this;
        setLayout(new BorderLayout());

        //======== panel1 ========
        {
            panel1.setBackground(FrontEnd.COLOR_DARK);
            panel1.setForeground(FrontEnd.COLOR_LIGHT);
            panel1.setLayout(new FlowLayout());

            //---- label1 ----
            lblTitle.setFont(FrontEnd.FONT_BIG_TITLE);
            lblTitle.setForeground(FrontEnd.COLOR_LIGHT);
            lblTitle.setText(Text.bundle.getString(Text.CREDIT_INFO));
            panel1.add(lblTitle);
        }
        add(panel1, BorderLayout.NORTH);

        //======== panel3 ========
        {
            panel3.setLayout(new FlowLayout());
            panel3.setBackground(Color.white);

            //======== pCreditPanel ========
            {
                pCreditPanel.setBackground(Color.white);
                pCreditPanel.setLayout(new BoxLayout(pCreditPanel, BoxLayout.Y_AXIS));
            }
            panel3.add(pCreditPanel);
        }
        add(panel3, BorderLayout.CENTER);
    }

    private static void setTitle(String name) {
        instance.lblTitle.setText(Text.bundle.getString(Text.CREDIT_HISTORY));
        if (CurrentUser.isManager()) {
            instance.lblTitle.setText(instance.lblTitle.getText() +
                    " " + Text.bundle.getString(Text.DASH) + " " + name);
        }
    }

    public static void loadPanel(Client client) {
        instance.client = client;
        setTitle(client.name);
        instance.pCreditPanel.removeAll();
        for (Credit credit : client.credits) {
            instance.pCreditPanel.add(
                    new CreditSingle().loadPanel(credit));
            instance.pCreditPanel.add(FrontEnd.emptyPanel());
        }
    }
}