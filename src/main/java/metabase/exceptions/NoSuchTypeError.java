package metabase.exceptions;

import metabase.db.columns.Types;

import java.lang.Exception;
public class NoSuchTypeError extends Exception {
    public NoSuchTypeError() {
        super("No such column type, must be " + Types.values().toString());
    }

}
