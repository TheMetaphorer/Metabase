package metabase;

import metabase.command.in.CommandLine;
import metabase.exceptions.AuthenticationError;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class Main {

    public static void main(String[] arg) throws IOException, ClassNotFoundException, NoSuchAlgorithmException, AuthenticationError {
        CommandLine.listen();
    }

}
