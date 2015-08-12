package server.executor;

import commons.commands.client.ComEditClient;
import commons.commands.client.ComSaveClient;
import commons.commands.client.RespEditClient;
import commons.commands.client.RespSaveClient;
import commons.commands.support.Command;
import commons.commands.support.Respond;
import commons.info.*;
import server.repository.*;
import server.view.ServerMainScreen;

public class ClientExec {

    public static Respond doSaveClient(Command command) {
        ComSaveClient com = (ComSaveClient) command;
        int save;
        Client client;
        try {
            ServerMainScreen.log("saving new client");
            save = UsersDAO.saveNewClientsUser(com.user);
            com.user.id = UsersDAO.getUserIdByLogin(com.user.email);
            save += ClientsDAO.saveNewClient(com.client, com.user.id);
            client = ClientsDAO.getClientByLogin(com.client.email);
            client.setManager(com.client.manager);

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return new RespSaveClient(client, save == 2);
    }

    public static Respond doEditClient(Command command) {
        ComEditClient com = (ComEditClient) command;
        int result;
        try {
            ServerMainScreen.log("editing client");
            result = ClientsDAO.editClient(com.client);
            result += UsersDAO.editClientsUser(com.client);

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return new RespEditClient(result == 2);
    }

    public static void loadClient(Client client) {

        client.letters = MailDAO.getMailByClientId(client.id);
        client.manager.mails = client.letters;

        for (Mail letter : client.letters) {
            letter.client = client;
            letter.manager = client.manager;
        }
        client.requests = RequestsDAO.getRequestsByClientId(client.id);

        for (Request request : client.requests) {
            request.client = client;
            request.tariff = Tariff.getTariffByIdForServer(request.tariffId);
            if (request.status.isPending())
                request.client.requestCount++;
        }

        for (Request request : client.requests) {
            Credit credit = CreditDAO.getCreditByRequestId(request.id);
            if (credit != null) {
                credit.client = client;
                credit.request = request;
                credit.tariff = request.tariff;
                client.credits.add(credit);
                credit.payments = PaymentsDAO.getPaymentsByCredit(credit);
            }
        }
    }
}
