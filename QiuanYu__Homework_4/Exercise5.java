package QiuanYu__Homework_4;
import java.util.*;
public class Exercise5 {
    public static boolean checkmul(int num1, int num2) {
        return (num2 / num1 > 0) && (num2 % num1 == 0) && (num2 > num1);
    }
    public static void main(String[] args) {
        Scanner sa = new Scanner(System.in);
        System.out.print("Input the 1st number: ");
        int num1 = sa.nextInt();
        System.out.print("Input the 2nd number: ");
        int num2 = sa.nextInt();
        if(checkmul(num1, num2)) System.out.println("The second is a multiple of the first!");
        else System.out.println("The second is NOT a multiple of the first!");
        sa.close();
    }
}
