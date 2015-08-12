package commons.commands.moder;

import commons.commands.support.Command;
import commons.commands.support.CommandType;

import java.io.Serializable;

public class ComDelManager implements Command, Serializable {
    private static final CommandType type = CommandType.DEL_MANAGER;

    public final int userId;
    public final String newManagerEmail;

    public ComDelManager(int userId, String newManagerEmail) {
        this.userId = userId;
        this.newManagerEmail = newManagerEmail;
    }

    @Override
    public CommandType getType() {
        return type;
    }
}
