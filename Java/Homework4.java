import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Put a short phrase describing the program here.
 *
 * @author James Wilfong
 *
 */
public final class Homework4 {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private Homework4() {
    }

    /**
     * Checks whether the given point (xCoord, yCoord) is inside the circle of
     * radius 1.0 centered at the point (1.0, 1.0).
     *
     * @param xCoord
     *            the x coordinate of the point
     * @param yCoord
     *            the y coordinate of the point
     * @return true if the point is inside the circle, false otherwise
     */
    private static boolean pointIsInCircle(double xCoord, double yCoord) {
        if (Math.pow(xCoord - 1, 2) + Math.pow(yCoord - 1, 2) < 1) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Generates n pseudo-random points in the [0.0,2.0) x [0.0,2.0) square and
     * returns the number that fall in the circle of radius 1.0 centered at the
     * point (1.0, 1.0).
     *
     * @param n
     *            the number of points to generate
     * @return the number of points that fall in the circle
     */
    private static int numberOfPointsInCircle(int n) {
        int i = 0;
        int count = 0;
        double x;
        double y;
        while (i < n) {
            x = Math.random() * 2;
            y = Math.random() * 2;
            if (Math.pow(x - 1, 2) + Math.pow(y - 1, 2) < 1) {
                count++;
            }
            i++;
        }
        return count;
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();
        /*
         * Put your main program code here; it may call myMethod as shown
         */
        numberOfPointsInCircle(in.nextInteger());

        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
