package HW3;
import java.util.*;
import java.text.DecimalFormat;
public class ATM {
    public static void main(String[] args) {
        double douBalance = 0.00;
        double douCash = 0.00;
        int sn = 0;
        DecimalFormat df = new DecimalFormat("#.00");
        Scanner sa = new Scanner(System.in);
        do{
            System.out.println("1. View your Balance");
            System.out.println("2. Deposit Cash");
            System.out.println("3. Withdraw Cash");
            System.out.println("4. Exit");
            System.out.println(" ");
            System.out.print("Enter your selection:");
            sn = sa.nextInt();
            System.out.println(" ");
            switch (sn) {
                case 1:
                    System.out.println("Your current balance is " + df.format(douBalance));
                    break;
                case 2:
                    System.out.print("Enter the amount you want to deposit: ");
                    douCash = sa.nextDouble();
                    douBalance += douCash;
                    break;
                case 3:
                    System.out.print("Enter the amount you want to withdraw: ");
                    douCash = sa.nextDouble();
                    if(douCash <= douBalance){
                        douBalance -= douCash;
                    }
                    else{
                        System.out.println("Sorry you don't have enough balance!");
                    }
                    break;
                case 4:
                    System.out.println("Goodbye");
                    break;
                default:
                    break;
            }
        }while(sn != 4);   
        sa.close();
    }
}