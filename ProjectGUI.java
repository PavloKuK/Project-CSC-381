import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ProjectGUI extends JFrame {
    private JPanel mainPanel;
    private JTextField eaglesTextField;
    private JTextField giantsTextField;
    private JLabel eaglesLabel;
    private JLabel giantsLabel;
    private JLabel eaglesresultsLabel;
    private JLabel giantsresultsLabel;
    private JButton confirmButton;

    public ProjectGUI(String title) {
        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String eaglespop = eaglesTextField.getText().trim();
                String giantspop = giantsTextField.getText().trim();

                int eaglesint = Integer.parseInt(eaglespop);
                int giantsint = Integer.parseInt(giantspop);

                if (eaglesint < 1 || eaglesint > 99) {
                    eaglesresultsLabel.setText("Please enter a number between 1 and 99");
                }
                else {
                    eaglesresultsLabel.setText("Eagles fans population density is: " + eaglespop);
                }
                if (giantsint < 1 || giantsint > 99) {
                    giantsresultsLabel.setText("Please enter a number between 1 and 99");
                }
                else {
                    giantsresultsLabel.setText("Giants fans population density is: " + giantspop);
                }


            }
        });
        eaglesTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                char c = e.getKeyChar();
                if(Character.isLetter(c)){
                    eaglesTextField.setEditable(false);
                    eaglesresultsLabel.setText("Please enter a number");
                } else {
                    eaglesTextField.setEditable(true);
                }
            }
        });
        giantsTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                char c = e.getKeyChar();
                if(Character.isLetter(c)){
                    giantsTextField.setEditable(false);
                    giantsresultsLabel.setText("Please enter a number");
                } else {
                    giantsTextField.setEditable(true);
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new ProjectGUI("Population Density");
        frame.setVisible(true);
    }
}
