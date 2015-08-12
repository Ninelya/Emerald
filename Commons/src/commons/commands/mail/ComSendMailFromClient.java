package commons.commands.mail;

import commons.commands.support.Command;
import commons.commands.support.CommandType;
import commons.info.Mail;

import java.io.Serializable;


public class ComSendMailFromClient implements Command, Serializable {
    private static final CommandType type = CommandType.SEND_MAIL_FROM_CLIENT;

    public final Mail newMail;

    public ComSendMailFromClient(Mail newMail) {
        this.newMail = newMail;
    }

    @Override
    public CommandType getType() {
        return type;
    }
}
