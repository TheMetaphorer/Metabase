package metabase.types.strings;

import metabase.exceptions.*;
import metabase.types.Object;
import java.lang.String;

public class SmallString {

    public char[] value = new char[32];
    public SmallString(String value) throws StringValueError {
        if (value.length() > 32)
            throw new StringValueError("Value entered was too big for SmallString, must be at most 32");
        else {
            for (int i=0; i<value.length(); i++) {
                this.value[i] = value.charAt(i);
            }
        }
    }

    public String type() {
        return "METABASE OBJECT: types.strings.SmallString";
    }

    public String repr() {
        return String.valueOf(value);
    }
}