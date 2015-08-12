package client.service.listener;

import client.view.ClientMainScreen;
import commons.commands.login.RespPassOk;
import commons.commands.support.Respond;
import commons.user.CurrentUser;
import commons.view.Text;


public class LoginListener {

    public static void confirmPassOk(Respond respond) {
        RespPassOk resp = (RespPassOk) respond;
        CurrentUser.logIn(resp.accessType);

        switch (CurrentUser.type) {
            case client:
                CurrentUser.setClient(resp.client);
                ClientMainScreen.showClientTopCard();
                break;
            case manager:
                CurrentUser.setManager(resp.manager);
                ClientMainScreen.showManagerTopCard();
                break;
            case marketer:
                ClientMainScreen.showMarketerTopCard();
                break;
            case admin:
                CurrentUser.setUsers(resp.users);
                ClientMainScreen.showAdminCard();
        }
    }

    public static void confirmPassWrong() {
        ClientMainScreen.showMessage(
                Text.bundle.getString(Text.FAILED_PASSWORD));
    }

    public static void confirmLogOff() {
        CurrentUser.logOut();
        ClientMainScreen.loadMainWindow();
    }
}