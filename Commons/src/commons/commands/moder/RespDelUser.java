package commons.commands.moder;

import commons.commands.support.Respond;
import commons.commands.support.RespondType;

import java.io.Serializable;

public class RespDelUser implements Respond, Serializable {
    private static final RespondType type = RespondType.RET_DEL_USER;

    public final boolean isConfirmed;

    public RespDelUser(boolean isConfirmed) {
        this.isConfirmed = isConfirmed;
    }

    @Override
    public RespondType getType() {
        return type;
    }
}