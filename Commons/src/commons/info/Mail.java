package commons.info;

import commons.info.status.MailStatus;

import java.io.Serializable;
import java.util.Date;

public class Mail implements Serializable {

    private static final String PENDING = "pending";
    private static final String QUESTION = "question";
    private static final String ANSWER = "answer";

    public Client client;
    public Manager manager;

    public int id;
    public int clientId;
    public Date sentTime;
    public MailStatus status;
    public String text;

    public Mail() {
    }

    public Mail(int id, int clientId, Date sentTime,
                String status, String text) {
        this.id = id;
        this.clientId = clientId;
        this.sentTime = sentTime;
        this.text = text;
        this.status = MailStatus.valueOf(status);
    }

    public Mail(int clientId, String text) {

        this.clientId = clientId;
        this.sentTime = new Date();
        this.text = text;
        this.status = MailStatus.pending;
        this.id = -1;
    }

    public Mail(Client client, String text) {

        this.clientId = client.id;
        this.sentTime = new Date();
        this.text = text;
        this.status = MailStatus.answer;
        this.id = -1;
        this.client = client;
    }
}