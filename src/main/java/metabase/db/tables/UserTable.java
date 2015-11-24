package metabase.db.tables;

import metabase.db.columns.Types;
import metabase.exceptions.*;
import metabase.types.numbers.*;
import metabase.types.strings.SmallString;
import metabase.types.strings.BigString;
import metabase.db.columns.Column;
import metabase.db.tables.Table;
import metabase.db.Database;
import java.lang.Class;
import java.lang.ClassNotFoundException;
import java.lang.String;
import java.util.ArrayList;
import java.lang.Object;

public class UserTable extends Table {

    public UserTable(Database db) throws Exception {
        super(db);
        name = "user_tables";
        ArrayList<Column> columns = new ArrayList<>();
        Types username = Types.SmallString;
        Types password = Types.SmallString;
        Types userKey = Types.BigString;
        columns.add(new Column(username, "username"));
        columns.add(new Column(password, "password"));
        columns.add(new Column(userKey, "userKey"));
    }
}
