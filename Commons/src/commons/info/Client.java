package commons.info;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Client implements Serializable {

    public Manager manager;
    public List<Request> requests = new ArrayList<>();
    public List<Credit> credits = new ArrayList<>();
    public List<Mail> letters = new ArrayList<>();

    public int id;
    public int userId;
    public int managerId;
    public String inn;
    public String email;
    public String name;
    public String address;
    public int telephone;
    public float income;
    public boolean hasGuarantee;
    public int requestCount;
    public int birthYear;
    public Date profileCreateDate;
    public int seniority;
    public boolean isStudent;

    public Request getRequestById(int requestId) {
        for (Request request : requests)
            if (request.id == requestId)
                return request;
        return null;
    }

    public Credit getCreditById(int creditId) {
        for (Credit credit : credits)
            if (credit.id == creditId)
                return credit;
        return null;
    }

    //ClientsDAO-getClientByLogin, getClientsByManagerId
    public Client(int id, int userId, String inn, String email,
                  int managerId, String name, String address,
                  int telephone, float income, boolean hasGuarantee,
                  int birthYear, Date profileCreateDate, boolean isStudent,
                  int seniority) {
        this.id = id;
        this.userId = userId;
        this.inn = inn;
        this.email = email;
        this.managerId = managerId;
        this.name = name;
        this.address = address;
        this.telephone = telephone;
        this.income = income;
        this.hasGuarantee = hasGuarantee;
        requestCount = 0;
        this.birthYear = birthYear;
        this.profileCreateDate = profileCreateDate;
        this.isStudent = isStudent;
        this.seniority = seniority;
    }

    //ClientNew
    public Client(String inn, String email, Manager manager,
                  String name, String address, int telephone,
                  float income, boolean hasGuarantee, int birthYear,
                  boolean isStudent, int seniority) {
        id = 0;
        userId = 0;
        this.name = name;
        this.email = email;
        this.address = address;
        this.telephone = telephone;
        this.income = income;
        this.hasGuarantee = hasGuarantee;
        this.manager = manager;
        this.managerId = manager.id;
        this.inn = inn;
        this.birthYear = birthYear;
        this.isStudent = isStudent;
        this.seniority = seniority;
    }

    public void setClientForEdit(String name, String email, String address,
                                 int telephone, float income, boolean guarantee,
                                 int birthDay, boolean isStudent, int seniority) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.telephone = telephone;
        this.income = income;
        this.hasGuarantee = guarantee;
        this.birthYear = birthDay;
        this.isStudent = isStudent;
        this.seniority = seniority;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    /*public Client(String inn, String email, int managerId,
                  String name, String address, int telephone,
                  int income, boolean guarantee) {
        this.id = 0;
        this.inn = inn;
        this.email = email;
        this.managerId = managerId;
        this.name = name;
        this.address = address;
        this.telephone = telephone;
        this.income = income;
        this.guarantee = guarantee;
        requestCount = 0;
    }*/

    public int getMinMonthsWithoutPenalty() {
        int result = credits.get(0).getMonthsWithoutPenalty();
        for (Credit credit : credits)
            if (credit.getMonthsWithoutPenalty() < result)
                result = credit.getMonthsWithoutPenalty();
        return result;
    }

    public int withEmerald() {
        return new Date().getYear() - profileCreateDate.getYear();
    }

    public int age() {
        return new Date().getYear() - birthYear;
    }

    public float getTotalCreditSum() {
        float result = 0;
        for (Credit credit : credits)
            result += credit.sum;
        return result;
    }

    public int getDiscount(Tariff tariff) {
        int result;
        int discount = 0;

        List<Integer> factors = new ArrayList<>();

        if (getMinMonthsWithoutPenalty() > 0)
            factors.add(getMinMonthsWithoutPenalty());
        if (withEmerald() > 1)
            factors.add(withEmerald());
        if (age() > 55)
            factors.add((age() - 55) / 10);
        if (isStudent)
            factors.add(2);
        if (getTotalCreditSum() > 10000)
            factors.add((int) getTotalCreditSum() / 10000);


        if (factors.size() > 2) {
            discount = 0;
            for (int iter = 0; iter < 2; iter++) {
                int maxIndex = 0;
                for (int i = 1; i < factors.size(); i++)
                    if (factors.get(i) > factors.get(i - 1))
                        maxIndex = i;
                discount += factors.get(maxIndex);
                if (iter == 0)
                    factors.set(maxIndex, 0);
            }
        } else
            for (Integer factor : factors)
                discount += factor;

        result = tariff.rate - discount < 5 ? discount : 5;

        return result;
    }
}