package metabase.db.rows;

import metabase.db.tables.Table;
import metabase.types.MetabaseObject;

public class Row {
    public MetabaseObject[] values;
    public Row(Table table, int row) {
        values = table.getValueAtID(row);
    }
}
