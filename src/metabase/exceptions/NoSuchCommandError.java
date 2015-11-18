package metabase.exceptions;

import java.lang.Exception;

public class NoSuchCommandError extends Exception {

    public NoSuchCommandError(String command) {
        super("No such command " + command);
    }
}