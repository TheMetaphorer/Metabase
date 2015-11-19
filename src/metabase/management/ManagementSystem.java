package metabase.management;

import metabase.db.user.Superuser;
import metabase.db.user.User;
import metabase.db.Database;
import metabase.db.tables.Table;
import metabase.exceptions.*;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ManagementSystem {

    public Database db;
    private String[] columnTypesArray;
    public ManagementSystem(String db, String username, String password) throws AuthenticationError, IOException, ClassNotFoundException {
        this.db = Database.loadDB(db);
        if (this.db.owner.username.equals(username)) {
            if (!this.db.owner.password.equals(password)) {
                throw new AuthenticationError(this.db.owner);
            }
        } else {
            throw new AuthenticationError();
        }

    }

    public void parseCommand(String command, int line) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        String commandName = command.split("\\|")[0];
        System.out.println(commandName);
        if (command.toLowerCase().equals("q"))
            System.exit(0);
        List<String> args = new ArrayList<>();
        for (String arg : command.split("\\|")) {
            if (arg.equals(commandName))
                continue;
            else {
                args.add(arg);
            }
        }
        System.out.println(args.get(0));
        System.out.println(args.get(1));
        Method method = this.getClass().getMethod(commandName, "".getClass(), "".getClass());
        method.invoke(this, String.valueOf(args.get(0)), String.valueOf(args.get(1)));
    }

    public void addTable(String name, String columnTypes) throws Exception {
        if (!columnTypes.contains(","))
            columnTypesArray = new String[]{columnTypes};
        else {
            columnTypesArray = columnTypes.split("\\,");
        }
        db.tables.add(new Table(columnTypesArray, name));
        Database.saveDB(db, db.path);
    }


    public static String makeDB() throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a username");
        String username = scanner.nextLine();
        System.out.println("Enter a password");
        String password = scanner.nextLine();
        Superuser user = new Superuser(username, password);
        System.out.println("Enter a name for your database.");
        String name = scanner.nextLine();
        System.out.println("Enter a location for your database.");
        String location = scanner.nextLine();
        Database newDB = new Database(name, location, user);
        Database.saveDB(newDB, location);
        return new File(location, name + ".medb").toString();

    }
}