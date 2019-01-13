package edu.miamioh.wilfonjv;
//James Wilfong
//Dr. Stephan
//CSE 271, Section C
/**
 * 
 * Describes a Course with a given Instructor, LectureHall, 
 * and courseName
 *
 */
public class Course {

	//instance variables
	private Instructor instructor;
	private LectureHall lectureHall;
	private String courseName;

	/**
	 * @return course name
	 */
	public String getCourseName() {
		return courseName;
	}//end getCourseName

	/**
	 * sets course name
	 * @param courseName
	 */
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}//end setCourseName

	/**
	 * @return instructor
	 */
	public Instructor getA() {
		return instructor;
	}//end getA

	/**
	 * sets instructor
	 * @param a
	 */
	public void setA(Instructor a) {
		this.instructor = a;
	}//end setA

	/**
	 * @return Lecture Hall
	 */
	public LectureHall getB() {
		return lectureHall;
	}//end getB

	/**
	 * sets Lecture Hall
	 * @param b
	 */
	public void setB(LectureHall b) {
		this.lectureHall = b;
	}//end setB

	/**
	 * formats the Course
	 * @param a
	 * @param b
	 * @param courseName
	 */
	public Course(Instructor a, LectureHall b, String courseName){
		this.setA(a);
		this.setB(b);
		this.setCourseName(courseName);
	}//end Course constructor
}//end Course class
