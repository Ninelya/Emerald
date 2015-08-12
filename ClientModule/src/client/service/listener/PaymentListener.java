package client.service.listener;

import client.view.ClientMainScreen;
import client.view.payment.PaymentPanel;
import commons.commands.payment.RespSavePayment;
import commons.commands.support.Respond;
import commons.user.CurrentUser;
import commons.view.Text;

public class PaymentListener {
    public static void confirmSavePayment(Respond respond) {
        RespSavePayment resp = (RespSavePayment) respond;

        if (resp.isConfirmed) {
            CurrentUser.manager.getClientById(resp.payment.credit.client.id).
                    getCreditById(resp.payment.credit.id).payments.add(resp.payment);
            PaymentPanel.loadPanel(resp.payment.credit);
            ClientMainScreen.showMessage(
                    Text.bundle.getString(Text.PAYMENT_SAVED_SUCCESSFULLY));
        } else
            ClientMainScreen.showMessage(
                    Text.bundle.getString(Text.PAYMENT_IS_NOT_SAVED));
    }
}
