import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Prompts the user for their name, then outputs a greeting to them using the
 * name provided.
 *
 * @author James Wilfong
 *
 */
public final class HelloJack {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private HelloJack() {
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
        String name = in.nextLine();
        out.print("Hello, " + name);
        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
