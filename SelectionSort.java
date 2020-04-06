package com.Sorting;

/**
 * Class to house selection sort algorithm
 * 
 * Separates the list it is sorting into unsorted and sorted
 * when starting the entire list is considered the unsorted list
 * and sorted is empty. Then as you go through the list, once
 * the smallest element in the unsorted portion is found swap
 * the it with the leftmost portion of the unsorted portion 
 * which essentially places it in the correct order
 * 
 * @author Deron Washington II
 *
 */
public class SelectionSort
{

	/**
	 * Determine the minimum between the two parameters
	 * @param <T> = any object that implements the Comparable interface
	 * @param m1 = possible minimum
	 * @param m2 = possible maximum
	 * @return
	 * 				= the smallest of the two parameters
	 * 				= null if both objects (parameters) are null
	 */
	public static <T extends Comparable<T>> T findMin(T m1, T m2)
	{
		
		// check  for null parameters
		if (m1 == null)
			{
			if (m2 == null)
				return null;
			
			else
				return m2;
			}
		
		else if (m2 == null)
			return m1;
			
		
		// determine minimum
		if (m1.compareTo(m2) >= 0)
			return m2;
			
		else
			return m1;
	}
	
	public static <T extends Comparable<T>> void selectionSort(T[] arr)
	{
		T localMin = arr[0];
		T min = arr[0];
		int minIndex = 0;
		
		// the first coordinate will be where the list starts 
		// and the second will be where the list ends
		int unsortedStart = 0;

		// update sorted list
		for (int i = 0; i < arr.length; i++)
		{
			// find minimum in unsorted list
			for (int j = unsortedStart; j < arr.length; j++)
			{
				if (j == unsortedStart)
				{
					localMin = arr[j];
					min = arr[j];
					minIndex = j;
				}
					
				localMin = findMin(min, arr[j]);
					
				if (min.compareTo(localMin) > 0)
				{
					min = localMin;
					minIndex = j;
				}
					
			}
			
			// swap minimum of unsorted list at the end of sorted list
			QuickSortGeneric.swap(arr, minIndex, i);
			unsortedStart++;
			
					
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
		selectionSort(intArr);
		QuickSortGeneric.printArray(intArr, afterMessage);

		// Character array testing
		QuickSortGeneric.printArray(charArr, beforeMessage);
		selectionSort(charArr);
		QuickSortGeneric.printArray(charArr, afterMessage);

		// String array testing
		QuickSortGeneric.printArray(stringArr, beforeMessage);
		selectionSort(stringArr);
		QuickSortGeneric.printArray(stringArr, afterMessage);

	}

}
