package edu.miamioh.wilfonjv;

/**
 * @author James Wilfong
 * Dr. Stephan
 * CSE 271, Section C
 */
public class Queen{
	
	//instance variables
	private int x;
	private int y;
	
	/**
	 * @return x position of Queen
	 */
	public int getX() {
		return x;
	}//end getX
	/**
	 * @param x position of Queen
	 */
	public void setX(int x) {
		this.x = x;
	}//end setX
	/**
	 * @return y position of Queen
	 */
	public int getY() {
		return y;
	}//end getY
	/**
	 * @param y position of Queen
	 */
	public void setY(int y) {
		this.y = y;
	}//end setY
	
	/**
	 * @param x position of Queen
	 * @param y position of Queen
	 */
	public Queen(int x, int y){
		this.setX(x);
		this.setY(y);
	}//end Queen constructor

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Queen other = (Queen) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}//end equals
}//end Queen class
