package metabase.exceptions;

import java.lang.Exception;

public class MismatchedColumnError extends Exception {

    public MismatchedColumnError() {
        super("Mismatched columns; number of types for columns passed was not the same as the number of columns");

    }

}