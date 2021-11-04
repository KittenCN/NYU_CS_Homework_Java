package QiuanYu_Homework_4;
import java.util.*;
import java.text.DecimalFormat;
import static java.lang.System.out;
public class Exercise1 {
    public static Scanner sa = new Scanner(System.in);
    public static double douBalance;
    public static String douToformat(double douNum){
        DecimalFormat df = new DecimalFormat("#0.00");
        return df.format(douNum);
    }
    public static double Checkdeposit(double douNum){
        while(douNum <= 0){
            out.println(("Invalid Input! Try it again! "));
            out.print("Enter the amount you want to deposit: ");
            douNum = sa.nextDouble();
        }
        return douNum;
    }
    public static double Checkwithdraw(double douNum){
        while(douNum > douBalance){
            out.println("Sorry you don't have enough balance!");
            out.print("Enter the amount you want to withdraw: ");
            douNum = sa.nextDouble();
        }
        return douNum;
    }
    public static void CheckInput(int intNum){
        switch (intNum) {
            case 1:
                out.println("Your current balance is " + douToformat(douBalance));
                break;
            case 2:
                out.print("Enter the amount you want to deposit: ");
                douBalance += Checkdeposit(sa.nextDouble());
                break;
            case 3:
                out.print("Enter the amount you want to withdraw: ");
                douBalance -= Checkwithdraw(sa.nextDouble());
                break;
            case 4:
                out.println("Goodbye");
                break;
            default:
                break;
        }
    }
    public static void main(String[] args) {
        int sn = 0;
        douBalance = 0.00;
        do{
            out.print("1. View your Balance" + "\r\n" + "2. Deposit Cash" + "\r\n" + "3. Withdraw Cash" + "\r\n" + "4. Exit" + "\r\n" + "Enter your selection:");
            sn = sa.nextInt();
            out.println("");
            CheckInput(sn);
        }while(sn != 4);   
        sa.close();
    }
}
