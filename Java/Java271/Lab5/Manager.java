// James Wilfong
// Dr. Stephan
// CSE 271, Section C
public class Manager extends Employee{
	
	private String department;
	
	public String getDepartment() {
		return department;
	}//end getDepartment

	public void setDepartment(String department) {
		this.department = department;
	}//end setDepartment

	public Manager(String name, double salary, String department) {
		super(name, salary);
		this.setDepartment(department);
	}//end Manager constructor
	
	public String toString(String department){
		return super.toString(getName(), getSalary())+"\nDepartment: "+department;
	}//end toString
}//end Manager class
