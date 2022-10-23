import java.awt.*;

import javax.swing.*;
import java.awt.Color;
import java.awt.GridLayout; //imports GridLayout library
import java.util.Random;
import java.awt.FlowLayout;


public class Main {
    static JFrame frame = new JFrame(); // creates frame
    static JButton[][] grid; // names the grid of buttons

    static Random random = new Random();

    public static Component Grid(int width, int length, int eagles, int giants) { // constructor
        frame.setLayout(new GridLayout(width, length)); // set layout
        grid = new JButton[width][length]; // allocate the size of grid
        int rand;
        for (int y = 0; y < length; y++) {
            for (int x = 0; x < width; x++) {
                grid[x][y] = new JButton(); // creates new button
                frame.add(grid[x][y]); // adds button to grid

                rand = random.nextInt(100);

                if ((0 < rand) && (rand < eagles)) {
                    grid[x][y].setBackground(Color.green);

                } else if ((eagles < rand) && (rand < eagles +giants)) {
                    grid[x][y].setBackground(Color.black);

                }
            }
        }
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack(); // sets appropriate size for frame
        frame.setVisible(true); // makes frame visible
        return null;
    }

    public static void main(String[] args) {
        //creates frame
        JFrame frame = new JFrame("Sprint 1");
        frame.setBounds(100, 100, 645, 470);
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        //creates label for width & text field and adds to panel
        JLabel widthLabel = new JLabel("Enter width for grid: ");
        JTextField widthField = new JTextField(10);
        panel.add(widthLabel);
        panel.add(widthField);

        //creates label for width & text field and adds to panel
        JLabel heightLabel = new JLabel("Enter height for grid: ");
        JTextField heightField = new JTextField(10);
        panel.add(heightLabel);
        panel.add(heightField);

        //creates population density for Eagles
        JLabel eagleDensityLabel = new JLabel("Enter density for eagles: ");
        JTextField eaglesField = new JTextField(10);
        panel.add(eagleDensityLabel);
        panel.add(eaglesField);

        //creates population density for Giants
        JLabel giantsDensityLabel = new JLabel("Enter density for giants: ");
        JTextField giantsField = new JTextField(10);
        panel.add(giantsDensityLabel);
        panel.add(giantsField);

        //creates stop button
        JButton stopButton = new JButton();
        stopButton.setText("Stop");
        stopButton.addActionListener(e -> frame.dispose());
        panel.add(stopButton);


        //creates submit button
        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(e -> {
            //gets text
            String width = widthField.getText();
            String height = heightField.getText();
            String eagleDensity = eaglesField.getText();
            String giantsDensity = giantsField.getText();

            //Converts width and height from string to int
            int Width;
            int Height;
            int Eagles;
            int Giants;
            try {
                Width = Integer.parseInt(width);
                Height = Integer.parseInt(height);
                Eagles = Integer.parseInt(eagleDensity);
                Giants = Integer.parseInt(giantsDensity);

                //Creates Grid
                Grid(Width, Height, Eagles, Giants);

                //Calculates population density for teams
                int green = 0;
                int black = 0;
                int blank = 0;

                for(int y = 0; y < Height; y++) {
                    for(int x = 0; x < Width; x++) {
                        if(grid[x][y].getBackground() == Color.black) {
                            black++;
                        } else if (grid[x][y].getBackground() == Color.green) {
                            green++;
                        } else {
                            blank++;
                        }
                    }
                }

                double blackPopulation = (double) black / (Height * Width) * 100;
                double greenPopulation = (double) green / (Height * Width) * 100;
                double blankPopulation = (double) blank / (Height * Width) * 100;

                //Prints out population
                System.out.println(blackPopulation + "\n" +
                        greenPopulation + "\n" +
                        blankPopulation + "\n\n\n");

                System.out.println("Black population: " + black + "\n"
                        + "Red population: " + green + "\n"
                        + "Blank population: " + blank + "\n");

            } catch (Exception E) {
                System.out.println("Got an exception");
            }

        });
        panel.add(submitButton);

        //adds a panel to the frame
        frame.add(panel);

        //displays frame
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
}
