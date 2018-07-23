package PostgresDB;

import java.awt.*;
import java.sql.*;
import java.util.ArrayList;


public class selectTable {
    ArrayList<Point> closePoints = new ArrayList<>();

    public static void main( String args[] ) {
        Connection c = null;
        Statement stmt = null;
        int qShot_x = 8;
        int qShot_y = 4;
        int qGoal_x = 12;
        int qGoal_y = 4;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/databasename",
                            "pante", "123");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            PreparedStatement st = c.prepareStatement("SELECT * FROM SHOT_LOCATION " +
                    "WHERE ((shot_x = ? AND shot_y = ?) " +
                    "AND (((goal_x = ? OR goal_x = ? OR goal_x = ?) AND goal_y = ?)" +
                    "OR  (( goal_y = ? OR goal_y = ? OR goal_y = ?) AND goal_x = ?)))" +
                    "OR  ((  mir_shot_x = ? AND mir_shot_y = ?)" +
                    "AND (((mir_goal_x = ? OR mir_goal_x = ? OR mir_goal_x = ?) AND mir_goal_y = ?)" +
                    "OR   ((mir_goal_y = ? OR mir_goal_y = ? +1 OR mir_goal_y = ?) AND mir_goal_x = ?)))");
            st.setInt(1, qShot_x);
            st.setInt(2, qShot_y);
            st.setInt(3, qGoal_x);
            st.setInt(4, qGoal_x + 1);
            st.setInt(5, qGoal_x -1);
            st.setInt(6, qGoal_y);
            st.setInt(7, qGoal_y + 1);
            st.setInt(8, qGoal_y - 1);
            st.setInt(9, qGoal_y);
            st.setInt(10, qGoal_x);
            st.setInt(11, qShot_x);
            st.setInt(12, qShot_y);
            st.setInt(13, qGoal_x);
            st.setInt(14, qGoal_x + 1);
            st.setInt(15, qGoal_x - 1);
            st.setInt(16, qGoal_y);
            st.setInt(17, qGoal_y + 1);
            st.setInt(18, qGoal_y - 1);
            st.setInt(19, qGoal_y);
            st.setInt(20, qGoal_x);

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
            }
            rs.close();
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }
        System.out.println("Operation done successfully");
    }
}