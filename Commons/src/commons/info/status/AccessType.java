package commons.info.status;

public enum AccessType {
    client(1),
    manager(2),
    marketer(3),
    admin(4);

    private int value;

    private AccessType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public boolean isAdmin() {
        return this == admin;
    }

    public boolean isClient() {
        return this == client;
    }

    public boolean isManager() {
        return this == manager;
    }
}
