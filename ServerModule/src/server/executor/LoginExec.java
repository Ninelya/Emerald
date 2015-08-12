package server.executor;

import commons.commands.login.ComGetLogin;
import commons.commands.login.RespPassOk;
import commons.commands.login.RespPassWrong;
import commons.commands.support.Command;
import commons.commands.support.Respond;
import commons.info.Client;
import commons.info.Manager;
import commons.info.User;
import commons.info.status.AccessType;
import server.repository.ClientsDAO;
import server.repository.UsersDAO;
import server.view.ServerMainScreen;

import java.util.List;

public class LoginExec {

    public static Respond doLogin(Command command) {
        ComGetLogin com = (ComGetLogin) command;
        Client client;
        Manager manager;
        List<User> users;
        try {
            ServerMainScreen.log("login and password are received");
            if (!UsersDAO.getPasswordChecked(com.loginPass))
                return new RespPassWrong();

            String access = UsersDAO.getUserAccessType(com.loginPass.email);
            switch (AccessType.valueOf(access)) {
                case client:
                    client = loadDBForClient(com.loginPass.email);
                    return new RespPassOk(access, client);
                case manager:
                    manager = loadDBForManager(com.loginPass.email);
                    return new RespPassOk(access, manager);
                case admin:
                    users = UsersDAO.loadUsersForAdmin();
                    return new RespPassOk(access, users);
                default:
                    return new RespPassOk(access);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    private static Client loadDBForClient(String login) {

        Client client = ClientsDAO.getClientByLogin(login);
        client.setManager(UsersDAO.getManagerById(client.managerId));

        ClientExec.loadClient(client);

        return client;
    }

    private static Manager loadDBForManager(String login) {

        Manager manager = UsersDAO.getManagerByLogin(login);
        manager.clients = ClientsDAO.getClientsByManagerId(manager.id);

        for (Client client : manager.clients) {
            client.setManager(manager);
            ClientExec.loadClient(client);
        }
        return manager;
    }
}