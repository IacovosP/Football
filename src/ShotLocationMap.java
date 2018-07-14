import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.*;

import static jdk.nashorn.internal.objects.Global.println;

public class ShotLocationMap {

    private static final String BACKHGROUND_IMAGE_URL = "shotlocationBackground.png";
    public ArrayList<Point> gShotPoints = new ArrayList<>();
    public JFrame frame = new JFrame(ShotLocationMap.class.getSimpleName());


    protected void initUI() throws MalformedURLException {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final ImageIcon backgroundImage = new ImageIcon(BACKHGROUND_IMAGE_URL);
        JLabel mainPanel = new JLabel(backgroundImage) {
        };
        mainPanel.setLayout(new GridBagLayout());

        JPanel paintPanel = new JPanel();
        paintPanel.setOpaque(false);
        paintPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(0, 0, 0, 0);
        String buttonName = "N";
        c.ipadx = 1;
        c.ipady = 20;
//        c.fill = GridBagConstraints.HORIZONTAL;


        for (int i = 4; i < 7; i++) {
            c.ipady = 20;       //reset to default
            c.ipadx = 0;
            for (int j=0; j< 14; j++) {
                buttonName = "M";
                c.ipadx = 52;
                c.ipady = 65;
                if (j<2 || j>11) {
                    c.ipadx = 120;
                    buttonName = "XXL";
                }

                c.gridx = j;
                c.gridy = i;
                int x = 0;
                int y = 0;
                if (j>6) {
                    x = Math.abs(j -14);
                    y = i;
                } else {
                    x = j +1;
                    y = i;
                }
                Point mirroredXY = new Point(x, y);
                Point xy = new Point(j+1,i);
                JButton button = new JButton(buttonName);
                button.setBorderPainted(true);
                button.setContentAreaFilled(false);
                button.setOpaque(false);
                button.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e)
                    {
                        // display/center the jdialog when the button is pressed
//                        JDialog d = new JDialog(frame, "x:" +mirroredXY.x +"y:"+mirroredXY.y, true);
                        System.out.println("something about xy" + xy);
                        gShotPoints.add(xy);
                        gShotPoints.add(mirroredXY);
//                        d.setLocationRelativeTo(frame);
//                        d.setVisible(true);
                        frame.dispose();
                    }
                });
                paintPanel.add(button, c);
            }

        }


        JPanel textPanel = new JPanel();

        textPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        textPanel.setOpaque( false );
        gbc.insets = new Insets(0, 0, 0, 0);
        gbc.ipadx = 0;
        gbc.ipady = 20;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;


        for (int i = 0; i < 3; i++) {
            gbc.ipady = 20;       //reset to default
            gbc.ipadx = 0;
            for (int j=0; j< 20; j++) {
                if (j<3 || j>16) {
                    gbc.ipadx = 80;
                    buttonName = "XL";
                }
                else if (j<6 || j>= 14) {
                    gbc.ipadx = 50;
                    buttonName = "L";
                } else {
                    buttonName = "S";
                    gbc.ipadx = 14;
                }
                gbc.weightx = 1.0;
                gbc.gridx = j;
                gbc.gridy = i;
                int x = 0;
                int y = 0;
                if (j>9) {
                    x = Math.abs(j -20);
                    y = i + 1;
                } else {
                    x = j +1;
                    y = i + 1;
                }
                Point mirroredXY = new Point(x, y);
                Point xy = new Point(j+1, i+1);
                JButton button = new JButton(buttonName);
                button.setBorderPainted(true);
                button.setContentAreaFilled(false);
                button.setOpaque(false);
                button.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e)
                    {
                        // display/center the jdialog when the button is pressed
//                        JDialog d = new JDialog(frame, "x:" +mirroredXY.x +"y:"+mirroredXY.y, true);
                        System.out.println("something about xy" + xy);
                        gShotPoints.add(xy);
                        gShotPoints.add(mirroredXY);
//                        d.setLocationRelativeTo(frame);
//                        d.setVisible(true);
                        frame.dispose();
                    }
                });
                textPanel.add(button, gbc);

            }

        }

        JPanel outBox = new JPanel();

        outBox.setLayout(new GridBagLayout());
        outBox.setOpaque( false );
        GridBagConstraints gbc2 = new GridBagConstraints();
        gbc2.insets = new Insets(0, 0, 0, 0);
        gbc2.ipadx = 0;
        gbc2.ipady = 20;
        gbc2.gridy = 0;
        gbc2.fill = GridBagConstraints.HORIZONTAL;


        for (int i = 7; i < 11; i++) {
            gbc2.ipady = 60;       //reset to default
            gbc2.ipadx = 110;
            for (int j=0; j< 8; j++) {
                buttonName = "L";
                gbc2.ipadx = 120;
                gbc2.ipady = 65;
                if (j<1 || j>6) {
                    gbc2.ipadx = 220;
                    buttonName = "XXXL";
                }
                gbc2.gridx = j;
                gbc2.gridy = i;
                int x = 0;
                int y = 0;
                if (j>3) {
                    x = Math.abs(j -8);
                    y = i;
                } else {
                    x = j +1;
                    y = i;
                }
                Point mirroredXY = new Point(x, y);
                Point xy = new Point(j+1,i);
                JButton button = new JButton(buttonName);
                button.setBorderPainted(true);
                button.setContentAreaFilled(false);
                button.setOpaque(false);
                outBox.add(button, gbc2);
                button.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e)
                    {
                        // display/center the jdialog when the button is pressed
//                        JDialog d = new JDialog(frame, "x:" +mirroredXY.x +"y:"+mirroredXY.y, true);
                        System.out.println("something about xy" + xy);
                        gShotPoints.add(xy);
                        gShotPoints.add(mirroredXY);
//                        d.setLocationRelativeTo(frame);
//                        d.setVisible(true);
                        frame.dispose();
                    }
                });
            }

        }

        paintPanel.setSize(1920,1080);
        textPanel.setSize(1920,1080);
        JSplitPane  splitPane = new JSplitPane();
        splitPane.setOpaque(false);
        splitPane.setSize(1920,1080);
        splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);  // we want it to split the window verticaly
        splitPane.setDividerLocation(150);                    // the initial position of the divider is 200 (our window is 400 pixels high)
        splitPane.setDividerSize(0);
        splitPane.setTopComponent(textPanel);                  // at the top we want our "topPanel"
        splitPane.setBottomComponent(paintPanel);

        JSplitPane  splitPane2 = new JSplitPane();
        splitPane2.setOpaque(false);
        splitPane2.setSize(1920,1080);
        splitPane2.setOrientation(JSplitPane.VERTICAL_SPLIT);  // we want it to split the window verticaly
        splitPane2.setDividerLocation(400);                    // the initial position of the divider is 200 (our window is 400 pixels high)
        splitPane2.setDividerSize(0);
        splitPane2.setTopComponent(splitPane);                  // at the top we want our "topPanel"
        splitPane2.setBottomComponent(outBox);

        mainPanel.add(splitPane2);
        // Let's put a filler bottom component that will push the rest to the top
        gbc.weighty = 1.0;
        mainPanel.add(Box.createGlue(), gbc);
        frame.add(mainPanel);
        frame.pack();
        frame.setVisible(true);
    }

    public void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                try {
                    new ShotLocationMap().initUI();
                } catch (MalformedURLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
    }

}