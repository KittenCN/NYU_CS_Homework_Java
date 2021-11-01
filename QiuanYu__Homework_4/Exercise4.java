package QiuanYu__Homework_4;
import java.util.*;
public class Exercise4 {
    public static boolean checkeven(int num){
        return num % 2 == 0;
    }
    public static void main(String[] args) {
        Scanner sa = new Scanner(System.in);
        System.out.print("Input a number: ");
        int num = sa.nextInt();
        if(checkeven(num)) System.out.println("even");
        else System.out.println("odd");
        sa.close();
    }
}
