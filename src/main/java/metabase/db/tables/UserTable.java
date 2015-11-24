package metabase.db.tables;

import metabase.db.Database;
import metabase.db.columns.Column;
import metabase.db.columns.Types;

import java.util.ArrayList;

public class UserTable extends Table {

    public UserTable(Database db) throws Exception {
        super(db);
        name = "user_tables";
        columns = new ArrayList<>();
        Types username = Types.SmallString;
        Types password = Types.SmallString;
        Types userKey = Types.BigString;
        columns.add(new Column(username, "username"));
        columns.add(new Column(password, "password"));
        columns.add(new Column(userKey, "userKey"));
    }
}
