package metabase.db.tables;

import metabase.db.Database;
import metabase.db.columns.Column;
import metabase.db.columns.Types;
import metabase.db.rows.Row;
import metabase.exceptions.NoSuchTypeError;
import metabase.types.MetabaseObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Table implements Serializable {
    public List<Column> columns = new ArrayList<>();
    public List<Row> rows = new ArrayList<>();
    public String name;
    public Table(String[] columnTypes, String name) throws Exception {
        this.name = name;
        String[] types = new String[]{"Double", "Float", "Int", "Long", "Short", "BigString", "Char", "SmallString", "Text"};
        for (String type : columnTypes) {
            type = type.split("\\.")[type.split("\\.").length - 1];
            if (!Arrays.asList(types).contains(type))
                throw new NoSuchTypeError();
            Types columnType = Types.valueOf(type);
            columns.add(new Column(columnType, name));
        }
    }

    public Table(Database db) {}

    public MetabaseObject[] getValueAtID(int id) {
        MetabaseObject[] id_vals = new MetabaseObject[columns.size()];
        for (int i=0; i<columns.size(); i++) {
            id_vals[i] = columns.get(i).ids.get(id);
        }
        return id_vals;
    }
}