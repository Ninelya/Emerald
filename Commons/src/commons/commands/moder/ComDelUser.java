package commons.commands.moder;

import commons.commands.support.Command;
import commons.commands.support.CommandType;

import java.io.Serializable;

public class ComDelUser implements Command, Serializable {
    private static final CommandType type = CommandType.DEL_USER;

    public final int userId;

    public ComDelUser(int userId) {
        this.userId = userId;
    }

    @Override
    public CommandType getType() {
        return type;
    }
}
