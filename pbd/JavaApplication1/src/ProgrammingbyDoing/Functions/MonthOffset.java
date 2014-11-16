/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ProgrammingbyDoing.Functions;

public class MonthOffset
{
	public static int month_offset( int month )
	{
		int result;
		// Your code goes in here.
                int[] monthOffset = {0, 1, 4, 4, 0, 2, 5, 0, 3, 6, 1, 4, 6};
                
                if (month >= 1 && month <= 12) {
                    result = monthOffset[month];
                } else {
                    result = -1;
                }
		
		return result;
	}


	public static void main( String[] args )
	{
		System.out.println( "Offset for month 1: " + month_offset(1) );
		System.out.println( "Offset for month 2: " + month_offset(2) );
		System.out.println( "Offset for month 3: " + month_offset(3) );
		System.out.println( "Offset for month 4: " + month_offset(4) );
		System.out.println( "Offset for month 5: " + month_offset(5) );
		System.out.println( "Offset for month 6: " + month_offset(6) );
		System.out.println( "Offset for month 7: " + month_offset(7) );
		System.out.println( "Offset for month 8: " + month_offset(8) );
		System.out.println( "Offset for month 9: " + month_offset(9) );
		System.out.println( "Offset for month 10: " + month_offset(10) );
		System.out.println( "Offset for month 11: " + month_offset(11) );
		System.out.println( "Offset for month 12: " + month_offset(12) );
		System.out.println( "Offset for month 43: " + month_offset(43) );
	}


}
