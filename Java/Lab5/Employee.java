// James Wilfong
// Dr. Stephan
// CSE 271, Section C
public class Employee {
	
	private double salary;
	private String name;
	
	public String getName() {
		return name;
	}//end getName

	public void setName(String name) {
		this.name = name;
	}//end setName

	public double getSalary() {
		return salary;
	}//end getSalary

	public void setSalary(double salary) {
		this.salary = salary;
	}//end setSalary

	public Employee(String name,double salary){
		this.setName(name);
		this.setSalary(salary);
	}//end Employee constructor
	
	public String toString(String name, double salary){
		return "Name: "+name+"\nSalary: "+salary;
	}//end toString
}//end Employee class
