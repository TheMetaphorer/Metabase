package metabase.types.strings;

import metabase.db.columns.Types;
import metabase.exceptions.*;
import metabase.types.MetabaseObject;
import java.lang.String;

public class SmallString implements MetabaseObject {

    public char[] value = new char[32];
    public final Types type = Types.SmallString;
    public SmallString(String value) throws StringValueError {
        if (value.length() > 32)
            throw new StringValueError("Value entered was too big for SmallString, must be at most 32");
        else {
            for (int i=0; i<value.length(); i++) {
                this.value[i] = value.charAt(i);
            }
        }
    }

    public Types type() {
        return type;
    }

    public String repr() {
        return String.valueOf(value);
    }
}