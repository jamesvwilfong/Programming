import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Asks the user for an amount of money in cents, and returns how to make change
 * for that amount using a minimal amount of coins.
 *
 * @author James Wilfong
 *
 */
public final class CoinChange2 {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private CoinChange2() {
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
        System.out.println("Money total: ");
        int total = in.nextInteger();
        int[] array1 = new int[6];
        int[] array2 = { 100, 50, 25, 10, 5, 1 };

        for (int i = 0; i < array1.length; i++) {
            array1[i] = total / array2[i];
            total = total % array2[i];
        }
        System.out.println("Dollars: " + array1[0]);
        System.out.println("Half-Dollars: " + array1[1]);
        System.out.println("Quarters: " + array1[2]);
        System.out.println("Dimes: " + array1[3]);
        System.out.println("Nickels: " + array1[4]);
        System.out.println("Pennies: " + array1[5]);
        /*
         * Put your main program code here
         */
        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
