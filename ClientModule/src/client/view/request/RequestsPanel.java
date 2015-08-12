package client.view.request;

import commons.info.Client;
import commons.info.Request;
import commons.user.CurrentUser;
import commons.view.FrontEnd;
import commons.view.Text;

import javax.swing.*;
import java.awt.*;


public class RequestsPanel extends JPanel {
    private static client.view.request.RequestsPanel instance;

    private final JPanel RequestsPanel;

    public RequestsPanel() {
        RequestsPanel = new JPanel();

        JLabel lblTitle = new JLabel();
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();

        //======== this ========
        instance = this;
        setBackground(Color.white);
        setLayout(new BorderLayout());

        //======== panel1 ========
        {
            panel1.setBackground(FrontEnd.COLOR_DARK);
            panel1.setLayout(new FlowLayout());

            //---- lblTitle ----
            lblTitle.setText(Text.bundle.getString(Text.REQUESTS_UNDONE));
            lblTitle.setFont(FrontEnd.FONT_BIG_TITLE);
            lblTitle.setForeground(FrontEnd.COLOR_LIGHT);
            panel1.add(lblTitle);
        }
        add(panel1, BorderLayout.PAGE_START);

        //======== panel2 ========
        {
            panel2.setLayout(new FlowLayout());
            panel2.setBackground(Color.white);

            //======== RequestsPanel ========
            {
                RequestsPanel.setBackground(Color.white);
                RequestsPanel.setLayout(new BoxLayout(RequestsPanel, BoxLayout.Y_AXIS));
            }
            panel2.add(RequestsPanel);
        }
        add(panel2, BorderLayout.CENTER);
    }

    public static void loadPanel() {
        instance.RequestsPanel.removeAll();
        for (Client client : CurrentUser.manager.clients)
            for (Request request : client.requests)
                if (request.status.isPending()) {
                    instance.RequestsPanel.add(new RequestSingle().loadPanel(request));
                    instance.RequestsPanel.add(FrontEnd.emptyPanel());
                }
    }
}