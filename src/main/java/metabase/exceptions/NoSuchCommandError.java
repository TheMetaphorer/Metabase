package metabase.exceptions;

public class NoSuchCommandError extends Exception {

    public NoSuchCommandError(String command) {
        super("No such command " + command);
    }
}