package AngleAndDistance;

import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;

public class insertTable {
    public static void addShotToTable(double distanceFromGoal, double angleFromGoal, double angleFromShotLocationOnGoal, double difGoalCentreGoalLoc, int goalY, int saved, int power) {
        Connection c = null;
        Statement stmt = null;

        int sPower = power;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/databasename",
                            "pante", "123");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

//            stmt = c.createStatement();
            PreparedStatement st = c.prepareStatement("INSERT INTO ANGLE_DISTANCE2 (distance_From_Goal,angle_From_Goal, angle_From_Shot_Location_On_Goal, dif_Goal_Centre_from_Goal_Loc, goal_Y, saved, power)" +
                    " VALUES (?, ?, ?, ?, ?, ?, ?)");
            st.setFloat(1, (float) distanceFromGoal);
            st.setFloat(2, (float) angleFromGoal);
            st.setFloat(3, (float) angleFromShotLocationOnGoal);
            st.setFloat(4,(float) difGoalCentreGoalLoc);
            st.setInt(5, goalY);
            st.setInt(6, saved);
            st.setInt(7, power);
            st.executeUpdate();
            st.close();
            c.commit();
            c.close();
        } catch (Exception e) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }
        System.out.println("Records created successfully");
    }
}