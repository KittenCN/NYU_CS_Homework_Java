import java.util.Scanner;
public class Quiz1{
    public static void main(String[] args) {
        int[][] matrix = new int[3][4];
        int num = 1;
        for(int i = 1; i <= 3; i++){
            for(int j = 1; j <= 4; j++){
                matrix[i-1][j-1] = num;
                num++;
            }
        }
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 4; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}