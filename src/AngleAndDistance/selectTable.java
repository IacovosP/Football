package AngleAndDistance;

import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class selectTable {
    ArrayList<Point> closePoints = new ArrayList<>();

    public static ArrayList<Map> getData() {
        ArrayList result = new ArrayList();
        Connection c = null;
        Statement stmt = null;
        int qShot_x = 6;
        int qShot_y = 8;
        int qGoal_x = 11;
        int qGoal_y = 4;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/databasename",
                            "pante", "123");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            PreparedStatement st = c.prepareStatement("SELECT * FROM SHOT_LOCATION WHERE ID > 514");

            ResultSet rs = st.executeQuery();
//            ResultSet rs = stmt.executeQuery( "SELECT * FROM SHOT_LOCATION " +
//                    "WHERE shot_x = qShot_x\"" );
            while ( rs.next() ) {
//                int id = rs.getInt("id");
                String  keeperName = rs.getString("name");
                int shot_x  = rs.getInt("shot_x");
                int shot_y  = rs.getInt("shot_y");
                int goal_x  = rs.getInt("goal_x");
                int goal_y  = rs.getInt("goal_y");
                int mir_shot_x = rs.getInt("mir_shot_x");
                int mir_shot_y = rs.getInt("mir_shot_y");
                int mir_goal_x = rs.getInt("mir_goal_x");
                int mir_goal_y= rs.getInt("mir_goal_y");
                int saved = rs.getInt("saved");
                int power = rs.getInt("power");
//                System.out.println( "ID = " + id );
                System.out.println( "NAME = " + keeperName );
                System.out.println( "goal_x = " + goal_x );
                System.out.println( "goal_y = " + goal_y );
                System.out.println( "mir_goal_x = " + mir_goal_x );
                System.out.println( "mir_goal_y = " + mir_goal_y );
                System.out.println( "saved = " + saved );
                System.out.println( "power = " + power );

                System.out.println();
                Map shotData = new HashMap<>();
                shotData.put("shotX", shot_x);
                shotData.put("shotY", shot_y);
                shotData.put("goalX", goal_x);
                shotData.put("goalY", goal_y);
                shotData.put("saved", saved);
                shotData.put("power", power);
                result.add(shotData);
            }
            rs.close();
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }
        System.out.println("Operation done successfully");
        return result;
    }
}