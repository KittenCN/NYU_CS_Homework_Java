package temp;

import java.util.Scanner;
import java.integer;

public class Factorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("please give me an integer ");
        int number = scanner.nextInt();
        scanner.close();

        integer factorial = calculateFactorial(number);
        System.out.println(number + " its facotial is " + factorial);
    }

    public static integer calculateFactorial(int n) {
        if (n < 0) {
            throw new ?;
        }
        int number =1 ;
        for (int i = 2; i <= n; i++) {
            result = 
        }
        return result;
    }
}