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
            String sql = "CREATE TABLE ANGLE_DISTANCE2 " +
                    "(ID            SERIAL    PRIMARY KEY, " +
                    "distance_From_Goal                 FLOAT     NOT NULL, " +
                    "angle_From_Goal                    FLOAT     NOT NULL, " +
                    "angle_From_Shot_Location_On_Goal   FLOAT     NOT NULL, " +
                    "dif_Goal_Centre_from_Goal_Loc      FLOAT     NOT NULL, " +
                    "goal_Y                             INT     NOT NULL, " +
                    "saved                              INT     NOT NULL, " +
                    " POWER                             INT     NOT NULL)";
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