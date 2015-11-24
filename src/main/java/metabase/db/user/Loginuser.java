package metabase.db.user;

import metabase.db.user.permissions.UserPermission;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Loginuser extends User {

    public Loginuser(String username, String password, String permissions) throws NoSuchAlgorithmException {
        this.username = username;
        this.password = password;
        perms = UserPermission.valueOf(permissions);
        passDigest = MessageDigest.getInstance("SHA");
        passDigest.update(String.valueOf(this).getBytes());
        byte[] userKeyAsBytes = passDigest.digest();
        userKey = String.format("%032X", new BigInteger(1, userKeyAsBytes));
    }
}
