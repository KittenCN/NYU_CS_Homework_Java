package quiz2;
import java.util.*;
public class Ex1 {
    public static int cnt(String str, char cr){
        int cntnum = 0;
        for(int i = 0; i < str.length(); ++i){
            if(str.charAt(i) == cr){
                ++cntnum;
            }
        }
        return cntnum;
    }
    public static void main(String[] args){
        Scanner sa = new Scanner(System.in);
        String str = sa.nextLine();
        char cr = sa.next().charAt(0);
        System.out.print(cnt(str, cr));
        sa.close();
    }
}
