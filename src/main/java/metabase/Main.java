package metabase;

import metabase.command.in.CommandLine;

import java.util.logging.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger("metabase.Main");
    public static void main(String[] arg) throws Exception {
        int in = 0;
        while (true) {
            try {
                CommandLine.listen(in);
            }
            catch (Exception e) {
                logger.severe("A fatal exception has been detected: exiting database");
                logger.severe(e.getMessage());
                logger.severe(e.getCause().getMessage());
            }
            in++;
        }
    }

}
