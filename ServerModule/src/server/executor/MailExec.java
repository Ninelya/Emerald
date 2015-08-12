package server.executor;


import commons.commands.mail.ComSendMailFromClient;
import commons.commands.mail.ComSendMailFromManager;
import commons.commands.mail.RespSendMailFromClient;
import commons.commands.mail.RespSendMailFromManager;
import commons.commands.support.Command;
import commons.commands.support.Respond;
import commons.info.Client;
import commons.info.Mail;
import commons.info.status.MailStatus;
import server.repository.MailDAO;
import server.view.ServerMainScreen;

import java.util.List;

public class MailExec {

    public static Respond doSendMailFromManager(Command command) {
        ComSendMailFromManager com = (ComSendMailFromManager) command;
        int result;
        List<Mail> letters;
        Client client = com.newMail.client;
        try {
            ServerMainScreen.log("saving mail from client");
            result = MailDAO.saveMailFromManager(com.newMail);
            for (Mail letter : client.letters)
                if (letter.status.isPending()) {
                    letter.status = MailStatus.question;
                    MailDAO.setMailStatusToQuestion(letter.id);
                }
            letters = MailDAO.getMailByClientId(client.id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return new RespSendMailFromManager(result == 1, letters, client.id);
    }

    public static Respond doSendMailFromClient(Command command) {
        ComSendMailFromClient com = (ComSendMailFromClient) command;
        int result;
        Mail mail;
        try {
            ServerMainScreen.log("saving mail from client");
            result = MailDAO.saveMailFromClient(com.newMail);
            mail = MailDAO.getLastMailByClientId(com.newMail.clientId);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return new RespSendMailFromClient(result == 1, mail);
    }
}