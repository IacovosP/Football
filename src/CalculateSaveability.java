import PostgresDB.insertTable;
import matchForm.matchForm;
import matchForm.insertForm;
import shooterForm.shooterForm;
import shooterForm.insertShooterTable;

import java.net.MalformedURLException;
import java.text.ParseException;

public class CalculateSaveability {
    public static void main(String[] args) {
        String keeperName = getKeeperName();
        System.out.println("Hello World!"); // Display the string.
        GoalGrid goalGrid = new GoalGrid();
        ShotLocationMap shotLoc = new ShotLocationMap();
        KeeperLocation keeperLoc = new KeeperLocation();
        shotPower power = new shotPower();
        Saved saved = new Saved();
        insertTable updateTable = new insertTable();
        insertForm updateForm  = new insertForm();
        matchForm match = new matchForm();
        shooterForm shooter = new shooterForm();
        insertShooterTable updateShooterTable = new insertShooterTable();
        try {
            match.initUI();
            match.frame.setVisible(true);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        match.frame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                System.out.println("Dateish: " + match.date);
                    try {
                        updateForm.addMatchToTable(match.home_team, match.away_team, match.date);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    try {
                        shooter.initUI();
                        shooter.frame.setVisible(true);
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                    shooter.frame.addWindowListener(new java.awt.event.WindowAdapter() {
                                                        @Override
                                                        public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                                                            try {
                                                                shotLoc.initUI();
                                                            } catch (MalformedURLException e) {
                                                                e.printStackTrace();
                                                            }
                                                        }
                                                    });

                    shotLoc.frame.addWindowListener(new java.awt.event.WindowAdapter() {
                        @Override
                        public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                            try {
                                keeperLoc.initUI();
                            } catch (MalformedURLException e) {
                                e.printStackTrace();
                            }
                        }
                    });

                    keeperLoc.frame.addWindowListener(new java.awt.event.WindowAdapter() {
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
                            try {
                                saved.initUI();
                            } catch (MalformedURLException e) {
                                e.printStackTrace();
                            }
                        }
                    });

                    saved.frame.addWindowListener(new java.awt.event.WindowAdapter() {
                        @Override
                        public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                            System.out.println("are are here ");
                            updateTable.addShotToTable(keeperName, keeperLoc.keeperPoints, goalGrid.gPoints, shotLoc.gShotPoints, saved.saved, power.shotPower);
                            try {
                                updateShooterTable.addShooterToTable(shooter.shooter, shooter.shot_time, updateForm.id, updateTable.id);
                            } catch (ParseException e) {
                                e.printStackTrace();
                            }
                        }
                    });
                }

        });

    }

    private static String getKeeperName() {
//       return "Karius";
//        return "Courtois";
//        return "Hart";
//        return "Lloris";
//        return "Schmeichel";
//        return "Forster";
//        return "Pope";
//        return "Degea";
//        return "Romero";
//        return "Leno";
//        return "Ederson";
//        return "Butland";
//        return "Gomes";
//        return "Fabianski";
//        return "Begovic";
//        return "Hennessey";
//        return "Karnezis";
//        return "Ryan";
//        return "Adrian";
//        return "Lossl";
//        return "Foster";
//        return "Pickford";
//        return "Darlow";
//        return "Cech";
//        return "Ospina";
//        return "Elliot";
//        return "Mignolet";
//        return "Jakupovic";
//        return "McCarthy";
        return "Bravo";
//        return "Dubravka";
//        return "Speroni";
//        return "Grant";
//        return "Gazzaniga";
    }
}
