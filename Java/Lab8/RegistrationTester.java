package edu.miamioh.wilfonjv;
//James Wilfong
//Dr. Stephan
//CSE 271, Section C
import java.util.ArrayList;

public class RegistrationTester {
	public static void main(String[] args) {
		
		AdminStaff molly = new AdminStaff(11,"molly@school.com",55.0);
		Student tim = new Student(13,"tim@school.com",new ArrayList<Course>(),4.0,"engineering");
		Instructor bob = new Instructor(15,"bob@school.com",60.0,new ArrayList<Course>(),"Bob");
		Instructor bill = new Instructor(19,"bill@school.com",60.0,new ArrayList<Course>(),"Bill");
		LectureHall benton = new LectureHall(100,"Benton");
		LectureHall bachelor = new LectureHall(100,"Bachelor");
		Course physics = new Course(bob,benton, "Physics");
		
		molly.enrollStudent(tim, physics);
		System.out.println("Expected:\nPhysics");
		Student.displayCourses(tim);
		
		molly.assignLectureHall(physics, bachelor);
		System.out.println("Expected:\nBachelor");
		System.out.println(physics.getB());
		
		molly.assignInstructor(bill, physics);
		System.out.println("Expected:\nBill");
		System.out.println(physics.getA());
		
		bob.assignGpa(tim, 3.7);
		System.out.println("Expected:\n3.7");
		System.out.println(tim.getGpa());
		
		System.out.println("Expected:\nPhysics");
		Instructor.getCourses(bill);
		
	}//end main method
}//end RegistrationTester class
