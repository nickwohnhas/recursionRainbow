package rainbowRecursion;
import javax.swing.*;
 /* rainbowRecursion uses a recursive algorithm
 to create fractal geometry using circles.
  Each time the circle is split in two
 and each of those circles is split in two.
 The color of circles alternates between rainbow colors
The code executes 10 times.
 Created by Nick Wohnhas on 3/14/21
 */

public class rainbowRecursion {
    public static void main(String[] args) {
        // set frame size and location
        JFrame frame = new JFrame();
        frame.setSize(800, 800);
        frame.setLocation(200, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // initialize starting circle values.
        int x = 200;
        int y = 200;
        int width = 400;
        int height = 400;
        // create our circle
        Circle circle = new Circle(x, y, width, height);
        // add the recursively drawn circles to the content pane
        frame.getContentPane().add(circle);
        frame.setVisible(true);
    } // end main()
} // end rainbowRecursion



