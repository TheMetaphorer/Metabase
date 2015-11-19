package metabase.types.numbers;

import metabase.db.columns.Types;
import metabase.exceptions.OverflowError;
import metabase.types.MetabaseObject;
import java.lang.String;

public class Int implements MetabaseObject {

    public int value;
    public final Types type = Types.Int;
    public Int(int value) throws OverflowError {
        if (value < Integer.MIN_VALUE || value > Integer.MAX_VALUE) {
            throw new OverflowError();
        }
        this.value = value;
    }

    public Types type() {
        return type;
    }

    public String repr() {
        return String.valueOf(this.value);
    }
}