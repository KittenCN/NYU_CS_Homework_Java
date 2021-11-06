package scratchplus;
import java.util.*;
public class C1069_X {
    public static void main(String[] args) {
        Scanner sa = new Scanner(System.in);
        int n = sa.nextInt();
        int a = sa.nextInt();
        int b, c;
        if(n == 1) {
            System.out.println(a);
        }
        else{
            for(int i = 2; i <= n; i++) {
                b = sa.nextInt();
                while(b > 0){
                    c = a % b;
                    a = b;
                    b = c;
                }
            }
        }
        System.out.println(a);
        sa.close();
    }
}
