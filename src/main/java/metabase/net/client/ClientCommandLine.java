package metabase.net.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Logger;

public class ClientCommandLine {
    private static String input;
    private static String output;
    private static final Logger logger = Logger.getLogger("ClientCommandLine");
    private static Socket connection;
    public static void connect(String hostname, int port) throws Exception {
        try {
            connection = new Socket(hostname, port);
            PrintWriter out = new PrintWriter(connection.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
            communicate(in, out, stdIn);
        } catch (Exception e) {
            logger.warning("Could not connect to host");
            logger.warning(e.getMessage());
            logger.warning(e.getCause().getLocalizedMessage());
            logger.warning("Retrying connection");
            connect(hostname, port);
        }
    }
    public static void communicate(BufferedReader in, PrintWriter out, BufferedReader stdIn) throws IOException {
        try {
            System.out.println(in.readLine());
            while ((input = stdIn.readLine()) != null) {
                out.println(input);
                while ((output = in.readLine()) != null)
                    System.out.println(output);
            }
        } catch (Exception e) {
            logger.warning("An exception has occurred during operation");
            logger.warning(e.getMessage());
            logger.warning(e.getStackTrace().toString());
            logger.warning("Retrying connection");
            communicate(in, out, stdIn);
        }
    }
}
