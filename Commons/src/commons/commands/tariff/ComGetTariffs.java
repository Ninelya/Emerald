package commons.commands.tariff;


import commons.commands.support.Command;
import commons.commands.support.CommandType;

import java.io.Serializable;

public class ComGetTariffs implements Command, Serializable {
    private static final CommandType type = CommandType.GET_TARIFFS;

    public ComGetTariffs() {
    }

    @Override
    public CommandType getType() {
        return type;
    }
}