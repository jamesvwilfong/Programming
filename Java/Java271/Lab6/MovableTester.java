//James Wilfong
//Dr.Stephan
//CSE 271, Section C
public class MovableTester {

	public static void main(String[] args) {
		Movable m1 = new MovablePoint(5,6,10,12); //upcast
		System.out.println(m1);
		m1.moveLeft();
		System.out.println(m1);
		m1.moveDown();
		System.out.println(m1);
		m1.moveRight();
		System.out.println(m1);
		Movable m2 = new MovableCircle(2,1,2,20,50); // upcast. Constructor takes in 4 point values and
		//radius
		System.out.println(m2);;
		m2.moveRight();
		System.out.println(m2);
		m2.moveDown();
		System.out.println(m2);
		m2.moveLeft();
		System.out.println(m2);
		
		Movable[] points = new Movable[2];
		points[0] = m1;
		points[1] = m2;
		chachaSlide(points);
		System.out.println("ChaChaSlide: \n" + m1 + m2);
	}//end main
	
	public static void chachaSlide(Movable[] points){
		for(Movable a : points)
		{
			a.moveLeft();
			a.moveRight();
			a.moveDown();
			a.moveUp();
			a.moveLeft();
			a.moveDown();
			a.moveUp();
			a.moveRight();
			a.moveLeft();
			a.moveDown();
			a.moveUp();
			a.moveUp();
		}//end for each loop
	}//end chachaSlide
}//end MovableTester class
