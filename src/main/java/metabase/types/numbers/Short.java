package metabase.types.numbers;

import metabase.db.columns.Types;
import metabase.exceptions.OverflowError;
import metabase.types.MetabaseObject;
import java.lang.String;

public class Short implements MetabaseObject {
    public short value;
    public final Types type = Types.Short;
    public Short(short value) throws OverflowError {
        if (value < java.lang.Short.MIN_VALUE || value > java.lang.Short.MAX_VALUE ) {
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