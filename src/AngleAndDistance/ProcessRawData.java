package AngleAndDistance;

import AngleAndDistance.selectTable;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ProcessRawData {
    private static String SHOT_X = "shotX";
    private static String SHOT_Y = "shotY";
    private static String GOAL_X = "goalX";
    private static String GOAL_Y = "goalY";
    private static String SAVED = "saved";
    private static String POWER = "power";

    public static void main(String[] args) {
        ArrayList<Map> shotData = selectTable.getData();
        int i = 0;
        for (Map shot : shotData) {
            int shot_x = (int) shot.get(SHOT_X);
            int shot_y = (int) shot.get(SHOT_Y);
            int goal_x = (int) shot.get(GOAL_X);
            int goal_y = (int) shot.get(GOAL_Y);
            int saved = (int) shot.get(SAVED);
            int power = (int) shot.get(POWER);
            double distanceFromGoal = calculateDistance(shot_x, shot_y, goal_x);
            double angleFromGoal = calculateAngle(shot_x, shot_y);
            double angleFromShotLocationOnGoal = calculateAngleFromGoalLoc(shot_x, shot_y, goal_x);
            double difGoalCentreGoalLoc = calculateDistanceOfGoalLocations(goal_x);
//            insertTable.addShotToTable(distanceFromGoal,angleFromGoal,difGoalCentreGoalLoc,goal_y,saved,power);
            i++;
        }
        System.out.println("MY I: " + i);
    }

    private static double calculateDistanceOfGoalLocations(int goal_x) {
        double Dx = 0;
        Dx = Math.abs(6.5 - goal_x) * 2;
        System.out.println("at location x: " + goal_x + " with dif: " + Dx);
        return Dx;
    }

    private static double calculateDistance(int shot_x, int shot_y, int goal_x){
        double Dx = 0;
        double Dy = 0;
        if (shot_y <=3) {
            Dy = shot_y * 6 - 3;
            if (shot_x >= 7 && shot_x <=14) {
                Dx = Math.abs(10.5 - shot_x) * 7.5;
            } else {
                Dx = Math.abs(10.5 - shot_x) * 12;
            }
        } else if (shot_y <=6) {
            Dy = shot_y * 12 - 6 - 18;
            if (shot_x >= 3 && shot_x <= 12) {
                Dx = Math.abs(7.5 -shot_x) * 13.2;
            } else {
                Dx = Math.abs(7.5 -shot_x) * 25;
            }
        } else {
            Dy = shot_y * 12 - 6 - 18;
            if (shot_x >= 2 && shot_x <= 7) {
                Dx = Math.abs(4.5 - shot_x) * 22;
            } else {
                Dx = Math.abs(4.5 - shot_x) * 40;
            }
        }
        double dist = Math.sqrt(Dx*Dx + Dy*Dy);

        // output distance
        System.out.println("distance from (" + shot_x + ", " + shot_y + ") to (0, 0) = " + dist);

        return dist;
    }

    private static double calculateAngleFromGoalLoc(int shot_x, int shot_y, int goal_x){
        double Dx = 0;
        double Dy = 0;
        if (shot_y <=3) {
            Dy = shot_y * 6 - 3;
            if (shot_x >= 7 && shot_x <=14) {
                Dx = Math.abs(10.5 - shot_x) * 7.5;
            } else {
                Dx = Math.abs(10.5 - shot_x) * 12;
            }
        } else if (shot_y <=6) {
            Dy = shot_y * 12 - 6 - 18;
            if (shot_x >= 3 && shot_x <= 12) {
                Dx = Math.abs(7.5 -shot_x) * 13.2;
            } else {
                Dx = Math.abs(7.5 -shot_x) * 25;
            }
        } else {
            Dy = shot_y * 12 - 6 - 18;
            if (shot_x >= 2 && shot_x <= 7) {
                Dx = Math.abs(4.5 - shot_x) * 22;
            } else {
                Dx = Math.abs(4.5 - shot_x) * 40;
            }
        }
        // output angle
        double goalLoc = (0 + goal_x - 6.5)*2; //multiplied by 2 to convert to feet
        double angle = (double) Math.toDegrees(Math.atan2(Dx - goalLoc, Dy - 0));
        System.out.println("angle from (" + shot_x + ", " + shot_y + ") to (" +goal_x+", 0) = " + angle);

        return angle;
    }

    private static double calculateAngle(int shot_x, int shot_y){
        double Dx = 0;
        double Dy = 0;
        if (shot_y <=3) {
            Dy = shot_y * 6 - 3;
            if (shot_x >= 7 && shot_x <=14) {
                Dx = Math.abs(10.5 - shot_x) * 7.5;
            } else {
                Dx = Math.abs(10.5 - shot_x) * 12;
            }
        } else if (shot_y <=6) {
            Dy = shot_y * 12 - 6 - 18;
            if (shot_x >= 3 && shot_x <= 12) {
                Dx = Math.abs(7.5 -shot_x) * 13.2;
            } else {
                Dx = Math.abs(7.5 -shot_x) * 25;
            }
        } else {
            Dy = shot_y * 12 - 6 - 18;
            if (shot_x >= 2 && shot_x <= 7) {
                Dx = Math.abs(4.5 - shot_x) * 22;
            } else {
                Dx = Math.abs(4.5 - shot_x) * 40;
            }
        }
        // output angle
        double angle = (double) Math.toDegrees(Math.atan2(Dx - 0, Dy - 0));
        System.out.println("angle from (" + shot_x + ", " + shot_y + ") to (0, 0) = " + angle);

        return angle;
    }

    private static double getAngle(int shot_x, int shot_y) {
        double Dx = 0;
        if (shot_y <=3) {
            Dx = Math.abs(10.5 - shot_x);
        } else if (shot_y <=6) {
            Dx = Math.abs(7.5 -shot_x);
        } else {
            Dx = Math.abs(4.5 - shot_x);

        }
        double angle = (double) Math.toDegrees(Math.atan2(Dx - 0, shot_y - 0));

        if(angle < 0){
            angle += 360;
        }
        System.out.println("angle from (" + shot_x + ", " + shot_y + ") to (0, 0) = " + angle);

        return angle;
    }

}
