package commons.info;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Credit implements Serializable {

    public List<Payment> payments = new ArrayList<>();

    public Client client;
    public Tariff tariff;
    public Request request;

    public final int id;
    public final int requestId;
    public final float sum;
    public final boolean payedOff;
    public final Date dateApplication;
    public final Date datePayed;
    public final float percent;

    public Credit(int id, int requestId, float sum, boolean payedOff,
                  Date dateApplication, Date datePayed, float percent) {
        this.id = id;
        this.requestId = requestId;
        this.sum = sum;
        this.payedOff = payedOff;
        this.dateApplication = dateApplication;
        this.datePayed = datePayed;
        this.percent = percent;
    }

    public float getCurrentPenalty() {
        int result = 0;
        Payment lastPayment = payments.get(payments.size() - 1);

        if (lastPayment.sum < lastPayment.penalty)
            result += lastPayment.penalty - lastPayment.sum;

        if (getMonthsLate() > 0)
            result += 50 * getMonthsLate();

        return result;
    }

    public float getLastPenalty() {
        return getMonthsLate() <= 0 ? 0 : 50 * getMonthsLate();
    }

    public int getMonthsLate() {
        Calendar today = Calendar.getInstance();
        Calendar payDay = Calendar.getInstance();
        Payment lastPayment = payments.get(payments.size() - 1);
        payDay.setTime(lastPayment.date);

        int days = (int) TimeUnit.MILLISECONDS.toDays(
                Math.abs(today.getTimeInMillis() - payDay.getTimeInMillis())
        );
        return days / 30;
    }

    public int getMonthsWithoutPenalty() {
        int result = 0;
        for (int i = payments.size() - 1; i >= 0; i--) {
            if (payments.get(i).penalty == 0)
                result++;
            else
                break;
        }
        return result;
    }

    public float getPaymentSum() {
        float result = 0;
        for (Payment payment : payments)
            result += payment.sum;
        return result;
    }

    public float getFullSum() {
        return request.sum + request.getPercent() + getAllPenalty();
    }

    public float getAllPenalty() {
        float result = 0;

        for (Payment payment : payments)
            result += payment.penalty;
        return result;
    }
}
