// James Wilfong
// Dr. Stephan
// CSE 271, Section C

import java.util.Scanner;
// needed to read user input

public class Lab2FloatingPoint {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int bad = 0; //keeps track of wrong input
		int sum = 0; //keeps track of the sum of correct input 
		while(in.hasNext()) {
			try{
				String input = in.nextLine();
				float f = Float.parseFloat(input);
				sum += f;
				bad=0;
			} // end try
			catch(NumberFormatException e) 
			{
				bad++;
				if(bad==2)
					break;
			} // end catch NumberFormatException

		} // end while loop
		in.close();
		System.out.println();
		System.out.print("(final total will be " + sum + ")");	
	} // end main
} // end Lab2FloatingPoint class
