package metabase.exceptions;

import metabase.db.columns.Column;

public class ColumnTypeViolationError extends Exception {
    public ColumnTypeViolationError(Column column) {
        super("Incorrect type in column, must be " + column.type);
    }
}
