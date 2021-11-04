package QiuanYu_Homework_6;
import java.util.*;
public class Exercise5 {
    static class Account{
        private int id = 0;
        private double balance = 0;
        private double annualInterestRate = 0;
        private Date dateCreated = new Date();
        public Account(){
            id = 0;
            balance = 0;
            annualInterestRate = 0;
            dateCreated = new Date();
        }
        public Account(int id, double balance){
            this.id = id;
            this.balance = balance;
            annualInterestRate = 0;
            dateCreated = new Date();
        }
        public int getId(){
            return id;
        }
        public double getBalance(){
            return balance;
        }
        public double getAnnualInterestRate(){
            return annualInterestRate;
        }
        public Date getDateCreated(){
            return dateCreated;
        }
        public void setId(int id){
            this.id = id;
        }
        public void setBalance(double balance){
            this.balance = balance;
        }
        public void setAnnualInterestRate(double annualInterestRate){
            this.annualInterestRate = annualInterestRate;
        }
        public double getMonthlyInterestRate(){
            return annualInterestRate/12;
        }
        public void withdraw(double amount){
            balance -= amount;
        }
        public void deposit(double amount){
            balance += amount;
        }
    }
    public static void main(String[] args) {
        Scanner sa = new Scanner(System.in);
        Account a1 = new Account();
        System.out.println("Enter the id of the account: ");
        int id = sa.nextInt();
        a1.setId(id);
        System.out.println("Enter the balance of the account: ");
        double balance = sa.nextDouble();
        a1.setBalance(balance);
        System.out.println("Enter the annual interest rate of the account: ");
        double annualInterestRate = sa.nextDouble();
        a1.setAnnualInterestRate(annualInterestRate);
        System.out.println("Enter the amount you want to withdraw: ");
        double amount = sa.nextDouble();
        a1.withdraw(amount);
        System.out.println("Enter the amount you want to deposit: ");
        amount = sa.nextDouble();
        a1.deposit(amount);
        System.out.println("The id of the account is: " + a1.getId());
        System.out.println("The balance of the account is: " + a1.getBalance());
        System.out.println("The monthly interest rate of the account is: " + a1.getMonthlyInterestRate());
        System.out.println("The date the account was created is: " + a1.getDateCreated());
        sa.close();
    }
}
