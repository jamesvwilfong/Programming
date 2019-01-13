// James Wilfong
// Dr. Stephan
// CSE 271, Section C
public class Student extends Person{
	
	private String major;

	public String getMajor() {
		return major;
	}//end getMajor

	public void setMajor(String major) {
		this.major = major;
	}//end setMajor

	public Student(String name, int yearOfBirth, String major) {
		super(name, yearOfBirth);
		this.setMajor(major);
	}//end Student constructor
	
	public String toString(String major){
		return super.toString(Person.getName(), Person.getYearOfBirth()) 
				+ "\nMajor: " + major;
	}//end toString
}//end Student class
