// James Wilfong
// Dr. Stephan
// CSE 271, Section C
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class AppointmentBook {
private ArrayList<Appointment> appointmentBook;
private AppointmentType a;

public ArrayList<Appointment> getAppointmentBook() {
	return appointmentBook;
}//end getAppointmentBook

public void setAppointmentBook(ArrayList<Appointment> appointmentBook) {
	this.appointmentBook = appointmentBook;
}//end setAppointmentBook

public AppointmentBook(ArrayList<Appointment> appointmentBook,AppointmentType a){
	this.setAppointmentBook(appointmentBook);
	this.setAppointmentType(a);
}//end AppointmentBook constructor

public enum AppointmentType{
	ONETIME, DAILY, MONTHLY
}//end AppointmentType enum

public void setAppointmentType(AppointmentBook.AppointmentType a){
	this.setAppointmentType(a);
}//end setAppointmentType
public void addAppointment(AppointmentType a, String description, GregorianCalendar date ){
}//end addAppointment

public void saveToFile(Appointment a) throws FileNotFoundException{
	PrintWriter output = new PrintWriter(new File("AppointmentBook"));
	output.println(a.toString());
	output.close();
}//end saveToFile

public void loadFromFile(Appointment a){
	Scanner in = new Scanner("AppointmentBook");
	String str=in.findInLine(a.toString());
	in.close();
	}//end loadFromFile
}//end AppointmentBook class

