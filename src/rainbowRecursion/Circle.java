package rainbowRecursion;
import java.awt.*;
/*
The circle class accepts x and y coordinates
along with width and height (they are the same)
 The class inherits from Canvas and
 recursively paints itself
 splitting into 2 new circles each time.
*/
public class Circle extends Canvas {
    // create rainbow effect by alternating through colors
    String[] colors = {"red", "orange", "yellow", "green", "blue", "indigo", "violet"};
    int x;
    int y;
    int width;
    int height;

    // initialize position and size of first circle
    Circle(int x, int y, int width,  int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    // draw the circle, then split it in 2 and paint again
    public void paint(Graphics graphics) {
        graphics.setColor(Color.red);
        graphics.drawOval(x, y, width, height);
        int currentColorIndex = 0;
        splitCircle(1, x, y, width, height, graphics, currentColorIndex);
    } // end paint()

    // split the circle in half and paint 2 new circles
    public void splitCircle(int count, int x, int y, int width, int height, Graphics graphics, int colorIndex) {
        if (colorIndex == 7) {
            // reset color index so we don't go out of bounds
            colorIndex = 0;
        }
        // the base case is 10
        // once we've hit it we exit the algorithm
        if (count < 10) {
            count += 1;
            // split in half
            int newWidth = width / 2;
            // left x is x - w/2
            int leftX = x - (newWidth / 2);
            // right x is x + (w + w/2)
            int rightX = x + (newWidth + newWidth / 2);
            // y is y + w/2
            int newY = y + (newWidth / 2);
            // draw the 2 new circles
            graphics.setColor(getColor(this.colors[colorIndex]));
            graphics.drawOval(leftX, newY, newWidth, newWidth);
            graphics.drawOval(rightX, newY, newWidth, newWidth);
            graphics.fillOval(x, y, width, height);
            colorIndex += 1;
            // recursively split each new circle
            splitCircle(count, rightX, newY, newWidth, newWidth, graphics, colorIndex);
            splitCircle(count, leftX, newY, newWidth, newWidth, graphics, colorIndex);
        } // end if statement
    } // end splitCircle()

    // here we map the color 'string' to a Color object
    public Color getColor(String color) {
        switch (color) {
            case "red":
                return Color.red;
            case "orange":
                return Color.orange;

            case "yellow":
                return Color.yellow;

            case "green":
                return Color.green;

            case "blue":
                return Color.blue;

            case "indigo":
                return Color.magenta;

            default:
                return Color.pink;
        }
    } // end getColor()
} // end Circle class

