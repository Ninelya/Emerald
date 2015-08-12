package commons.info;

import commons.info.status.RequestStatus;
import commons.view.Text;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Request implements Serializable {

    public static final List<Request> requestList = new ArrayList<>();

    public Tariff tariff;
    public Client client;

    public int id;
    public final int clientId;
    public final int tariffId;
    public final float sum;
    public int income;
    public boolean guarantee;
    public RequestStatus status;
    public Date createDate;
    public String denyReason;

    private static final float incomeSmall = 1000;
    private static final float incomeBig = 7000;
    private static final float sumSmall = 1000;
    private static final float sumMedium = 10000;
    private static final float sumBig = 50000;

    public Request(int id, int clientId, int tariffId, float sum,
                   int income, boolean guarantee, RequestStatus status,
                   Date createDate, String denyReason) {
        this.id = id;
        this.clientId = clientId;
        this.tariffId = tariffId;
        this.sum = sum;
        this.income = income;
        this.guarantee = guarantee;
        this.status = status;
        this.createDate = createDate;
        this.denyReason = denyReason;
        requestList.add(this);
    }

    public Request(Client client, Tariff tariff, float sum) {
        this.client = client;
        this.tariff = tariff;
        this.clientId = client.id;
        this.tariffId = tariff.id;
        this.sum = sum;
    }

    public static Request getRequestByIds(int clientId, int tariffId) {
        for (Request request : requestList)
            if (request.clientId == clientId
                    && request.tariffId == tariffId)
                return request;
        return null;
    }

    public float getPercent() {
        return sum / 1200 * tariff.rate * tariff.termMonth;
    }

    public boolean isApprovable() {
        return sum < sumSmall ||
                sum < sumMedium && client.income > incomeSmall ||
                sum < sumBig && client.income > incomeBig &&
                        (client.seniority >= 3 || client.hasGuarantee) ||
                sum >= sumBig && client.income > incomeBig &&
                        client.seniority >= 3 && client.hasGuarantee;
    }

    public String getDenyReason() {
        String result = Text.bundle.getString(Text.CONDITIONS);
        if (sum > sumSmall && sum < sumMedium)
            result += Text.bundle.getString(Text.INCOME) +
                    String.valueOf(incomeSmall) +
                    Text.bundle.getString(Text.DOT);
        else if (sum < sumBig)
            result += Text.bundle.getString(Text.INCOME) +
                    String.valueOf(incomeBig) +
                    Text.bundle.getString(Text.SEMICOLON) +
                    Text.bundle.getString(Text.GUARANTEE) +
                    Text.bundle.getString(Text.OR) +
                    Text.bundle.getString(Text.SENIORITY);
        else // if (sum >= sumBig)
            result += Text.bundle.getString(Text.INCOME) +
                    String.valueOf(incomeBig) +
                    Text.bundle.getString(Text.SEMICOLON) +
                    Text.bundle.getString(Text.GUARANTEE) +
                    Text.bundle.getString(Text.SENIORITY);
        return result;
    }
}