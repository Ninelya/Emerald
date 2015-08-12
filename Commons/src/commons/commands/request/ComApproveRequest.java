package commons.commands.request;

import commons.commands.support.Command;
import commons.commands.support.CommandType;
import commons.info.Request;

import java.io.Serializable;

public class ComApproveRequest implements Command, Serializable {
    private static final CommandType type = CommandType.APPROVE_REQUEST;

    public final Request request;

    public ComApproveRequest(Request request) {
        this.request = request;
    }

    @Override
    public CommandType getType() {
        return type;
    }
}