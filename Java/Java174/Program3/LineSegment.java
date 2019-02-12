// Name: James Wilfong
// Instructor: Viji
// CSE 174, Section D
// Date: 9/16/2016
// FIlename: LineSegment.java
// Description: write a program that asks the user to enter the 
//              coordinates of two points, then display those points,
//              the midpoint, and the slope of the segment 
//              that joins those points

import java.util.Scanner; // We need this for user input

public class LineSegment {
   
   public static void main(String[] args) {
      
      Scanner keyboardReader = new Scanner(System.in);
      double point1x, point1y;
      double point2x, point2y;
      double midPointx, midPointy, slope;
      
      // Get coordinates of point 1
      System.out.print("POINT 1: Enter x and y: ");
      point1x = keyboardReader.nextDouble();
      point1y = keyboardReader.nextDouble();
      
      // Get coordinates of point 2
      System.out.print("POINT 2: Enter x and y: ");
      point2x = keyboardReader.nextDouble();
      point2y = keyboardReader.nextDouble();
      
      System.out.println("Your points: (" + point1x + ", " + point1y + ") and (" + point2x + ", " + point2y + ")");
      
      // Calculate Midpoint
      midPointx = ( point1x + point2x ) / 2;
      midPointy = ( point1y + point2y ) / 2;
      
      System.out.println("Midpoint: (" + midPointx + ", " + midPointy + ")");
      
      // Calculate Slope
      slope = ( point2y - point1y ) / ( point2x - point1x );
      
      System.out.println("Slope: " + slope);
   }
}
