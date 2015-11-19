package metabase.db.columns;

import metabase.db.rows.Row;
import metabase.exceptions.*;
import metabase.db.columns.Types;
import metabase.types.MetabaseObject;
import java.io.Serializable;
import java.lang.Exception;
import java.lang.Class;
import java.util.ArrayList;

public class Column implements Serializable {

    public boolean isNull;
    public ArrayList<MetabaseObject> ids = new ArrayList<>();
    public final Types type;
    public Column(Types columnType, boolean isNull) throws NullViolationError {
        this.isNull = isNull;
        type = columnType;
        ids = new ArrayList<>();
    }

    public Column(Types columnType) {
        isNull = true;
        ids = new ArrayList<>();
        type = columnType;
    }
}