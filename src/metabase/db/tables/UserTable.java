package metabase.db.tables;

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

    public UserTable(Database db) throws ClassNotFoundException, StringValueError, NullViolationError {
        super(db);
        name = "user_tables";
        ArrayList<Column> columns = new ArrayList<>();
        Class username = Class.forName("metabase.types.strings.SmallString");
        Class password = Class.forName("metabase.types.strings.SmallString");
        Class userKey = Class.forName("metabase.types.strings.BigString");
        columns.add(new Column(username));
        columns.add(new Column(password));
        columns.add(new Column(userKey));
        updateRow(0, new Object[]{new SmallString(db.owner.username),new SmallString(db.owner.password), new BigString(db.owner.userKey)});
    }
}
