package metabase.exceptions;

import metabase.types.MetabaseObject;
import java.lang.Exception;

public class StringValueError extends Exception {
    public StringValueError(String msg, String object) {
        super(msg + object);
    }

    public StringValueError(MetabaseObject object) {
        super("StringValueError for " + object.type() +"; invalid value");
    }

    public StringValueError(String msg) {
        super(msg);
    }

    public StringValueError() {
        super("A StringValueError has occurred, an invalid value was entered");
    }
}