package edu.miamioh.wilfonjv;
//James Wilfong
//Dr. Stephan
//CSE 271, Section C
import java.util.ArrayList;

/**
 * 
 * Describes a Student with a given list of courses, gpa, and major
 *
 */
public class Student extends Person {

	//instance variables
	private ArrayList<Course> courseList;
	private double gpa;
	private String major;

	/**
	 * @return major
	 */
	public String getMajor() {
		return major;
	}//end getMajor
	
	/**
	 * sets major
	 * @param major
	 */
	public void setMajor(String major) {
		this.major = major;
	}//end setMajor

	/**
	 * @return course list
	 */
	public ArrayList<Course> getCourseList() {
		return courseList;
	}//end getCourseList
	
	/**
	 * sets course list
	 * @param courselist
	 */
	public void setCourseList(ArrayList<Course> courseList) {
		this.courseList = courseList;
	}//end setCourseList
	
	/**
	 * @return gpa
	 */
	public double getGpa() {
		return gpa;
	}//end getGpa
	
	/**
	 * sets gpa
	 * @param gpa
	 */
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}//end setGpa

	/**
	 * formats the Student
	 * @param idnumber
	 * @param email
	 * @param courselist
	 * @param gpa
	 * @param major
	 */
	public Student(int idnumber, String email, ArrayList<Course> courselist, double gpa, String major){
		super(idnumber,email);
		this.setCourseList(courselist);
		this.setMajor(major);
		this.setGpa(gpa);
	}//end Student constructor
	
	/**
	 * displays the courses a Student is enrolled in
	 * @param a
	 */
	public static void displayCourses(Student a){
		for(Course elements : a.getCourseList()){
			System.out.println(elements.getCourseName());
		}//end for loop
	}//end displayCourses
}//end Student class
