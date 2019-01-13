package edu.miamioh.wilfonjv;
//James Wilfong
//Dr. Stephan
//CSE 271, Section C

public class RecursiveFinder{

	public static void main(String[] args) {
		//test cases
		int[] arr = new int[]{3,1,4,21,2,4,9,8,5,6};
		System.out.println("Expected: 21");
		System.out.println(largestElement(arr));
		int[] arr2 = new int[]{4,5,8,11};
		System.out.println("Expected: 11");
		System.out.println(largestElement(arr2));
		int[] arr3 = new int[]{9,8,5,6,7,1};
		System.out.println("Expected: 9");
		System.out.println(largestElement(arr3));
	}//end main

	//returns the largest element of an array
	public static int largestElement(int[] arr){
		if(arr.length <=1)
			return arr[0];
		int[] newArr = new int[arr.length-1];
		for(int i = 0; i<arr.length-1;i++){
			newArr[i]=arr[i];
		}//end for loop
		return Math.max(arr[arr.length-1], largestElement(newArr));
	}//end largestElement
}//end RecursiveFinder class
