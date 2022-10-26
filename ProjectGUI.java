import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class Main extends JFrame {
    static JFrame frame = new JFrame(); // creates frame
    static JButton[][] grid; // names the grid of buttons

    static Random random = new Random();

    String eaglespop;
    String giantspop;
    String cowboyspop;
    String commandpop;

    int eaglesint = 0;
    int giantsint = 0;
    int cowboysint = 0;
    int commandint = 0;

    public void Grid(int width, int length) { // constructor
        frame.setLayout(new GridLayout(width, length)); // set layout
        grid = new JButton[width][length]; // allocate the size of grid
        int rand;
        for (int y = 0; y < length; y++) {
            for (int x = 0; x < width; x++) {
                grid[x][y] = new JButton(); // creates new button
                frame.add(grid[x][y]); // adds button to grid

                rand = random.nextInt(100);

                if ((0 < rand) && (rand < eaglesint)) {
                    grid[x][y].setBackground(Color.green);

                } else if ((eaglesint < rand) && (rand < eaglesint + giantsint)) {
                    grid[x][y].setBackground(Color.black);

                } else if ((eaglesint < rand) && (rand < eaglesint + giantsint + cowboysint)) {
                    grid[x][y].setBackground(Color.red);

                } else if ((eaglesint < rand) && (rand < eaglesint + giantsint + cowboysint + commandint)) {
                    grid[x][y].setBackground(Color.blue);
                }

            }

        }
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack(); // sets appropriate size for frame
        frame.setVisible(true); // makes frame visible
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
    private JCheckBox cowboysCheckBox;
    private JCheckBox commandersCheckBox;
    private JTextField cowboysTextField;
    private JTextField commandersTextField;
    private JLabel cowboysresultsLabel;
    private JLabel commandersresultsLabel;
    private JLabel cowboysLabel;
    private JLabel commandersLabel;
    private JLabel heightsresultsLabel;
    private JLabel widthresultsLabel;


    public Main(String title) {
        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();

        cowboysTextField.setVisible(false);
        cowboysLabel.setVisible(false);
        cowboysresultsLabel.setVisible(false);

        commandersTextField.setVisible(false);
        commandersLabel.setVisible(false);
        commandersresultsLabel.setVisible(false);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String width = widthInput.getText().trim();
                String height = heightInput.getText().trim();

                eaglespop = eaglesTextField.getText().trim();
                giantspop = giantsTextField.getText().trim();
                cowboyspop = cowboysTextField.getText().trim();
                commandpop = commandersTextField.getText().trim();

                eaglesint = Integer.parseInt(eaglespop);
                giantsint = Integer.parseInt(giantspop);
                cowboysint = Integer.parseInt(cowboyspop);
                commandint = Integer.parseInt(commandpop);

                int widthInt = Integer.parseInt(width);
                int heightInt = Integer.parseInt(height);

                // eagles
                if (eaglesint < 1 || eaglesint > 99) {
                    eaglesresultsLabel.setText("Please enter a number between 1 and 99");
                }
                else {
                    eaglesresultsLabel.setText("Eagles fans population density is: " + eaglespop);
                }
                // giants
                if (giantsint < 1 || giantsint > 99) {
                    giantsresultsLabel.setText("Please enter a number between 1 and 99");
                }
                else {
                    giantsresultsLabel.setText("Giants fans population density is: " + giantspop);
                }
                // cowboys
                if (cowboysint < 1 || cowboysint > 99) {
                    cowboysresultsLabel.setText("Please enter a number between 1 and 99");
                }
                else {
                    cowboysresultsLabel.setText("Cowboys fans population density is: " + cowboyspop);
                }
                // commanders
                if (commandint < 1 || commandint > 99) {
                    commandersresultsLabel.setText("Please enter a number between 1 and 99");
                }
                else {
                    commandersresultsLabel.setText("Commanders fans population density is: " + commandpop);
                }
                //width
                if (widthInt < 1 || widthInt > 100){
                    widthresultsLabel.setText("Please enter a number between 1 and 100");
                    widthresultsLabel.setVisible(true);
                }
                else {
                    widthresultsLabel.setText("Width input is: " + width);
                    widthresultsLabel.setVisible(true);
                }
                //height
                if (heightInt < 1 || heightInt > 100){
                    heightsresultsLabel.setText("Please enter a number between 1 and 100");
                    heightsresultsLabel.setVisible(true);
                }
                else {
                    heightsresultsLabel.setText("Height input is: " + height);
                    heightsresultsLabel.setVisible(true);
                }
                // grid
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
        cowboysTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                char c = e.getKeyChar();
                if(Character.isLetter(c)){
                    cowboysTextField.setEditable(false);
                    cowboysresultsLabel.setText("Please enter a number");
                } else {
                    cowboysTextField.setEditable(true);
                }
            }
        });
        commandersTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                char c = e.getKeyChar();
                if(Character.isLetter(c)){
                    commandersTextField.setEditable(false);
                    commandersresultsLabel.setText("Please enter a number");
                } else {
                    commandersTextField.setEditable(true);
                }
            }
        });
        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
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
        cowboysCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (cowboysCheckBox.isSelected()) {
                    cowboysTextField.setVisible(true);
                    cowboysLabel.setVisible(true);
                    cowboysresultsLabel.setVisible(true);
                }
                else {
                    cowboysTextField.setVisible(false);
                    cowboysLabel.setVisible(false);
                    cowboysresultsLabel.setVisible(false);
                }
            }


        });
        commandersCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (commandersCheckBox.isSelected()) {
                    commandersTextField.setVisible(true);
                    commandersLabel.setVisible(true);
                    commandersresultsLabel.setVisible(true);
                }
                else {
                    commandersTextField.setVisible(false);
                    commandersLabel.setVisible(false);
                    commandersresultsLabel.setVisible(false);
                }

            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new Main("Sprint 1");
        frame.setVisible(true);
    }
}
