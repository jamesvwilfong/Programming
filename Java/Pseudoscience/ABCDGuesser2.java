import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.utilities.FormatChecker;

/**
 * Java program that asks the user what constant u should be approximated, and
 * then asks in turn for each of the four personal numbers w, x, y, and z. The
 * program then calculates and reports the values of the exponents a, b, c, and
 * d that bring the de Jager formula as close as possible to u, as well as the
 * value of the formula w^a*x^b*y^c*z^d and the relative error of the
 * approximation to the nearest hundredth of one percent
 *
 * @author James Wilfong
 *
 */
public final class ABCDGuesser2 {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private ABCDGuesser2() {
    }

    /**
     * Repeatedly asks the user for a positive real number until the user enters
     * one. Returns the positive real number.
     *
     * @param in
     *            the input stream
     * @param out
     *            the output stream
     * @return a positive real number entered by the user
     */
    private static double getPositiveDouble(SimpleReader in, SimpleWriter out) {
        System.out.println("Give positive real number for value of µ: ");
        String a = in.nextLine();
        while (FormatChecker.canParseDouble(a) == false
                || Double.parseDouble(a) < 0) {
            System.out.println("Give positive real number for value of µ: ");
            a = in.nextLine();
        }
        return Double.parseDouble(a);
    }

    /**
     * Repeatedly asks the user for a positive real number not equal to 1.0
     * until the user enters one. Returns the positive real number.
     *
     * @param in
     *            the input stream
     * @param out
     *            the output stream
     * @return a positive real number not equal to 1.0 entered by the user
     */
    private static double getPositiveDoubleNotOne(SimpleReader in,
            SimpleWriter out) {
        System.out.println("Give positive real number greater than 0: ");
        String a = in.nextLine();
        while (FormatChecker.canParseDouble(a) == false
                || Double.parseDouble(a) < 0 || Double.parseDouble(a) == 1.0) {
            System.out.println("Give positive real number greater than 0: ");
            a = in.nextLine();
        }
        return Double.parseDouble(a);
    }

    /**
     * Checks which of two doubles are closer to the provided u value. Returns
     * true, if newEstimate is closer and false otherwise.
     *
     * @param u
     *            the u value given by the user
     * @param estimate
     *            the initial estimate value
     * @param newEstimate
     *            the new estimate value
     * @return true if the value of newEstimate is closer than the value of
     *         estimate to the value of u, false otherwise
     *
     */
    private static boolean closerEstimate(double u, double estimate,
            double newEstimate) {
        if (Math.abs(u - newEstimate) < Math.abs(u - estimate)) {
            return true;
        } else {
            return false;
        }
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
         * Put your main program code here; it may call private methods as shown
         */

        Double[] array = { -5.0, -4.0, -3.0, -2.0, -1.0, -.5, -1.0 / 3.0, -.25,
                0.0, .25, 1.0 / 3.0, .5, 1.0, 2.0, 3.0, 4.0, 5.0 };

        double u = getPositiveDouble(in, out);
        System.out.println("For the value of w,");
        double w = getPositiveDoubleNotOne(in, out);
        System.out.println("For the value of x,");
        double x = getPositiveDoubleNotOne(in, out);
        System.out.println("For the value of y,");
        double y = getPositiveDoubleNotOne(in, out);
        System.out.println("For the value of z,");
        double z = getPositiveDoubleNotOne(in, out);

        double estimate = 0;
        double a = 0;
        double b = 0;
        double c = 0;
        double d = 0;

        for (int i = 0; i < array.length; i++) {
            double e = Math.pow(w, array[i]);
            for (int j = 0; j < array.length; j++) {
                double f = Math.pow(x, array[j]);
                for (int k = 0; k < array.length; k++) {
                    double g = Math.pow(y, array[k]);
                    for (int n = 0; n < array.length; n++) {
                        double h = Math.pow(z, array[n]);
                        double newEstimate = e * f * g * h;
                        if (closerEstimate(u, estimate, newEstimate)) {
                            estimate = newEstimate;
                            a = array[i];
                            b = array[j];
                            c = array[k];
                            d = array[n];
                        }
                    }
                }
            }
        }
        System.out.println("a= " + a + "\nb= " + b + "\nc= " + c + "\nd= " + d);
        System.out.println("Best Estimate = " + estimate);
        System.out.print("Relative error = ");
        out.print(100 * Math.abs(u - estimate) / u, 2, false);
        System.out.print("%");
        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
