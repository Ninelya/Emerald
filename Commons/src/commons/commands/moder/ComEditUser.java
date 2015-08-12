package commons.commands.moder;

import commons.commands.support.Command;
import commons.commands.support.CommandType;
import commons.info.User;

import java.io.Serializable;

public class ComEditUser implements Command, Serializable {
    private static final CommandType type = CommandType.EDIT_USER;

    public final User user;

    public ComEditUser(User user) {
        this.user = user;
    }

    @Override
    public CommandType getType() {
        return type;
    }
}
