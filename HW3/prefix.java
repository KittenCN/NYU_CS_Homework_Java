package HW3;
import java.util.*;
public class prefix {
    public static void main(String[] args){
        Scanner sa = new Scanner(System.in);
        System.out.print("Enter thr first string: ");
        String st1 = sa.nextLine();
        String[] str1 = st1.split(" ");
        int lenstr1 = str1.length;
        System.out.print("Enter the second string: ");
        String st2 = sa.nextLine();
        String[] str2 = st2.split(" ");
        int lenstr2 = str2.length;
        int lens = 0;
        int lens2 = 0;
        String strresult="";
        if(lenstr1 > lenstr2){
            lens = lenstr2;
        }
        else{
            lens = lenstr1;
        }
        for(int i = 0; i < lens; ++i){
            if(str1[i].equals(str2[i])){
                strresult += str1[i];
                strresult += " ";
                ++lens2;
            }
            else{
                break;
            }
        }
        if(lens2 > 0){
            System.out.print("The common prefix is " + strresult);
        }
        else{
            System.out.print(st1 + " and " + st2 + " have no common prefix");
        }
        sa.close();
    }
}
