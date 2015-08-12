package server.service;

import commons.commands.support.Command;
import commons.commands.support.RespError;
import commons.commands.support.Respond;
import server.executor.*;
import server.view.ServerMainScreen;

public class CommandsService {

    public static Object handleCommand(Command command) {
        Respond respond = new RespError();
        ServerMainScreen.log("Executing: " + command);
        switch (command.getType()) {
            case GET_LOGIN:
                respond = LoginExec.doLogin(command);
                break;
            case GET_TARIFFS:
                respond = TariffExec.doGetTariffs();
                break;
            case DEL_TARIFF:
                respond = TariffExec.doDelTariff(command);
                break;
            case EDIT_TARIFF:
                respond = TariffExec.doEditTariff(command);
                break;
            case SAVE_TARIFF:
                respond = TariffExec.doSaveTariff(command);
                break;
            case APPROVE_REQUEST:
                respond = RequestExec.doApproveRequest(command);
                break;
            case DENY_REQUEST:
                respond = RequestExec.doDenyRequest(command);
                break;
            case SAVE_REQUEST:
                respond = RequestExec.doSaveRequest(command);
                break;
            case SEND_MAIL_FROM_CLIENT:
                respond = MailExec.doSendMailFromClient(command);
                break;
            case SEND_MAIL_FROM_MANAGER:
                respond = MailExec.doSendMailFromManager(command);
                break;
            case EDIT_USER:
                respond = UserExec.doEditUser(command);
                break;
            case SAVE_USER:
                respond = UserExec.doSaveUser(command);
                break;
            case DEL_USER:
                respond = UserExec.doDelUser(command);
                break;
            case DEL_MANAGER:
                respond = UserExec.doDelManager(command);
                break;
            case SAVE_CLIENT:
                respond = ClientExec.doSaveClient(command);
                break;
            case EDIT_CLIENT:
                respond = ClientExec.doEditClient(command);
                break;
            case SAVE_PAYMENT:
                respond = PaymentExec.doSavePayment(command);
                break;
        }
        return respond; //ответная команда клиенту
    }
}