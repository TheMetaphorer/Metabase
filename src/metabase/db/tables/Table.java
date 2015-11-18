package metabase.db.tables;

import metabase.exceptions.*;
import metabase.types.numbers.*;
import metabase.types.strings.*;
import metabase.db.columns.Column;
import metabase.db.Database;
import java.lang.Class;
import java.lang.ClassNotFoundException;
import java.lang.String;
import java.lang.Object;
import java.util.ArrayList;

public class Table {
    public ArrayList<Column> columns;
    public String name;
    public Table(String[] columnTypes, String name) throws ClassNotFoundException {
        this.name = name;
        String[] types = new String[]{"Double", "Float", "Int", "Long", "Short", "BigString", "Char", "SmallString", "Text"};
        ArrayList<Column> columns = new ArrayList<Column>();
        for (String class_name : columnTypes) {
            Class cls = Class.forName(class_name);
            columns.add(new Column(cls));
        }
    }

    public Table(Database db) {}

    public ArrayList<Object> getID(int id) {
        ArrayList<Object> id_info = new ArrayList<Object>();
        for (Column column : columns) {
            id_info.add(column.rows.get(id));
        }
        return id_info;
    }

    public void updateRow(int row, Object... values) throws NullViolationError {
        if (columns.size() != values.length) {
            for (Column column : columns) {
                if (!column.isNull) {
                    throw new NullViolationError();
                }
            }
        } else {
            for (Column column_ : columns) {
                column_.rows.set(row, values[columns.indexOf(column_)]);
            }
        }
    }
}