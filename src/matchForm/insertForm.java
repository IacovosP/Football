package matchForm;

import java.awt.*;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class insertForm {
    public int id;
    public void addMatchToTable(String home_team, String away_team, String date) throws ParseException {
        Connection c = null;
        Statement stmt = null;
        String startDate = date;
        SimpleDateFormat sdf1 = new SimpleDateFormat("MM/dd/yyyy");
        java.util.Date date2 = sdf1.parse(startDate);
        java.sql.Date sqlStartDate = new java.sql.Date(date2.getTime());
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/databasename",
                            "pante", "123");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

//            stmt = c.createStatement();
            PreparedStatement st = c.prepareStatement("INSERT INTO MATCH (HOME_TEAM,AWAY_TEAM,DATE)" +
                    " VALUES (?, ?, ?)" +
                    " RETURNING id;");
            st.setString(1, home_team);
            st.setString(2, away_team);
            st.setDate(3, sqlStartDate);
            ResultSet rs = st.executeQuery();
            while ( rs.next() ) {
                id = rs.getInt("id");
            }
            rs.close();
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
        }
        System.out.println("Records created successfully");
    }
}