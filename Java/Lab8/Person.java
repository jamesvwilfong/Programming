package edu.miamioh.wilfonjv;
//James Wilfong
//Dr. Stephan
//CSE 271, Section C
/**
   Describes a Person with a given ID number and email
 */
public class Person {
	
	//instance variables
	private int idnumber;
	private String email;
	
	/**
	 * @return the id number
	 */
	public int getIdnumber() {
		return idnumber;
	}//end getIdnumber
	
	/**
	 * sets the id number
	 * @param idnumber
	 */
	public void setIdnumber(int idnumber) {
		this.idnumber = idnumber;
	}//end setIdnumber
	
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}//end getEmail
	
	/**
	 * sets the email
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}//end setEmail
	
	/**
	 * formats the Person
	 * @param idnumber
	 * @param email
	 */
	public Person(int idnumber, String email){
		this.setEmail(email);
		this.setIdnumber(idnumber);
	}//end Person constructor
}//end Person class
