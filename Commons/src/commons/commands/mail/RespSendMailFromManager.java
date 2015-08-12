package commons.commands.mail;

import commons.commands.support.Respond;
import commons.commands.support.RespondType;
import commons.info.Mail;

import java.io.Serializable;
import java.util.List;

public class RespSendMailFromManager implements Respond, Serializable {
    private static final RespondType type = RespondType.RET_SEND_MAIL_FROM_MANAGER;

    public final boolean isConfirmed;
    public final List<Mail> mail;
    public final int clientId;

    public RespSendMailFromManager(boolean isConfirmed, List<Mail> mail, int clientId) {
        this.isConfirmed = isConfirmed;
        this.mail = mail;
        this.clientId = clientId;
    }

    @Override
    public RespondType getType() {
        return type;
    }
}
