package CalcMapInformation;

import AngleAndDistance.ProcessRawData;

import java.util.ArrayList;
import java.util.Map;

public class processMatchData {
    public static void main(String[] args) {
        int gameId = 1;
        ArrayList<Map> shooterData = selectMatchData.getData(gameId);
        ArrayList<Map> matchAnalysisReadyData = new ArrayList<>();
        ArrayList<Map> result = new ArrayList<>();
        for (Map shooterShot : shooterData) {
            ArrayList<Map> shotData = selectShotDataInferredFromShooter.getData((int) shooterShot.get("shot_id"));
            matchAnalysisReadyData.add(ProcessRawData.processRawData(shotData));
        }
        for (Map analysisData : matchAnalysisReadyData) {
            double distanceFromGoal = (double) analysisData.get("DX_FROM_GOAL");
            double angleFromShotLocationOnGoal = (double) analysisData.get("ANGLE_FROM_SHOT_LOCATION_ON_GOAL");
            double angleFromGoal = (double) analysisData.get("ANGLE_FROM_GOAL");
            double difGoalCentreGoalLoc = (double) analysisData.get("DX_GOAL_CENTRE_GOAL_LOC");
            int goal_y = (int) analysisData.get("GOAL_Y");
            int saved = (int) analysisData.get("SAVED");
            int power = (int) analysisData.get("POWER");
            System.out.println("Result: " + " distance from Goal " +
                    distanceFromGoal + " angleFromShotLocationOnGoal " +
                    angleFromShotLocationOnGoal + " angleFromGoal " +
                    angleFromGoal + " difGoalCentreGoalLoc " +
                    difGoalCentreGoalLoc + " goal_y " +
                    goal_y + " saved " +
                    saved + " power " +
                    power
            );
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
    }
}
