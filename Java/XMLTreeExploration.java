import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.xmltree.XMLTree;
import components.xmltree.XMLTree1;

/**
 * Program that loads an XMLTree object from an XML URL; then, from this object,
 * extracts various pieces of information using the XMLTree methods and outputs
 * that information to the console
 *
 * @author James Wilfong
 *
 */
public final class XMLTreeExploration {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private XMLTreeExploration() {
    }

    /**
     *  * Output information about the middle child of the given
     * {@code XMLTree}.  *  * @param xt  *            the {@code XMLTree} whose
     * middle child is to be printed  * @param out  *            the output
     * stream  * @updates out.content  * @requires <pre>
      * [the label of the root of xt is a tag]  and
      * [xt has at least one child]  and  out.is_open
      * </pre>  * @ensures <pre>
      * out.content = #out.content * [the label of the middle child
      *  of xt, whether the root of the middle child is a tag or text,
      *  and if it is a tag, the number of children of the middle child]
      * </pre>  
     */
    private static void printMiddleNode(XMLTree xt, SimpleWriter out) {
        XMLTree middleChild = xt.child((xt.numberOfChildren() - 1) / 2);
        out.println("Label: " + middleChild.label());
        if (middleChild.isTag()) {
            out.println("Label is a tag.");
        } else {
            out.println("Label is a text.");
        }
        if (middleChild.isTag()) {
            out.println(
                    "Number of children: " + middleChild.numberOfChildren());
        }
        out.println(
                "Index of middle child: " + (xt.numberOfChildren() - 1) / 2);
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
         * Put your main program code here
         */
        XMLTree xml = new XMLTree1(
                "http://web.cse.ohio-state.edu/software/2221/web-sw1/"
                        + "extras/instructions/xmltree-model/columbus-weather.xml");
        // out.print(xml.toString());
        xml.display();
        if (xml.isTag()) {
            System.out
                    .println("The root is a tag labeled " + xml.label() + ".");
        } else {
            System.out
                    .println("The root is a text labeled " + xml.label() + ".");
        }

        XMLTree results = xml.child(0);
        XMLTree channel = results.child(0);
        System.out
                .println("Children of channel: " + channel.numberOfChildren());
        XMLTree title = channel.child(1);
        XMLTree titleText = title.child(0);
        System.out.println("Title: " + titleText.label());
        System.out.println(
                "Title: " + xml.child(0).child(0).child(1).child(0).label());
        XMLTree astronomy = channel.child(10);
        if (astronomy.hasAttribute("sunset")) {
            System.out.println("Astronomy has attribute sunset.");
        } else {
            System.out.println("Astronomy does not have attribute sunset.");
        }
        if (astronomy.hasAttribute("midday")) {
            System.out.println("Astronomy has attribute midday.");
        } else {
            System.out.println("Astronomy does not have attribute midday.");
        }
        System.out.println("Sunrise: " + astronomy.attributeValue("sunrise")
                + "\nSunset: " + astronomy.attributeValue("sunset"));
        printMiddleNode(channel, out);

        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
