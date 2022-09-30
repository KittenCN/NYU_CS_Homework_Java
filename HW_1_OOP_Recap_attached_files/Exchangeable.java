package HW_1_OOP_Recap_attached_files;
public interface Exchangeable {
	public static double MM = 1.30;
	public static double SS = 0.87;
	public static double NN = 2.00;
	public static double ED = 1.00;
	public double fromEarthDollars(double EarthDollars);
    public double toEarthDollars(double amount);
    public void exchange(Exchangeable other, double amount);
	public void changeTotalFounds(double amount);
    public String getCurrencyName();
    public double getTotalFunds();
    public String getName();
}
