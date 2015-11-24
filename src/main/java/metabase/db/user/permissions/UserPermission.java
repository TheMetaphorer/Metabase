package metabase.db.user.permissions;

public enum UserPermission {

    SUPERUSER("SUPERUSER"),
    ADMIN("ADMIN"),
    NORMAL("NORMAL");

    public final String permission;
    UserPermission(String permission) {
        this.permission = permission;

    }

    public String toString() {
        return this.permission;
    }


}