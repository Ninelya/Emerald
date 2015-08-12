package commons.commands.mail;

import commons.commands.support.Respond;
import commons.commands.support.RespondType;
import commons.info.Mail;

import java.io.Serializable;

public class RespSendMailFromClient implements Respond, Serializable {
    private static final RespondType type = RespondType.RET_SEND_MAIL_FROM_CLIENT;

    public final boolean isConfirmed;
    public final Mail mail;

    public RespSendMailFromClient(boolean isConfirmed, Mail mail) {
        this.isConfirmed = isConfirmed;
        this.mail = mail;
    }

    @Override
    public RespondType getType() {
        return type;
    }
}
