// James Wilfong
// Dr. Stephan
// CSE 271, Section C
public class Instructor extends Person{
	
	private double salary;

	public double getSalary() {
		return salary;
	}//end getSalary

	public void setSalary(double salary) {
		this.salary = salary;
	}//end setSalary

	public Instructor(String name, int yearOfBirth,double salary) {
		super(name, yearOfBirth);
		this.setSalary(salary);
	}//end Instructor constructor
	
	public String toString(double salary){
		return super.toString(getName(), getYearOfBirth()) 
				+ "\nSalary: " + salary;
	}//end toString
}//end Instructor class
