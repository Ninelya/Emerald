package commons.commands.client;

import commons.commands.support.Respond;
import commons.commands.support.RespondType;

import java.io.Serializable;

public class RespEditClient implements Respond, Serializable {
    private static final RespondType type = RespondType.RET_EDIT_CLIENT;

    public final boolean isConfirmed;

    public RespEditClient(boolean isConfirmed) {
        this.isConfirmed = isConfirmed;
    }

    @Override
    public RespondType getType() {
        return type;
    }
}