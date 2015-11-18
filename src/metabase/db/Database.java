package metabase.db;

import metabase.db.columns.Column;
import metabase.db.tables.Table;
import metabase.db.user.*;
import java.io.*;
import java.lang.String;
import java.util.ArrayList;

public class Database implements Serializable {

    public User owner;
    public String name;
    public ArrayList<Table> tables;
    public Database(String name, User owner) {
        this.owner = owner;
        this.name = name;
    }

    public static void saveDB(Database db, String path) throws IOException, ClassNotFoundException {
        try {
            String pth = new File(path, db.name + ".medb").toString();
            FileOutputStream fileOutputStream = new FileOutputStream(pth);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(db);
            objectOutputStream.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static Database loadDB(String path) throws IOException, ClassNotFoundException {
        if (!path.endsWith("medb")) {
            throw new IOException("File is not a Metabase file");
        } else {
            FileInputStream fileInputStream = new FileInputStream(path);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Database db = (Database) objectInputStream.readObject();
            return db;
        }
    }
}