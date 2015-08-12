package client.view.tariff;

import client.service.ConnectionInvoker;
import commons.commands.tariff.ComGetTariffs;
import commons.info.Tariff;
import commons.user.CurrentUser;
import commons.view.FrontEnd;
import commons.view.Text;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class TariffPanel extends JPanel {
    private static TariffPanel instance;

    private final JPanel JPMainLogOff;
    private final JPanel panel1;
    private final JLabel label1;

    public TariffPanel() {
        label1 = new JLabel();
        panel1 = new JPanel();
        JPMainLogOff = new JPanel();

        JPanel panel2 = new JPanel();

        //======== this ========
        setBackground(Color.white);
        setLayout(new BorderLayout());
        instance = this;

        //======== panel1 ========
        {
            panel1.setBackground(FrontEnd.COLOR_DARK);
            panel1.setForeground(FrontEnd.COLOR_LIGHT);
            panel1.setLayout(new FlowLayout());

            //---- label1 ----
            label1.setText(Text.bundle.getString(Text.TARIFF_LIST));
            label1.setFont(FrontEnd.FONT_BIG_TITLE);
            label1.setForeground(FrontEnd.COLOR_LIGHT);
            panel1.add(label1);
        }
        add(panel1, BorderLayout.NORTH);

        //======== panel2 ========
        {
            panel2.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 5));
            panel2.setBackground(Color.white);

            //======== JPMainLogOff ========
            {
                JPMainLogOff.setBackground(Color.white);
                JPMainLogOff.setLayout(new BoxLayout(JPMainLogOff, BoxLayout.Y_AXIS));
            }
            panel2.add(JPMainLogOff);
        }
        add(panel2, BorderLayout.CENTER);
    }

    public static void loadPanel(List<Tariff> tariffs) {
        instance.JPMainLogOff.removeAll();
        for (Tariff tariff : tariffs)
            if (tariff.isActive || CurrentUser.isMarketer()) {
                instance.JPMainLogOff.add(new TariffSingle().loadPanel(tariff));
                instance.JPMainLogOff.add(FrontEnd.emptyPanel());
            }
    }

    public static void getTariffsForLogoff() {
        ConnectionInvoker.invoke(new ComGetTariffs());
    }

    public static void updateLogoffUI() {
        instance.JPMainLogOff.updateUI();
    }
}