//James Wilfong
//Dr.Stephan
//CSE 271, Section C
public class MovableCircle implements Movable {
	
	//instance variables
	private MovablePoint a;
	private int radius;
	
	public MovableCircle(int x, int y, int xSpeed, int ySpeed, int radius){
		this.a =new MovablePoint(x,y,xSpeed,ySpeed);
		this.radius = radius;
	}//end MovableCircle constructor
	
	public String toString(){
		return "\nCenter: \n"+a.toString()+"\nradius: "+this.radius;
	}//end toString

	public void moveUp() {
		a.moveUp();
	}//end moveUp

	public void moveDown() {
		a.moveDown();
	}//end moveDown

	public void moveLeft() {
		a.moveLeft();
	}//end moveLeft

	public void moveRight() {
		a.moveRight();
	}//end moveRight
}//end MovableCircle class
