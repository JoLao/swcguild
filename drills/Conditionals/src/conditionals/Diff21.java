
package conditionals;
//Given an int n, return the absolute value of the difference between n and 21, 
//except return double the absolute value of the difference if n is over 21. 
//
//Diff21(23) -> 4
//Diff21(10) -> 11
//Diff21(21) -> 0

public class Diff21 {

    public int diff21(int n) {
        
        return (n < 22 ? Math.abs(n-21) : Math.abs(n-21) * 2);
    }
}
