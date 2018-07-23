import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.util.ArrayList;

public class KeeperLocation {


    private static final String BACKHGROUND_IMAGE_URL = "keeperLocation.png";
    public ArrayList<Point> keeperPoints = new ArrayList<>();
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
        c.ipady = 40;
//        c.fill = GridBagConstraints.HORIZONTAL;

        JPanel textPanel = new JPanel();

        textPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        textPanel.setOpaque( false );
        gbc.insets = new Insets(0, 0, 0, 0);
        gbc.ipadx = 0;
        gbc.ipady = 40;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;


        for (int i = 0; i < 8; i++) {
            gbc.ipady = 40;       //reset to default
            gbc.ipadx = 0;
            for (int j=0; j< 24; j++) {

                buttonName = "S";
                gbc.ipadx = 8;

                gbc.weightx = 1.0;
                gbc.gridx = j;
                gbc.gridy = i;
                int x = 0;
                int y = 0;
                if (j>11) {
                    x = 12 - Math.abs(12 - j);
                    y = i + 1;
                } else {
                    x = 12 - j + 12;
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
                        System.out.println("something about xy" + mirroredXY);
                        keeperPoints.add(xy);
                        keeperPoints.add(mirroredXY);
//                        d.setLocationRelativeTo(frame);
//                        d.setVisible(true);
                        frame.dispose();
                    }
                });
                textPanel.add(button, gbc);

            }

        }

        textPanel.setSize(1920,1080);
        textPanel.setOpaque(false);

        mainPanel.add(textPanel);
        // Let's put a filler bottom component that will push the rest to the top
        gbc.weighty = 1.0;
        mainPanel.add(Box.createGlue(), gbc);
        frame.add(mainPanel);
        frame.setLocation(300, 200);
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
