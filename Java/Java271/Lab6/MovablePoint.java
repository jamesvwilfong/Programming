//James Wilfong
//Dr.Stephan
//CSE 271, Section C
public class MovablePoint implements Movable {
	
	//instance variables
	private int x,y;
	private int xSpeed,ySpeed;
	
	public MovablePoint(int x, int y, int xSpeed, int ySpeed){
		this.setxSpeed(xSpeed);
		this.setySpeed(ySpeed);
		this.x=x;
		this.y=y;
	}//end MovablePoint constructor
	
	public String toString(){
		return "x location: " + x + "\ny location: " 
				+ y + "\nspeed in x direction: " + xSpeed +
				"\nspeed in y direction: " + ySpeed;
	}//end toString

	public int getxSpeed() {
		return xSpeed;
	}//end getxSpeed

	public void setxSpeed(int xSpeed) {
		if(xSpeed>0)
		this.xSpeed = xSpeed;
	}//end setxSpeed

	public int getySpeed() {
		return ySpeed;
	}//end getySpeed

	public void setySpeed(int ySpeed) {
		if(ySpeed>0)
		this.ySpeed = ySpeed;
	}//end setySpeed

	public void moveUp() {
		this.y=y+ySpeed;
	}//end moveUp

	public void moveDown() {
		this.y=y-ySpeed;
	}//end moveDown

	public void moveLeft() {
		this.x=x-xSpeed;
	}//end moveLeft

	public void moveRight() {
		this.x=x+xSpeed;
	}//end moveRight
}//end MovablePoint class
