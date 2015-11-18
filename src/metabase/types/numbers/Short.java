package metabase.types.numbers;

import metabase.exceptions.OverflowError;
import metabase.types.Object;
import java.lang.String;
import java.lang.Math;

public class Short implements Object {
    public short value;
    public Short(short value) throws OverflowError {
        if (value < -(Math.pow(2, 15)) || value > (Math.pow(2, 15)) - 1 ) {
            throw new OverflowError();
        }

        this.value = value;

    }

    public String type() {
        return "METABASE OBJECT: types.numbers.Short";
    }

    public String repr() {
        return String.valueOf(this.value);
    }

}