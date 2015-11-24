package metabase.types.strings;

import metabase.db.columns.Types;
import metabase.types.MetabaseObject;
import java.lang.String;

public class Char implements MetabaseObject {

    public char value;
    public final Types type = Types.Char;
    public Char(char value) {
        this.value = value;
    }

    public Types type() {
        return type;
    }

    public String repr() {
        return String.valueOf(this.value);
    }

}