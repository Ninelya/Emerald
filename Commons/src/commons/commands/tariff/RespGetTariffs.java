package commons.commands.tariff;


import commons.commands.support.Respond;
import commons.commands.support.RespondType;
import commons.info.Tariff;

import java.io.Serializable;
import java.util.List;

public class RespGetTariffs implements Respond, Serializable {
    private static final RespondType type = RespondType.RET_TARIFFS;

    public final List<Tariff> tariffs;
    public final boolean isConfirmed;

    public RespGetTariffs(List<Tariff> tariffs) {
        this.tariffs = tariffs;
        isConfirmed = tariffs.size() > 0;
    }

    @Override
    public RespondType getType() {
        return type;
    }
}