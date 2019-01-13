// James Wilfong
// Dr. Stephan
// CSE 271, Section C
public class Message {
	
	//instance variables
	private String sender;
	private String recipient;
	private String messageBody;
	
	//constants
	public static final String FROM = "From: ";
	public static final String TO = "\nTo: ";
	
	public Message(String sender, String recipient, String messageBody){
		this.setRecipient(recipient);
		this.setSender(sender);
		this.setMessageBody(messageBody);
	}//end Message constructor

	public void append(String newLine){
		messageBody = messageBody + "\n" + newLine;
	}//end append
	
	public String toString() {
		return FROM + sender + TO + recipient + "\n" + messageBody + "\n";
	}//end toString

	public void setMessageBody(String messageBody) {
		this.messageBody = messageBody;
	}//end setMessageBody
	
	public String getSender() {
		return sender;
	}//end getSender

	public void setSender(String sender) {
		this.sender = sender;
	}//end setSender

	public String getRecipient() {
		return recipient;
	}//end getRecipient

	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}//end setRecipient
}//end Message class
