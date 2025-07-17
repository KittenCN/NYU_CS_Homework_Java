package temp;
import java.util.*;
public class temp {
    public static void main(String[] args) {
        int[][] mat = new int[99][99];
        int m, n;
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        sc.close();

        for(int i = 0; i < m; ++i){
            for(int j = 0; j < n; ++j){
                mat[i][j] = i + 1;
            }
        }
        for (int i = 0; i < m; ++i){
            for(int j = 0; j < n; ++j){
                System.out.print(mat[i][j]);
                System.out.print(' ');
            }
            System.out.println();
        }
    }
}
