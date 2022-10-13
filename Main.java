import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setBounds(30, 30, 450, 450);
        window.getContentPane().add(new MyCanvas());
        window.setVisible(true);;
    }
}

class MyCanvas extends JComponent {
    public void paint(Graphics g) {

        int rows = 50;

        int cols = 50;
        int width = getSize().width;
        int height = getSize().height;

        // draw the rows
        int rowHt = height / (rows);
        for (int i = 0; i < rows; i++)
            g.drawLine(0, i * rowHt, width, i * rowHt);

        // draw the columns
        int rowWid = width / (cols);
        for (int i = 0; i < cols; i++)
            g.drawLine(i * rowWid, 0, i * rowWid, height);

    }
}