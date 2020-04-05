package com.Searches;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.Sorting.QuickSortGeneric;

/**
 * Class to house the Linear Search Algorithm
 * 
 * Search each item in the list starting from the beginning
 * and going to the end of the list
 * 
 * @author Deron Washington II
 *
 */
public class LinearSearch
{

	/**
	 * Method to implement the linear search algorithm
	 * @param <T> = any object that implements the Comparable interface
	 * @param arr = array to be searched
	 * @param find = element to find in the array
	 * @return
	 * 				= returns the index of find in arr
	 * 				= -1 if not found in arr
	 */
	public  static <T extends Comparable<T>>  int linearSearch(T[] arr, T find)
	{
		int size = arr.length;
		
		for (int i = 0; i < size; i++)
		{
			if (arr[i] == find)
				return i;
		}
		
		return -1;
	}
	
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
				// test arrays
				Integer[] intArr = {0, 4, 5, 5, 6, 7, 7, 8, 45, 65, 5555, 66, 66, 33, 3, 6, 7, 8, 9};
				Character[] charArr = {'z', 'c', 'x', 'd', 'e', 'a', 'f', 't', 'b'};
				String[] stringArr = {"temp", "Temp", "abc", "def", "Dgoat", "otis", "aaaaaaz", "aaz"};

				Scanner read = new Scanner(System.in);
				Integer find = null;
				
				QuickSortGeneric.printArray(intArr, "Before sort ");
				System.out.print("\nWhich element do you want to search for within the given list? ");

				while (find == null)
				{
					try
					{
						find = read.nextInt();
					}
					catch(InputMismatchException inputException)
					{
						inputException.printStackTrace();
						System.out.println("The input cannot be searched for within the array "
								+ "because you did not input an integer. Try again.\n\n");
						find = null;
						continue;
					}
					catch(Exception e)
					{
						e.printStackTrace();
						System.exit(-1);
					}
				}
					
				read.close();

				int index = linearSearch(intArr, find);
				
				QuickSortGeneric.printArray(intArr, "After sort ");

				if (index == -1)
				{
					System.out.printf("%d doesn't exist in this list.", find);
					System.exit(-1);
				}

				System.out.printf("%n%nThe number %d exists at index %d in the list.", find, index);


			}

}
