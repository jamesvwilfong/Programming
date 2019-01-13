package edu.miamioh.wilfonjv;
//James Wilfong
//Dr. Stephan
//CSE 271, Section C
import java.util.ArrayList;
/**
 * 
 * Describes an Instructor using a given salary, 
 * list of assigned courses, and name
 *
 */
public class Instructor extends Person {

	//instance variables
	private String name;
	private double salary;
	private ArrayList<Course> instructorCourses = new ArrayList<Course>();

	/**
	 * @return instructorCourses
	 */
	public ArrayList<Course> getInstructorCourses() {
		return instructorCourses;
	}//end getInstructorCourses

	/**
	 * sets instructorCourses
	 * @param instructorCourses
	 */
	public void setInstructorCourses(ArrayList<Course> instructorCourses) {
		this.instructorCourses = instructorCourses;
	}//end setInstructorCourses

	/**
	 * @return salary
	 */
	public double getSalary() {
		return salary;
	}//end getSalary

	/**
	 * sets salary
	 * @param salary
	 */
	public void setSalary(double salary) {
		this.salary = salary;
	}//end setSalary

	/**
	 * formats the Instructor
	 * @param idnumber
	 * @param email
	 * @param salary
	 * @param instructorCourses
	 */
	public Instructor(int idnumber, String email, double salary, ArrayList<Course> instructorCourse, String name){
		super(idnumber,email);
		this.setName(name);
		this.setSalary(salary);
		this.setInstructorCourses(instructorCourses);
	}//end Instructor constructor

	/**
	 * assigns a gpa to a particular Student
	 * @param a
	 * @param gpa
	 */
	public void assignGpa(Student a, double gpa){
		a.setGpa(gpa);
	}//end assignGpa

	/**
	 * displays a list of courses that an Instructor is assigned to
	 * @param a
	 */
	public static void getCourses(Instructor a){
		for(Course elements : a.getInstructorCourses()){
			System.out.println(elements.getCourseName());
		}//end for loop
	}//end getCourses
	
	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}//end getName

	/**
	 * sets name
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}//end setName
	
	/**
	 * overrides the toString method
	 */
	public String toString(){
		return this.name;
	}//end toString
}//end Instructor class
