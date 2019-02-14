package edu.miamioh.wilfonjv;
//James Wilfong
//Dr. Stephan
//CSE 271, Section C
public class SelectionSorter {
	/**
	 * Sorts an arrray, using selection sort.
	 * @param a the array to sort
	 */
	public static void sort(int[] a)
	{
		for(int i = 0; i< a.length-1;i++)
		{
			int minPos = minimumPosition(a,i);
			ArrayUtil.swap(a, minPos, i);
		}//end for loop
	}//end sort

	/**
	 * Finds the largest element in a tail range of the array.
	 * @param a the array to sort
	 * @param from the first position in a to compare
	 * @return the position of the largest element in the
	 * range a[from]...a[a.length-1]
	 */
	private static int minimumPosition(int[] a, int from)
	{
		int minPos = from;
		for(int i = from + 1; i<a.length;i++)
		{
			if(a[i]>a[minPos]) {minPos=i;}
		}//end for loop
		return minPos;
	}//end minimumPosition
}//end SelectionSorter class
