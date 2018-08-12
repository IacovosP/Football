package shooterForm;

import java.sql.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class createShooterTable {
    public static void main( String args[] ) {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/databasename",
                            "pante", "123");
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            String sql = "CREATE TABLE SHOOTER " +
                    "(ID                        SERIAL      PRIMARY KEY, " +
                    "shooter                    TEXT        NOT NULL, " +
                    "shot_time                  INT         NOT NULL, " +
                    "game_id                    SERIAL      NOT NULL, " +
                    "shot_id                    SERIAL      NOT NULL)";
            stmt.executeUpdate(sql);
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }
        System.out.println("Table created successfully");
    }
}