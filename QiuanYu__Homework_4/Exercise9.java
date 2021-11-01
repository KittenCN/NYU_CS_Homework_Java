package QiuanYu__Homework_4;
import java.util.*;
public class Exercise9 {
    public static String ckspace(String st){
        String ans = "";
        char[] crs = st.toCharArray();
        for(int i = 0; i < crs.length; ++i){
            if(crs[i] != ' ') ans += crs[i];
        }
        ans = ans.toLowerCase();
        return ans;
    }
    public static boolean checkpalindrome(String st){
        st = ckspace(st);
        char[] crs = st.toCharArray();
        for(int i = 0; i<= crs.length / 2; ++i){
            if(crs[i] != crs[crs.length - i - 1]) return false;
        }
        return true;
    }
    public static void main(String[] args){
        Scanner sa = new Scanner(System.in);
        System.out.print("Input a String: ");
        String st = sa.nextLine();
        if(checkpalindrome(st)) System.out.println("It is palindrome.");
        else System.out.println("It is NOT palindrome. ");
        sa.close();
    }
}
