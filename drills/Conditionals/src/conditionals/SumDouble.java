
package conditionals;

//Given two int values, return their sum. However, if the two values are the same, 
//then return double their sum. 
//
//SumDouble(1, 2) -> 3
//SumDouble(3, 2) -> 5
//SumDouble(2, 2) -> 8
public class SumDouble {

    public int sumDouble(int a, int b) {
        int sum = 0;
        
        sum = a + b;
        if (a == b) {
            sum *= 2;
        }
        return sum;
    }
}
