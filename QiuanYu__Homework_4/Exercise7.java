package QiuanYu__Homework_4;
import java.util.*;
public class Exercise7 {
    public static int getRandomNumber(int begin, int end){
        Random r = new Random();
        return r.nextInt(end-begin+1)+begin;
    }
    public static void main(String[] args) {
        Scanner sa = new Scanner(System.in);
        System.out.print("Input 1st number: ");
        int num1 = sa.nextInt();
        System.out.print("Input 2nd number: ");
        int num2 = sa.nextInt();
        System.out.print(getRandomNumber(num1, num2));
        sa.close();
    }
}
