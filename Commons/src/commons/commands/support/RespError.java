package commons.commands.support;

import java.io.Serializable;

public class RespError implements Respond, Serializable {
    private static final RespondType type = RespondType.RET_ERROR;

    public RespError() {
    }

    @Override
    public RespondType getType() {
        return type;
    }
}