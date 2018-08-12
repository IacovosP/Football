package shooterForm;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.net.MalformedURLException;
import java.util.ArrayList;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class shooterForm {
    public String shooter = "";
    public int shot_time;

    public JFrame frame = new JFrame(shooterForm.class.getSimpleName());
    private JTextField textField;
    private JTextField textField_1;

    /**
     * Initialize the contents of the frame.
     */
    public void initUI() throws MalformedURLException {
        frame.setBounds(100, 100, 730, 489);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblName = new JLabel("Shooter");
        lblName.setBounds(65, 31, 46, 14);
        frame.getContentPane().add(lblName);

        JLabel lblPhone = new JLabel("Time");
        lblPhone.setBounds(65, 68, 46, 14);
        frame.getContentPane().add(lblPhone);

        JButton btnClear = new JButton("Clear");

        btnClear.setBounds(312, 387, 89, 23);
        frame.getContentPane().add(btnClear);

        textField = new JTextField(20);

        textField.setBounds(128, 28, 86, 20);
        frame.getContentPane().add(textField);

        textField_1 = new JTextField(20);
        textField_1.setBounds(128, 65, 86, 20);
        frame.getContentPane().add(textField_1);

        JButton btnSubmit = new JButton("submit");

        btnSubmit.setBackground(Color.BLUE);
        btnSubmit.setForeground(Color.MAGENTA);
        btnSubmit.setBounds(65, 387, 89, 23);
        frame.getContentPane().add(btnSubmit);


        btnSubmit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                if(textField.getText().isEmpty()||(textField_1.getText().isEmpty()))
                    JOptionPane.showMessageDialog(null, "Data Missing");
                else {
                    shooter = textField.getText();
                    int result = Integer.parseInt(textField_1.getText());
                    shot_time = result;
                    frame.dispose();
                }
            }
        });

        btnClear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textField_1.setText(null);
                textField.setText(null);
            }
        });

    }
}
