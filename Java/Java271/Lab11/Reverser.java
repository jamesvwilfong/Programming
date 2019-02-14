package edu.miamioh.wilfonjv;
//James Wilfong
//Dr. Stephan
//CSE 271, Section C

public class Reverser {

	public static void main(String[] args) {
		//test cases
		System.out.println("Expected: atnegaM");
		System.out.println(reverse("Magenta"));
		System.out.println("Expected: 987654321");
		System.out.println(reverse("123456789"));
		System.out.println("Expected: ?uoy era woH");
		System.out.println(reverse("How are you?"));
	}//end main
	//returns the reverse of a string 
	public static String reverse(String text){
		if(text.length()<=1)
			return text;
		return reverse(text.substring(1))+text.charAt(0);
	}//end reverse
}//end Reverser class
