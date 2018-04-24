package projectpackage;

import java.sql.*;



public class DataBase {
    public static void main( ) {
        Connection c = null;
        Statement stmt = null;

        try {
           Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:Log.db");

            stmt = c.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS Logs " +
                    "(name            TEXT     ," +
                    " start           TEXT     , " +
                    " stop            TEXT     , " +
                    " description     TEXT     , " +
                    " size            TEXT      )";
            stmt.executeUpdate(sql);
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        
    }
}
