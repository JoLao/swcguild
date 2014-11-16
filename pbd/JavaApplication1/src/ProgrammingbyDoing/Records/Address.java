/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ProgrammingbyDoing.Records;

public class Address
{
	String street;
	String city;
	String state;
	int zip;
        
        public String toString()
	{
		return (this.street + ", " + this.city + ", " + this.state + " "+ this.zip);
	}
}