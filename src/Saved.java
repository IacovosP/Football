import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.util.ArrayList;

public class Saved {

    public int saved = 0;
    public JFrame frame = new JFrame(ShotLocationMap.class.getSimpleName());

    protected void initUI() throws MalformedURLException {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel paintPanel = new JPanel();
        paintPanel.setOpaque(true);
        paintPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(0, 0, 0, 0);
        String buttonName = "MEDIUM";
        c.ipadx = 20;
        c.ipady = 20;
        c.fill = GridBagConstraints.NONE;


        for (int i = 0; i < 2; i++) {
            if (i == 0) {
                buttonName = "NO";
            } else if ( i ==1) {
                buttonName = "YES";
            }
            c.gridx = i;
            JButton button = new JButton(buttonName);
            button.setBorderPainted(true);
            button.setContentAreaFilled(false);
            button.setOpaque(false);
            int save = i;
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    System.out.println("something about xy" + save);
                    saved = save;
                    frame.dispose();
                }
            });
            paintPanel.add(button, c);
        }

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dim.width/3, dim.height/3);
        c.weighty = 1.0;
        paintPanel.add(Box.createGlue(), c);
        frame.add(paintPanel);
        frame.pack();
        frame.setVisible(true);

    }

    public void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new shotPower().initUI();
                } catch (MalformedURLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
    }
}
