package commons.commands.request;

import commons.commands.support.Respond;
import commons.commands.support.RespondType;
import commons.info.Request;

import java.io.Serializable;

public class RespDenyRequest implements Respond, Serializable {
    private static final RespondType type = RespondType.RET_DENY_REQUEST;

    public final boolean isConfirmed;
    public final Request request;

    public RespDenyRequest(Request request, boolean isConfirmed) {
        this.isConfirmed = isConfirmed;
        this.request = request;
    }

    @Override
    public RespondType getType() {
        return type;
    }
}