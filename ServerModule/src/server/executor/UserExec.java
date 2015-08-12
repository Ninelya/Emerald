package server.executor;

import commons.commands.moder.*;
import commons.commands.support.Command;
import commons.commands.support.Respond;
import commons.info.User;
import server.repository.ClientsDAO;
import server.repository.ModersDAO;
import server.repository.UsersDAO;
import server.view.ServerMainScreen;

public class UserExec {

    public static Respond doEditUser(Command command) {
        ComEditUser com = (ComEditUser) command;
        int save;

        try {
            ServerMainScreen.log("editing user");
            save = UsersDAO.editUser(com.user);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return new RespEditUser(save == 1);
    }

    public static Respond doDelUser(Command command) {
        ComDelUser com = (ComDelUser) command;
        int result;
        try {
            ServerMainScreen.log("deleting user");
            result = UsersDAO.delUserById(com.userId);

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return new RespDelUser(result == 1);
    }

    public static Respond doDelManager(Command command) {
        ComDelManager com = (ComDelManager) command;
        int result;
        int newManagerId;
        int thisManagerId;
        try {
            ServerMainScreen.log("deleting manager");
            thisManagerId = ModersDAO.getManagerIdById(com.userId);
            newManagerId = ModersDAO.getManagerIdByEmail(com.newManagerEmail);
            ClientsDAO.setNewManager(thisManagerId, newManagerId);
            result = UsersDAO.delUserById(com.userId);

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return new RespDelUser(result == 1);
    }

    public static Respond doSaveUser(Command command) {
        ComSaveUser com = (ComSaveUser) command;
        int save;
        User user = null;
        try {
            ServerMainScreen.log("saving new moder");
            save = UsersDAO.saveNewUser(com.user);
            if (save == 1)
                user = UsersDAO.getUserByLogin(com.user.email);
            if (com.user.access.isManager() && user != null)
                save += ModersDAO.saveNewModer(user.id);

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return new RespSaveUser(user, save == 2 && user != null);
    }
}