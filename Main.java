import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.Color;
import java.util.Random;
import javax.swing.JFrame; //imports JFrame library
import javax.swing.JButton; //imports JButton library
import java.awt.Color;
import java.awt.GridLayout; //imports GridLayout library

public class Main {

    static JFrame frame = new JFrame(); // creates frame
    static JButton[][] grid; // names the grid of buttons

    static Random random = new Random();

    public static void Grid(int width, int length) { // constructor
        frame.setLayout(new GridLayout(width, length)); // set layout
        grid = new JButton[width][length]; // allocate the size of grid
        int rand;
        for (int y = 0; y < length; y++) {
            for (int x = 0; x < width; x++) {
                grid[x][y] = new JButton(); // creates new button
                frame.add(grid[x][y]); // adds button to grid

                rand = random.nextInt(4);

                switch (rand) {
                    case 0 -> grid[x][y].setBackground(Color.black);
                    case 1 -> grid[x][y].setBackground(Color.red);
                    case 2 -> grid[x][y].setBackground(Color.gray);
                    case 3 -> grid[x][y].setBackground(Color.white);
                }
            }

        }
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack(); // sets appropriate size for frame
        frame.setVisible(true); // makes frame visible
    }

    public static void main(String[] args) {

        Grid(50, 50);
        
        int black = 0;
        int red = 0;
        int gray = 0;
        int white = 0;

        for(int i = 0; i < 50; i++) {
            for(int j = 0; j < 50; j++) {
                if(grid[j][i].getBackground() == Color.black) {
                    black++;
                } else if (grid[j][i].getBackground() == Color.red) {
                    red++;
                } else if (grid[j][i].getBackground() == Color.gray) {
                    gray++;
                } else if (grid[j][i].getBackground() == Color.white) {
                    white++;
                }
            }
        }

        System.out.println(black + "\n" + red + "\n" + gray + "\n" + white);

    }
}

//import javax.swing.JFrame; //imports JFrame library
//import javax.swing.JButton; //imports JButton library
//import java.awt.Color;
//import java.awt.GridLayout; //imports GridLayout library

//public class Main {
//
//    public static void main(String[] args) {
//        new Grid(50, 50);// makes new ButtonGrid with 2 parameters
//    }
//
//    public static class Grid {
//        JFrame frame = new JFrame(); // creates frame
//        JButton[][] grid; // names the grid of buttons
//
//        Random random = new Random();
//
//        public Grid(int width, int length) { // constructor
//            frame.setLayout(new GridLayout(width, length)); // set layout
//            grid = new JButton[width][length]; // allocate the size of grid
//            int rand;
//            for (int y = 0; y < length; y++) {
//                for (int x = 0; x < width; x++) {
//                    grid[x][y] = new JButton(); // creates new button
//                    frame.add(grid[x][y]); // adds button to grid
//
//                    rand = random.nextInt(4);
//
//                    switch (rand) {
//                        case 0 -> grid[x][y].setBackground(Color.black);
//                        case 1 -> grid[x][y].setBackground(Color.red);
//                        case 2 -> grid[x][y].setBackground(Color.gray);
//                        case 3 -> grid[x][y].setBackground(Color.white);
//                    }
//                }
//
//            }
//            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//            frame.pack(); // sets appropriate size for frame
//            frame.setVisible(true); // makes frame visible
//        }
//    }
//}
