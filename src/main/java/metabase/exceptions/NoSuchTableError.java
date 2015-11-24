package metabase.exceptions;

public class NoSuchTableError extends Exception {

    public NoSuchTableError(String name) {
        super("No such table " + name + " in database");
    }
}
