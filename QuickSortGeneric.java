package com.Sorting;
import java.util.Random;
/**
 * Class that houses and tests the quick sort algorithm that works for any
 * comparable objects
 * @author Deron Washington II
 * Last Updated: 4/1/20
 * @param <T> = an object that can be represented using a less than relation and 
 * 						     implements Comparable
 */
public class QuickSortGeneric<T extends Comparable<T>>
{

	/**
	 * Method to swap the values located at index1 and index2 in the array parameter
	 * @param <T>       = an object that can be represented using a less than relation and 
	 * 								  implements Comparable
	 * @param arrayObj  = an array of objects that implements Comparable
	 * @param index1     = 1st index to swap in the array
	 * @param index2		= 2nd index to swap in the array
	 */
	public static <T extends Comparable<T>> void swap(T[] arrayObj, int index1, int index2)
	{
		T temp = arrayObj[index1];
		arrayObj[index1] = arrayObj[index2];
		arrayObj[index2] = temp;
	}
	
	/**
	 * Method to create random pivot between starting Index in 
	 * the array and the ending Index
	 * @param <T>    = an object that can be represented using a less than relation and 
	 * 							    implements Comparable
	 * @param array   = array to partition
	 * @param sIndex = index to start looking for a pivot to partition around
	 * @param eIndex = index to stop looking for a pivot to partition around
	 * @return
	 * 				= the index of the pivot
	 */
	public static <T extends Comparable<T>> int randomPivot(T[] arrayObj, int sIndex, int eIndex)
	{
		Random rand = new Random();
		int size = (eIndex - sIndex) + 1;
		int pivotIndex = rand.nextInt(size) + sIndex;
		
		// swap the value of the pivot with the value of the last element
		swap(arrayObj, pivotIndex, eIndex);
		
		return partition(arrayObj, sIndex, eIndex);
	}
	
	
	/**
	 * Method to partition around the last element
	 * @param <T>    = an object that can be represented using a less than relation and 
	 * 							    implements Comparable
	 * @param array   = array to partition
	 * @param sIndex = index to start looking for a pivot to partition around
	 * @param eIndex = index to stop looking for a pivot to partition around
	 */
	public static <T extends Comparable<T>> int lastElementPivot(T[] arrayObj, int sIndex, int eIndex)
	{
		// choose last element as pivot
		int pivotIndex = eIndex;

		// partition the array around the pivot & return the pivot's index
		return partition(arrayObj, sIndex, eIndex);
	}
	
	/**
	 * Method to partition the arrayObj parameter around the pivot 
	* @param <T>        = an object that can be represented using a less than relation and 
	 * 								   implements Comparable
	 * @param arrayObj  = an array of objects that implements Comparable
	 * @param sIndex     = starting Index of the array
	 * @param eIndex		= ending Index of the array
	 * @return
	 * 				= the index of the pivot
	 */
	public static <T extends Comparable<T>> int partition(T[] arrayObj, int sIndex, int eIndex)
	{
		int currStart = sIndex;
		int currEnd = eIndex - 1;
		T pivot = arrayObj[eIndex];
		
		while(currStart <= currEnd)
		{
			if (arrayObj[currStart].compareTo(pivot) < 0)
				currStart++;
			
			else if (arrayObj[currEnd].compareTo(pivot) > 0)
				currEnd--;
			
			else if (arrayObj [currStart].compareTo(pivot) == 0)
				currStart++;
			
			else if (arrayObj[currEnd].compareTo(pivot) == 0)
				currEnd--;
				
			else if (arrayObj[currStart].compareTo(pivot) > 0
					&& arrayObj[currEnd].compareTo(pivot) < 0)
					swap(arrayObj, currStart, currEnd);
		}
		
		// place pivot in correct position
		swap(arrayObj, currStart, eIndex);
		
		return currStart;
	}
	
	/**
	 * Quick sort algorithm to be used for any objects that
	 * can be compared
	 * @param <T>       = an object that can be represented using a less than relation and 
	 * 								   implements Comparable
	 * @param arrayObj  = an array of objects that implements Comparable
	 * @param sIndex     = starting Index of the array
	 * @param eIndex		= ending Index of the array
	 */
	public static <T extends Comparable<T>> void quickSort(T[] arrayObj, int sIndex, int eIndex)
	{
		if (sIndex < eIndex)
		{
			// find the pivot
			int pivotIndex = randomPivot(arrayObj, sIndex, eIndex);
			
			// sort the left side of the pivot
			quickSort(arrayObj, sIndex, pivotIndex - 1);
			
			// sort the right side of the pivot
			quickSort(arrayObj, pivotIndex + 1, eIndex);
		}
	}
	
	/**
	 * Method to output the array to the console 
	 * @param <T>       = any data type
	 * @param arrayObj = an array of <T> objects to print
	 */
	public static <T> void printArray(T[] arrayObj)
	{
		System.out.println("Printing array: ");
		
		for (int i = 0; i < arrayObj.length; i++)
			System.out.print(arrayObj[i] + " ");
		
		System.out.printf("%n%n");
	}
	
	/**
	 * Method to output the array to the console 
	 * @param <T>       = any data type
	 * @param arrayObj = an array of <T> objects to print
	 */
	public static <T> void printArray(T[] arrayObj, String message)
	{
		System.out.println("Printing array " + message + ": ");
		
		for (int i = 0; i < arrayObj.length; i++)
			System.out.print(arrayObj[i] + " ");
		
		System.out.printf("%n%n");
	}
	
	
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Integer[] intArr = {0,9,8, 45, 7, 2, 33, 44, 17};
		Character[] charArr = {'z', 'c', 'x', 'd', 'e', 'a', 'f', 't', 'b'};
		String[] stringArr = {"temp", "Temp", "abc", "def", "Dgoat", "otis", "aaaaaaz", "aaz"};
		
		
		// generic quick sort testing 
		String beforeMessage = "Before sort ";
		String afterMessage = "After sort ";
		
		// Integer array testing
		printArray(intArr, beforeMessage);
		quickSort(intArr, 0, intArr.length - 1);
		printArray(intArr, afterMessage);
		
		// Character array testing
		printArray(charArr, beforeMessage);
		quickSort(charArr, 0, charArr.length - 1);
		printArray(charArr, afterMessage);
		
		// String array testing
		printArray(stringArr, beforeMessage);
		quickSort(stringArr, 0, stringArr.length - 1);
		printArray(stringArr, afterMessage);
		
		
	}

}
