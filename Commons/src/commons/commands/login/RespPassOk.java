package commons.commands.login;

import commons.commands.support.Respond;
import commons.commands.support.RespondType;
import commons.info.Client;
import commons.info.Manager;
import commons.info.User;

import java.io.Serializable;
import java.util.List;

public class RespPassOk implements Respond, Serializable {
    private static final RespondType type = RespondType.RET_PASS_OK;

    public final String accessType;
    public final Client client;
    public final Manager manager;
    public List<User> users;

    public RespPassOk(String accessType, Client client) {
        this.accessType = accessType;
        this.client = client;
        this.manager = null;
    }

    public RespPassOk(String accessType) {
        this.accessType = accessType;
        client = null;
        manager = null;
    }

    public RespPassOk(String accessType, Manager manager) {
        this.accessType = accessType;
        this.client = null;
        this.manager = manager;
    }

    public RespPassOk(String accessType, List<User> users) {
        this.accessType = accessType;
        this.client = null;
        manager = null;
        this.users = users;
    }

    @Override
    public RespondType getType() {
        return type;
    }
}