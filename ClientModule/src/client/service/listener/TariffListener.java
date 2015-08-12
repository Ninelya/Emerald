package client.service.listener;

import client.view.ClientMainScreen;
import client.view.tariff.TariffPanel;
import commons.commands.support.Respond;
import commons.commands.tariff.RespDelTariff;
import commons.commands.tariff.RespEditTariff;
import commons.commands.tariff.RespGetTariffs;
import commons.commands.tariff.RespSaveTariff;
import commons.info.Tariff;
import commons.user.CurrentUser;
import commons.view.Text;


public class TariffListener {

    public static void confirmSaveNewTariff(Respond respond) {
        RespSaveTariff resp = (RespSaveTariff) respond;

        if (resp.isConfirmed) {
            Tariff.addToList(resp.tariff);
            ClientMainScreen.showMessage(
                    Text.bundle.getString(Text.TARIFF_SAVED_SUCCESSFULLY));
        } else
            ClientMainScreen.showMessage(
                    Text.bundle.getString(Text.TARIFF_IS_NOT_SAVED));
    }

    public static void confirmEditTariff(Respond respond) {
        RespEditTariff resp = (RespEditTariff) respond;

        if (resp.isConfirmed) {
            ClientMainScreen.showMessage(
                    Text.bundle.getString(Text.TARIFF_SAVED_SUCCESSFULLY));
        } else
            ClientMainScreen.showMessage(
                    Text.bundle.getString(Text.TARIFF_IS_NOT_SAVED));
    }

    public static void confirmDelTariff(Respond respond) {
        RespDelTariff resp = (RespDelTariff) respond;

        if (resp.isConfirmed)
            ClientMainScreen.showMessage(
                    Text.bundle.getString(Text.TARIFF_DELETED_SUCCESSFULLY)
            );
        else
            ClientMainScreen.showMessage(
                    Text.bundle.getString(Text.TARIFF_IS_NOT_DELETED)
            );
    }

    public static void loadTariffs(Respond respond) {
        RespGetTariffs resp = (RespGetTariffs) respond;

        if (resp.isConfirmed) {
            TariffPanel.loadPanel(resp.tariffs);
            CurrentUser.tariffs = resp.tariffs;
            ClientMainScreen.showLogoffMainCard();
            TariffPanel.updateLogoffUI();
        }
    }
}