package QiuanYu_Homework_4;
import java.util.*;
public class Exercise3 {
    public static final double pi = 3.1415926;
    public static double calarea(double douR){
        return pi * douR * douR;
    }
    public static void main(String[] args) {
        Scanner sa = new Scanner(System.in);
        System.out.print("Intpu the radius: ");
        double douR = sa.nextDouble();
        System.out.print(calarea(douR));
        sa.close();
    }
}
