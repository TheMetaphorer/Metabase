package metabase.exceptions;

import metabase.types.Object;
import java.lang.Exception;

public class OverflowError extends Exception {
    public OverflowError(String msg, String object) {
        super(msg + object);
    }

    public OverflowError(Object object) {
        super("OverflowError for " + object.type() +"; value too large");
    }

    public OverflowError(String msg) {
        super(msg);
    }

    public OverflowError() {
        super("An OverflowError has occured; The value entered was too large");
    }
}