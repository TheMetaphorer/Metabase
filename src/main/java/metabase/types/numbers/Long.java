package metabase.types.numbers;

import metabase.db.columns.Types;
import metabase.exceptions.OverflowError;
import metabase.types.MetabaseObject;
import java.lang.String;

public class Long implements MetabaseObject {

    public long value;
    public final Types type = Types.Long;
    public Long(String val) throws OverflowError {
        long value = java.lang.Long.parseLong(val);
        if (value < java.lang.Long.MIN_VALUE|| value > java.lang.Long.MAX_VALUE) {
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