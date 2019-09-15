//1601890
//Ramy Fekry

public class SavingAccount extends Account {
	private int numberWithdraw = 0;
	private static double minBalance = 300;
	private static int maxWithdraw = 3;
	
	public SavingAccount(int id, double balance) {
		super(id,balance);
		
	}
	public static double getMinBalance() {
		return minBalance;
	}
	public static double getMaxWithdraw() {
		return maxWithdraw;
	}
	public int getNumberWithdraw() {
		return numberWithdraw;
		}
	public void setNumberWithdraw(int numWithdraw) {
		this.numberWithdraw = numWithdraw;
	}
	@Override
	public double getMonthlyInterestRate() {
		return getAnnualInterestRate()/12;
	}
	@Override
	public void withdraw(double amount) {
		if (numberWithdraw < maxWithdraw)
		{
			if ((getBalance() - amount) >= minBalance) {
				setBalance(getBalance() - amount);
				numberWithdraw++;
				}else {

					System.out.println("You have insufficient balance");
				}
			}else {
				System.out.println("You have reached your witdrawal limit");
			}
		}
	@Override
	public String toString(){
		 System.out.println("Account Number              Balance");
		 String TheOutput = String.format("%14d%21.1f", getId(), getBalance()) + ("\n--------------------------------------------------");
		 
		 return TheOutput;
	}
}
