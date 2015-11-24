package metabase.db.user;

import metabase.db.user.permissions.UserPermission;

import java.io.Serializable;
import java.security.MessageDigest;

public class User implements Serializable {

    public UserPermission perms;
    public String username;
    public String password;
    public transient MessageDigest passDigest;
    public String userKey;
}