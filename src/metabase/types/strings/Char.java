package metabase.types.strings;

import metabase.exceptions.*;
import metabase.types.Object;
import java.lang.String;

public class Char implements Object {

    public char value;
    public Char(char value) {
        this.value = value;
    }

    public String type() {
        return "METABASE OBJECT: types.strings.Char";
    }

    public String repr() {
        return String.valueOf(this.value);
    }

}