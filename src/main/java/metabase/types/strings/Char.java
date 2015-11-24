package metabase.types.strings;

import metabase.db.columns.Types;
import metabase.exceptions.ColumnTypeViolationError;
import metabase.exceptions.StringValueError;
import metabase.types.MetabaseObject;

public class Char implements MetabaseObject {

    public char value;
    public final Types type = Types.Char;
    public Char(String value) throws Exception {
        if (value.length() > 1) {
            throw new StringValueError(this);
        }
        this.value = value.charAt(0);
    }

    public Types type() {
        return type;
    }

    public String repr() {
        return String.valueOf(this.value);
    }

}