
package logic;

//Given 2 ints, a and b, return their sum. However, sums in the range 10..19 inclusive are forbidden, 
//so in that case just return 20. 
//
//SkipSum(3, 4) → 7
//SkipSum(9, 4) → 20
//SkipSum(10, 11) → 21
public class SkipSum {
    
    public int doASkipSum(int a, int b) {
        int sum = 0;
        sum = a + b;
        if (sum >= 10 && sum <= 19) {
            sum = 20;
        }
        return sum;
    }
    
}
