package client.view;

import client.view.client.ClientEdit;
import client.view.client.ClientExpand;
import client.view.client.ClientNew;
import client.view.client.ClientsPanel;
import client.view.credit.CreditExpand;
import client.view.credit.CreditPanel;
import client.view.mail.client.MailForClient;
import client.view.mail.manager.MailForManager;
import client.view.mail.manager.MailNewPanel;
import client.view.moder.ModerEdit;
import client.view.moder.ModerNew;
import client.view.moder.ModerPanel;
import client.view.payment.PaymentPanel;
import client.view.request.*;
import client.view.settings.SettingsEdit;
import client.view.tariff.TariffEdit;
import client.view.tariff.TariffExpand;
import client.view.tariff.TariffNew;
import client.view.tariff.TariffPanel;
import client.view.top.*;
import commons.info.*;
import commons.view.FrontEnd;
import commons.view.Text;
import commons.view.View;

import javax.swing.*;
import java.awt.*;

public class ClientMainScreen extends JFrame implements View {
    static public ClientMainScreen instance;

    private JFrame frame;
    private final JPanel clientPanel;
    private final JPanel jpTop;
    private final JPanel jpMain;

    private final CardLayout clTop;
    private final CardLayout clMain;

    private final static String MENU_LOGOFF = "MenuLogOff";                     //41
    private final static String MENU_CLIENT = "MenuClient";                     //42
    private final static String MENU_MANAGER = "MenuManager";                   //43
    private final static String MENU_MARKETER = "MenuMarketer";                 //44
    private final static String MENU_ADMIN = "MenuAdmin";                       //45

    private final static String TARIFF_PANEL = "TariffPanel";                   //0
    private final static String TARIFF_EXPAND = "TariffExpand";                 //5
    private final static String TARIFF_EDIT = "TariffEdit";                     //21
    private final static String TARIFF_NEW = "TariffNew";                       //22

    private final static String REQUEST_PANEL_CLIENTS = "RequestPanelClients";  //4
    private final static String REQUEST_EXPAND = "RequestExpand";               //7
    private final static String REQUEST_NEW = "RequestNew";                     //6

    private final static String REQUEST_PANEL = "RequestPanel";                 //10
    private final static String REQUEST_APPROVE = "RequestApprove";             //14

    private final static String CREDIT_HISTORY_PANEL = "CreditPanel";           //3
    private final static String CREDIT_EXPAND = "CreditExpand";                 //8
    private final static String PAYMENT_PANEL = "PaymentPanel";                 //17

    private final static String CLIENT_PANEL = "clientPanel";                   //11
    private final static String CLIENT_EXPAND = "ClientExpand";                 //1
    private final static String CLIENT_EDIT = "ClientEdit";                     //12
    private final static String CLIENT_NEW = "ClientNew";                       //15

    private final static String MAIL_NEW_PANEL = "MailNewPanel";                //16
    private final static String MAIL_FOR_MANAGER = "MailForManager";            //13
    private final static String MAIL_FOR_CLIENT = "MailForClient";              //2

    private final static String MODER_PANEL = "ModerPanel";                     //31
    private final static String MODER_EDIT = "ModerEdit";                       //32
    private final static String MODER_NEW = "ModerNew";                         //33
    private final static String SETTINGS_EDIT = "SettingsEdit";                 //34


    public ClientMainScreen() {

        clientPanel = new JPanel();
        jpMain = new JPanel();
        jpTop = new JPanel();

        JScrollPane jScrollPane = new JScrollPane();

        instance = this;

        //======== clientPanel ========
        {
            clientPanel.setPreferredSize(FrontEnd.SIZE_WINDOW);
            clientPanel.setLayout(new BorderLayout());

            //======== jpTop ========
            jpTop.setLayout(new CardLayout());
            clientPanel.add(jpTop, BorderLayout.NORTH);

            //======== jpMain ========
            jpMain.setLayout(new CardLayout());
            jScrollPane.setViewportView(jpMain);
            clientPanel.add(jScrollPane, BorderLayout.CENTER);
        }

        clTop = (CardLayout) (jpTop.getLayout());
        clMain = (CardLayout) (jpMain.getLayout());

        setCards();
    }

