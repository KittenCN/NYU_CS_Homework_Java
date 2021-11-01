package scratchplus;
import java.util.*;
public class T_1867 {
    public static void main(String[] args){
        Scanner sa = new Scanner(System.in);
        int x = sa.nextInt();
        int[] arr = new int[4];
        int intIndex = 0;
        while(x > 0){
            arr[intIndex] = x % 10;
            x /= 10;
            intIndex++;
        }
        Arrays.sort(arr);
        int small = 1000 * arr[0] + 100 * arr[1] + 10 * arr[2] + arr[3];
        int big = 1000 * arr[3] + 100 * arr[2] + 10 * arr[1] + arr[0];
        int diff = big - small;
        if (diff / 1000 > 0){
            System.out.print(big + "-" + small + "=" + diff);
        }
        else if (diff == 0){
            System.out.print("OMG!");
        }
        else {
            System.out.print("unlucky!");
        }
        sa.close();
    }
}
