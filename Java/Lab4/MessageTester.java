// James Wilfong
// Dr. Stephan
// CSE 271, Section C
public class MessageTester {
	public static void main(String[] args) {
	Message a = new Message("Bob", "Bill", "Hello world.");
	a.append("how are you?");
	System.out.println("Expected:\nFrom: Bob\nTo: Bill\nHelo world.\nhow are you?\n");
	System.out.print(a.toString());
	}//end main 
}//end MessageTester
