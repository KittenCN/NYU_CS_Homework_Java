package QiuanYu_Homework_5;
import java.util.Scanner;
public class Exercise2 {
    public static void main(String[] args) {
        Scanner sa = new Scanner(System.in);
        System.out.println("Enter a Integers between 1 and 100: ");
        int[] intCnt = new int[101];
        while(sa.hasNextInt()){
            int n = sa.nextInt();
            if(n == 0) break;
            else if(n>=1 && n<=100){
                intCnt[n]++;
            }
            else{
                System.out.println("The number is not between 1 and 100");
                System.out.println("Enter a Integers between 1 and 100: ");
            }
        }
        for(int i = 1; i <= 100; ++i){
            if(intCnt[i] > 0){
                String stRes = " times";
                if(intCnt[i] == 1) stRes = " time";
                System.out.println(i + " occurs " + intCnt[i] + stRes);
            }
        }
        sa.close();
    }
}
