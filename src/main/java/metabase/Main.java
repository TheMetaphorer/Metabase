package metabase;

import metabase.command.in.CommandLine;

public class Main {

    public static void main(String[] arg) throws Exception {
        try {
            CommandLine.listen();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            Throwable throwable = e.getCause();
            throwable.printStackTrace();
            System.out.println("A fatal exception has occurred during operation. Database will exit.");
            System.exit(-1);
        }
    }

}
