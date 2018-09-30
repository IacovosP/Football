import PostgresDB.insertTable;
import matchForm.matchForm;
import matchForm.insertForm;
import shooterForm.shooterForm;
import shooterForm.insertShooterTable;

import java.net.MalformedURLException;
import java.text.ParseException;

public class CalculateSaveability {
    public static void main(String[] args) {
        System.out.println("Hello World!"); // Display the string.
        GoalGrid goalGrid = new GoalGrid();
        ShotLocationMap shotLoc = new ShotLocationMap();
        KeeperLocation keeperLoc = new KeeperLocation();
        shotPower power = new shotPower();
        Saved saved = new Saved();
        insertTable updateTable = new insertTable();
        insertForm updateForm = new insertForm();
        matchForm match = new matchForm();
        shooterForm shooter = new shooterForm();
        insertShooterTable updateShooterTable = new insertShooterTable();
        runMatchCollection(match, updateForm, shooter, shotLoc, keeperLoc, goalGrid, power, saved, updateTable, updateShooterTable);
    }


    private static void runMatchCollection(
            matchForm match,
            insertForm updateForm,
            shooterForm shooter,
            ShotLocationMap shotLoc,
            KeeperLocation keeperLoc,
            GoalGrid goalGrid,
            shotPower power,
            Saved saved,
            insertTable updateTable,
            insertShooterTable updateShooterTable
    ) {
        try {
            match.initUI();
            match.frame.setVisible(true);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        runFormChain(match, updateForm, shooter, shotLoc, keeperLoc, goalGrid, power, saved, updateTable, updateShooterTable, 0); // 0 for gameid as it's unknown at this time
    }

    private static void runFormChain(
            matchForm match,
            insertForm updateForm,
            shooterForm shooter,
            ShotLocationMap shotLoc,
            KeeperLocation keeperLoc,
            GoalGrid goalGrid,
            shotPower power,
            Saved saved,
            insertTable updateTable,
            insertShooterTable updateShooterTable,
            int gameId
    ) {
        String keeperName = shooter.keeper;
        System.out.println("Keeper : " + shooter.keeper);

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
                        updateTable.addShotToTable(shooter.keeper, keeperLoc.keeperPoints, goalGrid.gPoints, shotLoc.gShotPoints, saved.saved, power.shotPower);
                        try {
                            updateShooterTable.addShooterToTable(shooter.shooter, shooter.shot_time, updateTable.id, updateForm.id);
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        int gameID = updateForm.id > 0 ? updateForm.id : 0;
                        runFormChainWithoutMatchForm(gameID);
                    }
                });
            }

        });
    }

        private static void runFormChainWithoutMatchForm(
                int gameId
            ) {
            GoalGrid goalGrid = new GoalGrid();
            ShotLocationMap shotLoc = new ShotLocationMap();
            KeeperLocation keeperLoc = new KeeperLocation();
            shotPower power = new shotPower();
            Saved saved = new Saved();
            insertTable updateTable = new insertTable();
            insertForm updateForm = new insertForm();
            matchForm match = new matchForm();
            shooterForm shooter = new shooterForm();
            insertShooterTable updateShooterTable = new insertShooterTable();
            String keeperName = shooter.keeper;
            System.out.println("Keeper : " + shooter.keeper);

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
                    updateTable.addShotToTable(shooter.keeper, keeperLoc.keeperPoints, goalGrid.gPoints, shotLoc.gShotPoints, saved.saved, power.shotPower);
                    try {
                        updateShooterTable.addShooterToTable(shooter.shooter, shooter.shot_time, updateTable.id, gameId);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    int gameID = gameId > 0 ? gameId : 0;
                    runFormChainWithoutMatchForm(gameID);
                }
            });
        }

    private static String getKeeperName() {
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
//        return "Bravo";
        return "Dubravka";
//        return "Speroni";
//        return "Grant";
//        return "Gazzaniga";
//        return "Hamer";
    }
}
