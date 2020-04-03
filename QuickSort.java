package com.Sorting;
import java.util.Random;

/**
 * Class to hold and test the quick sort algorithm
 * Quick sort is an efficient in place sorting algorithm that
 * performs 2-3x faster than merge sort and heapsort if implemented well.
 * 
 * Quick sort on averages takes O(n log n) comparisons to sort a list of size n
 * but O(n ^2) in the worst case
 * 
 * Quick sort is a divide and conquer algorithm that divides an array of size n into 
 * subarrays of size n / 2 and sorts them recursively
 * STEPS:
 * 1. Choose a pivot to split the array around 
 * 2. Partition the array around the pivot to create two new arrays 
 * 		(reorder the array so that every element after the pivot is greater than 
 * 		 the pivot and every element before the the pivot is less than the pivot)
 * 3. Recursively do this until everything is sorted
 * 
 * The beautiful thing about quick sort is it is a comparison sort algorithm
 * so as long as there is a less-than relation within the data being sorted 
 * it can be used.
 * @author Deron Washington II
 * Last Updated: 3/27/20
 *
 */
public class QuickSort
{

	/**
	 * Method to swap the elements at the indexes
	 * specified by the parameters
	 * @param array   = array to swap the elements
	 * @param index1 = index of first element to be swapped
	 * @param index2 = index of second element to be swapped
	 */
	public static void swap(int[] array, int index1, int index2)
	{
		if (index1 != index2)
		{
			int temp = array[index1];
			array[index1] = array[index2];
			array[index2] = temp;
		}
	}

	/**
	 * Method to partition the elements in array around the pivot
	 * so that every entry to the left of the pivot is less than the pivot
	 * and so that every entry to the right of the pivot is greater than
	 * the pivot
	 * @param array  = array to partition
	 * @param pivot   = value of the pivot
	 * @param sIndex = starting Index to partition around
	 * @param eIndex = ending Index to partition around (location of pivot)
	 * @return 
	 * 				= the index of the pivot
	 */
	public static int partition(int[] array, int pivot, int sIndex, int eIndex)
	{
		int currStart = sIndex;
		int currEnd = eIndex - 1;
		boolean done = false;

		
		while (done == false)
		{
			// if the left reference is greater than or equal to the
			// right reference then left reference passed the right reference
			// so you need to insert the pivot at the left reference which is now
			// on the right (direction) side of the pivot so everything is now in
			// the correct partitions
			if (currStart > currEnd)
			{
				if (array[currStart] > array[eIndex])
					swap(array, currStart, eIndex);
				done = true;
			}

			// if left reference's value is less than the pivot value it is in the correct 
			// partition so move the reference to the next spot
			else if (array[currStart] <= pivot)
				currStart++;

			// if right reference's value is greater than the pivot value it is in the 
			// correct partition so move the reference to the next spot
			else if (array[currEnd] >= pivot)
				currEnd--;
			
			// if right reference's value is less than pivot value and the   
			// left reference's value is greater than pivot value then both 
			// reference values are in the wrong partitions so swap them
			else if (array[currStart] > pivot && array[currEnd] < pivot)
				swap(array, currStart, currEnd);

		}

		// return the index of the pivot
		return currStart;
	}

	/**
	 * Method to create random pivot between starting Index in 
	 * the array and the ending Index
	 * @param array   = array to partition
	 * @param sIndex = index to start looking for a pivot to partition around
	 * @param eIndex = index to stop looking for a pivot to partition around
	 */
	public static int randomPivot(int[] array, int sIndex, int eIndex)
	{
		// choose random pivot
		int pivotIndex = -1;
		int size = (eIndex - sIndex) + 1;
		Random rand = new Random();

		// random pivot between sIndex and eIndex
		pivotIndex = rand.nextInt(size) + sIndex;

		// swap the pivot and the last element
		swap(array, pivotIndex, eIndex);

		// partition the array around the pivot & return the pivot's index
		return partition(array, array[eIndex], sIndex, eIndex);

	}

	/**
	 * Method to partition around the last element
	 * @param array   = array to partition
	 * @param sIndex = index to start looking for a pivot to partition around
	 * @param eIndex = index to stop looking for a pivot to partition around
	 */
	public static int lastElementPivot(int[] array, int sIndex, int eIndex)
	{
		// choose last element as pivot
		int pivotIndex = eIndex;

		// partition the array around the pivot & return the pivot's index
		return partition(array, array[eIndex], sIndex, eIndex);
	}

	/**
	 * Method to implement the quick sort algorithm
	 * (this version uses a random partition to minimize the affects 
	 * of the worst case of quick sort)
	 * @param array
	 * @param sIndex
	 * @param eIndex
	 */
	public static void quickSort(int[] array, int sIndex, int eIndex)
	{
		if (sIndex < eIndex)
		{
			// partition
			int pivotIndex =  lastElementPivot(array, sIndex, eIndex);
									//randomPartition(array, sIndex, eIndex);
			// call quick sort on the list smaller than the pivot 
			quickSort(array, sIndex, pivotIndex - 1);

			// call quick sort on the list larger than the pivot
			quickSort(array, pivotIndex + 1, eIndex);
		}
	}


	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		int[] arr = {0,9,8, 8, 9, 45, 7, 2, 33, 44, 17};

		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + "\n");

		quickSort(arr, 0, arr.length - 1);

		for (int j = 0; j < arr.length; j++)
			System.out.println(arr[j]);

	}

}
