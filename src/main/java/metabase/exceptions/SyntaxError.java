package metabase.exceptions;

import java.lang.Exception;

public class SyntaxError extends Exception{

    public SyntaxError(String command, int line) {
        super("SyntaxError at line " + line +": " + command);
    }

}
