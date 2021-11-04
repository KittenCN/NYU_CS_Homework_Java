package QiuanYu_Homework_5;
import java.util.*;
public class Exercise1 {
    public static void main(String[] args) {
        int[] num = new int[10];
        Scanner sa = new Scanner(System.in);
        System.out.println("Please input 10 numbers:");
        for(int i = 0; i < 10; i++) {
            num[i] = sa.nextInt();
        }
        System.out.println("The numbers are:");
        for(int i = 9; i >= 0; i--) {
            System.out.print(num[i] + " ");
        }
        sa.close();
    }
}
