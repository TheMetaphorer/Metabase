package metabase.types.numbers;

import metabase.exceptions.OverflowError;
import metabase.types.MetabaseObject;
import metabase.db.columns.Types;
import java.lang.String;

public class Float implements MetabaseObject {

    public float value;
    public final Types type = Types.Float;
    public Float(float value) throws OverflowError {
        if (value < java.lang.Float.MIN_VALUE || value > java.lang.Float.MAX_VALUE) {
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