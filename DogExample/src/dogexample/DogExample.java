/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dogexample;

/**
 *
 * @author apprentice
 */
public class DogExample {


    public static void main(String[] args) {
        System.out.println(Dog.getCount());
        
        Dog dogOne = new Dog("Spot",10,80);
      
        Dog dogTwo = new Dog("Rover",7,40);
        
        System.out.println(dogOne.getDogName());
        System.out.println(dogTwo.getDogName());
        System.out.println(Dog.getCount());     //proper way to access static variable
        System.out.println(dogOne.getCount());  //will work but not proper way
        System.out.println(dogTwo.getCount());  //will work but not proper way
        
        dogOne = dogTwo;
        System.out.println(dogOne.getDogName());
        System.out.println(dogTwo.getDogName());
        
        dogOne.setDogName("Buster");
        System.out.println(dogOne.getDogName());
        System.out.println(dogTwo.getDogName());
        
        String str1 = "foo";
        String str2 =  new String("foo");
        
        System.out.println(str1.equals(str2));
        System.out.println(str1 == str2);
    }
    
}
