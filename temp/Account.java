package temp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class Account{
	private int id;
	private double balance;
	private double annualInterestRate;
	private Date dateCreated;
	
	public Account() {
		this.id = 0;
		this.balance = 0;
		this.annualInterestRate = 0;
		this.dateCreated  = new Date();
	}
	
	public Account(int id, double balance) {
		this.id = id;
		this.balance = balance;
		this.annualInterestRate = 0;
		this.dateCreated = Calendar.getInstance().getTime();
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public double getBalance() {
		return this.balance;
	}
	
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public double getAnnualInterestRate() {
		return this.annualInterestRate;
	}
	
	public void setAnnualInterestRate(double annualInterestRate) {
		this.annualInterestRate = annualInterestRate;
	}
	
	public String getDateCreated() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss"); 
		String strDate = dateFormat.format(this.dateCreated); 
		return strDate;
	}
	
	public double getMonthlyInterest() {
		return this.annualInterestRate * this.balance / 12;
	}
	
	public void withdraw(double withdrawAmount) {
		this.balance -= withdrawAmount;
	}
	
	public void deposit(double depositAmount) {
		this.balance += depositAmount;
	}
}