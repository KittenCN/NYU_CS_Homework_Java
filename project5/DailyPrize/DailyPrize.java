package project5.DailyPrize;
import java.util.Scanner;
import java.util.Arrays;
public class DailyPrize {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numDays = sc.nextInt();
        int totalPrizes = 0;
        int[] bills = new int[numDays * 100000];
        Arrays.fill(bills, -1);
        int billindex = 0;
        for (int i = 0; i < numDays; i++) {
            int numForms = sc.nextInt();
            if (numForms == 0) {
                bills[billindex] = -1;
                billindex++;
            }
            else{
                for (int j = 0; j < numForms; j++) {
                    int billAmount = sc.nextInt();
                    bills[billindex] = billAmount;
                    billindex++;
                }
            };
            int highestBill = 0, lowestBill = 0;
            Arrays.sort(bills);
            for(int j = 0; j < bills.length; j++) {
                if (bills[j] != -1) {
                    lowestBill = bills[j];
                    bills[j] = -1;
                    break;
                }
            }
            for(int j = bills.length - 1; j >= 0; j--) {
                if (bills[j] != -1) {
                    highestBill = bills[j];
                    bills[j] = -1;
                    break;
                }
            }
          int prize = highestBill - lowestBill;
          totalPrizes += prize;
        }
        System.out.println(totalPrizes);
        sc.close();
      }
}
