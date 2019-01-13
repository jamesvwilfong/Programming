import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.xmltree.XMLTree;
import components.xmltree.XMLTree1;

/**
 * Program to convert an XML RSS (version 2.0) feed from a given URL into the
 * corresponding HTML output file.
 *
 * @author James Wilfong
 *
 */
public final class RSSAggregator {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private RSSAggregator() {
    }

    /**
     * Outputs the "opening" tags in the generated HTML file. These are the
     * expected elements generated by this method:
     *
     * <html> <head> <title>the channel tag title as the page title</title>
     * </head> <body>
     * <h1>the page title inside a link to the <channel> link</h1>
     * <p>
     * the channel description
     * </p>
     * <table border="1">
     * <tr>
     * <th>Date</th>
     * <th>Source</th>
     * <th>News</th>
     * </tr>
     *
     * @param channel
     *            the channel element XMLTree
     * @param out
     *            the output stream
     * @updates out.content
     * @requires [the root of channel is a <channel> tag] and out.is_open
     * @ensures out.content = #out.content * [the HTML "opening" tags]
     */
    private static void outputHeader(XMLTree channel, SimpleWriter out) {
        assert channel != null : "Violation of: channel is not null";
        assert out != null : "Violation of: out is not null";
        assert channel.isTag() && channel.label().equals("channel") : ""
                + "Violation of: the label root of channel is a <channel> tag";
        assert out.isOpen() : "Violation of: out.is_open";

        /*
         * TODO: fill in body
         */

        String link = channel.child(getChildElement(channel, "link")).child(0)
                .label();

        String title;
        if (channel.child(getChildElement(channel, "title"))
                .numberOfChildren() == 0) {
            title = "No title available";
        } else {
            title = channel.child(getChildElement(channel, "title")).child(0)
                    .label();
        }

        String description;
        if (channel.child(getChildElement(channel, "description"))
                .numberOfChildren() == 0) {
            description = "No description availabe";
        } else {
            description = channel.child(getChildElement(channel, "description"))
                    .child(0).label();
        }

        out.println("<html>\n<head>\n<title>" + title + "</title>");
        out.println("</head>\n<body>");
        out.println("\t<h1>\n\t\t<a href=\"" + link + "\">" + title
                + "</a>\n\t</h1>");
        out.print("\t<p>");
        out.print(description);
        out.println("</p>");
        out.println("\t<table border=\"1\">");
        out.println("\t\t<tr>");
        out.println(
                "\t\t\t<th>Date</th>\n\t\t\t<th>Source</th>\n\t\t\t<th>News</th>\n\t\t</tr>");

    }

    /**
     * Outputs the "closing" tags in the generated HTML file. These are the
     * expected elements generated by this method:
     *
     * </table>
     * </body> </html>
     *
     * @param out
     *            the output stream
     * @updates out.contents
     * @requires out.is_open
     * @ensures out.content = #out.content * [the HTML "closing" tags]
     */
    private static void outputFooter(SimpleWriter out) {
        assert out != null : "Violation of: out is not null";
        assert out.isOpen() : "Violation of: out.is_open";

        /*
         * TODO: fill in body
         */
        out.println("\t</table>\n</body>\n</html>");
    }

    /**
     * Finds the first occurrence of the given tag among the children of the
     * given {@code XMLTree} and return its index; returns -1 if not found.
     *
     * @param xml
     *            the {@code XMLTree} to search
     * @param tag
     *            the tag to look for
     * @return the index of the first child of type tag of the {@code XMLTree}
     *         or -1 if not found
     * @requires [the label of the root of xml is a tag]
     * @ensures <pre>
     * getChildElement =
     *  [the index of the first child of type tag of the {@code XMLTree} or
     *   -1 if not found]
     * </pre>
     */
    private static int getChildElement(XMLTree xml, String tag) {
        assert xml != null : "Violation of: xml is not null";
        assert tag != null : "Violation of: tag is not null";
        assert xml.isTag() : "Violation of: the label root of xml is a tag";

        /*
         * TODO: fill in body
         */
        for (int i = 0; i < xml.numberOfChildren(); i++) {
            if (xml.child(i).label().equals(tag)) {
                return i;
            }
        }
        return -1;

    }

