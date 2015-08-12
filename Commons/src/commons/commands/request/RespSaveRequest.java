package commons.commands.request;

import commons.commands.support.Respond;
import commons.commands.support.RespondType;
import commons.info.Request;

import java.io.Serializable;

public class RespSaveRequest implements Respond, Serializable {
    private static final RespondType type = RespondType.RET_SAVE_REQUEST;

    public final int result;
    public final Request request;

    public RespSaveRequest(int result, Request request) {
        this.result = result;
        this.request = request;
    }

    @Override
    public RespondType getType() {
        return type;
    }
}