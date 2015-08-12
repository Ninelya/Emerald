package commons.commands.request;

import commons.commands.support.Respond;
import commons.commands.support.RespondType;
import commons.info.Credit;

import java.io.Serializable;

public class RespApproveRequest implements Respond, Serializable {
    private static final RespondType type = RespondType.RET_APPROVE_REQUEST;

    public final boolean isConfirmed;
    public final Credit credit;

    public RespApproveRequest(Credit credit) {
        this.credit = credit;
        this.isConfirmed = credit != null;
    }

    @Override
    public RespondType getType() {
        return type;
    }
}