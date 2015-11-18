package metabase.types.strings;

import metabase.exceptions.*;
import metabase.types.Object;
import java.lang.String;

public class BigString implements Object {

    public char[] value = new char[64];
    public BigString(String value) throws StringValueError {
        if (value.length() > 64)
            throw new StringValueError("Value entered was too big for BigString, must be at most be 64");
        else {
            for (int i=0; i<value.length(); i++) {
                this.value[i] = value.charAt(i);
            }
        }
    }

    public String type() {
        return "METABASE OBJECT: types.strings.BigString";
    }

    public String repr() {
        return String.valueOf(value);
    }
}