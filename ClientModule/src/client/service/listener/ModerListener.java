package client.service.listener;

import client.view.ClientMainScreen;
import client.view.top.MenuManager;
import commons.commands.moder.RespDelUser;
import commons.commands.moder.RespEditUser;
import commons.commands.moder.RespSaveUser;
import commons.commands.support.Respond;
import commons.user.CurrentUser;
import commons.view.Text;


public class ModerListener {

    public static void confirmDelUser(Respond respond) {
        RespDelUser resp = (RespDelUser) respond;
        if (CurrentUser.isManager())
            MenuManager.loadMailAndRequests();

        if (resp.isConfirmed)
            ClientMainScreen.showMessage(
                    Text.bundle.getString(Text.MODER_DELETED_SUCCESSFULLY)
            );
        else
            ClientMainScreen.showMessage(
                    Text.bundle.getString(Text.MODER_IS_NOT_DELETED)
            );
    }

    public static void confirmSaveModer(Respond respond) {
        RespSaveUser resp = (RespSaveUser) respond;

        if (resp.isConfirmed) {
            CurrentUser.users.add(resp.user);
            ClientMainScreen.showMessage(
                    Text.bundle.getString(Text.MODER_SAVED_SUCCESSFULLY));
        } else
            ClientMainScreen.showMessage(
                    Text.bundle.getString(Text.MODER_IS_NOT_SAVED));
    }

    public static void confirmEditModer(Respond respond) {
        RespEditUser resp = (RespEditUser) respond;

        if (resp.isConfirmed)
            ClientMainScreen.showMessage(
                    Text.bundle.getString(Text.USER_EDITED_SUCCESSFULLY)
            );
        else
            ClientMainScreen.showMessage(
                    Text.bundle.getString(Text.USER_IS_NOT_EDITED)
            );
    }
}