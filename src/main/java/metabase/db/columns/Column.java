package metabase.db.columns;

import metabase.db.rows.Row;
import metabase.exceptions.*;
import metabase.db.columns.Types;
import metabase.types.MetabaseObject;
import java.io.Serializable;
import java.lang.Exception;
import java.lang.Class;
import java.util.ArrayList;
import java.util.List;

public class Column implements Serializable {

    public boolean isNull;
    public List<MetabaseObject> ids = new ArrayList<>();
    public final Types type;
    public final String name;
    public Column(Types columnType, String name, boolean isNull) throws NullViolationError {
        this.isNull = isNull;
        type = columnType;
        ids = new ArrayList<>();
        this.name = name;
    }

    public Column(Types columnType, String name) {
        isNull = true;
        ids = new ArrayList<>();
        type = columnType;
        this.name = name;
    }
}