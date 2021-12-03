package temp;
public class Main {
	public static void main(String[] args) {
		Account[] accounts = new Account[10];
		accounts[0] = new Account();
		accounts[0].setAnnualInterestRate(0.045);
		accounts[0].setBalance(20000);
		accounts[0].setId(1122);
		accounts[0].withdraw(2500);
		accounts[0].deposit(3000);
		System.out.println(accounts[0].getBalance());
		System.out.println(accounts[0].getMonthlyInterest());
		System.out.println(accounts[0].getDateCreated());

	}
}
