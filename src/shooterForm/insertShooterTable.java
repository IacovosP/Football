package shooterForm;

import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class insertShooterTable {
    public void addShooterToTable(String shooter, int shot_time, int shot_id, int game_id) throws ParseException {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/databasename",
                            "pante", "123");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

//            stmt = c.createStatement();
            PreparedStatement st = c.prepareStatement("INSERT INTO SHOOTER (SHOOTER,SHOT_TIME,GAME_ID, SHOT_ID)" +
                    " VALUES (?, ?, ?, ?)");
            st.setString(1, shooter);
            st.setInt(2, shot_time);
            st.setInt(3, game_id);
            st.setInt(4, shot_id);
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