/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ProgrammingbyDoing.Functions;
public class HeronsFormula
{
	public static void main( String[] args )
	{

//    Compile and run both files (HeronsFormula.java and HeronsFormulaNoFunction.java). Do they both produce the 
//    same output? (Answer in a comment in HeronsFormula.java.) 
//            Answer: Yes
//    How many lines long is HeronsFormulaNoFunction.java?  Answer: 43
//    How many lines long is HeronsFormula.java if you don't 
//    count the two lines of comments inside the triangleArea() function? (Put the answers to both questions in a 
//    comment in HeronsFormula.java.) Answer: 13
//    There is a bug in the formula for both files. When (a+b+c) is an odd number, dividing by 2 throws away the .5. 
//    Fix both files so that instead of (a+b+c) / 2 you have (a+b+c) / 2.0 everywhere it occurs. Was it easier to fix 
//    the file that used a function, or the one that didn't use a function? Answer in a comment.
//    Add one more test to both files: find the area of a triangle with sides 9, 9, and 9. Was it difficult to add to 
//    the file that used a function? Answer in a comment on the line below where you added the new function call.
//    Answer: Easier to add using methods.            
//    (You don't need to turn in HeronsFormulaNoFunction.java. Only turn in one file: HeronsFormula.java)             
		double a;
		
		a = triangleArea(3, 3, 3);
		System.out.println("A triangle with sides 3,3,3 has an area of " + a );

		a = triangleArea(3, 4, 5);
		System.out.println("A triangle with sides 3,4,5 has an area of " + a );
 
		a = triangleArea(7, 8, 9);
		System.out.println("A triangle with sides 7,8,9 has an area of " + a );
                
                a = triangleArea(9, 9, 9);
                System.out.println("A triangle with sides 9,9,9 has an area of " + a );

		System.out.println("A triangle with sides 5,12,13 has an area of " + triangleArea(5, 12, 13) );
		System.out.println("A triangle with sides 10,9,11 has an area of " + triangleArea(10, 9, 11) );
		System.out.println("A triangle with sides 8,15,17 has an area of " + triangleArea(8, 15, 17) );
                System.out.println("A triangle with sides 9,9,9 has an area of " + triangleArea(9, 9, 9) );
	}
 
	public static double triangleArea( int a, int b, int c )
	{
		// the code in this function computes the area of a triangle whose sides have lengths a, b, and c
		double s, A;

		s = (a+b+c) / 2.0;
		A = Math.sqrt( s*(s-a)*(s-b)*(s-c) );

		return A;
		// ^ after computing the area, "return" it
	}
}
