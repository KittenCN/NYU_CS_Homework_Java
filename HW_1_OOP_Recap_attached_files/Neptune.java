package HW_1_OOP_Recap_attached_files;
public class Neptune extends Currency implements Exchangeable{
	Neptune(double d){
		this.totalFunds = d;
        this.Name = "Neptune";
		this.currencyName = "NeptuneNuggets";
	}
	@Override
	public double toEarthDollars(double amount) {
		return amount / Exchangeable.NN;
	}
	@Override
	public double fromEarthDollars(double EarthDollars) {
		return EarthDollars * Exchangeable.NN;
	}
    @Override
    public String getCurrencyName() {
        return this.currencyName;
    }
    @Override
    public double getTotalFunds() {
        return this.totalFunds;
    }
    @Override
    public String getName() {
        return this.Name;
    }
	@Override
	public void exchange(Exchangeable other, double amount) {
		if(this.totalFunds >= amount) {
			double earthDollar = this.toEarthDollars(amount); 
			double newAmount = other.fromEarthDollars(earthDollar); 
			other.changeTotalFounds(newAmount); 
			this.totalFunds = this.totalFunds - amount; 
            System.out.printf("Converting from %s to %s and initiating transfer...\n", this.currencyName, other.getCurrencyName());
            System.out.printf("$%.2f %s = $%.2f EarthDollars = %.2f %s\n", amount, this.currencyName, earthDollar, newAmount, other.getCurrencyName());
            System.out.printf("%s has a total of $%.2f %s\n", this.Name, this.totalFunds, this.currencyName);
            System.out.printf("%s has a total of $%.2f %s\n", other.getName(), other.getTotalFunds(), other.getCurrencyName());
		}
        else{
            System.out.printf("Uh oh - %s only has an available balance of $%.2f, which is less than $%.2f!\n", this.Name, this.totalFunds, amount);
        }
		System.out.println("");
	}
	@Override
	public void changeTotalFounds(double amount) {
		this.totalFunds = this.totalFunds + amount;
	}
}