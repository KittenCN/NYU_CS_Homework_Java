package scratchplus;
import java.util.*;
public class C1053_S {
    public static void main(String[] args) {
        Scanner sa = new Scanner(System.in);
        int n = sa.nextInt();
        int[][] m = new int[n][2];
        int[] s = new int[n];
        for (int i = 0; i < n; i++) {
            m[i][0] = sa.nextInt();
            m[i][1] = sa.nextInt();
        }
        for(int i = 0; i < n; ++i){
            for(int j = i + 1; j < n; ++j){
                if(m[j][0] > m[i][0]){
                    s[j] += m[i][1];
                    break;
                }
            }
            for(int j = i - 1; j >= 0; --j){
                if(m[j][0] > m[i][0]){
                    s[j] += m[i][1];
                    break;
                }
            }
        }
        int max = 0;
        for(int i = 0; i < n; ++i){
            if(s[i] > max){
                max = s[i];
            }
        }
        System.out.println(max);
        sa.close();
    }
}
