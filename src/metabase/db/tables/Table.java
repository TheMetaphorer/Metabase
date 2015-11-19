package metabase.db.tables;

import metabase.db.columns.Types;
import metabase.db.rows.Row;
import metabase.types.MetabaseObject;
import metabase.db.columns.Column;
import metabase.db.Database;

import java.io.Serializable;
import java.lang.String;
import java.util.ArrayList;

public class Table implements Serializable {
    public ArrayList<Column> columns = new ArrayList<>();
    public ArrayList<Row> rows = new ArrayList<>();
    public String name;
    public Table(String[] columnTypes, String name) {
        this.name = name;
        String[] types = new String[]{"Double", "Float", "Int", "Long", "Short", "BigString", "Char", "SmallString", "Text"};
        for (String class_name : columnTypes) {
            Types classType = Types.valueOf(class_name);
            columns.add(new Column(classType));
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