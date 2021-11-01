package QiuanYu_Midterm.Occurrences;
import java.util.*;
public class Occurrences {
    public static void Occurrencess(String input){
        int[] cnt = new int[255];
        char[] cra = input.toCharArray();
        for(int i = 0; i < input.length(); ++i) cnt[(int)cra[i]]++;
        boolean ex = false;
        for(int i = (int)'a'; i <= (int)'z'; ++i){
            if(cnt[i] >= 3) {
                ex = true;
                System.out.println((char)i + " occurs " + cnt[i] + " times");
            }
        }
        if(ex == false) System.out.println("None");
    }
    public static void main(String[] args){
        System.out.print("Input an string: ");
        Scanner sa = new Scanner(System.in);
        String st = sa.nextLine();
        Occurrencess(st);
        sa.close();
    }
}
