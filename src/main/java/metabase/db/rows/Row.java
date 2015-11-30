package metabase.db.rows;

import metabase.db.tables.Table;
import metabase.types.MetabaseObject;

import java.io.Serializable;

public class Row implements Serializable {
    public MetabaseObject[] values;
    public final int row;
    public Row(Table table, int row) {
        values = table.getValueAtID(row);
        this.row = row;
    }
}
