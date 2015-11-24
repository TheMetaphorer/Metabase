package metabase.command.in;

import metabase.db.Database;
import metabase.management.ManagementSystem;

import java.util.Scanner;
import java.util.logging.Logger;

public class CommandLine {
    public static String input;
    public static String db;
    public static String username;
    public static String password;
    public static Logger logger = Logger.getLogger("metabase.Main");
    public static void listen(int in) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Have you created a database? [Y/N]");
        if (scanner.nextLine().toLowerCase().equals(new String("n"))) {
            db = ManagementSystem.makeDB();
            username = Database.loadDB(db).owner.username;
            password = Database.loadDB(db).owner.password;

        } else {
            System.out.println("Enter a database to load");
            db = scanner.nextLine();
            System.out.println("Enter your username on this database");
            username = scanner.nextLine();
            System.out.println("Enter your password on this database");
            password = scanner.nextLine();
        }
        while (true) {
            try {
                ManagementSystem mng = new ManagementSystem(db, username, password);
                System.out.print(mng.db.name + " >>>");
                input = scanner.nextLine();
                mng.parseCommand(input);
            } catch (Exception e) {
                logger.warning(e.getMessage());
                logger.warning(e.getCause().toString());
            }
        }
    }
}