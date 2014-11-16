
package arrays;
//Return an int array length n containing the first n digits of pi.
//
//MakePi(3) -> {3, 1, 4}

public class MakePi {
    public int[] makePi(int n) {
        int    numPi  = (int) (Math.PI * (Math.pow(10, (n-1))));
        int[]  digits = new int[n];
        int    j      = 0;
        String numStr = Integer.toString(numPi);;
        
        System.out.println(numPi+" "+n);
        for (int i = 0; i < numStr.length(); i++) {            
            digits[i] = Integer.parseInt(String.valueOf(numStr.charAt(i)));           
        }
        return digits;
    }
    
}
