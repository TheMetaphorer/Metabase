package metabase.types.numbers;

import metabase.exceptions.OverflowError;
import metabase.types.Object;
import java.lang.String;

public class Float implements Object {

    public float value;
    public Float(float value) throws OverflowError {
        if (value < -(Math.pow(2, 31)) || value > Math.pow(2, 31) - 1) {
            throw new OverflowError();
        }
        this.value = value;
    }

    public String type() {
        return "METABASE OBJECT: types.numbers.Float";
    }

    public String repr() {
        return String.valueOf(this.value);
    }
}