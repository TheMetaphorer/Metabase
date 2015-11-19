package metabase.types.numbers;

import metabase.exceptions.OverflowError;
import metabase.types.MetabaseObject;
import metabase.db.columns.Types;
import java.lang.String;

public class Double implements MetabaseObject {

    public double value;
    public final Types type = Types.Double;
    public Double(double value) throws OverflowError {
        if (value < java.lang.Double.MIN_VALUE|| value > java.lang.Double.MAX_VALUE) {
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