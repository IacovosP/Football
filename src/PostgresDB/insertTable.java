package PostgresDB;

import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;

public class insertTable {
    public void addShotToTable(String keeperName, ArrayList<Point> keeperPoints, ArrayList<Point> goalPoints, ArrayList<Point> shotPoints, int saved, int power) {
        Connection c = null;
        Statement stmt = null;
        int shot_x = shotPoints.get(0).x;
        int shot_y = shotPoints.get(0).y;
        int mir_shot_x = shotPoints.get(1).x;
        int mir_shot_y = shotPoints.get(1).y;
        int goal_x = goalPoints.get(0).x;
        int goal_y = goalPoints.get(0).y;
        int mir_goal_x = goalPoints.get(1).x;
        int mir_goal_y = goalPoints.get(1).y;
        int gk_x = keeperPoints.get(0).x;
        int gk_y = keeperPoints.get(0).y;
        int mir_gk_x = keeperPoints.get(1).x;
        int mir_gk_y = keeperPoints.get(1).y;
        int sPower = power;
        String keeper = keeperName;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/databasename",
                            "pante", "123");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

//            stmt = c.createStatement();
            PreparedStatement st = c.prepareStatement("INSERT INTO SHOT_LOCATION (NAME,SHOT_X,SHOT_Y,GOAL_X, GOAL_Y, MIR_SHOT_X, MIR_SHOT_Y, MIR_GOAL_X, MIR_GOAL_Y, SAVED, POWER, GK_X,GK_Y, MIR_GK_X, MIR_GK_Y)" +
                    " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?,?,?)");
            st.setString(1, keeper);
            st.setInt(2, shot_x);
            st.setInt(3, shot_y);
            st.setInt(4, goal_x);
            st.setInt(5, goal_y);
            st.setInt(6, mir_shot_x);
            st.setInt(7, mir_shot_y);
            st.setInt(8, mir_goal_x);
            st.setInt(9, mir_goal_y);
            st.setInt(10, saved);
            st.setInt(11, sPower);
            st.setInt(12, gk_x);
            st.setInt(13, gk_y);
            st.setInt(14,mir_gk_x);
            st.setInt(15,mir_gk_y);
            st.executeUpdate();
            st.close();
//            String sql = "INSERT INTO SHOT_LOCATION (NAME,SHOT_X,SHOT_Y,GOAL_X, GOAL_Y, MIR_SHOT_X, MIR_SHOT_Y, MIR_GOAL_X, MIR_GOAL_Y, POWER) "
//                    + "VALUES (keeper, shot_x, shot_y, goal_x, goal_y, mir_shot_x, mir_shot_y, mir_goal_x, mir_goal_y, sPower);";
//            stmt.executeUpdate(sql);

//            sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) "
//                    + "VALUES (2, 'Allen', 25, 'Texas', 15000.00 );";
//            stmt.executeUpdate(sql);
//
//            sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) "
//                    + "VALUES (3, 'Teddy', 23, 'Norway', 20000.00 );";
//            stmt.executeUpdate(sql);
//
//            sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) "
//                    + "VALUES (4, 'Mark', 25, 'Rich-Mond ', 65000.00 );";
//            stmt.executeUpdate(sql);

//            stmt.close();
            c.commit();
            c.close();
        } catch (Exception e) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }
        System.out.println("Records created successfully");
    }
}