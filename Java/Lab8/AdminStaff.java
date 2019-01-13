package edu.miamioh.wilfonjv;
//James Wilfong
//Dr. Stephan
//CSE 271, Section C
/**
 * 
 * Describes an AdminStaff using a given salary
 *
 */
public class AdminStaff extends Person {

	//instance variable
	private double salary;

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
	 * formats the AdminStaff
	 * @param idnumber
	 * @param email
	 * @param salary
	 */
	public AdminStaff(int idnumber, String email, double salary){
		super(idnumber,email);
		this.setSalary(salary);
	}//end AdminStaff constructor

	/**
	 * enrolls a Student in a Course
	 * @param c
	 * @param e
	 */
	public void enrollStudent(Student c, Course e){
		c.getCourseList().add(e);
	}//end enrollStudent

	/**
	 * assigns a Lecture Hall to a Course
	 * @param e
	 * @param b
	 */
	public void assignLectureHall(Course e, LectureHall b){
		e.setB(b);
	}//end assignLectureHall

	/**
	 * assigns an Instructor to a Course
	 * @param a
	 * @param e
	 */
	public void assignInstructor(Instructor a, Course e){
		a.getInstructorCourses().add(e);
		e.setA(a);
	}//end assignInstructor
}//end AdminStaff class
