import PostgresDB.insertTable;

import java.net.MalformedURLException;

public class CalculateSaveability {
    public static void main(String[] args) {
        String keeperName = getKeeperName();
        System.out.println("Hello World!"); // Display the string.
        GoalGrid goalGrid = new GoalGrid();
        ShotLocationMap shotLoc = new ShotLocationMap();
        shotPower power = new shotPower();
        insertTable updateTable = new insertTable();
        try {
            shotLoc.initUI();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        shotLoc.frame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                goalGrid.createAndShowGUI();
            }
        });

        goalGrid.frame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                try {
                    power.initUI();
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
        });

        power.frame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                System.out.println("are are here ");
                updateTable.addShotToTable("keeper", goalGrid.gPoints, shotLoc.gShotPoints, power.shotPower);
            }
        });
    }

    private static String getKeeperName() {
        return "Karius";
//        return "Courtois";
//        return "Hart";
//        return "Lloris";
//        return "Schmeichel";
//        return "Forster";
//        return "Pope";
//        return "Degea";
//        return "Leno";
//        return "Ederson";
//        return "Butland";
//        return "Gomez";
//        return "Fabianski";
    }
}
