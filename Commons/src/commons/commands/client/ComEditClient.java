package commons.commands.client;

import commons.commands.support.Command;
import commons.commands.support.CommandType;
import commons.info.Client;

import java.io.Serializable;


public class ComEditClient implements Command, Serializable {
    private static final CommandType type = CommandType.EDIT_CLIENT;

    public final Client client;

    public ComEditClient(Client client) {
        this.client = client;
    }

    @Override
    public CommandType getType() {
        return type;
    }
}
