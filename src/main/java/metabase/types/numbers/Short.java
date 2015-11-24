package metabase.types.numbers;

import metabase.db.columns.Types;
import metabase.exceptions.OverflowError;
import metabase.types.MetabaseObject;

public class Short implements MetabaseObject {
    public short value;
    public final Types type = Types.Short;
    public Short(String value) throws OverflowError {
        if (java.lang.Short.valueOf(value) < java.lang.Short.MIN_VALUE || java.lang.Short.valueOf(value) > java.lang.Short.MAX_VALUE ) {
            throw new OverflowError();
        }

        this.value = java.lang.Short.valueOf(value);

    }

    public Types type() {
        return type;
    }

    public String repr() {
        return String.valueOf(this.value);
    }

}