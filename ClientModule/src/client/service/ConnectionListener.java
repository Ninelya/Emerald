package client.service;

import client.service.listener.*;
import commons.commands.support.Respond;

class ConnectionListener {

    static void process(Respond respond) {
        switch (respond.getType()) {
            case RET_ERROR:
                break;
            case RET_TARIFFS:
                TariffListener.loadTariffs(respond);
                break;
            case RET_PASS_OK:
                LoginListener.confirmPassOk(respond);
                break;
            case RET_PASS_WRONG:
                LoginListener.confirmPassWrong();
                break;
            case RET_DEL_TARIFF:
                TariffListener.confirmDelTariff(respond);
                break;
            case RET_EDIT_TARIFF:
                TariffListener.confirmEditTariff(respond);
                break;
            case RET_SAVE_TARIFF:
                TariffListener.confirmSaveNewTariff(respond);
                break;
            case RET_APPROVE_REQUEST:
                RequestListener.confirmApproveRequest(respond);
                break;
            case RET_DENY_REQUEST:
                RequestListener.confirmDenyRequest(respond);
                break;
            case RET_SAVE_REQUEST:
                RequestListener.confirmSaveRequest(respond);
                break;
            case RET_SEND_MAIL_FROM_CLIENT:
                MailListener.confirmSendMailFromClient(respond);
                break;
            case RET_SEND_MAIL_FROM_MANAGER:
                MailListener.confirmSendMailFromManager(respond);
                break;
            case RET_EDIT_USER:
                ModerListener.confirmEditModer(respond);
                break;
            case RET_SAVE_USER:
                ModerListener.confirmSaveModer(respond);
                break;
            case RET_DEL_USER:
                ModerListener.confirmDelUser(respond);
                break;
            case RET_SAVE_CLIENT:
                ClientListener.confirmSaveClient(respond);
                break;
            case RET_EDIT_CLIENT:
                ClientListener.confirmEditClient(respond);
                break;
            case RET_SAVE_PAYMENT:
                PaymentListener.confirmSavePayment(respond);
                break;
        }
    }
}