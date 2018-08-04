package AngleAndDistance;

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
            String sql = "CREATE TABLE ANGLE_DISTANCE " +
                    "(ID            SERIAL    PRIMARY KEY, " +
                    "distance_From_Goal           FLOAT     NOT NULL, " +
                    "angle_From_Goal              FLOAT     NOT NULL, " +
                    "dif_Goal_Centre_from_Goal_Loc       FLOAT     NOT NULL, " +
                    "goalY                      FLOAT     NOT NULL, " +
                    "saved                      FLOAT     NOT NULL, " +
                    " POWER                     FLOAT     NOT NULL)";
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