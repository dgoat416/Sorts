import java.util.InputMismatchException;
import java.util.Scanner;

import com.Sorting.QuickSortGeneric;

public class BinarySearch
{

	public static <T extends Comparable<T>> int binarySearch(T[] array, T find)
	{
		// sort it first
		QuickSortGeneric.quickSort(array, 0, array.length - 1);

		boolean found = false;
		int findIndex = -1;
		int min = 0;
		int max = array.length - 1;
		int inquiry = -1;
		int size = max - min + 1;

		while (!found && size >= 0)
		{

			if (size > 2)
				inquiry = (max + min) / 2;	

			else if (size <= 2)
			{
				if ((int)array[max] == (int)find)
				{
					found = true;
					findIndex = max;
				}

				else if ((int)array[min] == (int)find)
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


			if (array[inquiry] == find)
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

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Integer[] arr = {0, 4, 5, 5, 6, 7, 7, 8, 45, 65, 5555, 66, 66, 33, 3, 6, 7, 8, 9};
		Scanner read = new Scanner(System.in);
		Integer find = null;

		QuickSortGeneric.printArray(arr, "Before sort ");
		System.out.print("\nWhich number do you want to search for within the given list? ");

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

		int index = binarySearch(arr, find);
		
		QuickSortGeneric.printArray(arr, "After sort ");

		if (index == -1)
		{
			System.out.printf("%d doesn't exist in this list.", find);
			System.exit(-1);
		}

		System.out.printf("%n%nThe number %d exists at index %d in the list.", find, index);
	}

}
