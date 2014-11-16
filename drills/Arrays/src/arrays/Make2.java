package arrays;
//Given 2 int arrays, a and b, return a new array length 2 containing, as much as will fit, 
//the elements from a followed by the elements from b. The arrays may be any length, 
//including 0, but there will be 2 or more elements available between the 2 arrays. 
//
//Make2({4, 5}, {1, 2, 3}) -> {4, 5}
//Make2({4}, {1, 2, 3}) -> {4, 1}
//Make2({}, {1, 2}) -> {1, 2}

public class Make2 {

    public int[] make2(int[] a, int[] b) {
        int[] c = new int[2];

        switch (a.length) {
            case 0:
                c = b;
                break;
            case 1:
                c[0] = a[0];
                c[1] = b[0];
                break;
            case 2:
            default:
                c = a;
        }

        return c;
    }
}

