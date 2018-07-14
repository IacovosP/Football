import javax.swing.*;
/*
 * GridBagLayoutDemo.java requires no other files.
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;

public class GoalGrid {
    final static boolean shouldFill = true;
    final static boolean shouldWeightX = true;
    final static boolean RIGHT_TO_LEFT = false;
    public ArrayList<Point> gPoints = new ArrayList<>();
    public JFrame frame = new JFrame("GridBagLayoutDemo");


    public void addComponentsToPane(Container pane) {
        if (RIGHT_TO_LEFT) {
            pane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        }
        JButton button;
        pane.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        if (shouldFill) {
            //natural height, maximum width
            c.fill = GridBagConstraints.HORIZONTAL;
        }

        for (int i=0;i<4; i++) {
            for (int j = 0; j < 12; j++) {
                button = new JButton("Button " + (i+1)  + "," + (j+1));
                if (shouldWeightX) {
                    c.weightx = 0.5;
                    c.weighty = 1;
                }
                c.gridwidth = 1;
                c.gridheight = 1;
                c.ipady = 60;
                c.fill = GridBagConstraints.HORIZONTAL;
                c.gridx = j;
                c.gridy = i;
                int x = 0;
                int y = 0;
                x = Math.abs(j - 12);
                y = i + 1;
//                ArrayList<Point> points = new ArrayList<>();
                Point mirroredXY = new Point(x, y);
                Point xy = new Point(j+1,i+1);
                button.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e)
                    {
                        // display/center the jdialog when the button is pressed
                        System.out.println( "x:" +mirroredXY.x +"y:"+mirroredXY.y);
                        ArrayList<Point> points = new ArrayList<>();
                        points.add(xy);
                        points.add(mirroredXY);
                        addPointsGlobal(points);
                        frame.dispose();
                    }
                });
                pane.add(button, c);
            }
        }

    }

    public void addPointsGlobal(ArrayList<Point> points) {
        this.gPoints = points;
    }

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    public void createAndShowGUI() {
        //Create and set up the window.
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Set up the content pane.
        addComponentsToPane(frame.getContentPane());
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dim.width/5, dim.height/5);
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}