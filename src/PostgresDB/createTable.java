package PostgresDB;

import java.sql.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class createTable {
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
            String sql = "CREATE TABLE SHOT_LOCATION " +
                    "(ID            SERIAL    PRIMARY KEY, " +
                    " NAME           TEXT               , " +
                    "SHOT_X             INT     NOT NULL, " +
                    "SHOT_Y             INT     NOT NULL, " +
                    "GOAL_X             INT     NOT NULL, " +
                    "GOAL_Y             INT     NOT NULL, " +
                    "MIR_SHOT_X         INT     NOT NULL, " +
                    "MIR_SHOT_Y         INT     NOT NULL, " +
                    "MIR_GOAL_X         INT     NOT NULL, " +
                    "MIR_GOAL_Y         INT     NOT NULL, " +
                    "SAVED              INT     NOT NULL, " +
                    " POWER             INT     NOT NULL)";
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