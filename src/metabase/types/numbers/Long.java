package metabase.types.numbers;

import metabase.exceptions.OverflowError;
import metabase.types.Object;
import java.lang.String;

public class Long implements Object {

    public long value;
    public Long(long value) throws OverflowError {
        if (value < -(Math.pow(2, 63)) || value > Math.pow(2, 63) - 1) {
            throw new OverflowError();
        }
        this.value = value;
    }

    public String type() {
        return "METABASE OBJECT: types.numbers.Long";
    }

    public String repr() {
        return String.valueOf(this.value);
    }
}