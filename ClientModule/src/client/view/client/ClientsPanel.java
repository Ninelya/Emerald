package client.view.client;

import client.view.ClientMainScreen;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;
import commons.info.Client;
import commons.info.ClientComparatorNames;
import commons.info.ClientComparatorRequests;
import commons.user.CurrentUser;
import commons.view.FrontEnd;
import commons.view.Text;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ClientsPanel extends JPanel {
    private static ClientsPanel instance;
    private final List<Client> clientList;

    private final JTextField tfSearch;
    private final JButton btnSearch;
    private final JPanel clientsPanel;
    private final JComboBox<String> cbSort;

    public ClientsPanel() {
        clientList = new ArrayList<>();

        clientsPanel = new JPanel();
        btnSearch = new JButton();
        tfSearch = new JTextField();
        cbSort = new JComboBox<>();

        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();
        Spacer hSpacer1 = new Spacer();
        JLabel lblTitle = new JLabel();
        JLabel label1 = new JLabel();

        //======== this ========
        instance = this;
        setLayout(new BorderLayout());

        //======== panel1 ========
        {
            panel1.setBackground(FrontEnd.COLOR_DARK);
            panel1.setLayout(new GridLayoutManager(2, 1, new Insets(0, 0, 0, 0), 0, 0));

            //---- lblTitle ----
            lblTitle.setText(Text.bundle.getString(Text.CLIENT_LIST));
            lblTitle.setForeground(FrontEnd.COLOR_LIGHT);
            lblTitle.setFont(FrontEnd.FONT_BIG_TITLE);
            panel1.add(lblTitle, new GridConstraints(0, 0, 1, 1,
                    GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
                    GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                    GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                    null, null, null));

            //======== panel2 ========
            {
                panel2.setBackground(FrontEnd.COLOR_LIGHT);
                panel2.setLayout(new FlowLayout());

                //======== panel3 ========
                {
                    panel3.setBackground(FrontEnd.COLOR_LIGHT);
                    panel3.setLayout(new GridLayoutManager(3, 4, new Insets(0, 0, 0, 0), 3, 3));

                    //---- label1 ----
                    label1.setText(Text.bundle.getString(Text.SEARCH_BY_FIRST_NAME));
                    label1.setFont(FrontEnd.FONT_TITLE);
                    label1.setForeground(FrontEnd.COLOR_DARK);
                    panel3.add(label1, new GridConstraints(1, 0, 1, 2,
                            GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                            null, null, null));

                    //---- tfSearch ----
                    tfSearch.setBackground(Color.white);
                    tfSearch.setFont(FrontEnd.FONT_NORM);
                    panel3.add(tfSearch, new GridConstraints(2, 0, 1, 1,
                            GridConstraints.ANCHOR_NORTH, GridConstraints.FILL_HORIZONTAL,
                            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                            null, FrontEnd.SIZE_TEXT_FIELD, null));

                    //---- btnSearch ----
                    btnSearch.setText(Text.bundle.getString(Text.BUTTON_SEARCH));
                    btnSearch.setBackground(FrontEnd.COLOR_DARK);
                    btnSearch.setFont(FrontEnd.FONT_BOLD);
                    panel3.add(btnSearch, new GridConstraints(2, 1, 1, 1,
                            GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
                            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                            null, null, null));

                    //---- hSpacer1 ----
                    panel3.add(hSpacer1, new GridConstraints(2, 2, 1, 1,
                            GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL,
                            GridConstraints.SIZEPOLICY_CAN_GROW | GridConstraints.SIZEPOLICY_WANT_GROW,
                            GridConstraints.SIZEPOLICY_CAN_SHRINK,
                            null, FrontEnd.SIZE_SPACER, null));

                    //---- cbSort ----
                    cbSort.setBackground(FrontEnd.COLOR_LIGHT);
                    cbSort.setFont(FrontEnd.FONT_NORM);
                    cbSort.addItem(Text.bundle.getString(Text.SORT_TEXT));
                    cbSort.addItem(Text.bundle.getString(Text.SORT_NAMES));
                    cbSort.addItem(Text.bundle.getString(Text.SORT_REQUESTS));
                    panel3.add(cbSort, new GridConstraints(2, 3, 1, 1,
                            GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL,
                            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                            null, null, null));
                }
                panel2.add(panel3);
            }
            panel1.add(panel2, new GridConstraints(1, 0, 1, 1,
                    GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
                    GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                    GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                    null, null, null));
        }
        add(panel1, BorderLayout.NORTH);

        //======== panel4 ========
        {
            panel4.setLayout(new FlowLayout());
            panel4.setBackground(Color.white);

            //======== clientsPanel ========
            {
                clientsPanel.setBackground(Color.white);
                clientsPanel.setLayout(new BoxLayout(clientsPanel, BoxLayout.Y_AXIS));
            }
            panel4.add(clientsPanel);
        }
        add(panel4, BorderLayout.CENTER);

        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tfSearch.getText().isEmpty())
                    ClientMainScreen.showMessage(Text.bundle.getString(Text.ENTER_CLIENT_NAME));
                else
                    findClient(tfSearch.getText());
            }
        });

        cbSort.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox cb = (JComboBox) e.getSource();
                if (cb.getSelectedIndex() != FrontEnd.COMBO_ITEM_0) {
                    sortClients(cb.getSelectedIndex());
                    cb.setSelectedIndex(FrontEnd.COMBO_ITEM_0);
                    tfSearch.requestFocusInWindow();
                    updateUI();
                }
            }
        });
    }

    private void findClient(String searchName) {
        clientsPanel.removeAll();
        for (Client client : clientList)
            if (searchName.equalsIgnoreCase(client.name.substring(0, searchName.length()))) {
                clientsPanel.add(new ClientSingle().loadPanel(client));
                clientsPanel.add(FrontEnd.emptyPanel());
            }
        clientsPanel.updateUI();
    }

    private void sortClients(int parameter) {
        clientsPanel.removeAll();
        tfSearch.setText("");

        switch (parameter) {
            case FrontEnd.COMBO_ITEM_1:
                Collections.sort(clientList, new ClientComparatorNames());
                break;
            case FrontEnd.COMBO_ITEM_2:
                Collections.sort(clientList, new ClientComparatorRequests());
                break;
            default:
                break;
        }
        for (Client client : clientList) {
            clientsPanel.add(new ClientSingle().loadPanel(client));
            clientsPanel.add(FrontEnd.emptyPanel());
        }
    }

    public static void loadPanel() {
        instance.clientsPanel.removeAll();
        instance.clientList.clear();
        for (Client client : CurrentUser.manager.clients) {
            instance.clientsPanel.add(new ClientSingle().loadPanel(client));
            instance.clientsPanel.add(FrontEnd.emptyPanel());
            instance.clientList.add(client);
        }
    }
}