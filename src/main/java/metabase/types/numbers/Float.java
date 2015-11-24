package metabase.types.numbers;

import metabase.db.columns.Types;
import metabase.exceptions.OverflowError;
import metabase.types.MetabaseObject;

public class Float implements MetabaseObject {

    public float value;
    public final Types type = Types.Float;
    public Float(String val) throws OverflowError {
        float value = java.lang.Float.parseFloat(val);
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