package commons.info;

import commons.info.status.AccessType;

import java.io.Serializable;

public class User implements Serializable {
    public int id;
    public String name;
    public String email;
    public String password;
    public AccessType access;

    public User() {
        password = "";
        access = AccessType.manager;
    }

    public User(int id, String name, String email,
                String password, AccessType access) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.access = access;
    }

    public User(String name, String email,
                String password, AccessType access) {
        this.id = 0;
        this.name = name;
        this.email = email;
        this.password = password;
        this.access = access;
    }

    public User(String email, String password) {
        id = 0;
        this.password = password;
        access = AccessType.manager;
        this.email = email;
        this.name = "";
    }
}
