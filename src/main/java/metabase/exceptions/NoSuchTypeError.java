package metabase.exceptions;

import metabase.db.columns.Types;
public class NoSuchTypeError extends Exception {
    public NoSuchTypeError() {
        super("No such column type, must be " + Types.values().toString());
    }

}
