/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ProgrammingbyDoing.Records;

/**
 *
 * @author apprentice
 */
public class Dog {
    //class level variables are automatically initialized by java
    //local variables are not automatically initialized by java
    private String breed;
    private int    age;
    private int    weight;
    
    private static int count = 0;
    
    public static int getCount() {
        return count;
    }
    
    public Dog(String breed, int age, int weight) {
        this.breed   = breed;
        this.age     = age;
        this.weight  = weight;
        count++;
    }  
    
    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
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
        
    public String toString() {
        return (breed+", "+age+", "+weight);
    }
}
