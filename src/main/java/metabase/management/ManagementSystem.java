package metabase.management;

import metabase.db.Database;
import metabase.db.columns.Column;
import metabase.db.columns.Types;
import metabase.db.rows.Row;
import metabase.db.tables.Table;
import metabase.db.user.Superuser;
import metabase.exceptions.*;
import metabase.types.MetabaseObject;
import metabase.types.numbers.Double;
import metabase.types.numbers.Float;
import metabase.types.numbers.*;
import metabase.types.numbers.Long;
import metabase.types.numbers.Short;
import metabase.types.strings.BigString;
import metabase.types.strings.Char;
import metabase.types.strings.SmallString;
import metabase.types.strings.Text;

import java.io.File;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class ManagementSystem {

    public Database db;
    private Map<Types, Class> ObjectManager = new HashMap<>();
    private Map<String, String> typeManager = new HashMap<>();
    public ManagementSystem(String db, String username, String password) throws Exception {
        this.db = Database.loadDB(db);
        ObjectManager.put(Types.Double, Double.class);
        ObjectManager.put(Types.Float, Float.class);
        ObjectManager.put(Types.Int, Int.class);
        ObjectManager.put(Types.Long, Long.class);
        ObjectManager.put(Types.Short, Short.class);
        ObjectManager.put(Types.BigString, BigString.class);
        ObjectManager.put(Types.Char, Char.class);
        ObjectManager.put(Types.SmallString, SmallString.class);
        ObjectManager.put(Types.Text, Text.class);
        for (Types value : Types.values()) {
            typeManager.put(value.toString(), ObjectManager.get(value).getPackage().toString().replace("package ", "") + "." + value.toString());
        }
        if (this.db.owner.username.equals(username)) {
            if (!this.db.owner.password.equals(password)) {
                throw new AuthenticationError(this.db.owner);
            }
        } else {
            throw new AuthenticationError();
        }

    }
    public ManagementSystem(String db, String username, String password, PrintStream out) throws Exception {
        System.setOut(out);
        this.db = Database.loadDB(db);
        ObjectManager.put(Types.Double, Double.class);
        ObjectManager.put(Types.Float, Float.class);
        ObjectManager.put(Types.Int, Int.class);
        ObjectManager.put(Types.Long, Long.class);
        ObjectManager.put(Types.Short, Short.class);
        ObjectManager.put(Types.BigString, BigString.class);
        ObjectManager.put(Types.Char, Char.class);
        ObjectManager.put(Types.SmallString, SmallString.class);
        ObjectManager.put(Types.Text, Text.class);
        for (Types value : Types.values()) {
            typeManager.put(value.toString(), ObjectManager.get(value).getPackage().toString().replace("package ", "") + "." + value.toString());
        }
        if (this.db.owner.username.equals(username)) {
            if (!this.db.owner.password.equals(password)) {
                throw new AuthenticationError(this.db.owner);
            }
        } else {
            throw new AuthenticationError();
        }

    }

    public void parseCommand(String command) throws Exception {
        if (command.equals(""))
            return;
        try {
            String commandName = command.split("\\|")[0];
            System.out.println(commandName);
            if (command.toLowerCase().equals("q")) {
                Database.saveDB(db, db.path);
                System.exit(0);
            }
            List<String> args = new ArrayList<>();
            for (String arg : command.split("\\|")) {
                if (arg.equals(commandName))
                    continue;
                else {
                    args.add(arg);
                }
            }
            if (!args.isEmpty()) {
                Method method = this.getClass().getMethod(commandName, List.class);
                method.invoke(this, args);
            } else {
                Method method = this.getClass().getDeclaredMethod(commandName);
                method.invoke(this);
            }
        } catch (InvocationTargetException e) {
            throw new NoSuchCommandError(command);
        }
    }

    public void addTable(List<String> args) throws Exception {
        String name = args.get(0);
        String[] columnTypes = args.get(1).split("\\,");
        for (String str : columnTypes) {
        }
        for (int i=0; i<columnTypes.length; i++) {
            columnTypes[i] = typeManager.get(columnTypes[i]);
            System.out.println(columnTypes[i]);
        }
        db.tables.add(new Table(columnTypes, name));
        Database.saveDB(db, db.path);
    }
    public void addRow(List<String> args) throws Exception {
        Table table = db.getTable(args.get(0));
        String[] vals = args.get(1).split(",");
        int index = 0;
        if (!(args.get(1).split("\\,").length == table.columns.size())) {
            throw new MismatchedColumnError();
        } else {
            MetabaseObject[] values = new MetabaseObject[table.columns.size()];
            for (Column column : table.columns) {
                index = table.columns.indexOf(column);
                values[index] = (MetabaseObject)ObjectManager.get(table.columns.get(index).type).getConstructor(String.class).newInstance(vals[index]);
                if (!Arrays.asList(values).get(index).type().equals(column.type))
                    throw new ColumnTypeViolationError(column);
                else {
                    column.ids.add(values[index]);
                }
            }
            table.rows.add(new Row(table, index));
        }
    }

    public void getTables() {
        for (Table table : db.getTables()) {
            System.out.print(table.name + ";");
            for (Column column : table.columns) {
                System.out.print(column.type.toString() + ", ");
            }
            System.out.println();
        }
    }

    public void select(List<String> args) throws NoSuchTableError {
        Table table = db.getTable(args.get(0));
        try {
            String row = args.get(1);
        } catch (IndexOutOfBoundsException e) {}
    }

    public void save() throws Exception {
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