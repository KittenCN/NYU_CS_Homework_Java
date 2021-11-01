package QiuanYu__Homework_4;
import java.util.*;
public class Exercise8 {
    public static int reverse(int num){
        int ans = 0;
        while(num > 0){
            ans = ans * 10 + (num % 10);
            num /= 10;
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.print("Input a Number: ");
        Scanner sa = new Scanner(System.in);
        int num = sa.nextInt();
        System.out.println(reverse(num));
        sa.close();
    }
}
