package commons.info;

import java.io.Serializable;
import java.util.Date;

public class Payment implements Serializable {
    public Credit credit;

    public int id;
    public Date date;
    public float sum;
    public float penalty;

    public Payment(int id, Date date, float sum, float penalty, Credit credit) {
        this.credit = credit;
        this.id = id;
        this.date = date;
        this.sum = sum;
        this.penalty = penalty;
    }

    public void setCredit(Credit credit) {
        this.credit = credit;
    }

    public Payment(float sum, float penalty, Credit credit) {
        this.sum = sum;
        this.penalty = penalty;
        this.credit = credit;
    }
}
