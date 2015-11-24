package metabase.db.user;

import metabase.db.user.permissions.UserPermission;
import java.lang.String;
import java.security.MessageDigest;
import java.io.Serializable;

public class User implements Serializable {

    public UserPermission perms;
    public String username;
    public String password;
    public transient MessageDigest passDigest;
    public String userKey;
}