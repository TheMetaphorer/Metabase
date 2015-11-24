package metabase.exceptions;

public class MismatchedColumnError extends Exception {

    public MismatchedColumnError() {
        super("Mismatched columns; number of arguments for columns passed was not the same as the number of columns");

    }
}