    /**
     * Processes one news item and outputs one table row. The row contains three
     * elements: the publication date, the source, and the title (or
     * description) of the item.
     *
     * @param item
     *            the news item
     * @param out
     *            the output stream
     * @updates out.content
     * @requires [the label of the root of item is an <item> tag] and
     *           out.is_open
     * @ensures <pre>
     * out.content = #out.content *
     *   [an HTML table row with publication date, source, and title of news item]
     * </pre>
     */
    private static void processItem(XMLTree item, SimpleWriter out) {
        assert item != null : "Violation of: item is not null";
        assert out != null : "Violation of: out is not null";
        assert item.isTag() && item.label().equals("item") : ""
                + "Violation of: the label root of item is an <item> tag";
        assert out.isOpen() : "Violation of: out.is_open";

        /*
         * TODO: fill in body
         */
        String pubDate = "No date available";
        if (getChildElement(item, "pubDate") != -1) {
            pubDate = item.child(getChildElement(item, "pubDate")).child(0)
                    .label();
        }

        String source = "No source available";
        String sourceName = "No source available";
        if (getChildElement(item, "source") != -1) {
            sourceName = item.child(getChildElement(item, "source")).child(0)
                    .label();
            source = item.child(getChildElement(item, "source"))
                    .attributeValue("url");

        }

        String title = "No title available";
        if (getChildElement(item, "title") != -1) {
            if (item.child(getChildElement(item, "title"))
                    .numberOfChildren() > 0) {
                title = item.child(getChildElement(item, "title")).child(0)
                        .label();
            }
        } else if (item.child(getChildElement(item, "description"))
                .numberOfChildren() > 0) {
            title = item.child(getChildElement(item, "description")).child(0)
                    .label();
        }

        out.println("\t\t<tr>");
        out.print("\t\t\t<td>" + pubDate + "</td>\n\t\t\t<td>");
        if (source.compareTo("No source available") != 0) {
            out.print("<a href=\"" + source + "\">" + sourceName + "</a>");
        } else {
            out.print(sourceName);
        }
        out.print("</td>\n\t\t\t<td>");
        if (source.compareTo("No source available") != 0) {
            out.print("<a href=\"" + source + "\">" + title + "</a>");
        } else {
            out.print(title);
        }
        out.println("</td>\n\t\t</tr>");

    }

    /**
     * Processes one XML RSS (version 2.0) feed from a given URL converting it
     * into the corresponding HTML output file.
     *
     * @param url
     *            the URL of the RSS feed
     * @param file
     *            the name of the HTML output file
     * @param out
     *            the output stream to report progress or errors
     * @updates out.content
     * @requires out.is_open
     * @ensures <pre>
     * [reads RSS feed from url, saves HTML document with table of news items
     *   to file, appends to out.content any needed messages]
     * </pre>
     */
    private static void processFeed(String url, String file, SimpleWriter out) {
        XMLTree feed = new XMLTree1(url);
        XMLTree channel = feed.child(getChildElement(feed, "channel"));
        outputHeader(channel, out);
        for (int i = 0; i < channel.numberOfChildren(); i++) {
            if (channel.child(i).label().equals("item")) {
                processItem(channel.child(i), out);
            }
        }
        outputFooter(out);

    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments; unused here
     */
    public static void main(String[] args) {
        SimpleReader in = new SimpleReader1L();

        // writes to the console
        SimpleWriter console = new SimpleWriter1L();

        //get xml file to be processed from user
        console.println("XML File Name: ");
        String xmlFileName = in.nextLine();

        // construct XMLTree from user input
        XMLTree index = new XMLTree1(xmlFileName);

        //get output file name from user
        console.println("Output file name: ");
        String outputFileName = in.nextLine();

        //writes to the output file given by user
        SimpleWriter indexOut = new SimpleWriter1L(outputFileName);

        indexOut.println("<html>\n<head>\n<title>"
                + index.attributeValue("title") + "</title>");
        indexOut.println("</head>\n<body>\n<h1>" + index.attributeValue("title")
                + "</h1>\n<ul>");

        //creates unordered list of links to each html file generated from xml file provided by user
        for (int i = 0; i < index.numberOfChildren(); i++) {
            indexOut.println("<li><a href=\""
                    + index.child(i).attributeValue("file") + "\">"
                    + index.child(i).attributeValue("name") + "</a></li>");
        }
        indexOut.println("</ul></body></html>");

        //processes each feed from the xml file provided by user except for the child at index 1 which causes an error
        for (int i = 0; i < index.numberOfChildren(); i++) {
            if (i != 1) {
                String url = index.child(i).attributeValue("url");
                String fileName = index.child(i).attributeValue("file");
                SimpleWriter fileOut = new SimpleWriter1L(fileName);
                processFeed(url, fileName, fileOut);
            }
        }

        //closes SimpleReader and SimpleWriters
        in.close();
        console.close();
        indexOut.close();
    }

}
