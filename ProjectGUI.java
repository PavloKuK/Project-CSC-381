import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ProjectGUI extends JFrame {
public class ProjectGUI extends JFrame{
    static JFrame frame = new JFrame(); // creates frame
    static JButton[][] grid; // names the grid of buttons

    static Random random = new Random();

    public static Component Grid(int width, int length) { // constructor
        frame.setLayout(new GridLayout(width, length)); // set layout
        grid = new JButton[width][length]; // allocate the size of grid
        int rand;
        for (int y = 0; y < length; y++) {
            for (int x = 0; x < width; x++) {
                grid[x][y] = new JButton(); // creates new button
                frame.add(grid[x][y]); // adds button to grid

                rand = random.nextInt(4);

                switch (rand) {
                    case 0:
                        grid[x][y].setBackground(Color.black);
                        break;

                    case 1:
                        grid[x][y].setBackground(Color.red);
                        break;

                    case 2:
                        grid[x][y].setBackground(Color.gray);
                        break;
                    case 3:
                        grid[x][y].setBackground(Color.white);
                        break;
                }

            }

        }
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack(); // sets appropriate size for frame
        frame.setVisible(true); // makes frame visible
        return null;
    }
    private JPanel mainPanel;
    private JTextField eaglesTextField;
    private JTextField giantsTextField;
    private JLabel eaglesLabel;
    private JLabel giantsLabel;
    private JLabel eaglesresultsLabel;
    private JLabel giantsresultsLabel;
    private JButton submitButton;
    private JButton stopButton;
    private JTextField widthInput;
    private JTextField heightInput;
    private JLabel widthLabel;
    private JLabel heightLabel;

    public ProjectGUI(String title) {
        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
        
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String eaglespop = eaglesTextField.getText().trim();
                String giantspop = giantsTextField.getText().trim();
                String width = widthInput.getText().trim();
                String height = heightInput.getText().trim();

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
                int Width;
                int Height;
                try {
                    Width = Integer.parseInt(width);
                    Height = Integer.parseInt(height);
                    //Creates Grid
                    Grid(Width, Height);
                } catch (Exception E) {
                    System.out.println("Got an exception");
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
        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
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
         heightInput.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                char c = e.getKeyChar();
                if(Character.isLetter(c)){
                    heightInput.setEditable(false);
                    heightInput.setText("Please enter a number");
                } else {
                    heightInput.setEditable(true);
                }
            }
        });
        widthInput.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                char c = e.getKeyChar();
                if(Character.isLetter(c)){
                    widthInput.setEditable(false);
                    widthInput.setText("Please enter a width");
                }
                else {
                    widthInput.setEditable(true);
                }
            }
        });     
    }
}

    public static void main(String[] args) {
        JFrame frame = new ProjectGUI("Sprint 1");
        frame.setVisible(true);
    }
}
