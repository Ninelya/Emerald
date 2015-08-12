package commons.info.status;


public enum MailStatus {
    pending,
    question,
    answer;

    public boolean isAnswer() {
        return this == answer;
    }

    public boolean isPending() {
        return this == pending;
    }
}
