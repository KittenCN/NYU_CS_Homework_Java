package quiz2;
import java.util.*;
public class Ex3 {
    public static String sort(String str){
        String st = "";
        char[] cra = str.toCharArray();
        for(int i = 0; i < cra.length; ++i){
            for(int j = i + 1; j < cra.length; ++j){
                if(cra[i] > cra[j]){
                    char tmp = cra[i];
                    cra[i] = cra[j];
                    cra[j] = tmp;
                }
            }
        }
        for(int i = 0; i < cra.length; ++i){
            st += cra[i];
        }
        return st;
    }
    public static void main(String[] args){
        Scanner sa = new Scanner(System.in);
        String str1 = sa.nextLine();
        String str11 = sort(str1);
        String str2 = sa.nextLine();
        String str22 = sort(str2);
        if(str11.equals(str22)){
            System.out.print("0");
        }
        else{
            System.out.print(str1);
        }
        sa.close();
    }
}
