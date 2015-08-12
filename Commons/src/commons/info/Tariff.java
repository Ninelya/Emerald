package commons.info;

import commons.user.CurrentUser;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Tariff implements Serializable {

    public static List<Tariff> tariffList = new ArrayList<>();

    public final int id;
    public final String name;
    public final float minSum;
    public final float maxSum;
    public final int rate;
    public final int termMonth;
    public final String conditions;
    public boolean isActive;

    public Tariff(int id, String name, float minSum, float maxSum, int rate,
                  int termMonth, String conditions, boolean isActive) {
        this.id = id;
        this.name = name;
        this.minSum = minSum;
        this.maxSum = maxSum;
        this.rate = rate;
        this.termMonth = termMonth;
        this.conditions = conditions;
        this.isActive = isActive;
        addToList(this);
    }

    public static void addToList(Tariff tariff) {
        if (getTariffByIdForServer(tariff.id) == null)
            tariffList.add(tariff);
    }

    public Tariff(String name, float minSum, float maxSum, int rate,
                  int termMonth, String conditions) {
        id = -1;
        this.name = name;
        this.minSum = minSum;
        this.maxSum = maxSum;
        this.rate = rate;
        this.termMonth = termMonth;
        this.conditions = conditions;
        isActive = false;
    }

    public static Tariff getTariffById(int id) {
        for (Tariff tariff : CurrentUser.tariffs)
            if (tariff.id == id)
                return tariff;
        return null;
    }

    public static Tariff getTariffByName(String name) {
        for (Tariff tariff : CurrentUser.tariffs)
            if (tariff.name.equals(name))
                return tariff;
        return null;
    }


    public static Tariff getTariffByIdForServer(int tariffId) {
        for (Tariff tariff : tariffList)
            if (tariff.id == tariffId)
                return tariff;
        return null;
    }
}