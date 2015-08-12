package client.service.listener;

import client.view.ClientMainScreen;
import commons.commands.client.RespEditClient;
import commons.commands.client.RespSaveClient;
import commons.commands.support.Respond;
import commons.user.CurrentUser;
import commons.view.Text;

public class ClientListener {

    public static void confirmEditClient(Respond respond) {
        RespEditClient resp = (RespEditClient) respond;

        if (resp.isConfirmed) {
            ClientMainScreen.showMessage(
                    Text.bundle.getString(Text.CLIENT_EDITED_SUCCESSFULLY));
        } else
            ClientMainScreen.showMessage(
                    Text.bundle.getString(Text.CLIENT_IS_NOT_EDITED));
    }

    public static void confirmSaveClient(Respond respond) {
        RespSaveClient resp = (RespSaveClient) respond;

        if (resp.isConfirmed) {
            CurrentUser.manager.clients.add(resp.client);
            ClientMainScreen.showMessage(
                    Text.bundle.getString(Text.CLIENT_SAVED_SUCCESSFULLY));
        } else
            ClientMainScreen.showMessage(
                    Text.bundle.getString(Text.CLIENT_IS_NOT_SAVED));
    }
}