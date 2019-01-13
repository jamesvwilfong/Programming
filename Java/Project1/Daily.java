// James Wilfong
// Dr. Stephan
// CSE 271, Section C
import java.util.GregorianCalendar;

public class Daily extends Appointment {
	
	public Daily(String description, GregorianCalendar date){
		super(description,date);
	}//end Daily constructor
	
	public void recurring(String description,GregorianCalendar date){
		if(super.getDayOfMonth() == date.getMaximum(GregorianCalendar.DAY_OF_MONTH))
			date = new GregorianCalendar(super.getYear(),super.getMonth(),super.getDayOfMonth()+1);
			else
				date = new GregorianCalendar(super.getYear(),super.getMonth(),0);
	}//end recurring method

	public boolean occursOn(GregorianCalendar date) {
		return date.equals(super.getDate());
	}//end occursOn

}//end Daily class
