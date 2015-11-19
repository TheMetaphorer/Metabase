package metabase.exceptions;

import metabase.db.columns.Column;

import java.lang.Exception;

public class ColumnTypeViolationError extends Exception {
    public ColumnTypeViolationError(Column column) {
        super("Incorrect type in column, must be " + column.type);
    }
}
