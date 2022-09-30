package temp;
import java.util.*;
 
public class temp1 {
    static long position = -1;
    public static void split(long left, long right, long target, long[] array) {
        long middlePos = (left + right) / 2;
        long middleValue = array[(int) middlePos];
        if(left > right) {
            return;
        }
        if(middleValue == target) {
            position = middlePos;
        }
        else if(middleValue > target) {
            split(left, middlePos - 1,target,array);
        }
        else {
            split(middlePos + 1,right,target,array);
        }
    }
    public static void main(String[] args) {
        Scanner sa = new Scanner(System.in);
        long n = sa.nextLong();
        long k = sa.nextLong();
        long[] array = new long[(int) n];
        for(long i = 0; i < n; i++) {
            array[(int) i] = sa.nextLong();
        }
        split(0, n - 1, k, array);
        if(position == -1) {
            System.out.print(position);
        }
        else {
            System.out.print(position + 1);
        }
        sa.close();
    }
}