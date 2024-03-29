import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;
import java.util.Objects;
import java.util.ArrayList;
import java.util.List;

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
    
    //Morgan - 10c. created a global variable that the entirety of ProjectGUI.java could call to
    //int toleranceBound = 100;

    static int UniversaltoleranceSlider;
    static int EaglestoleranceSlider;
    static int CowboystoleranceSlider;
    static int CommanderstoleranceSlider;
    static int GiantstoleranceSlider;

    static List<JButton> emptyList = new ArrayList<>();
    static List<Boolean> tolerance = new ArrayList<>();

    static int clicks = 0;

    public static void emptySpotList() {

        for (int width = 0; width < Width; width++) {
            for (int height = 0; height < Height; height++) {
                if (Objects.equals(grid[width][height].getBackground(), new Color(238, 238, 238))) {
                    emptyList.add(grid[width][height]);
                }
            }
        }
        System.out.println("Number of empty spots is " + emptyList.size());
    }

    public static boolean indexExist(int w, int h) {

        boolean flag;

        try {
            grid[w][h].getBackground();
            flag = true;
        } catch (ArrayIndexOutOfBoundsException e) {
            flag = false;
        }

        return flag;
    }

    public static void moveToRandomSpot(int w, int h) {
        Random random1 = new Random();

        int rand = random1.nextInt(emptyList.size());
        JButton g = emptyList.get(rand);

        g.setBackground(grid[w][h].getBackground());
        grid[w][h].setBackground(null);

        emptyList.remove(rand);
        emptyList.add(grid[w][h]);
    }

    public double checkNeighbors(int width, int height) {

        double friends = 0;
        double enemies = 0;
        double empty = 0;
        double enemiesPercentage;

        if (indexExist(width+1, height)) {
            if (grid[width][height].getBackground() == grid[width+1][height].getBackground()) {
                friends++;
            } else if (!Objects.equals(grid[width+1][height].getBackground(), new Color(238, 238, 238))) {
                enemies++;
            } else {
                empty++;
            }
        }

        if (indexExist(width+1, height-1)) {
            if (grid[width][height].getBackground() == grid[width+1][height-1].getBackground()) {
                friends++;
            } else if (!Objects.equals(grid[width+1][height-1].getBackground(), new Color(238, 238, 238))) {
                enemies++;
            } else {
                empty++;
            }
        }

        if (indexExist(width, height-1)) {
            if (grid[width][height].getBackground() == grid[width][height-1].getBackground()) {
                friends++;
            } else if (!Objects.equals(grid[width][height-1].getBackground(), new Color(238, 238, 238))) {
                enemies++;
            } else {
                empty++;
            }
        }

        if (indexExist(width-1, height-1)) {
            if (grid[width][height].getBackground() == grid[width-1][height-1].getBackground()) {
                friends++;
            } else if (!Objects.equals(grid[width-1][height-1].getBackground(), new Color(238, 238, 238))) {
                enemies++;
            } else {
                empty++;
            }
        }

        if (indexExist(width-1, height)) {
            if (grid[width][height].getBackground() == grid[width-1][height].getBackground()) {
                friends++;
            } else if (!Objects.equals(grid[width-1][height].getBackground(), new Color(238, 238, 238))) {
                enemies++;
            } else {
                empty++;
            }
        }

        if (indexExist(width-1, height+1)) {
            if (grid[width][height].getBackground() == grid[width-1][height+1].getBackground()) {
                friends++;
            } else if (!Objects.equals(grid[width-1][height+1].getBackground(), new Color(238, 238, 238))) {
                enemies++;
            } else {
                empty++;
            }
        }

        if (indexExist(width, height+1)) {
            if (grid[width][height].getBackground() == grid[width][height+1].getBackground()) {
                friends++;
            } else if (!Objects.equals(grid[width][height+1].getBackground(), new Color(238, 238, 238))) {
                enemies++;
            } else {
                empty++;
            }
        }

        if (indexExist(width+1, height+1)) {
            if (grid[width][height].getBackground() == grid[width+1][height+1].getBackground()) {
                friends++;
            } else if (!Objects.equals(grid[width+1][height+1].getBackground(), new Color(238, 238, 238))) {
                enemies++;
            } else {
                empty++;
            }
        }


        System.out.println("Friends: " + friends + "\n" +
                "Enemies: " + enemies + "\n" +
                "Empty: " + empty);


        enemiesPercentage = 100 / (enemies + friends) * enemies;

        System.out.println(enemiesPercentage);

        return enemiesPercentage;
    }
    
