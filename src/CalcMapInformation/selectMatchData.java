package CalcMapInformation;

import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class selectMatchData {
    ArrayList<Point> closePoints = new ArrayList<>();

    public static ArrayList<Map> getData(int game_id) {
        ArrayList result = new ArrayList();
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/databasename",
                            "pante", "123");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            PreparedStatement st = c.prepareStatement("SELECT * FROM SHOOTER WHERE GAME_ID = ?");
            st.setInt(1, game_id);

            ResultSet rs = st.executeQuery();

            while ( rs.next() ) {
                String shooter  = rs.getString("shooter");
                int shot_time  = rs.getInt("shot_time");
                int shot_id  = rs.getInt("shot_id");
                System.out.println( "shot_id = " + shot_id );
                System.out.println( "shot_time = " + shot_time );
                System.out.println( "shooter = " + shooter );

                System.out.println();
                Map shotData = new HashMap<>();
                shotData.put("shot_id", shot_id);
                shotData.put("shot_time", shot_time);
                shotData.put("shooter", shooter);
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