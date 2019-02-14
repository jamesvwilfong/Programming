// James Wilfong
// Dr. Stephan
// CSE 271, Section C
public class Address {

	//instance variables
	private int houseNum, apartmentNum;
	private String street, city, state, zip;

	//Address constructor
	public Address(int houseNum, String street, int apartmentNum, 
			String city, String state, String zip){
		this.setCity(city);
		this.setHouseNum(houseNum);
		this.setApartmentNum(apartmentNum);
		this.setStreet(street);
		this.setState(state);
		this.setZip(zip);
	}//end Address constructor
	
	//Address constructor without apartment number
	public Address(int houseNum, String street, String city, 
			String state, String zip){
		this.setCity(city);
		this.setHouseNum(houseNum);
		this.setStreet(street);
		this.setState(state);
		this.setZip(zip);
	} //end constructor

	public int getHouseNum() {
		return houseNum;
	}//end getHouseNum
	
	public void setHouseNum(int houseNum) {
		this.houseNum = houseNum;
	} //end setHouseNum
	
	public int getApartmentNum() {
		return apartmentNum;
	}//end getApartmentNum
	
	public void setApartmentNum(int apartmentNum) {
		if(apartmentNum>0)
		this.apartmentNum = apartmentNum;
		else
			this.apartmentNum = -1;
	}//end setApartmentNum
	
	public String getStreet() {
		return street;
	}//end getStreet
	
	public void setStreet(String street) {
		this.street = street;
	}//end setStreet
	
	public String getCity() {
		return city;
	}//end getCity
	
	public void setCity(String city) {
		this.city = city;
	}//end setCity
	
	public String getState() {
		return state;
	}//end getState
	
	public void setState(String state) {
		this.state = state;
	}//end setState
	
	public String getZip() {
		return zip;
	}//end getZip
	
	public void setZip(String zip) {
		if(Integer.parseInt(zip)>0 && Integer.parseInt(zip)<=99999)
		this.zip = zip;
	}//end setZip
	
	public void printAddress(){
		if(this.apartmentNum >= 0)
			System.out.println(houseNum + " "+ street +
					" APT " + apartmentNum);
		else
			System.out.println(houseNum + " " + street);
		System.out.println(city + ", " + state + " " + zip);
	}//end printAddress
	
	public boolean comesBefore(Address other){
		int otherAddress = Integer.parseInt(other.zip);
		int address1 = Integer.parseInt(this.zip);
		if(otherAddress<address1)
			return true;
		else
			return false;
	}//end comesBefore 
}//end Address class
