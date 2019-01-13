// James Wilfong
// Dr. Stephan
// CSE 271, Section C
import java.util.ArrayList;

public class Mailbox {
	
	//instance variables
	private ArrayList<String> messages;
	private static String signature;
	
	public Mailbox(ArrayList<String> messages,String signature){
		this.setMessages(messages);
		this.setSignature(signature);
	}//end Mailbox constructor
	
	public void setMessages(ArrayList<String> messages) {
		this.messages = messages;
	}//end setMessages

	public void setSignature(String i) {
		Mailbox.signature = i;
	}//end setSignature

	int i = 0;
	public void addMessage(Message m){
		m.append(Mailbox.getSignature());
		messages.add(i,m.toString());	
		i++;
	}//end addMessage

	public String getMessage(int i){
		return messages.get(i);	
	}//end getMessage
	
	public void removeMessage(int i){
		messages.remove(i);
	}//end removeMessage
	
    public ArrayList<String> getMessages() {
		return messages;
	}//end getMessages

	public static String getSignature() {
		return signature;
	}//end getSignature
}//end Mailbox class
