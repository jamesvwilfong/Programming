// James Wilfong
// Dr. Stephan
// CSE 271, Section C
public class Executive extends Manager{
	
	private String officeLocation;

	public String getOfficeLocation() {
		return officeLocation;
	}//end getOfficeLocation

	public void setOfficeLocation(String officeLocation) {
		this.officeLocation = officeLocation;
	}//end setOfficeLocation

	public Executive(String name, double salary, String department, String officeLocation) {
		super(name, salary, department);
		this.setOfficeLocation(officeLocation);
	}//end Executive constructor
	
	public String toString(String officeLocation){
		return super.toString(getDepartment())+"\nOffice Location: "+officeLocation;
	}//end toString
}//end Manager class
