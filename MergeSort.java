package com.Sorting;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Class to hold the merge sort algorithm
 * 
 * Divide the array into n sublists each of size 1 and then
 * Conquer the array by merging the n sublists back together
 * in the correct order
 * @author Deron Washington II
 *
 */
public class MergeSort
{

	/**
	 * Method to merge two arrays together in sorted order (ascending order)
	 * @param <T> = any object that implements the comparable interface
	 * @param left = first array to merge
	 * @param right = second array to merge
	 * @return
	 * 				= a single array that contains all elements of left and right
	 * 				   in sorted order (ascending order)
	 */
	public static <T extends Comparable<T>> T[] merge(T[] left, T[] right)
	{
		// merged array that will be returned
		ArrayList<T> merged = new ArrayList<T>();
		int iLeft = 0;
		int iRight = 0;

		while (iLeft <= left.length || iRight <= right.length)
		{

			// is left array now all added to merged array?
			if (iLeft == left.length)
			{
				// empty right array into merged array
				for ( /*iRight = iRight*/; iRight < right.length; iRight++	)
					merged.add(right[iRight]);

				break;
			}

			// is right array now all added to merged array?
			else if (iRight == right.length)
			{
				// empty left array into merged array
				for(/*iLeft = iLeft*/; iLeft < left.length; iLeft++)
					merged.add(left[iLeft]);

				break;
			}

			// ADD THE SMALLEST VALUE BETWEEN LEFT AND RIGHT ARRAY
			// THEN UPDATE THE NECESSARY "POINTER" (iLeft or iRight)

			// iLeft  < jRight
			if (left[iLeft].compareTo(right[iRight]) < 0)	
			{
				merged.add(left[iLeft]);
				iLeft++;
			}

			// iLeft > jRight
			else if (left[iLeft].compareTo(right[iRight]) > 0)
			{
				merged.add(right[iRight]);
				iRight++;
			}

			// iLeft == jRight
			else if (left[iLeft].compareTo(right[iRight]) == 0)
			{
				// add both and update
				merged.add(left[iLeft]);
				merged.add(right[iRight]);
				iLeft++;
				iRight++;
			}

		} // end while loop


		return merged.toArray(left);
	}

	/**
	 * Method to divide the array into two subarrays 
	 * @param <T> = any object that implements the comparable interface
	 * @param arr = starting array (input array)
	 * @param start = starting index of subarray 
	 * @param end = ending index of subarray
	 */
	public static <T extends Comparable<T>> T[] divide(T[] arr, int start, int end)
	{
		T[] left;
		T[] right;

		int mid = start + (end - start) / 2;



		// array of length 1
		if (end == start)
			return Arrays.copyOfRange(arr, start, end + 1);

		else
		{
			// divide left side
			left = divide(arr, start, mid);

			// divide right side
			right = divide(arr, mid + 1, end);

			// merge
			return merge(left, right);

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
		intArr = divide(intArr, 0, intArr.length - 1);
		QuickSortGeneric.printArray(intArr, afterMessage);

		// Character array testing
		QuickSortGeneric.printArray(charArr, beforeMessage);
		charArr = divide(charArr, 0, charArr.length - 1);
		QuickSortGeneric.printArray(charArr, afterMessage);

		// String array testing
		QuickSortGeneric.printArray(stringArr, beforeMessage);
		stringArr = divide(stringArr, 0, stringArr.length - 1);
		QuickSortGeneric.printArray(stringArr, afterMessage);
	}

}
