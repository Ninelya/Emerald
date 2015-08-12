package commons.commands.login;

import commons.commands.support.Respond;
import commons.commands.support.RespondType;

import java.io.Serializable;

public class RespPassWrong implements Respond, Serializable {
    private static final RespondType type = RespondType.RET_PASS_WRONG;

    public RespPassWrong() {
    }

    @Override
    public RespondType getType() {
        return type;
    }
}
