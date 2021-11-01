package QiuanYu_Midterm.PrimeNumbers;
import java.util.*;
public class PrimeNumbers {
    public static boolean isprime(int n){
        if(n <= 1) return false;
        else if(n == 2) return true;
        else{
            for(int i = 2; i <= Math.sqrt(n); ++i)
                if(n % i == 0) return false;
            return true;
        }
    }
    public static void main(String[] args){
        System.out.print("Input an integer:");
        Scanner sa = new Scanner(System.in);
        int num = sa.nextInt();
        if(isprime(num) == true) System.out.println(1);
        else System.out.println(0);
        sa.close();
    }
}
