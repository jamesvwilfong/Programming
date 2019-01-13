package edu.miamioh.wilfonjv;
//James Wilfong
//Dr. Stephan
//CSE 271, Section C
/**
 * 
 * Describes a LectureHall using a given capacity and name
 *
 */
public class LectureHall {

	//instance variables
	private int capacity;
	private String name;

	/**
	 * @return capacity
	 */
	public int getCapacity() {
		return capacity;
	}//end getCapacity
	
	/**
	 * sets capacity
	 * @param capacity
	 */
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}//end setCapacity

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
	 * formats the LectureHall
	 * @param capacity
	 * @param name
	 */
	public LectureHall(int capacity, String name){
		this.setCapacity(capacity);
		this.setName(name);
	}//end LectureHall constructor
	
	/**
	 * overrides the toString method
	 */
	public String toString(){
		return this.name;
	}//end toString
}//end LectureHall class
