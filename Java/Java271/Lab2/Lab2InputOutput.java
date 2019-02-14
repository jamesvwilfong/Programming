// James Wilfong
// Dr. Stephan
// CSE 271, Section C

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Lab2InputOutput {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner keyboardReader = new Scanner(System.in);
		System.out.print("Name of output file: ");
		String outputFileName = keyboardReader.next();
		keyboardReader.close();
		// prompt user for output file name

		String input = args[0];
		File inputFile = new File(input);
		Scanner in = new Scanner(inputFile);
		PrintWriter output = new PrintWriter(new File(outputFileName));
		int lineNumber = 0;
		while(in.hasNextLine()){
			lineNumber++;
			String str = in.nextLine();
			output.println("/* " + lineNumber + " */ " + str);
		} //end while loop
		in.close();
		output.close();

	} //end main
} //end Lab2InputOutput class