    private void setCards() {
        jpTop.removeAll();
        jpMain.removeAll();

        jpTop.add(MENU_LOGOFF, new MenuLogOff());
        jpTop.add(MENU_CLIENT, new MenuClient());
        jpTop.add(MENU_MANAGER, new MenuManager());
        jpTop.add(MENU_MARKETER, new MenuMarketer());
        jpTop.add(MENU_ADMIN, new MenuAdmin());

        jpMain.add(TARIFF_PANEL, new TariffPanel());
        jpMain.add(TARIFF_EDIT, new TariffEdit());
        jpMain.add(TARIFF_EXPAND, new TariffExpand());
        jpMain.add(TARIFF_NEW, new TariffNew());

        jpMain.add(REQUEST_PANEL_CLIENTS, new RequestsPanelClients());
        jpMain.add(REQUEST_EXPAND, new RequestExpand());
        jpMain.add(REQUEST_NEW, new RequestNew());

        jpMain.add(REQUEST_PANEL, new RequestsPanel());
        jpMain.add(REQUEST_APPROVE, new RequestApprove());

        jpMain.add(CREDIT_HISTORY_PANEL, new CreditPanel());
        jpMain.add(CREDIT_EXPAND, new CreditExpand());
        jpMain.add(PAYMENT_PANEL, new PaymentPanel());

        jpMain.add(CLIENT_PANEL, new ClientsPanel());
        jpMain.add(CLIENT_EXPAND, new ClientExpand());
        jpMain.add(CLIENT_EDIT, new ClientEdit());
        jpMain.add(CLIENT_NEW, new ClientNew());

        jpMain.add(MAIL_FOR_CLIENT, new MailForClient());
        jpMain.add(MAIL_FOR_MANAGER, new MailForManager());
        jpMain.add(MAIL_NEW_PANEL, new MailNewPanel());

        jpMain.add(MODER_PANEL, new ModerPanel());
        jpMain.add(MODER_EDIT, new ModerEdit());
        jpMain.add(MODER_NEW, new ModerNew());
        jpMain.add(SETTINGS_EDIT, new SettingsEdit());
    }

