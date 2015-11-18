package metabase.db.columns;

import metabase.exceptions.*;
import java.lang.Object;
import java.lang.Exception;
import java.lang.Class;
import java.util.ArrayList;

public class Column {

    public boolean isNull;
    public ArrayList<Object> rows = new ArrayList<Object>();
    public Column(Class columnType, boolean isNull, Object... values) throws NullViolationError {
        this.isNull = isNull;
        rows = new ArrayList<>();
        if (this.isNull)
            for (Object value : values) {
                rows.add(value);
            }

        if (!this.isNull) {
            if (rows.size() == 0) {
                throw new NullViolationError();
            }
            else {
                for (Object value : values) {
                    rows.add(value);
                }
            }
        }
    }

    public Column(Class columnType) {
        isNull = true;
        rows = new ArrayList<>();
    }
    public int updateColumn(int id, Object value) throws NullViolationError {
        try {
            if (isNull && value == null) {
                throw new NullViolationError();
            }
            else {
                rows.set(id, value);
            }
            return 0;
        } catch (Exception e) {
            System.out.println("Caught Exception: " + e.getMessage());
            return 1;
        }

    }
}