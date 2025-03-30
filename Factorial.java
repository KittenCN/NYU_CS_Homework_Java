import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("please give me an integer ");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        scanner.close();

        int factorial = gcd(a, b);
        System.out.println(" its facotial is " + factorial);
    }

    //欧几里得原理 递归法
    public static int gcd(int a, int b) {
        if(b == 0){
            return a;
        }
        else{
            return gcd(b, a % b);
        }
    }

    //欧几里得原理 递推法
    public static int gcd2(int a, int b) {
        while(b != 0){
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}