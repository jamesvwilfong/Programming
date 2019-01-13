import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Prompts the user for a number, and reports the square root of that number to
 * within a relative error of no more than the user given epsilon value Repeats
 * until user does not wish to continue.
 *
 * @author James Wilfong
 *
 */
public final class Newton3 {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private Newton3() {
    }

    /**
     * Computes estimate of square root of x to within relative error of user
     * given epsilon value.
     *
     * @param x
     *            positive number to compute square root of
     * @param epsilon
     *            value of epsilon given by user
     * @return estimate of square root
     */
    private static double sqrt(double x, double epsilon) {
        double r = x;
        if (x == 0) {
            return 0;
        }
        while ((Math.abs(((r * r) - x)) / x) > (epsilon * epsilon)) {
            r = (r + (x / r)) / 2;
        }
        return r;
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        String response = "y";
        double a;
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();
        /*
         * Put your main program code here; it may call sqrt as shown
         */
        System.out.println("Value of Epsilon: ");
        double epsilon = in.nextDouble();
        while (response.equals("y")) {
            System.out.println("Provide a positive number: ");
            a = in.nextDouble();
            double b = sqrt(a, epsilon);
            System.out.println(b);
            System.out.println("Continue?");
            response = in.nextLine();
        }
        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
