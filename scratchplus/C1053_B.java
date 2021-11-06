package scratchplus;
import java.util.*;
public class C1053_B {
    public static void main(String[] args) {
        Scanner sa = new Scanner(System.in);
        int n = sa.nextInt();
        int[] a = new int[n];
        a[0] = 0;
        a[1] = 1;
        for(int i = 2; i < n; i++) {
            a[i] = a[i - 1] + a[i - 2];
        }
        for(int i = 0; i < n; i++) {
            System.out.println(a[i] + " ");
        }
        sa.close();
    }
}
