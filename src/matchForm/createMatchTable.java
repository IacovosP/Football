package matchForm;

import java.sql.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class createMatchTable {
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
            String sql = "CREATE TABLE MATCH " +
                    "(ID                        SERIAL   PRIMARY KEY, " +
                    "home_team                  TEXT     NOT NULL, " +
                    "away_team                  TEXT     NOT NULL, " +
                    "date                       DATE     NOT NULL, " +
                    "unique (home_team, away_team, date))";

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