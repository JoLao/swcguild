/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ProgrammingbyDoing.Records;
import java.net.URL;
import java.util.Scanner;

//class Address
//{
//	String street;
//	String city;
//	String state;
//	int zip;
//}

public class WebAddressesArray
{
	public static void main(String[] args) throws Exception
	{
		URL addys = new URL("https://cs.leanderisd.org/txt/fake-addresses.txt");

		Address[] addybook = new Address[6];

		Scanner fin = new Scanner( addys.openStream() );

		for ( int i=0; i<addybook.length; i++ )
		{
			addybook[i] = new Address();
			addybook[i].street = fin.nextLine();
			addybook[i].city   = fin.nextLine();
			addybook[i].state  = fin.next();
			addybook[i].zip    = fin.nextInt();
			fin.skip("\n");
		}
		fin.close();
		
		for ( int i=0; i<addybook.length; i++ )
		{
			System.out.println((i+1) + ". " + addybook[i].street + ", " + addybook[i].city + ", " + addybook[i].state + "  " + addybook[i].zip);
		}
	}
}

