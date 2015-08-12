package commons.commands.client;

import commons.commands.support.Command;
import commons.commands.support.CommandType;
import commons.info.Client;
import commons.info.User;

import java.io.Serializable;

public class ComSaveClient implements Command, Serializable {
    private static final CommandType type = CommandType.SAVE_CLIENT;

    public final Client client;
    public final User user;

    public ComSaveClient(Client client, User user) {
        this.client = client;
        this.user = user;
    }

    @Override
    public CommandType getType() {
        return type;
    }
}