//Morgan - for 10c, I thought I could try and place teams in certain quadrants of the sprint, but struggled with logic behind it, and realized it is not a good way to go about completing it.
/*    public Component newGrid (int width, int height){
        frame.setLayout(new GridLayout(width, height)); // set layout
        frame.setBounds(350, 250, 250, 500);
        grid = new JButton[width][height]; // allocate the size of grid
        int rand;

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                grid[x][y] = new JButton(); // creates new button
                frame.add(grid[x][y]); // adds button to grid

                rand = random.nextInt(toleranceBound);

                int e;
                int g;
                int c;
                int co;
                int he;
                int gh;
                int ch;
                int coh;

                e = width / 4;
                g = width / 4;
                c = width / 4;
                co = width / 4;

                coh = height / 4;
                gh = height / 4;
                he = height / 4;
                ch = height / 4;


                if ((0 < rand) && (rand < eaglesint)) {
                    grid[e][he].setBackground(Color.green);

                } else if ((eaglesint < rand) && (rand < eaglesint + giantsint)) {
                    grid[g][gh].setBackground(Color.black);

                } else if ((eaglesint < rand) && (rand < eaglesint + giantsint + cowboysint)) {
                    grid[c][coh].setBackground(Color.red);

                } else if ((eaglesint < rand) && (rand < eaglesint + giantsint + cowboysint + commandint)) {
                    grid[co][ch].setBackground(Color.blue);
                }

            }

        }
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack(); // sets appropriate size for frame
        frame.setVisible(true); // makes frame visible
        return null;
    }*/

    public Component Grid(int width, int height) { // constructor
        frame.setLayout(new GridLayout(width, height)); // set layout
        frame.setBounds(350, 250, 250, 500);
        grid = new JButton[width][height]; // allocate the size of grid
        int rand;
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                grid[x][y] = new JButton(); // creates new button
                frame.add(grid[x][y]); // adds button to grid
                
                //Morgan - tried to make the tolerance level affect randomization, but realized it wouldn't work for 10c
                //rand = random.nextInt(toleranceBound);

                rand = random.nextInt(100);

                if ((0 < rand) && (rand <= eaglesint)) {
                    grid[x][y].setBackground(Color.green);

                } else if ((eaglesint <= rand) && (rand < eaglesint + giantsint)) {
                    grid[x][y].setBackground(Color.black);

                } else if ((eaglesint <= rand) && (rand < eaglesint + giantsint + cowboysint)) {
                    grid[x][y].setBackground(Color.red);

                } else if ((eaglesint <= rand) && (rand < eaglesint + giantsint + cowboysint + commandint)) {
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
    private JButton pauseButton;
    private JButton resetButton;
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

    //creates timer for submit button
    Timer timer = new Timer(0, submitButton.getAction());


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
                clicks++;
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

                UniversaltoleranceSlider = universaltoleranceSlider.getValue();
                EaglestoleranceSlider = eaglestoleranceSlider.getValue();
                CowboystoleranceSlider = cowboystoleranceSlider.getValue();
                CommanderstoleranceSlider = commanderstoleranceSlider.getValue();
                GiantstoleranceSlider = giantstoleranceSlider.getValue();

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

                    if(clicks > 1) {
                        return;
                    } else {
                        Grid(Width, Height);
                    }
                } catch (Exception E) {
                    System.out.println("Got an exception");
                }

                boolean universalChecked = universaltoleranceCheckBox.isSelected();

                if (clicks > 2) {
                    for(int i = 0; i < Width; i++) {
                        for(int j = 0; j < Height; j++) {
                            if (!Objects.equals(grid[i][j].getBackground(), new Color(238, 238, 238))) {

                            }
                        }
                    }
                }

                
                //Morgan - checks which tolerance checkbox was checked off and then proceed from there, but wasn't able to figure out how to handle the tolerance levels - 10c
/*                if (universaltoleranceCheckBox.isSelected()){
                    checkNeighbors(Width, Height);
                    toleranceBound = universalTolerance;
                }
                if (individualCheckbox.isSelected()){
                    checkNeighbors(Width, Height);
                    eaglesTolerance;
                    giantsTolerance;
                    commandTolerance;
                    cowboysTolerance
                }*/


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
                    eaglestoleranceSlider.setEnabled(false);
                    giantstoleranceSlider.setEnabled(false);
                    cowboystoleranceSlider.setEnabled(false);
                    commanderstoleranceSlider.setEnabled(false);
                    individualCheckbox.setEnabled(false);
                    eaglestolerancevalueLabel.setVisible(false);
                    giantstolerancevalueLabel.setVisible(false);
                    commandtolerancevalueLabel.setVisible(false);
                    giantstolerancevalueLabel.setVisible(false);
                    universalvalueLabel.setVisible(true);

                }
                else {
                    universaltoleranceSlider.setVisible(false);
                    universaltoleranceLabel.setVisible(false);
                    eaglestoleranceSlider.setEnabled(true);
                    giantstoleranceSlider.setEnabled(true);
                    cowboystoleranceSlider.setEnabled(true);
                    commanderstoleranceSlider.setEnabled(true);
                    individualCheckbox.setEnabled(true);
                    eaglestolerancevalueLabel.setVisible(true);
                    giantstolerancevalueLabel.setVisible(true);
                    commandtolerancevalueLabel.setVisible(true);
                    giantstolerancevalueLabel.setVisible(true);
                    universalvalueLabel.setVisible(false);
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
    resetButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            eaglesTextField.setText("");
            eaglesresultsLabel.setText("");
            eaglesresultsLabel.setVisible(false);

            giantsTextField.setText("");
            giantsresultsLabel.setText("");
            giantsresultsLabel.setVisible(false);

            commandersTextField.setText("");
            commandersresultsLabel.setText("");
            commandersresultsLabel.setText("");

            cowboysTextField.setText("");
            cowboysresultsLabel.setText("");
            cowboysresultsLabel.setVisible(false);

            widthInput.setText("");
            widthresultsLabel.setText("");
            widthresultsLabel.setVisible(false);

            heightInput.setText("");
            heightsresultsLabel.setText("");
            heightsresultsLabel.setVisible(false);

            cowboysCheckBox.setSelected(false);
            commandersCheckBox.setSelected(false);

            commandtoleranceLabel.setVisible(false);
            commandtolerancevalueLabel.setText("");
            commanderstoleranceSlider.setValue(50);

            cowboystoleranceSlider.setValue(50);
            cowboystolerancevalueLabel.setText("");
            commandtolerancevalueLabel.setVisible(false);

            eaglestolerancevalueLabel.setText("");
            eaglestoleranceSlider.setValue(50);
            eaglestolerancevalueLabel.setVisible(false);

            giantstoleranceSlider.setValue(50);
            giantstolerancevalueLabel.setText("");
            giantstolerancevalueLabel.setVisible(false);

            universaltoleranceLabel.setVisible(false);
            universaltoleranceSlider.setValue(50);


            universaltoleranceCheckBox.setSelected(false);
            individualCheckbox.setSelected(false);

            //restarts timer
            timer.restart();
        }
    });
           pauseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //stops timer
                timer.stop();
            }
        });
  }
    public static void main(String[] args) {
        JFrame frame = new ProjectGUI("Sprint 1");
        frame.setBounds(350, 250, 1300, 500);
        frame.setVisible(true);
    }
}
