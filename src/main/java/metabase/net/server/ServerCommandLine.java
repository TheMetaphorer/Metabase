package metabase.net.server;

import metabase.db.Database;
import metabase.management.ManagementSystem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Logger;

public class ServerCommandLine {
    public static String db;
    public static String username;
    public static String password;
    private static String input;
    private static final Logger logger = Logger.getLogger("metabase.net.client.in.ServerCommandLine");
    public static void listen(int port) throws Exception {
        logger.info("Listening for connection on port " + port);
        ServerSocket serverSocket = new ServerSocket(port);
        Socket clientSocket = serverSocket.accept();
        logger.info("Accepted connection from " + clientSocket.getInetAddress().toString() + ":" + clientSocket.getLocalPort());
        PrintStream out = new PrintStream(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        System.setOut(out);
        out.println("Have you created a database? [Y/N]");
        if (in.readLine().toLowerCase().equals("n")) {
            db = ManagementSystem.makeDB();
            username = Database.loadDB(db).owner.username;
            password = Database.loadDB(db).owner.password;

        } else {
            out.println("Enter a database to load");
            db = in.readLine();
            out.println("Enter your username on this database");
            username = in.readLine();
            out.println("Enter your password on this database");
            password = in.readLine();
        }
        while (true) {
            try {
                ManagementSystem mng = new ManagementSystem(db, username, password, out);
                out.println(mng.db.name + " >>> ");
                input = in.readLine();
                mng.parseCommand(input);
                logger.info("Command received from client: " + input);
            } catch (Exception e) {
                logger.warning(e.getMessage());
                logger.warning(e.getCause().getMessage());
            }
        }
    }
}