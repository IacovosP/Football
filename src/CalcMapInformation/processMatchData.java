package CalcMapInformation;

import AngleAndDistance.ProcessRawData;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class processMatchData {
    public static void main(String[] args) {
        int gameId = 43;
        double xG = 0;

        ArrayList<Map> shooterData = selectMatchData.getData(gameId);
//        ArrayList<Map> shooterData = selectAllMatches.getData(gameId);
        ArrayList<Map> matchAnalysisReadyData = new ArrayList<>();
        ArrayList<Map> result = new ArrayList<>();
        for (Map shooterShot : shooterData) {
            ArrayList<Map> shotData = selectShotDataInferredFromShooter.getData((int) shooterShot.get("shot_id"));
            Map addToProcessedMap = ProcessRawData.processRawData((shotData));
            addToProcessedMap.put("SHOOTER" , shooterShot.get("shooter"));
            matchAnalysisReadyData.add(addToProcessedMap);
        }

        for (Map analysisData : matchAnalysisReadyData) {
            double distanceFromGoal = (double) analysisData.get("DX_FROM_GOAL");
            double angleFromShotLocationOnGoal = (double) analysisData.get("ANGLE_FROM_SHOT_LOCATION_ON_GOAL");
            double angleFromGoal = (double) analysisData.get("ANGLE_FROM_GOAL");
            double difGoalCentreGoalLoc = (double) analysisData.get("DX_GOAL_CENTRE_GOAL_LOC");
            int goal_y = (int) analysisData.get("GOAL_Y");
            int saved = (int) analysisData.get("SAVED");
            int power = (int) analysisData.get("POWER");
            String shooter = (String) analysisData.get("SHOOTER");
            String keeper = (String) analysisData.get("KEEPER");
            System.out.println("Result: " +"Keeper: " + keeper + " Shooter: " + shooter+ " distance from Goal " +
                    distanceFromGoal + " angleFromShotLocationOnGoal " +
                    angleFromShotLocationOnGoal + " angleFromGoal " +
                    angleFromGoal + " difGoalCentreGoalLoc " +
                    difGoalCentreGoalLoc + " goal_y " +
                    goal_y + " saved " +
                    saved + " power " +
                    power
            );
//            System.out.print("Not Saved, Saved");
            String[] cmd = {
                    "python",
                    "D:/Users/Jackys/IdeaProjects/Football Saveability/shoot.py",
                    "s2",
            };

            String shotAngleData = " 1.0," + Double.toString(distanceFromGoal) + "," + Double.toString(angleFromGoal) +
                    "," + Double.toString(angleFromShotLocationOnGoal) + "," + Double.toString(difGoalCentreGoalLoc) + "," + Integer.toString(goal_y) + ".0," + Integer.toString(power)+ ".0" ;
            Runtime r = Runtime.getRuntime();
            //System.out.println("This string array " + shotAngleData);
            String pyScript = "./shoot.py";
            File f = new File(pyScript);
            if (f.exists() && !f.isDirectory()) {
                try {
                    Process p = r.exec("python " + pyScript + shotAngleData);
                    BufferedReader in = new BufferedReader(
                            new InputStreamReader(p.getInputStream()));
                    String line = null;
                    while ((line = in .readLine()) != null) {
                        String[] splited = line.split("\\s+");
                        String notSavedChance = splited[0].replaceAll("[\\[\\](){}]","");
                        String savedChance = splited[1].replaceAll("[\\[\\](){}]","");
                        double savedP =  Double.parseDouble(savedChance);
                        double notSavedP = Double.parseDouble(notSavedChance);
                        xG = xG + notSavedP;
//                        System.out.println("First " + savedChance);
//                        System.out.println("Second " + notSavedChance);
                        System.out.println(line);
                    }
                    //System.out.println("Python script ran!!");
                } catch (Exception ex) {
                    System.out.println("Something bad happened!!");
                    ex.printStackTrace();
                }
            }
//            result.add(PythonMethod(
//                    distanceFromGoal,
//                    angleFromShotLocationOnGoal,
//                    angleFromGoal,
//                    difGoalCentreGoalLoc,
//                    goal_y,
//                    saved,
//                    power
//            )
        }
        System.out.println("xG = " + xG);
    }

    private ArrayList<String> jsonStringToArray(String jsonString) throws JSONException {

        ArrayList<String> stringArray = new ArrayList<String>();

        JSONArray jsonArray = new JSONArray(jsonString);

        for (int i = 0; i < jsonArray.length(); i++) {
            stringArray.add(jsonArray.getString(i));
        }

        return stringArray;
    }
}
