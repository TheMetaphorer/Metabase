package metabase.types.strings;

import metabase.exceptions.*;
import metabase.types.Object;
import java.lang.String;

public class Text implements Object {

    public char[] value;
    public Text(int size, String value) throws StringValueError {
        this.value = new char[size];
        if (value.length() > size)
            throw new StringValueError("Value entered was too big for Text, size must be no bigger than size parameter: " + String.valueOf(size));
        else {
            for (int i=0; i<value.length(); i++) {
                this.value[i] = value.charAt(i);
            }
        }
    }

    public String type() {
        return "METABASE OBJECT: types.strings.Object";
    }

    public String repr() {
        return String.valueOf(value);
    }
}