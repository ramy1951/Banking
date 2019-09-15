//1601890
//Ramy Fekry

public class CheckingAccount extends Account{
	private static double minBalance = 0;
	
	public CheckingAccount(int id, double balance) {
		setId(id);
		setBalance(balance);
	}
	public static double getMinBalance() {
		return minBalance;
	}
	@Override
	public double getMonthlyInterestRate() {
		return 0;
	}
	@Override
	public void withdraw(double amount) {
		if(getBalance()- amount <= minBalance) {
			System.out.println("You have insufficient balance");
		}else {
			setBalance(getBalance() - amount);
		}
			
		
	}
	@Override
	public String toString(){
		 System.out.println("Account Number              Balance");
		 String TheOutput = String.format("%14d%21.1f", getId(), getBalance()) + ("\n--------------------------------------------------");
		 
		 return TheOutput;
	}
}
	