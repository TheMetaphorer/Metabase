package metabase.management;

import metabase.db.user.Superuser;
import metabase.db.user.User;
import metabase.db.Database;
import metabase.db.tables.Table;
import metabase.exceptions.*;

import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class ManagementSystem {

    public Database db;
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

    public void addTable(String name, String... columnTypes) throws ClassNotFoundException {
        db.tables.add(new Table(columnTypes, name));
    }


    public static String makeDB() throws IOException, ClassNotFoundException, NoSuchAlgorithmException {
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
        Database newDB = new Database(name, user);
        Database.saveDB(newDB, location);
        return new File(location, name + ".medb").toString();

    }
}