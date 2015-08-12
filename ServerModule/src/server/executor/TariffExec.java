package server.executor;


import commons.commands.support.Command;
import commons.commands.support.Respond;
import commons.commands.tariff.*;
import commons.info.Tariff;
import server.repository.TariffsDAO;
import server.view.ServerMainScreen;

import java.util.List;

public class TariffExec {

    public static Respond doEditTariff(Command command) {
        ComEditTariff com = (ComEditTariff) command;
        int result;
        try {
            ServerMainScreen.log("saving tariff");
            result = TariffsDAO.editTariff(com.tariff);

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return new RespEditTariff(result == 1);
    }

    public static Respond doSaveTariff(Command command) {
        ComSaveTariff com = (ComSaveTariff) command;
        int save;
        Tariff result = null;
        try {
            ServerMainScreen.log("saving new tariff");
            save = TariffsDAO.saveNewTariff(com.tariff);
            if (save == 1)
                result = TariffsDAO.getTariffByName(com.tariff.name);

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return new RespSaveTariff(result);
    }

    public static Respond doDelTariff(Command command) {
        ComDelTariff com = (ComDelTariff) command;
        int result;
        try {
            ServerMainScreen.log("deleting tariff");
            result = TariffsDAO.delTariff(com.tariffId);

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return new RespDelTariff(result == 1);
    }

    public static Respond doGetTariffs() {
        List<Tariff> tariffs;
        try {
            ServerMainScreen.log("retrieving credit programs");
            tariffs = TariffsDAO.getTariffs();

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return new RespGetTariffs(tariffs);
    }
}