package commons.user;


import commons.info.Client;
import commons.info.Manager;
import commons.info.Tariff;
import commons.info.User;

import java.util.List;

public class CurrentUser {

    public static UserAccessType type = UserAccessType.logoff;

    public static Client client;
    public static Manager manager;
    public static List<Tariff> tariffs;
    public static List<User> users;

    public static void logIn(String typeName) {
        if (type != UserAccessType.logoff)
            return;
        type = UserAccessType.valueOf(typeName);
    }

    public static void logOut() {
        type = UserAccessType.logoff;
        client = null;
        manager = null;
    }

    public static UserAccessType getType() {
        return type;
    }

    public static boolean isLogoff() {
        return type == UserAccessType.logoff;
    }

    public static boolean isClient() {
        return type == UserAccessType.client;
    }

    public static boolean isManager() {
        return type == UserAccessType.manager;
    }

    public static boolean isMarketer() {
        return type == UserAccessType.marketer;
    }

    public static boolean isNotAdmin() {
        return type != UserAccessType.admin;
    }

    public static int getUserIdByEmail(String email) {
        for (User user : users)
            if (user.email.equals(email))
                return user.id;
        return 0;
    }

    public static void setClient(Client client) {
        CurrentUser.client = client;
    }

    public static void setManager(Manager manager) {
        CurrentUser.manager = manager;
    }

    public static void setUsers(List<User> users) {
        CurrentUser.users = users;
    }

    public static void setTariffInactive(Tariff tariff) {
        tariffs.get(CurrentUser.tariffs.indexOf(tariff)).isActive = false;
    }
}