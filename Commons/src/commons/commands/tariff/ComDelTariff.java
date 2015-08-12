package commons.commands.tariff;

import commons.commands.support.Command;
import commons.commands.support.CommandType;

import java.io.Serializable;

public class ComDelTariff implements Command, Serializable {
    private static final CommandType type = CommandType.DEL_TARIFF;

    public final int tariffId;

    public ComDelTariff(int tariffId) {
        this.tariffId = tariffId;
    }

    @Override
    public CommandType getType() {
        return type;
    }
}