    @Override
    public void render() {
        frame = new JFrame(Text.bundle.getString(Text.EMERALD));
        frame.setContentPane(ClientMainScreen.instance.clientPanel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        loadMainWindow();

        frame.pack();
        frame.setVisible(true);
    }

    public void update() {
        frame.setTitle(Text.bundle.getString(Text.EMERALD));
        setCards();
        loadMainWindow();
        clientPanel.updateUI();
    }

    public static void loadMainWindow() {//0, 41
        MenuLogOff.clearFields();
        instance.clTop.show(instance.jpTop, MENU_LOGOFF);
        instance.clMain.show(instance.jpMain, TARIFF_PANEL);
        TariffPanel.getTariffsForLogoff();
        scroll();
    }

    public static void showClientTopCard() {//42
        MenuClient.loadPanel();
        instance.clTop.show(instance.jpTop, MENU_CLIENT);
    }

    public static void showManagerTopCard() {//43
        MenuManager.loadMailAndRequests();
        instance.clTop.show(instance.jpTop, MENU_MANAGER);
    }

    public static void showMarketerTopCard() {//44
        instance.clTop.show(instance.jpTop, MENU_MARKETER);
    }

    public static void showAdminCard() {//45, 31
        instance.clTop.show(instance.jpTop, MENU_ADMIN);
        ModerPanel.loadPanel();
        instance.clMain.show(instance.jpMain, MODER_PANEL);
    }

    public static void loadLogoffMainCard() {//0
        instance.clMain.show(instance.jpMain, TARIFF_PANEL);
        TariffPanel.getTariffsForLogoff();
        scroll();
    }

    public static void showLogoffMainCard() {//0
        instance.clMain.show(instance.jpMain, TARIFF_PANEL);
        scroll();
    }

    public static void showTariffExpand(Tariff tariff) {//5
        TariffExpand.loadPanel(tariff);
        instance.clMain.show(instance.jpMain, TARIFF_EXPAND);
        scroll();
    }

    public static void showTariffEdit(Tariff tariff) {//21
        TariffEdit.loadPanel(tariff);
        instance.clMain.show(instance.jpMain, TARIFF_EDIT);
        scroll();
    }

    public static void showNewTariff() {//22
        instance.clMain.show(instance.jpMain, TARIFF_NEW);
        scroll();
    }

    public static void showRequestPanelClient(Client client) {//4
        RequestsPanelClients.loadPanel(client);
        instance.clMain.show(instance.jpMain, REQUEST_PANEL_CLIENTS);
        scroll();
    }

    public static void showRequestExpand(Request request) {//7
        RequestExpand.loadPanel(request);
        instance.clMain.show(instance.jpMain, REQUEST_EXPAND);
        scroll();
    }

    public static void showRequestNew(Tariff tariff) {//6
        RequestNew.loadPanel(tariff);
        instance.clMain.show(instance.jpMain, REQUEST_NEW);
        scroll();
    }

    public static void showRequestPanel() {//10
        RequestsPanel.loadPanel();
        instance.clMain.show(instance.jpMain, REQUEST_PANEL);
        scroll();
    }

    public static void showRequestApprove(Request request) {//14
        RequestApprove.loadPanel(request);
        instance.clMain.show(instance.jpMain, REQUEST_APPROVE);
        scroll();
    }

    public static void showCreditHistoryPanel(Client client) {//3
        CreditPanel.loadPanel(client);
        instance.clMain.show(instance.jpMain, CREDIT_HISTORY_PANEL);
        scroll();
    }

    public static void showCreditExpand(Credit credit) {//8
        CreditExpand.loadPanel(credit);
        instance.clMain.show(instance.jpMain, CREDIT_EXPAND);
        scroll();
    }

    public static void showPaymentPanel(Credit credit) {//17
        PaymentPanel.loadPanel(credit);
        instance.clMain.show(instance.jpMain, PAYMENT_PANEL);
        scroll();
    }

    public static void showClientPanel() {//11
        ClientsPanel.loadPanel();
        instance.clMain.show(instance.jpMain, CLIENT_PANEL);
        scroll();
    }

    public static void showClientExpand(Client client) {//1
        ClientExpand.loadPanel(client);
        instance.clMain.show(instance.jpMain, CLIENT_EXPAND);
        scroll();
    }

    public static void showClientEdit(Client client) {//12
        ClientEdit.loadPanel(client);
        instance.clMain.show(instance.jpMain, CLIENT_EDIT);
        scroll();
    }

    public static void showClientNew() {//15
        ClientNew.loadPanel();
        instance.clMain.show(instance.jpMain, CLIENT_NEW);
        scroll();
    }

    public static void showMailNewPanel() {//16
        MailNewPanel.loadPanel();
        instance.clMain.show(instance.jpMain, MAIL_NEW_PANEL);
        scroll();
    }

    public static void showMailForManager(Client client) {//13
        MailForManager.loadPanel(client);
        instance.clMain.show(instance.jpMain, MAIL_FOR_MANAGER);
        scroll();
    }

    public static void showMailForClient() {//2
        MailForClient.loadPanel();
        instance.clMain.show(instance.jpMain, MAIL_FOR_CLIENT);
        scroll();
    }

    public static void showModerPanel() {//31
        ModerPanel.loadPanel();
        instance.clMain.show(instance.jpMain, MODER_PANEL);
        scroll();
    }

    public static void showModerEdit(User user) {//32
        ModerEdit.loadPanel(user);
        instance.clMain.show(instance.jpMain, MODER_EDIT);
        scroll();
    }

    public static void showModerNew() {//33
        instance.clMain.show(instance.jpMain, MODER_NEW);
        scroll();
    }

    public static void showSettingsEdit() {//34
        SettingsEdit.loadPanel();
        instance.clMain.show(instance.jpMain, SETTINGS_EDIT);
        scroll();
    }

    private static void scroll() {
        Rectangle rect = new Rectangle(0, 0, 1, 1);
        instance.jpMain.scrollRectToVisible(rect);
    }

    public static void showMessage(String message) {
        JOptionPane.showMessageDialog(instance, message);
    }

    public static int showConfirm(String title, String question) {
        return JOptionPane.showConfirmDialog(
                instance,
                question,
                title,
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
    }
}