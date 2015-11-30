package metabase;

import metabase.net.client.ClientCommandLine;
import metabase.net.client.LocalCommandLine;
import metabase.net.server.ServerCommandLine;

import java.util.Arrays;
import java.util.logging.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger("metabase.Main");
    private static int defaultPort = 6561;
    private static String host = "127.0.0.1";
    public static void main(String[] args) throws Exception {
        String arg = args[0];
        if (arg.toLowerCase().equals("local") && Arrays.asList(args).indexOf(arg) == 0) {
            while (true) {
                LocalCommandLine.listen();
            }
        } else if (arg.toLowerCase().equals("client") && Arrays.asList(args).indexOf(arg) == 0 && args.length == 3) {
            try {
                String host = args[1];
                int port;
                if (args.length  >= 3) {
                    port = Integer.valueOf(args[2]);
                } else {
                    port = defaultPort;
                }
                ClientCommandLine.connect(host, port);
            } catch (Exception e) {
                logger.severe("A fatal exception as occurred. Database will exit.");
                logger.severe(e.getMessage());
                logger.severe(e.getCause().getMessage());
            }
        } else if (arg.toLowerCase().equals("server") && Arrays.asList(args).indexOf(arg) == 0) {
            if (args.length == 2) {
                ServerCommandLine.listen(Integer.valueOf(args[1]));
            } else {
                ServerCommandLine.listen(defaultPort);
            }
        }
    }
}
