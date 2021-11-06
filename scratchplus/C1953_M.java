package scratchplus;
import java.util.*;
public class C1953_M {
    public static void main(String[] args) {  
        Scanner sa = new Scanner(System.in);
        int n = sa.nextInt();
        int maxm = 0, cnt = 0;
        int[] m = new int[n];
        for(int i = 0; i < n; i++) {
            m[i] = sa.nextInt();
            if(m[i] > maxm) {
                maxm = m[i];
                cnt++;
            }
        }
        System.out.println(cnt);
        sa.close();
    }
}
