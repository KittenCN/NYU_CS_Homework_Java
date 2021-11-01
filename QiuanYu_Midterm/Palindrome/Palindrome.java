package QiuanYu_Midterm.Palindrome;
import java.util.*;
public class Palindrome {
    public static boolean ispalindrome(String st){
        st = st.toLowerCase();
        char[] cra = st.toCharArray();
        char[] crb = new char[cra.length];
        int cnt = 0;
        for(int i = 0; i < cra.length; ++i) if(cra[i] >= (int)'a' && cra[i] <= (int)'z') crb[cnt++] = cra[i];
        for(int i = 0; i < cnt; ++i) if(crb[i] != crb[cnt - i - 1]) return false;
        return true;
    }
    public static void main(String[] args) {
        System.out.print("Input an string: ");
        Scanner sa = new Scanner(System.in);
        String st = sa.nextLine();
        if(ispalindrome(st) == true) System.out.println("True");
        else System.out.println("False");
        sa.close();
    }
}
