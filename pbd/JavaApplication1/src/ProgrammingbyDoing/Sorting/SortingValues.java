/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ProgrammingbyDoing.Sorting;

public class SortingValues
{
//Use nested loops, an if statement, and some "swapping" code to rearrange the values in the array 
//so that they're in order from smallest to largest. 

	public static void main( String[] args )
	{
		int[] arr = { 45, 87, 39, 32, 93, 86, 12, 44, 75, 50 };
                int swap = 0;
		// Display the original (unsorted values)
		System.out.print("before: ");
		for ( int i=0; i<arr.length; i++ )
			System.out.print( arr[i] + " " );
		System.out.println();

		// Swap the values around to put them ascending order.
		
		for (int i = 0 ; i < arr.length - 1; i++)
		{
			for (int j = i+1 ; j < arr.length ; j++)
			{
				if (arr[i] > arr[j])
				{
					// swap the values in two slots
                                        swap = arr[i];
                                        arr[i] = arr[j];
                                        arr[j] = swap;
				}
			}
		}
		

		// Display the values again, now (hopefully) sorted.
		System.out.print("after : ");
		for ( int i=0; i<arr.length; i++ )
			System.out.print( arr[i] + " " );
		System.out.println();
	}
}