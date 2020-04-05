package com.Searches;
import java.util.InputMismatchException;
import java.util.Scanner;

// user defined
import com.Sorting.QuickSortGeneric;

/**
 * Binary Search Algorithm to determine the location
 * of an element within a list (MUST BE SORTED FIRST)
 * 
 * Compare what you are trying to find
 * with the middle element in the list. 
 * If the middle element is less than the element to be found
 * then you restrict the list to only include everything greater than 
 * the middle element which will be the right side of the list if ordered in ascending order
 * and vice versa if the middle element is greater than the element to be found
 * Essentially you are reducing the list size to check within by half 
 * 
 * Once sorted the algorithm will have to check =[ log (base 2) n] times 
 * Example if the list has 256 possible elements within the list then it will take 8 tries max
 * to find the element because 2 raised to the 8th power = 256 this works because you
 * will be eliminating half of the list with each guess
 * 
 * This implementation uses Quick Sort
 * @author Deron Washington II
 * Last Updated: 4/2/2020
 *
 */
public class BinarySearch
{

	/**
	 * Method to perform the binary search algorithm
	 * @param <T> = any object that implements the Comparable interface
	 * @param array = list to find the specified element 
	 * @param find   = the element to find within the array
	 * @return
	 * 				= the location of the element within the array 
	 */
	public static <T extends Comparable<T>> int binarySearch(T[] array, T find)
	{
		// sort it first
		QuickSortGeneric.quickSort(array, 0, array.length - 1);

		boolean found = false;
		int findIndex = -1;
		int min = 0;
		int max = array.length - 1;
		
		// represents the index of the array we are checking
		int inquiry = -1;
		int size = max - min + 1;

		while (!found && size >= 0)
		{			
			// cut the list in half and check if it matches find
			if (size > 2)
				inquiry = (max + min) / 2;	

			// when list is 2 or less just check it the bruteforce way
			else if (size <= 2)
			{
					if (array[max].compareTo(find) == 0)
					{
						found = true;
						findIndex = max;
					}
	
					else if (array[min].compareTo(find) == 0)
					{
						found = true;
						findIndex = min;
					}
	
					else
					{
						findIndex = -1;
					}
	
					break;
			}

			
			
			// how does the inquiry compare to what we are looking for?
			if (array[inquiry].compareTo(find) == 0)
			{
				found = true;
				findIndex = inquiry;
			}

			else if (array[inquiry].compareTo(find) < 0)
			{				
					if (inquiry < array.length - 2)
						min = inquiry++;
					else
						min = array.length - 1;
			}

			else if (array[inquiry].compareTo(find) > 0)
			{
					if (inquiry > 0)
						max = inquiry--;
					else
						max = 0;
			}

			// update size of the list
			size = max - min + 1;

		}

		if (found == false)
			findIndex = -1;

		return findIndex;
	}

	/**
	 * Method to determine if the string represents a number
	 * @param str = string 
	 * @return
	 * 				= true if the string represents a number
	 * 				= false otherwise
	 */
	public static boolean isNumeric(String str)
	{
		
		try
		{	
			Double.parseDouble(str);
		}
		catch(NumberFormatException numFormatException)
		{
			return false;
		}
		
		
		return true;
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

		int index = binarySearch(intArr, find);
		
		QuickSortGeneric.printArray(intArr, "After sort ");

		if (index == -1)
		{
			System.out.printf("%d doesn't exist in this list.", find);
			System.exit(-1);
		}

		System.out.printf("%n%nThe number %d exists at index %d in the list.", find, index);


	}

}
