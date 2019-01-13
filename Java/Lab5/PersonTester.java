// James Wilfong
// Dr. Stephan
// CSE 271, Section C
public class PersonTester {
public static void main(String[] args) {
	Person a = new Person("james",1998);
	System.out.println("Expected: james");
	System.out.println(Person.getName());
	System.out.println("Expected: 1998");
	System.out.println(Person.getYearOfBirth());
	System.out.println("Expected:\nName: james\nBirth Year: 1998");
	System.out.println(a.toString("james", 1998));
	Student b = new Student("james",1998,"Engineering");
	System.out.println("Expected: Engineering");
	System.out.println(b.getMajor());
	System.out.println("Expected: \nName: james\nBirth Year: 1998\nMajor: Engineering");
	System.out.println(b.toString("Engineering"));
	Instructor c = new Instructor("james",1998,130000.0);
	System.out.println("Expected: 130000.0");
	System.out.println(c.getSalary());
	System.out.println("Expcted: \nName: james\nBirth Year: 1998\nSalary: 130000.0");
	System.out.println(c.toString(130000.0));
	}//end main
}//end PersonTester class
