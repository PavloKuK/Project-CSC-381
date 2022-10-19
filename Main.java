import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.Color;
import java.util.Random;

//public class Main {
//
//    public static void main(String[] args) {
//
//
//        JFrame jf = new JFrame("Example");
//        JPanel p = new JPanel();
//
//        jf.setLayout(new GridLayout(10, 10));
//
//        for(int i = 1; i <= 100; i++) {
//            jf.add(new JButton(""));
//        }
//
//        jf.setBackground(Color.black);
//
//        jf.setSize(400,400);
//        jf.setVisible(true);
//    }
//}

import javax.swing.JFrame; //imports JFrame library
import javax.swing.JButton; //imports JButton library
import java.awt.Color;
import java.awt.GridLayout; //imports GridLayout library

public class Main {

    JFrame frame = new JFrame(); // creates frame
    JButton[][] grid; // names the grid of buttons

    Random random = new Random();

    public Main(int width, int length) { // constructor
        frame.setLayout(new GridLayout(width, length)); // set layout
        grid = new JButton[width][length]; // allocate the size of grid
        int rand;
        for (int y = 0; y < length; y++) {
            for (int x = 0; x < width; x++) {
                grid[x][y] = new JButton(); // creates new button
                frame.add(grid[x][y]); // adds button to grid

                rand = random.nextInt(4);

                if(rand == 0) {
                    grid[x][y].setBackground(Color.black);
                } else if(rand == 1) {
                    grid[x][y].setBackground(Color.red);
                } else if(rand == 2) {
                    grid[x][y].setBackground(Color.gray);
                } else {
                    grid[x][y].setBackground(Color.white);
                }
            }

        }
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack(); // sets appropriate size for frame
        frame.setVisible(true); // makes frame visible
    }

    public static void main(String[] args) {
        new Main(50, 50);// makes new ButtonGrid with 2 parameters
    }
}
