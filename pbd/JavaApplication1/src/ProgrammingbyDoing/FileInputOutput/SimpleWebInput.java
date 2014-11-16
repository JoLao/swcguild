/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ProgrammingbyDoing.FileInputOutput;

import java.net.URL;
import java.util.Scanner;

public class SimpleWebInput
{
	public static void main(String[] args) throws Exception
	{
//    The code provided only reads a single line from the URL given, but mitchellis.txt contains two lines. 
//    Add in code to read in and display the second line as well.
//    Once that works, change the URL to read text from a different web location.             
		URL mcool = new URL("https://cs.leanderisd.org/mitchellis.txt");
                URL adjectives = new URL("https://cs.leanderisd.org/txt/adjectives.txt");
		Scanner webIn = new Scanner( mcool.openStream() );
                Scanner webIn2 = new Scanner(adjectives.openStream());
                
		//String one = webIn.nextLine();
                String one = "";
		while (webIn.hasNext()) {
                    one = webIn.nextLine();
                    System.out.println(one);
                }
		webIn.close();
		one = "";
		while (webIn2.hasNext()) {
                    one = webIn2.nextLine();
                    System.out.println(one);
                }
		webIn.close();
		//System.out.println(one);
	}
}