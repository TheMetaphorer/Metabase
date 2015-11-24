package metabase.types.strings;

import metabase.db.columns.Types;
import metabase.exceptions.StringValueError;
import metabase.types.MetabaseObject;

public class Text implements MetabaseObject {

    public char[] value;
    public final Types type = Types.Text;
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

    public Types type() {
        return type;
    }

    public String repr() {
        return String.valueOf(value);
    }
}