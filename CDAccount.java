//1601890
//Ramy fekry

public class CDAccount extends Account{
	private double mature;
	private int duration;
	private double CDAnnualInterestRate;
	
	public CDAccount() {
		setCDAnnualInterestRate();
	}
	public CDAccount(int id, double balance, int duration) {
		setId(id);
		setBalance(balance);
		setDuration(duration);

		setCDAnnualInterestRate();
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public int getDuration() {
		return this.duration;
	}
	public double getMatureBalance() {
		mature = getBalance() *  (Math.pow(1 + getMonthlyInterestRate(), duration));

		return mature;
	}
	private void setCDAnnualInterestRate() {
		this.CDAnnualInterestRate = super.getAnnualInterestRate() + (getDuration()/3 * 0.005);
	}
	public double getCDAnnualInterestRate() {
		return this.CDAnnualInterestRate;
	}
	@Override
	public double getMonthlyInterestRate() {
		return CDAnnualInterestRate / 12;
	}
	@Override
	public double getMonthlyInterest() {
		double RDouble = getBalance() * getMonthlyInterestRate();
		return RDouble;
	}
	@Override
	public final void withdraw(double amount) {
		System.out.println("you cannot withdraw from a CD Account");
	}
	@Override
	public final void deposit(double amount) {
		System.out.println("you cannot deposit from a CD Account");
		System.out.println("=================================================================================================");
		
	}
	@Override
	public String toString(){
		 System.out.println("Account Number      Initial Balance      Mature Balance      Rate                      Date Created");
		 String TheOutput = String.format("%14d%21.1f%20.2f%10.2f%34s", getId(), getBalance(), getMatureBalance(), getCDAnnualInterestRate()*100,getDateCreated());		
		 
		 return TheOutput;
	}
	public void displayMonthlyInterests() {
		double newBalance;
		for(int i = 0; i < duration;i++) {
			newBalance = getBalance() *  (Math.pow(1 + getMonthlyInterestRate(), i+1));
			System.out.print("Month " + (i+1) + "  ");
			System.out.printf("%10.2f\n", newBalance);
		}
		System.out.println("=================================================================================================");
	}
	@Override
	public boolean equals(Object o){
		if (o instanceof CDAccount){
			CDAccount a = (CDAccount)o;
			return (this.getId() == a.getId());
			}
		return false;
		}

}
