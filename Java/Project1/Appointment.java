// James Wilfong
// Dr. Stephan
// CSE 271, Section C
import java.util.GregorianCalendar;

public abstract class Appointment {
	
	private String description;
	private int month;
	private int year;
	private int dayOfMonth;
	private GregorianCalendar date = new GregorianCalendar(year, month, dayOfMonth);
	
	
	public Appointment(String description, GregorianCalendar date){
		this.setDescription(description);
		this.setDate(date);
	}//end Appointment constructor
	public GregorianCalendar getDate() {
		return date;
	}//end getDate
	public void setDate(GregorianCalendar date) {
		this.date = date;
	}//end setDate
	public int getMonth() {
		return month;
	}//end getMonth
	public void setMonth(int month) {
		this.month = month;
	}//end setMonth
	public int getYear() {
		return year;
	}//end getYear
	public void setYear(int year) {
		this.year = year;
	}//end setYear
	public int getDayOfMonth() {
		return dayOfMonth;
	}//end getDayOfMonth
	public void setDayOfMonth(int dayOfMonth) {
		this.dayOfMonth = dayOfMonth;
	}//end setDayOfMonth
	public String getDescription() {
		return description;
	}//end getDescription
	public void setDescription(String description) {
		this.description = description;
	}//end setDescription
	public abstract boolean occursOn(GregorianCalendar date);
}//end Appointment class
