import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Hailstone series. This program takes in an integer greater than 0 from the
 * user. If the integer is even it divides it by 2 to give the next integer of
 * series. If the integer is odd, it multiplies it by 3 and adds 1 to give the
 * next integer of the series. This continues until the series gets to the value
 * of 1.
 *
 * @author James Wilfong
 *
 */
public final class Hailstone2 {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private Hailstone2() {
    }

    /**
     * Generates and outputs the Hailstone series starting with the given
     * integer. Also keeps count of the length of the series, and outputs that
     * value.
     *
     * @param n
     *            the starting integer
     * @param out
     *            the output stream
     */
    private static void generateSeries(int n, SimpleWriter out) {
        int i = 1;
        while (n != 1 && n > 0) {
            System.out.print(n + " ");
            i++;
            if (n == 2) {
                System.out.println(1);
            }
            if (n % 2 == 0) {
                n = n / 2;
            } else {
                n = 3 * n + 1;
            }
        }
        System.out.print("Length of Series: " + i);
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
        generateSeries(in.nextInteger(), out);
        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
