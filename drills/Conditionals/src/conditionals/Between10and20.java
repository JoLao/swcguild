package conditionals;
//Given 2 int values, return true if either of them is in the range 10..20 inclusive. 
//
//Between10and20(12, 99) -> true
//Between10and20(21, 12) -> true
//Between10and20(8, 99) -> false

public class Between10and20 {

    public boolean between10and20(int a, int b) {
        return ((a > 9 && a < 21) || (b > 9 && b < 21)) ? true : false;
    }
}
