package metabase.exceptions;

import metabase.db.user.User;
import java.lang.Exception;

public class AuthenticationError extends Exception {
    public AuthenticationError(User user) {
        super("Authentication failed for user " + user.username);
    }

    public AuthenticationError() {
        super("Database authentication failed");
    }
}
