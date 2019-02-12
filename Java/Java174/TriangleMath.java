// Name: James Wilfong
// Instructor: Viji
// CSE 174, Section D
// Date: 9/23/2016
// FIlename: TriangleMath.java
// Description: Displays various calculations 
//              for a triangle using user input

import java.util.Scanner; // We need this for user input

public class TriangleMath {
   
   public static void main(String[] args) {
     
     // Declaring local variables for later use
     Scanner keyboardReader = new Scanner(System.in); 
     String triangle;
     double x1, y1, x2, y2, x3, y3;
     double side1, side2, side3;
     double perimeter;
     
     // Get name of triangle
     System.out.print("Enter a three letter name for your triangle: ");
     triangle = keyboardReader.next();
     
     triangle = triangle.toUpperCase();
     
     char vertex1 = triangle.charAt(0);
     char vertex2 = triangle.charAt(1);
     char vertex3 = triangle.charAt(2);
     
     // Get coordinates of triangle
     System.out.print("Coordinates of vertex " + vertex1 + ":");
     x1 = keyboardReader.nextDouble();
     y1 = keyboardReader.nextDouble();
     System.out.print("Coordinates of vertex " + vertex2 + ":");
     x2 = keyboardReader.nextDouble();
     y2 = keyboardReader.nextDouble();
     System.out.print("Coordinates of vertex " + vertex3 + ":");
     x3 = keyboardReader.nextDouble();
     y3 = keyboardReader.nextDouble();
     
     System.out.println();
     System.out.println("--- Side lengths ---");
     
     side1 = Math.sqrt(Math.pow(x2-x1,2)+Math.pow(y2-y1,2));
     side2 = Math.sqrt(Math.pow(x3-x2,2)+Math.pow(y3-y2,2));
     side3 = Math.sqrt(Math.pow(x1-x3,2)+Math.pow(y1-y3,2));
     
     System.out.print(vertex1);
     System.out.print(vertex2);
     System.out.printf(": %.3f%n", side1);
     System.out.print(vertex2);
     System.out.print(vertex3);
     System.out.printf(": %.3f%n", side2);
     System.out.print(vertex3);
     System.out.print(vertex1);
     System.out.printf(": %.3f%n", side3);
     
     System.out.println();
     System.out.println("--- Other measures ---");
     
     // Perimeter
     perimeter = side1 + side2 + side3;
     System.out.printf("Perimeter      = %.3f%n", perimeter);
     
     // Area
     double s = .5*perimeter;
     double area = Math.sqrt(s*(s-side1)*(s-side2)*(s-side3));
     System.out.printf("Area           = %.3f%n", area);
     
     // Centroid
     double centroidx, centroidy;
     centroidx = (x1 + x2 + x3)/3.0;
     centroidy = (y1 + y2 + y3)/3.0;
     System.out.printf("Centroid       = (%.3f",centroidx);
     System.out.printf(", %.3f",centroidy);
     System.out.println(")");
     
     // Incircle radius
     double circleRadius = Math.sqrt(((s-side1)*(s-side2)*(s-side3))/s);
     System.out.printf("Incircle radius = %.3f%n", circleRadius);
     
     // Incircle area
     double circleArea = Math.PI*Math.pow(circleRadius,2);
     System.out.printf("Incircle area   = %.3f%n", circleArea);
         
   }
}
