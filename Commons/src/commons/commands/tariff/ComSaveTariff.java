package commons.commands.tariff;

import commons.commands.support.Command;
import commons.commands.support.CommandType;
import commons.info.Tariff;

import java.io.Serializable;


public class ComSaveTariff implements Command, Serializable {
    private static final CommandType type = CommandType.SAVE_TARIFF;

    public final Tariff tariff;

    public ComSaveTariff(Tariff tariff) {
        this.tariff = tariff;
    }

    @Override
    public CommandType getType() {
        return type;
    }
}
