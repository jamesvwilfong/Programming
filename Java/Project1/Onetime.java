// James Wilfong
// Dr. Stephan
// CSE 271, Section C
import java.util.GregorianCalendar;

class Onetime extends Appointment {
	
	
	public Onetime(String description, GregorianCalendar date){
		super(description,date);
	}//end Onetime constructor

	public boolean occursOn(GregorianCalendar date) {
		return date.equals(super.getDate());
	}//end occursOn
}//end Onetime class
