package shooterForm;

import matchForm.AutoSuggestor;

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
    public String keeper = "";

    public JFrame frame = new JFrame(shooterForm.class.getSimpleName());
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

        JLabel lblName = new JLabel("Shooter");
        lblName.setBounds(65, 31, 46, 14);
        frame.getContentPane().add(lblName);

        JLabel lblPhone = new JLabel("Time");
        lblPhone.setBounds(65, 68, 46, 14);
        frame.getContentPane().add(lblPhone);

        JLabel lblKeeperName = new JLabel("Keeper");
        lblKeeperName.setBounds(65, 100, 46, 14);
        frame.getContentPane().add(lblKeeperName);

        JButton btnClear = new JButton("Clear");

        btnClear.setBounds(312, 387, 89, 23);
        frame.getContentPane().add(btnClear);

        textField = new JTextField(20);

        textField.setBounds(128, 28, 86, 20);
        frame.getContentPane().add(textField);

        textField_1 = new JTextField(20);
        textField_1.setBounds(128, 65, 86, 20);
        frame.getContentPane().add(textField_1);

        textField_2 = new JTextField(20);
        textField_2.setBounds(128, 100, 86, 20);
        frame.getContentPane().add(textField_2);

        AutoSuggestor autoSuggestor = new AutoSuggestor(textField_2, frame, null, Color.WHITE.brighter(), Color.BLUE, Color.RED, 0.75f) {
            @Override
            public boolean wordTyped(String typedWord) {

                //create list for dictionary this in your case might be done via calling a method which queries db and returns results as arraylist
                ArrayList<String> words = new ArrayList<>();
                words.add("Hart");
                words.add("Lloris");
                words.add("Schmeichel");
                words.add("Forster");
                words.add("Pope");
                words.add("Degea");
                words.add("Romero");
                words.add("Leno");
                words.add("Ederson");
                words.add("Gomes");
                words.add("Everton");
                words.add("Fabianski");
                words.add("Begovic");
                words.add("Hennessey");
                words.add("Karnezis");
                words.add("Ryan");
                words.add("Adrian");
                words.add("Lossl");
                words.add("Foster");
                words.add("Pickford");
                words.add("Darlow");
                words.add("Cech");
                words.add("Ospina");
                words.add("Elliot");
                words.add("Mignolet");
                words.add("Jakupovic");
                words.add("McCarthy");
                words.add("Bravo");
                words.add("Mignolet");
                words.add("Dubravka");
                words.add("Speroni");
                words.add("Grant");
                words.add("Gazzaniga");
                words.add("Hamer");
                words.add("Fabri");
                words.add("Patrício");
                words.add("Etheridge");
                words.add("Kepa");


                setDictionary(words);
                //addToDictionary("bye");//adds a single word

                return super.wordTyped(typedWord);//now call super to check for any matches against newest dictionary
            }
        };

        JButton btnSubmit = new JButton("submit");

        btnSubmit.setBackground(Color.BLUE);
        btnSubmit.setForeground(Color.MAGENTA);
        btnSubmit.setBounds(65, 387, 89, 23);
        frame.getContentPane().add(btnSubmit);


        btnSubmit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                if(textField.getText().isEmpty()||(textField_1.getText().isEmpty()) || (textField_2.getText().isEmpty()))
                    JOptionPane.showMessageDialog(null, "Data Missing");
                else {
                    shooter = textField.getText();
                    int result = Integer.parseInt(textField_1.getText());
                    keeper = textField_2.getText();
                    shot_time = result;
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
