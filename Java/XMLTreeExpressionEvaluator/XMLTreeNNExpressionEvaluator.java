import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber2;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.utilities.Reporter;
import components.xmltree.XMLTree;
import components.xmltree.XMLTree1;

/**
 * Program to evaluate XMLTree expressions of {@code NaturalNumber}.
 *
 * @author James Wilfong
 *
 */
public final class XMLTreeNNExpressionEvaluator {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private XMLTreeNNExpressionEvaluator() {
    }

    /**
     * Evaluate the given expression.
     *
     * @param exp
     *            the {@code XMLTree} representing the expression
     * @return the value of the expression
     * @requires <pre>
     * [exp is a subtree of a well-formed XML arithmetic expression]  and
     *  [the label of the root of exp is not "expression"]
     * </pre>
     * @ensures evaluate = [the value of the expression]
     */
    private static NaturalNumber evaluate(XMLTree exp) {
        assert exp != null : "Violation of: exp is not null";

        //initial result value
        NaturalNumber result = new NaturalNumber2(0);
        //performs subtraction
        if (exp.label().equals("minus")) {
            NaturalNumber left = new NaturalNumber2(evaluate(exp.child(0)));
            NaturalNumber right = new NaturalNumber2(evaluate(exp.child(1)));
            if (left.compareTo(right) > 0) {
                left.subtract(right);
                return left;
            } else {
                //stops subtraction resulting in a negative value
                Reporter.fatalErrorToConsole(
                        "CALCULATION ERROR: subtraction resulting in negative value.");
            }
        }
        //performs addition
        if (exp.label().equals("plus")) {
            NaturalNumber left = new NaturalNumber2(evaluate(exp.child(0)));
            NaturalNumber right = new NaturalNumber2(evaluate(exp.child(1)));
            left.add(right);
            return left;
        }
        //performs division
        if (exp.label().equals("divide")) {
            NaturalNumber left = new NaturalNumber2(evaluate(exp.child(0)));
            NaturalNumber right = new NaturalNumber2(evaluate(exp.child(1)));
            if (right.compareTo(new NaturalNumber2(0)) > 0) {
                left.divide(right);
                return left;
            } else {
                //stops division by 0
                Reporter.fatalErrorToConsole(
                        "CALCULATION ERROR: division by 0.");
            }
        }
        //performs multiplication
        if (exp.label().equals("times")) {
            NaturalNumber left = new NaturalNumber2(evaluate(exp.child(0)));
            NaturalNumber right = new NaturalNumber2(evaluate(exp.child(1)));
            left.multiply(right);
            return left;
        }
        //returns number values
        if (exp.label().equals("number")) {
            if (Integer.parseInt(exp.attributeValue("value")) >= 0) {
                return new NaturalNumber2(exp.attributeValue("value"));
            } else {
                //stops the calculation when given a negative value
                Reporter.fatalErrorToConsole(
                        "CALCULATION ERROR: negative value.");
            }
        }
        //returns if XML file does not have any of the labels checked for above
        return result;
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

        out.print("Enter the name of an expression XML file: ");
        String file = in.nextLine();
        while (!file.equals("")) {
            XMLTree exp = new XMLTree1(file);
            out.println(evaluate(exp.child(0)));
            out.print("Enter the name of an expression XML file: ");
            file = in.nextLine();
        }

        in.close();
        out.close();
    }

}
