package commons.commands.tariff;

import commons.commands.support.Respond;
import commons.commands.support.RespondType;

import java.io.Serializable;

public class RespEditTariff implements Respond, Serializable {
    private static final RespondType type = RespondType.RET_EDIT_TARIFF;

    public final boolean isConfirmed;

    public RespEditTariff(boolean isConfirmed) {
        this.isConfirmed = isConfirmed;
    }

    @Override
    public RespondType getType() {
        return type;
    }
}
