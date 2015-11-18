package metabase.db.user.permissions;

import java.lang.String;

public enum UserPermission {

    SUPERUSER("SUPERUSER"),
    ADMIN("ADMIN"),
    NORMAL("NORMAL");

    public String permission;
    UserPermission(String permission) {
        this.permission = permission;

    }

    public String toString() {
        return this.permission;
    }


}