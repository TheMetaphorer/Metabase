package metabase.command.in;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;
import java.lang.System;

import metabase.db.Database;
import metabase.db.user.User;
import metabase.exceptions.AuthenticationError;
import metabase.management.ManagementSystem;

public class CommandLine {
    public static String input;
    public static String db;
    public static String username;
    public static String password;
    public static void listen() throws IOException, ClassNotFoundException, NoSuchAlgorithmException, AuthenticationError {
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
        ManagementSystem mng = new ManagementSystem(db, username, password);
        while (true) {
            System.out.print(mng.db.name + " >>>");
            input = scanner.nextLine();
        }
    }
}