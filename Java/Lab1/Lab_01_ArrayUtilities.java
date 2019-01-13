// James Wilfong
// Dr. Stephan
// CSE 271, Section C
// a method used to build a random array,
// and a swap() method to swap elements 
// within an array
public class Lab_01_ArrayUtilities {

	public static int[] buildIntArray(int length, int fromNum, int toNum) {

		int[] newArr = new int[length];

		for (int i = 0; i < newArr.length; i++) {
			newArr[i] = (int) (fromNum + (toNum+1 - fromNum) * Math.random());
		}//end for loop
		return newArr;
	} //end buildIntArray 

	public static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i]=nums[j];
		nums[j]= temp;		
	} //end swap 
}//end Lab_01_ArrayUtilities class
