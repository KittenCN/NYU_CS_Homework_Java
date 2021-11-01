package QiuanYu_Midterm.IsSorted;
import java.util.*;
public class IsSorted {
    public static boolean issorted(double[] arrs){
        boolean f1 = true, f2 = true;
        for(int i = 0; i < arrs.length - 1; ++i){
            if(arrs[i] > arrs[i+1]){
                f1 = false;
                break;
            }
        }
        for(int i = 0; i < arrs.length - 1; ++i){
            if(arrs[i] < arrs[i+1]){
                f2 = false;
                break;
            }
        }
        if(f1 == true || f2 == true) return true;
        else return false;
    } 
    public static void main(String[] args){
        Scanner sa = new Scanner(System.in);
        System.out.print("Input an array separet by space: ");
        String st = sa.nextLine();
        String[] starr = st.split(" ");
        double[] numarr = new double[starr.length];
        for(int i = 0; i < numarr.length; ++i){
            numarr[i] = Integer.parseInt(starr[i]);
        }
        if(issorted(numarr) == true) System.out.println(1);
        else System.out.println(0);
        sa.close();
    }
}
