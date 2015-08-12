package commons.commands.client;

import commons.commands.support.Respond;
import commons.commands.support.RespondType;
import commons.info.Client;

import java.io.Serializable;

public class RespSaveClient implements Respond, Serializable {
    private static final RespondType type = RespondType.RET_SAVE_CLIENT;

    public final Client client;
    public final boolean isConfirmed;

    public RespSaveClient(Client client, boolean isConfirmed) {
        this.client = client;
        this.isConfirmed = isConfirmed;
    }

    @Override
    public RespondType getType() {
        return type;
    }
}