package QiuanYu_Midterm.KSmallest;
import java.util.*;
public class KSmallest {
    public static int max(int x, int y){
        return x < y ? y : x;
    }
    public static int Ksmallest(int[] array, int k){
        int maxs = -1;
        for(int i = 0; i < array.length; ++i) maxs = max(maxs, array[i]);
        int[] ans = new int[maxs + 1];
        for(int i = 0; i < array.length; ++i) ans[array[i]]++;
        int now_k = 1;
        for(int i = 1; i <= maxs; ++i){
            if(ans[i] == 0) continue;
            if(now_k == k) return i;
            now_k++;
        }
        return 0;
    }
    public static void main(String[] args){
        Scanner sa = new Scanner(System.in);
        System.out.print("Input an array separet by space: ");
        String st = sa.nextLine();
        String[] starr = st.split(" ");
        int[] numarr = new int[starr.length];
        for(int i = 0; i < numarr.length; ++i){
            numarr[i] = Integer.parseInt(starr[i]);
        }
        System.out.print("Input number K:");
        int k = sa.nextInt();
        System.out.println(Ksmallest(numarr, k));
        sa.close();
    }
}
