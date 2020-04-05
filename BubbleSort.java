package com.Sorting;

/**
 * Class to house the bubble sort algorithm
 * @author Deron Washington II
 * Last updated: 4/5/2020
 *
 */
public class BubbleSort
{
	
	/**
	 * Method to implement the bubble sort algorithm
	 * @param <T> = object that implements the Comparable interface
	 * @param arr = array to sort
	 */
	public static <T extends Comparable<T>>  void bubbleSort(T[] arr)
	{
		// can't sort empty list
		if (arr.length == 0)
			return;
		
		T curr = null;
		T next = null;
		int unsortedCells = arr.length;
		
	// sort until all cells are sorted
	while (unsortedCells >= 1)
	{
		// move the greatest value to it's position in the array
		for (int i = 0; i < unsortedCells - 1; i++)
		{
			// update current
			curr = arr[i];
			
			// update next
			next = arr[i + 1];
			
			// current > next?
			if (curr.compareTo(next) > 0)
				QuickSortGeneric.swap(arr, i, i + 1);
		}
		
		// update unsortedCells
		unsortedCells--;
	}
		
	}

	public static void main(String[] args)
	{
		// test arrays
				Integer[] intArr = {0, 4, 5, 5, 6, 7, 7, 8, 45, 65, 5555, 66, 66, 33, 3, 6, 7, 8, 9};
				Character[] charArr = {'z', 'c', 'x', 'd', 'e', 'a', 'f', 't', 'b'};
				String[] stringArr = {"temp", "Temp", "abc", "def", "Dgoat", "otis", "aaaaaaz", "aaz"};

				// generic quick sort testing 
				String beforeMessage = "Before sort ";
				String afterMessage = "After sort ";

				// Integer array testing
				QuickSortGeneric.printArray(intArr, beforeMessage);
				bubbleSort(intArr);
				QuickSortGeneric.printArray(intArr, afterMessage);

				// Character array testing
				QuickSortGeneric.printArray(charArr, beforeMessage);
				bubbleSort(charArr);
				QuickSortGeneric.printArray(charArr, afterMessage);

				// String array testing
				QuickSortGeneric.printArray(stringArr, beforeMessage);
				bubbleSort(stringArr);
				QuickSortGeneric.printArray(stringArr, afterMessage);

	}

}
