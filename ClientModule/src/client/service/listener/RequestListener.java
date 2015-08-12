package client.service.listener;

import client.view.ClientMainScreen;
import client.view.request.RequestNew;
import client.view.top.MenuManager;
import commons.commands.request.RespApproveRequest;
import commons.commands.request.RespDenyRequest;
import commons.commands.request.RespSaveRequest;
import commons.commands.support.Respond;
import commons.info.Client;
import commons.info.Request;
import commons.info.status.RequestStatus;
import commons.user.CurrentUser;
import commons.view.Text;


public class RequestListener {

    public static void confirmDenyRequest(Respond respond) {
        RespDenyRequest resp = (RespDenyRequest) respond;

        if (resp.isConfirmed) {
            Client client = CurrentUser.manager.getClientById(resp.request.clientId);
            Request request = client.getRequestById(resp.request.id);
            request.status = RequestStatus.denied;
            request.denyReason = resp.request.denyReason;
            MenuManager.loadRequests();
            ClientMainScreen.showMessage(
                    Text.bundle.getString(Text.REQUEST_DENIED));
        } else
            ClientMainScreen.showMessage(
                    Text.bundle.getString(Text.REQUEST_IS_NOT_DENIED));
    }

    public static void confirmApproveRequest(Respond respond) {
        RespApproveRequest resp = (RespApproveRequest) respond;

        if (resp.isConfirmed) {
            Client client = CurrentUser.manager.getClientById(resp.credit.client.id);
            Request request = client.getRequestById(resp.credit.request.id);
            client.credits.add(resp.credit);
            request.status = RequestStatus.approved;
            MenuManager.loadRequests();
            ClientMainScreen.showMessage(
                    Text.bundle.getString(Text.REQUEST_APPROVED));
        } else
            ClientMainScreen.showMessage(
                    Text.bundle.getString(Text.REQUEST_IS_NOT_APPROVED));
    }

    public static void confirmSaveRequest(Respond respond) {
        RespSaveRequest resp = (RespSaveRequest) respond;

        switch (resp.result) {
            case 1:
                ClientMainScreen.showMessage(
                        Text.bundle.getString(Text.REQUEST_IS_ACCEPTED));
                resp.request.client = CurrentUser.client;
                CurrentUser.client.requests.add(resp.request);
                CurrentUser.client.requestCount++;
                RequestNew.clearSum();
                break;
            case -1:
                ClientMainScreen.showMessage(
                        Text.bundle.getString(Text.REQUEST_ALREADY_EXISTS));
                break;
            default:
                ClientMainScreen.showMessage(
                        Text.bundle.getString(Text.REQUEST_IS_NOT_ACCEPTED));
                break;
        }
    }
}