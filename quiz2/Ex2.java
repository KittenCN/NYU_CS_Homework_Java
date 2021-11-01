package quiz2;
import java.util.*;
public class Ex2 {
    public static void cnt(String str){
        int[] cntnum = new int[128];
        for(int i = 0; i < str.length(); ++i){
            ++cntnum[(int)str.charAt(i)];
        }
        for(int i =0; i < 128; ++i){
            if(cntnum[i] > 0){
                System.out.println((char)i + ":" + cntnum[i]);
            }
        }
        return;
    }
    public static void main(String[] args){
        Scanner sa = new Scanner(System.in);
        String str = sa.nextLine();
        cnt(str);
        sa.close();
    }
}
