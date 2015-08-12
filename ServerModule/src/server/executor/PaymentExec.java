package server.executor;

import commons.commands.payment.ComSavePayment;
import commons.commands.payment.RespSavePayment;
import commons.commands.support.Command;
import commons.commands.support.Respond;
import commons.info.Payment;
import server.repository.PaymentsDAO;
import server.view.ServerMainScreen;

public class PaymentExec {

    public static Respond doSavePayment(Command command) {
        ComSavePayment com = (ComSavePayment) command;
        int result;
        Payment payment;
        try {
            ServerMainScreen.log("saving payment");
            result = PaymentsDAO.savePayment(com.newPayment);
            payment = PaymentsDAO.getLastPaymentByCreditId(com.newPayment.credit.id);
            payment.setCredit(com.newPayment.credit);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return new RespSavePayment(result == 1, payment);
    }
}
