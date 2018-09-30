package matchForm;

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

public class matchForm {
    public String home_team = "";
    public String away_team = "";
    public String date;

    public JFrame frame = new JFrame(matchForm.class.getSimpleName());
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;

    /**
     * Initialize the contents of the frame.
     */
    public void initUI() throws MalformedURLException {
        frame.setBounds(100, 100, 730, 489);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblName = new JLabel("Home Team");
        lblName.setBounds(65, 31, 46, 14);
        frame.getContentPane().add(lblName);

        JLabel lblPhone = new JLabel("Away Team");
        lblPhone.setBounds(65, 68, 46, 14);
        frame.getContentPane().add(lblPhone);

        JLabel lblEmailId = new JLabel("Date");
        lblEmailId.setBounds(65, 115, 46, 14);
        frame.getContentPane().add(lblEmailId);

        textField_2 = new datePicker();
        textField_2.setBounds(128, 112, 247, 17);
        frame.getContentPane().add(textField_2);
        textField_2.setColumns(10);

        JButton btnClear = new JButton("Clear");

        btnClear.setBounds(312, 387, 89, 23);
        frame.getContentPane().add(btnClear);

        textField = new JTextField(20);
        AutoSuggestor autoSuggestor = new AutoSuggestor(textField, frame, null, Color.WHITE.brighter(), Color.BLUE, Color.RED, 0.75f) {
            @Override
            public boolean wordTyped(String typedWord) {

                //create list for dictionary this in your case might be done via calling a method which queries db and returns results as arraylist
                ArrayList<String> words = new ArrayList<>();
                words.add("Liverpool");
                words.add("Man United");
                words.add("Man City");
                words.add("Burnley");
                words.add("Arsenal");
                words.add("Spurs");
                words.add("Chelsea");
                words.add("Fullham");
                words.add("Saints");
                words.add("Watford");
                words.add("Everton");
                words.add("Wolves");
                words.add("Palace");
                words.add("West Ham");
                words.add("Brighton");
                words.add("Bournemouth");
                words.add("Leicester");
                words.add("Huddersfield");
                words.add("Cardiff");
                words.add("Newcastle");


                setDictionary(words);
                //addToDictionary("bye");//adds a single word

                return super.wordTyped(typedWord);//now call super to check for any matches against newest dictionary
            }
        };

        textField.setBounds(128, 28, 86, 20);
        frame.getContentPane().add(textField);

        textField_1 = new JTextField(20);
        AutoSuggestor autoSuggestor2 = new AutoSuggestor(textField_1, frame, null, Color.WHITE.brighter(), Color.BLUE, Color.RED, 0.75f) {
            @Override
            public boolean wordTyped(String typedWord) {

                //create list for dictionary this in your case might be done via calling a method which queries db and returns results as arraylist
                ArrayList<String> words = new ArrayList<>();
                words.add("Liverpool");
                words.add("Man United");
                words.add("Man City");
                words.add("Burnley");
                words.add("Arsenal");
                words.add("Spurs");
                words.add("Chelsea");
                words.add("Fullham");
                words.add("Saints");
                words.add("Watford");
                words.add("Everton");
                words.add("Wolves");
                words.add("Palace");
                words.add("West Ham");
                words.add("Brighton");
                words.add("Bournemouth");
                words.add("Leicester");
                words.add("Huddersfield");
                words.add("Cardiff");
                words.add("Newcastle");


                setDictionary(words);
                //addToDictionary("bye");//adds a single word

                return super.wordTyped(typedWord);//now call super to check for any matches against newest dictionary
            }
        };
        textField_1.setBounds(128, 65, 86, 20);
        frame.getContentPane().add(textField_1);

        JButton btnSubmit = new JButton("submit");

        btnSubmit.setBackground(Color.BLUE);
        btnSubmit.setForeground(Color.MAGENTA);
        btnSubmit.setBounds(65, 387, 89, 23);
        frame.getContentPane().add(btnSubmit);


        btnSubmit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                if(textField.getText().isEmpty()||(textField_1.getText().isEmpty())||(textField_2.getText().isEmpty())||(textField_2.getText().isEmpty()))
                    JOptionPane.showMessageDialog(null, "Data Missing");
                else {
                    home_team = textField.getText();
                    away_team = textField_1.getText();
                    date = textField_2.getText();
                    frame.dispose();
                }
            }
        });

        btnClear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textField_1.setText(null);
                textField_2.setText(null);
                textField.setText(null);
            }
        });

    }
}
