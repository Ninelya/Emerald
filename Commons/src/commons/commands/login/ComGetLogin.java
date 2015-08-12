package commons.commands.login;


import commons.commands.support.Command;
import commons.commands.support.CommandType;
import commons.info.User;

import java.io.Serializable;

public class ComGetLogin implements Command, Serializable {
    private static final CommandType type = CommandType.GET_LOGIN;

    public final User loginPass;

    public ComGetLogin(String login, String pass) {
        loginPass = new User(login, pass);
    }

    @Override
    public CommandType getType() {
        return type;
    }
}