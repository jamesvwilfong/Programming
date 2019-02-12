// James Wilfong
// Dr.Stephan
// CSE 271, Section C
// Takes a random array, sorts it, and writes it to a .txt file.
// Returns the number of odd numbers from the sorted array.
// Reads a words.txt file, and returns the number of vowels,
// consonants, and special characters from that file.
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;


public class Lab_01_Tester {

	public static void main(String[] args) throws FileNotFoundException {

		PrintWriter PW = new PrintWriter(new File("Lab_01_nums.txt"));

		int[] newArr = Lab_01_ArrayUtilities.buildIntArray(20, 10, 29);

		System.out.println(Arrays.toString(newArr));
		PW.println(Arrays.toString(newArr));
		
		for(int i = 0; i<newArr.length;i+=2){
			Lab_01_ArrayUtilities.swap(newArr, i, i+1);
		} // end for loop
		
		System.out.println(Arrays.toString(newArr));
		PW.println(Arrays.toString(newArr));

		Arrays.sort(newArr);
		System.out.println(Arrays.toString(newArr));
		PW.println(Arrays.toString(newArr));
		PW.close();

		int count = 0;
		for(int i = 0; i<newArr.length; i++){
			if(newArr[i] > 0 && newArr[i] % 2 !=0)
				count++;
		}// end for loop
		System.out.println("Odd values: "+count);

		int vowel = 0;
		int cons = 0;
		int special = 0;
		File inputFile = new File("words.txt");
		Scanner in = new Scanner(inputFile);
		in.useDelimiter("");
		
		while(in.hasNext())
		{
			char ch = in.next().charAt(0);
			if(Character.isWhitespace(ch))
				continue;
			else if(Character.isLetter(ch))
			{
				if(ch == 'a' || ch== 'e' || ch== 'i' || ch== 'o' || ch== 'u')
					vowel+=1;
				else
					cons+=1;	
			}// end if statement
			else 
				special+=1;
		}// end while loop
		
		in.close();
		System.out.printf("There were " + vowel + " vowels, " 
				+ cons + " consonants and " + special 
				+ " other characters in the text file.");
	}// end main method
}// end Lab_01_Tester class
