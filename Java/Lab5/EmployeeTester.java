// James Wilfong
// Dr. Stephan
// CSE 271, Section C
public class EmployeeTester {
public static void main(String[] args) {
	Employee a = new Employee("james",48.0);
	System.out.println("Expected: james");
	System.out.println(a.getName());
	System.out.println("Expected: 48.0");
	System.out.println(a.getSalary());
	System.out.println("Expected:\nName: james\nSalary: 48.0");
	System.out.println(a.toString("james", 48.0));
	Manager b = new Manager("james",48.0,"Clothing");
	System.out.println("Expected: Clothing");
	System.out.println(b.getDepartment());
	System.out.println("Expected: \nName: james\nSalary: 48.0\nDepartment: Clothing");
	System.out.println(b.toString("Clothing"));
	Executive c = new Executive("james",100.0,"Tech","Building 2");
	System.out.println("Expected: Building 2");
	System.out.println(c.getOfficeLocation());
	System.out.println("Expected: \nName: james\nSalary: 100.0\nDepartment: Tech\nOffice Location: Building 2");
	System.out.println(c.toString("Building 2"));
	}//end main
}//end EmployeeTester class
