package metabase.db;

import metabase.db.tables.Table;
import metabase.db.user.User;
import metabase.exceptions.NoSuchTableError;

import java.io.*;
import java.util.ArrayList;

public class Database implements Serializable {

    public User owner;
    public String name;
    public ArrayList<Table> tables = new ArrayList<>();
    public String path;
    public Database(String name, String path, User owner) throws Exception {
        this.owner = owner;
        this.name = name;
        this.path = path;
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

    public Table getTable(String name) throws NoSuchTableError {
        for (Table table : tables) {
            if (table.name.equals(name))
                return table;
        }
        throw new NoSuchTableError(name);
    }

    public ArrayList<Table> getTables() {
        return tables;
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