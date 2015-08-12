package commons.info.status;

public enum RequestStatus {
    pending,
    approved,
    denied;

    public boolean isDenied() {
        return this == denied;
    }

    public boolean isPending() {
        return this == pending;
    }
}