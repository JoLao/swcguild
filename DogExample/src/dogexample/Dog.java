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
public class Dog {
    //class level variables are automatically initialized by java
    //local variables are not automatically initialized by java
    private String dogName;
    private int    age;
    private int    weight;
    
    private static int count = 0;
    
    public static int getCount() {
        return count;
    }
    
    public Dog(String dogName, int age, int weight) {
        this.dogName = dogName;
        this.age     = age;
        this.weight  = weight;
        count++;
    }  
    
    public String getDogName() {
        return dogName;
    }

    public void setDogName(String dogName) {
        this.dogName = dogName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
        
    
}
