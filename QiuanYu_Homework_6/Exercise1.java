package QiuanYu_Homework_6;
import java.util.Scanner;
public class Exercise1 {
    public static double sumColumn(double[][] m, int columnIndex) {
        double sum = 0;
        for (int i = 0; i < m.length; i++) {
            sum += m[i][columnIndex];
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner sa = new Scanner(System.in);
        System.out.println("Enter a 3 by 4 matrix row by row: ");
        double[][] m = new double[3][4];
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                m[i][j] = sa.nextDouble();
            }
        }
        for(int i = 0; i < m[0].length; i++) {
            System.out.println("The sum of the elements at Column " + i + " is " + sumColumn(m, i));
        }
        sa.close();
    }    
}
