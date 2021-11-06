package scratchplus;
import java.util.*;
public class C1053_J {
    public static void main(String[] args) {
        Scanner sa = new Scanner(System.in);
        int n = sa.nextInt();
        int m = sa.nextInt();
        int sum = 0, t = 0;
        int[] monkey = new int[n];
        for(int i = 0; i < n; i++) {
            monkey[i] = 1;
        }
        while(t < n){
            for(int i = 0; i < n; i++) {
                sum += monkey[i];
                if(sum == m){
                    System.out.print((i + 1) + " ");
                    sum = 0;
                    monkey[i] = 0;
                    t++;
                }
            }
        }
        sa.close();
    }
}
