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
public final class CoinChange1 {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private CoinChange1() {
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
        int dollar = total / 100;
        total = total % 100;
        int halfDollar = total / 50;
        total = total % 50;
        int quarter = total / 25;
        total = total % 25;
        int dime = total / 10;
        total = total % 10;
        int nickel = total / 5;
        total = total % 5;
        System.out.println("Dollars: " + dollar);
        System.out.println("Half-Dollars: " + halfDollar);
        System.out.println("Quarters: " + quarter);
        System.out.println("Dimes: " + dime);
        System.out.println("Nickels: " + nickel);
        System.out.println("Pennies: " + total);
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
