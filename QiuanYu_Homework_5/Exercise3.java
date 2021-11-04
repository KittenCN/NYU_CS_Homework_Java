package QiuanYu_Homework_5;
import java.util.Scanner;
public class Exercise3 {
    public static int average(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return sum / array.length;
    }
    public static double average(double[] array) {
        double sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return sum / array.length;
    }
    public static void main(String[] args) {
        Scanner sa = new Scanner(System.in);
        System.out.print("Enter 10 double value: ");
        double[] array = new double[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = sa.nextDouble();
        }
        System.out.println("Average of the double array is " + average(array));
        sa.close();
    }
}
