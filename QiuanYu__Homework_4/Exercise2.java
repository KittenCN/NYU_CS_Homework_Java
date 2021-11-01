package QiuanYu__Homework_4;
import java.util.*;
public class Exercise2 {
    public static int getlast(int num){
        return num % 10;
    }
    public static int sumlast(int num1, int num2){
        return getlast(num1) + getlast(num2);
    }
    public static void main(String[] args) {
        Scanner sa = new Scanner(System.in);
        System.out.print("Input the 1st number: ");
        int num1 = sa.nextInt();
        System.out.print("Input the 2nd number: ");
        int num2 = sa.nextInt();
        System.out.println(sumlast(num1, num2));
        sa.close();
    }
}
