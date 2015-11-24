package metabase.exceptions;

public class NullViolationError extends Exception {

    public NullViolationError(String msg) {
        super(msg);
    }

    public NullViolationError() {
        super("Tried to assign null value to column assigned not-null state");
    }
}