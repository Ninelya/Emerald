package commons.commands.tariff;

import commons.commands.support.Respond;
import commons.commands.support.RespondType;
import commons.info.Tariff;

import java.io.Serializable;

public class RespSaveTariff implements Respond, Serializable {
    private static final RespondType type = RespondType.RET_SAVE_TARIFF;

    public final Tariff tariff;
    public final boolean isConfirmed;

    public RespSaveTariff(Tariff tariff) {
        this.tariff = tariff;
        isConfirmed = tariff != null;
    }

    @Override
    public RespondType getType() {
        return type;
    }
}