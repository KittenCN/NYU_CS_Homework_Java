package QiuanYu_Midterm.PrimeDigits;
import java.util.*;
public class PrimeDigits {
    public static boolean isprime(int n){
        if(n <= 1) return false;
        else if(n == 2) return true;
        else{
            for(int i = 2; i <= Math.sqrt(n); ++i)
                if(n % i == 0) return false;
            return true;
        }
    }
    public static int Sum(int n){
        int sum = 0, cnt = 0;
        while(n > 0){
            int cur = n % 10;
            if(isprime(cur) == true){
                sum += cur;
                if(++cnt == 2) return sum;
            }
            n /= 10;
        }
        return sum;
    }
    public static void main(String[] args){
        System.out.print("Input an integer:");
        Scanner sa = new Scanner(System.in);
        int num = sa.nextInt();
        System.out.println(Sum(num));
        sa.close();
    }
}
