package commons.commands.moder;

import commons.commands.support.Respond;
import commons.commands.support.RespondType;
import commons.info.User;

import java.io.Serializable;

public class RespSaveUser implements Respond, Serializable {
    private static final RespondType type = RespondType.RET_SAVE_USER;

    public final User user;
    public final Boolean isConfirmed;

    public RespSaveUser(User user, Boolean isConfirmed) {
        this.user = user;
        this.isConfirmed = isConfirmed;
    }

    @Override
    public RespondType getType() {
        return type;
    }
}