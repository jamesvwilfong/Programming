// James Wilfong
// Dr. Stephan
// CSE 271, Section C
import java.util.GregorianCalendar;

public class Monthly extends Appointment {
	
	public Monthly(String description, GregorianCalendar date){
		super(description,date);
	}// end Monthly constructor

	public boolean occursOn(GregorianCalendar date) {
		return date.equals(super.getDate());
	}//end occursOn

}//end Monthly class
