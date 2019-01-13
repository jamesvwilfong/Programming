import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Program that checks whether a string entered by the user meets several
 * criteria to qualify as a valid password.
 *
 * @author James Wilfong
 *
 */
public final class CheckPassword {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private CheckPassword() {
    }

    /**
     * Checks whether the given String satisfies the CSE department criteria for
     * a valid password. Prints an appropriate message to the given output
     * stream.
     *
     * @param s
     *            the String to check
     * @param out
     *            the output stream
     */
    private static void checkPassword(String s, SimpleWriter out) {
        if (s.length() < 6) {
            System.out.println("Password is too short.");
        }
    }

    /**
     * Checks if the given String contains an upper case letter.
     *
     * @param s
     *            the String to check
     * @return true if s contains an upper case letter, false otherwise
     */
    private static boolean containsUpperCaseLetter(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (Character.isUpperCase(s.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if the given String contains a lower case letter.
     *
     * @param s
     *            the String to check
     * @return true if s contains a lower case letter, false otherwise
     */
    private static boolean containsLowerCaseLetter(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLowerCase(s.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if the given String contains a digit.
     *
     * @param s
     *            the String to check
     * @return true if s contains a digit, false otherwise
     */
    private static boolean containsDigit(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                return true;
            }
        }
        return false;
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
         * Put your main program code here; it may call checkPassword as shown
         */
        int check = 0;
        System.out.println("Password: ");
        String s = in.nextLine();
        checkPassword(s, out);
        if (containsUpperCaseLetter(s) == false) {
            check++;
        }
        if (containsLowerCaseLetter(s) == false) {
            check++;
        }
        if (containsDigit(s) == false) {
            check++;
        }
        if (check > 1) {
            System.out.println(
                    "INVALID. Password must contain at least 2 of the following: uppercase letter, lowercase letter, digit.");
        }
        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
