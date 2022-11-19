package HW_1_OOP_Recap_attached_files;
public abstract class Currency {
    String Name;
	String currencyName;
	double totalFunds;
	public abstract double toEarthDollars(double amount);
	public abstract double fromEarthDollars(double EarthDollars);
}