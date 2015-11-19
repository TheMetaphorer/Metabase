package metabase.exceptions;

import java.lang.Exception;

public class NoSuchTableError extends Exception {

    public NoSuchTableError(String name) {
        super("No such table " + name + " in database");
    }
}
