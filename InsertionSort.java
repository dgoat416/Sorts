package com.Sorting;
import java.util.ArrayList;

import com.Sorting.QuickSortGeneric;

/**
 * Class to house the insertion sort algorithm
 * 
 * Works by creating a new array and inserting the elements of the unsorted array
 * into the correct order in the new array
 * 
 * Optimize by possibly making comparison between start, median, and end 
 * with regards to element we are trying to add
 * 
 * @author Deron Washington II
 * Last Updated: 4/3/2020
 *
 */
public class InsertionSort
{

	/**
	 * Method to perform the insertion sort algorithm
	 * @param <T> = any object that implements the Comparable interface
	 * @param arr = array to be sorted
	 */
	public static <T extends Comparable<T>> void insertionSort(T[] arr)
	{
		// if arr is empty can't sort
		if (arr.length == 0)
			return;
			
		// use array list for dynamic inserting
		ArrayList<T> newArr = new ArrayList<T>();
		T add = null;
		int comparison = 0;

		for (int i = 0; i < arr.length; i++)
		{
			// initialize the value you are trying to add to the array
			add = arr[i]; 
			
			// add the first value or if add is greater than or equal to lastAdd add to array
			if (newArr.isEmpty())
			{
				newArr.add(add);
				continue;
			}
			
				
			// make the comparisons
			for (int j = 0; j < newArr.size(); j++)
			{
				comparison = newArr.get(j).compareTo(add);

				// if new arr value is greater than or equal to add value add it to the array
				if (comparison >= 0 )
				{
					newArr.add(j, add);
					break;
				}

				// if at the last index of the newArr and still haven't added add to the back
				else if (comparison < 0 && j == newArr.size() - 1)
					{
						newArr.add(add);
						break;
					}
			}

		}
		
		// copy new array to the parameter
		arr = newArr.toArray(arr);
	}

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		// test arrays
		Integer[] intArr = {0, 4, 5, 5, 6, 7, 7, 8, 45, 65, 5555, 66, 66, 33, 3, 6, 7, 8, 9};
		Character[] charArr = {'z', 'c', 'x', 'd', 'e', 'a', 'f', 't', 'b'};
		String[] stringArr = {"temp", "Temp", "abc", "def", "Dgoat", "otis", "aaaaaaz", "aaz"};

		// generic quick sort testing 
		String beforeMessage = "Before sort ";
		String afterMessage = "After sort ";

		// Integer array testing
		QuickSortGeneric.printArray(intArr, beforeMessage);
		insertionSort(intArr);
		QuickSortGeneric.printArray(intArr, afterMessage);

		// Character array testing
		QuickSortGeneric.printArray(charArr, beforeMessage);
		insertionSort(charArr);
		QuickSortGeneric.printArray(charArr, afterMessage);

		// String array testing
		QuickSortGeneric.printArray(stringArr, beforeMessage);
		insertionSort(stringArr);
		QuickSortGeneric.printArray(stringArr, afterMessage);
	}

}
