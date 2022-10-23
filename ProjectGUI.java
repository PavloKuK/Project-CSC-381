import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class ProjectGUI extends JFrame {
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
        private JCheckBox cowboysCheckBox;
        private JCheckBox commandersCheckBox;
        private JTextField cowboysTextField;
        private JTextField commandersTextField;
        private JLabel cowboysresultsLabel;
        private JLabel commandersresultsLabel;
        private JLabel cowboysLabel;
        private JLabel commandersLabel;



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

            submitButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String eaglespop = eaglesTextField.getText().trim();
                    String giantspop = giantsTextField.getText().trim();
                    String cowboyspop = cowboysTextField.getText().trim();
                    String commandpop = commandersTextField.getText().trim();
                    String width = widthInput.getText().trim();
                    String height = heightInput.getText().trim();

                    int eaglesint = Integer.parseInt(eaglespop);
                    int giantsint = Integer.parseInt(giantspop);
                    int cowboysint = Integer.parseInt(cowboyspop);
                    int commandint = Integer.parseInt(commandpop);

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
                    if (cowboyspop.isEmpty()) {
                        System.out.println("Cowboys not selected");;
                    }
                    else {
                        cowboysresultsLabel.setText("Giants fans population density is: " + cowboyspop);
                    }
                    // commanders
                    if (commandint < 1 || commandint > 99) {
                        commandersresultsLabel.setText("Please enter a number between 1 and 99");
                    }
                    if (commandpop.isEmpty()) {
                        System.out.println("Commanders not selected");
                    }
                    else {
                        commandersresultsLabel.setText("Giants fans population density is: " + commandpop);
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
        JFrame frame = new ProjectGUI("Sprint 1");
        frame.setVisible(true);
    }
}
