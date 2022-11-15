import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class ProjectGUI extends JFrame {
    static JFrame frame = new JFrame(); // creates frame
    static JButton[][] grid; // names the grid of buttons

    static int Width;
    static int Height;
    static Random random = new Random();

    String eaglespop;
    String giantspop;
    String cowboyspop;
    String commandpop;

    int eaglesint;
    int giantsint;
    int cowboysint;
    int commandint;

    static int empty;

    public static void emptySpotList() {

        for (int width = 0; width < Width; width++) {
            for (int height = 0; height < Height; height++) {
                if (grid[width][height].getBackground() == null) {

                }
            }
        }
    }

    public Component checkNeighbors(int width, int height) {

        int friends = 0;
        int enemies = 0;

        if (grid[width+1][height].getBackground() != null) {
            if (grid[width][height].getBackground() == grid[width+1][height].getBackground()) {
                friends++;
            } else enemies++;
        }

        if (grid[width+1][height-1].getBackground() != null) {
            if (grid[width][height].getBackground() == grid[width+1][height-1].getBackground()) {
                friends++;
            } else enemies++;
        }

        if (grid[width][height-1].getBackground() != null) {
            if (grid[width][height].getBackground() == grid[width][height-1].getBackground()) {
                friends++;
            } else enemies++;
        }

        if (grid[width-1][height-1].getBackground() != null) {
            if (grid[width][height].getBackground() == grid[width-1][height-1].getBackground()) {
                friends++;
            } else enemies++;
        }

        if (grid[width-1][height].getBackground() != null) {
            if (grid[width][height].getBackground() == grid[width-1][height].getBackground()) {
                friends++;
            } else enemies++;
        }

        if (grid[width-1][height+1].getBackground() != null) {
            if (grid[width][height].getBackground() == grid[width-1][height+1].getBackground()) {
                friends++;
            } else enemies++;
        }

        if (grid[width][height+1].getBackground() != null) {
            if (grid[width][height].getBackground() == grid[width][height+1].getBackground()) {
                friends++;
            } else enemies++;
        }

        if (grid[width+1][height+1].getBackground() != null) {
            if (grid[width][height].getBackground() == grid[width+1][height+1].getBackground()) {
                friends++;
            } else enemies++;
        }


        System.out.println("Friends: " + friends + "\n" +
                "Enemies: " + enemies);

        return null;
    }

    public Component Grid(int width, int height) { // constructor
        frame.setLayout(new GridLayout(width, height)); // set layout
        frame.setBounds(350, 250, 250, 500);
        grid = new JButton[width][height]; // allocate the size of grid
        int rand;
        for (int y = 0; y < height; y++) {
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
    private JCheckBox universaltoleranceCheckBox;
    private JLabel universaltoleranceLabel;
    private JLabel eaglestoleranceLabel;
    private JLabel cowboystoleranceLabel;
    private JLabel giantstoleranceLabel;
    private JLabel commandtoleranceLabel;
    private JCheckBox individualCheckbox;
    private JSlider universaltoleranceSlider;
    private JSlider eaglestoleranceSlider;
    private JSlider cowboystoleranceSlider;
    private JSlider commanderstoleranceSlider;
    private JSlider giantstoleranceSlider;
    private JLabel universalvalueLabel;
    private JLabel eaglestolerancevalueLabel;
    private JLabel giantstolerancevalueLabel;
    private JLabel cowboystolerancevalueLabel;
    private JLabel commandtolerancevalueLabel;


    public ProjectGUI(String title) {
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

        universaltoleranceSlider.setVisible(false);
        universaltoleranceLabel.setVisible(false);
        universalvalueLabel.setVisible(false);

        cowboystoleranceSlider.setVisible(false);
        cowboystoleranceLabel.setVisible(false);
        cowboystolerancevalueLabel.setVisible(false);

        commanderstoleranceSlider.setVisible(false);
        commandtoleranceLabel.setVisible(false);
        commandtolerancevalueLabel.setVisible(false);



        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eaglespop = eaglesTextField.getText().trim();
                giantspop = giantsTextField.getText().trim();
                cowboyspop = cowboysTextField.getText().trim();
                commandpop = commandersTextField.getText().trim();
                String width = widthInput.getText().trim();
                String height = heightInput.getText().trim();

                eaglesint = Integer.parseInt(eaglespop);
                giantsint = Integer.parseInt(giantspop);
                cowboysint = Integer.parseInt(cowboyspop);
                commandint = Integer.parseInt(commandpop);
                int widthint = Integer.parseInt(width);
                int heightint = Integer.parseInt(height);

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
                if (widthint < 1 || widthint > 100){
                    widthresultsLabel.setText("Please enter a number between 1 and 100");
                    widthresultsLabel.setVisible(true);
                }
                else {
                    widthresultsLabel.setText("Width input is: " + width);
                    widthresultsLabel.setVisible(true);
                }
                //height
                if (heightint < 1 || heightint > 100){
                    heightsresultsLabel.setText("Please enter a number between 1 and 100");
                    heightsresultsLabel.setVisible(true);
                }
                else {
                    heightsresultsLabel.setText("Height input is: " + height);
                    heightsresultsLabel.setVisible(true);
                }
                // grid
                try {
                    Width = Integer.parseInt(width);
                    Height = Integer.parseInt(height);
                    //Creates Grid
                    Grid(Width, Height);
                } catch (Exception E) {
                    System.out.println("Got an exception");
                }

                int eaglesPopulation = 0;
                int giantsPopulation = 0;
                int cowboysPopulation = 0;
                int commandersPopulation = 0;

                double eaglePercent = 0;
                double giantPercent = 0;
                double cowboysPercent = 0;
                double commandersPercent = 0;

                for (int h = 0; h < Height; h++) {
                    for (int w = 0; w < Width; w++) {
                        if(grid[w][h].getBackground() == Color.green) {
                            eaglesPopulation++;
                        } else if (grid[w][h].getBackground() == Color.black) {
                            giantsPopulation++;
                        } else if (grid[w][h].getBackground() == Color.red) {
                            cowboysPopulation++;
                        } else if (grid[w][h].getBackground() == Color.blue) {
                            commandersPopulation++;
                        }
                    }
                }

                int h = 10;
                int w = 10;

                int colorOne = 0;
                int colorTwo = 0;

                grid[w][h].setBackground(Color.GREEN);

                grid[11][10].setBackground(Color.GREEN);
                grid[11][9].setBackground(Color.BLACK);
                grid[10][9].setBackground(Color.BLACK);
                grid[9][9].setBackground(Color.BLACK);
                grid[9][10].setBackground(Color.GREEN);
                grid[9][11].setBackground(Color.BLACK);
                grid[10][11].setBackground(Color.BLACK);
                grid[11][11].setBackground(Color.GREEN);

                checkNeighbors(w, h);

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
                    cowboystoleranceSlider.setVisible(true);
                    cowboystoleranceLabel.setVisible(true);
                    cowboystolerancevalueLabel.setVisible(true);
                }
                else {
                    cowboysTextField.setVisible(false);
                    cowboysLabel.setVisible(false);
                    cowboysresultsLabel.setVisible(false);
                    cowboystoleranceSlider.setVisible(false);
                    cowboystoleranceLabel.setVisible(false);
                    cowboystolerancevalueLabel.setVisible(true);
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
                    commanderstoleranceSlider.setVisible(true);
                    commandtoleranceLabel.setVisible(true);
                    commandtolerancevalueLabel.setVisible(true);
                }
                else {
                    commandersTextField.setVisible(false);
                    commandersLabel.setVisible(false);
                    commandersresultsLabel.setVisible(false);
                    commanderstoleranceSlider.setVisible(false);
                    commandtoleranceLabel.setVisible(false);
                    commandtolerancevalueLabel.setVisible(false);
                }

            }
        });
        universaltoleranceCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (universaltoleranceCheckBox.isSelected()) {
                    universaltoleranceSlider.setVisible(true);
                    universaltoleranceLabel.setVisible(true);
                    universalvalueLabel.setVisible(true);
                    eaglestoleranceSlider.setEnabled(false);
                    giantstoleranceSlider.setEnabled(false);
                    cowboystoleranceSlider.setEnabled(false);
                    commanderstoleranceSlider.setEnabled(false);
                    individualCheckbox.setEnabled(false);
                    eaglestolerancevalueLabel.setVisible(false);
                    giantstolerancevalueLabel.setVisible(false);
                    commandtolerancevalueLabel.setVisible(false);
                    giantstolerancevalueLabel.setVisible(false);

                }
                else {
                    universaltoleranceSlider.setVisible(false);
                    universaltoleranceLabel.setVisible(false);
                    universalvalueLabel.setVisible(false);
                    eaglestoleranceSlider.setEnabled(true);
                    giantstoleranceSlider.setEnabled(true);
                    cowboystoleranceSlider.setEnabled(true);
                    commanderstoleranceSlider.setEnabled(true);
                    individualCheckbox.setEnabled(true);
                    eaglestolerancevalueLabel.setVisible(true);
                    giantstolerancevalueLabel.setVisible(true);
                    commandtolerancevalueLabel.setVisible(true);
                    giantstolerancevalueLabel.setVisible(true);
                }

            }
        });
        individualCheckbox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (individualCheckbox.isSelected()) {
                    eaglestoleranceSlider.setEnabled(false);
                    giantstoleranceSlider.setEnabled(false);
                    cowboystoleranceSlider.setEnabled(false);
                    commanderstoleranceSlider.setEnabled(false);
                    universaltoleranceCheckBox.setEnabled(false);
                    eaglestolerancevalueLabel.setVisible(false);
                    giantstolerancevalueLabel.setVisible(false);
                    commandtolerancevalueLabel.setVisible(false);
                    giantstolerancevalueLabel.setVisible(false);
                }
                else {
                    eaglestoleranceSlider.setEnabled(true);
                    giantstoleranceSlider.setEnabled(true);
                    cowboystoleranceSlider.setEnabled(true);
                    commanderstoleranceSlider.setEnabled(true);
                    universaltoleranceCheckBox.setEnabled(true);
                    eaglestolerancevalueLabel.setVisible(true);
                    giantstolerancevalueLabel.setVisible(true);
                    commandtolerancevalueLabel.setVisible(true);
                    giantstolerancevalueLabel.setVisible(true);
                }

            }
        });
        universaltoleranceSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int universalvalue = universaltoleranceSlider.getValue();
                universalvalueLabel.setText(String.valueOf(universalvalue) + " %");
            }
        });
        eaglestoleranceSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int eaglesvalue = eaglestoleranceSlider.getValue();
                eaglestolerancevalueLabel.setText(String.valueOf(eaglesvalue) + " %");
            }
        });
        giantstoleranceSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int giantsvalue = giantstoleranceSlider.getValue();
                giantstolerancevalueLabel.setText(String.valueOf(giantsvalue) + " %");
            }
        });
        cowboystoleranceSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int cowboysvalue = cowboystoleranceSlider.getValue();
                cowboystolerancevalueLabel.setText(String.valueOf(cowboysvalue) + " %");
            }
        });
        commanderstoleranceSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int commandvalue = commanderstoleranceSlider.getValue();
                commandtolerancevalueLabel.setText(String.valueOf(commandvalue) + " %");
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new ProjectGUI("Sprint 1");
        frame.setBounds(450, 250, 1000, 500);
        frame.setVisible(true);
    }
}