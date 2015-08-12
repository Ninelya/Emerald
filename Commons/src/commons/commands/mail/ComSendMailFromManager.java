package commons.commands.mail;

import commons.commands.support.Command;
import commons.commands.support.CommandType;
import commons.info.Mail;

import java.io.Serializable;


public class ComSendMailFromManager implements Command, Serializable {
    private static final CommandType type = CommandType.SEND_MAIL_FROM_MANAGER;

    public final Mail newMail;

    public ComSendMailFromManager(Mail newMail) {
        this.newMail = newMail;
    }

    @Override
    public CommandType getType() {
        return type;
    }
}
