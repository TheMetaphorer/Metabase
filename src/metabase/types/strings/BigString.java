package metabase.types.strings;

import metabase.db.columns.Types;
import metabase.exceptions.*;
import metabase.types.MetabaseObject;
import java.lang.String;

public class BigString implements MetabaseObject {

    public char[] value = new char[64];
    public final Types type = Types.BigString;
    public BigString(String value) throws StringValueError {
        if (value.length() > 64)
            throw new StringValueError("Value entered was too big for BigString, must be at most be 64");
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