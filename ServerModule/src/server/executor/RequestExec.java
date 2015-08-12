package server.executor;

import commons.commands.request.*;
import commons.commands.support.Command;
import commons.commands.support.Respond;
import commons.info.Credit;
import commons.info.Request;
import server.repository.CreditDAO;
import server.repository.RequestsDAO;
import server.view.ServerMainScreen;

public class RequestExec {

    public static Respond doDenyRequest(Command command) {
        ComDenyRequest com = (ComDenyRequest) command;
        int result;

        try {
            ServerMainScreen.log("approving request");
            result = RequestsDAO.setDenyStatusById(com.request.id, com.request.denyReason);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return new RespDenyRequest(com.request, result == 1);
    }

    public static Respond doApproveRequest(Command command) {
        ComApproveRequest com = (ComApproveRequest) command;
        int result;
        Credit credit = null;
        try {
            ServerMainScreen.log("approving request");
            result = RequestsDAO.setApproveStatusById(com.request.id);
            if (result == 1) {
                result += CreditDAO.createCredit(com.request);
                if (result == 2) {
                    credit = CreditDAO.getCreditByRequestId(com.request.id);
                    credit.client = com.request.client;
                    credit.request = com.request;
                    if (credit.request != null)
                        credit.tariff = credit.request.tariff;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return new RespApproveRequest(credit);
    }

    public static Respond doSaveRequest(Command command) {
        ComSaveRequest com = (ComSaveRequest) command;
        int result;
        Request request;
        try {
            ServerMainScreen.log("saving new request");
            result = RequestsDAO.saveRequest(com.request);
            request = RequestsDAO.getRequestByIds(
                    com.request.clientId,
                    com.request.tariffId);
            request.tariff = com.request.tariff;
            request.client = com.request.client;

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return new RespSaveRequest(result, request);
    }
}