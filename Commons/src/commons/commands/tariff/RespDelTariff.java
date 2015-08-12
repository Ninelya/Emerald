package commons.commands.tariff;

import commons.commands.support.Respond;
import commons.commands.support.RespondType;

import java.io.Serializable;

public class RespDelTariff implements Respond, Serializable {
    private static final RespondType type = RespondType.RET_DEL_TARIFF;

    public final boolean isConfirmed;

    public RespDelTariff(boolean isConfirmed) {
        this.isConfirmed = isConfirmed;
    }

    @Override
    public RespondType getType() {
        return type;
    }
}