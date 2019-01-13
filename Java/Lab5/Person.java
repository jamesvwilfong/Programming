// James Wilfong
// Dr. Stephan
// CSE 271, Section C
public class Person {
	
	private static String name;
	private static int yearOfBirth;
	
	public static String getName() {
		return name;
	}//end getName

	public void setName(String name) {
		Person.name = name;
	}//end setName

	public static int getYearOfBirth() {
		return yearOfBirth;
	}//end getYearOfBirth

	public void setYearOfBirth(int yearOfBirth) {
		Person.yearOfBirth = yearOfBirth;
	}//end setYearOfBirth

	public Person(String name, int yearOfBirth){
		this.setName(name);
		this.setYearOfBirth(yearOfBirth);
	}//end Person constructor
	
	public String toString(String name, int yearOfBirth){
		return "Name: " + name + "\nBirth Year: " + yearOfBirth;
	}//end toString
}//end Person class
