// James Wilfong
// Dr. Stephan
// CSE 271, Section C
import java.util.ArrayList;

public class MailboxTester {
	public static void main(String[] args) {
		Message a = new Message("Bob", "Bill", "Hello world.");
		Message b = new Message("Amos", "Arnold", "Hello town.");
		Mailbox c = new Mailbox(new ArrayList<String>(),"mailbox 1");
		c.addMessage(a);
		System.out.println("Expected:\n[From: Bob\nTo: Bill\nHello World.\nmailbox 1\n]");
		System.out.println(c.getMessages());
		c.addMessage(b);
		System.out.println("\nExpected:\nFrom: Amos\nTo: Arnold\nHello town.\nmailbox 1\n");
		System.out.println(c.getMessage(1));
		c.removeMessage(1);
		System.out.println("Expected:\n[From: Bob\nTo: Bill\nHello World.\nmailbox 1\n]");
		System.out.println(c.getMessages());
	}//end main
}//end MailboxTester class
