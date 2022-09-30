package scratchplus;
import java.util.*;
public class C1032_A {
    static int n;
    static int l[], ans[];
    static boolean f[];
    static void dfs(int dep){
        if(dep == n){
            for(int i = 0; i < n; i++){
                System.out.print(ans[i] + " ");
            }
            System.out.println();
            return;
        }
        else{
            for(int i = 0; i < n; i++){
                if(f[i] == false){
                    ans[dep] = l[i];
                    f[i] = true;
                    dfs(dep + 1);
                    f[i] = false;
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sa = new Scanner(System.in);
        n = sa.nextInt();
        l = new int[n];
        ans = new int[n];
        f = new boolean[n];
        for(int i = 0; i < n; i++) {
            l[i] = sa.nextInt();
            f[i] = false;
        }
        dfs(0);
        sa.close();
    }
}
