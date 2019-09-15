//ramy fekry
//1601890

public abstract class Account {
    private int id = 0;
    private double balance = 0.0;
    private static double annualInterestRate = 0.03;
    final private java.util.Date dateCreated = new java.util.Date();

    protected Account() {
    
    }
    protected Account(int id, double balance) {
        this.id = id;
        this.balance = balance;
    }

    public int getId() {
        return this.id;
    }

    public double getBalance() {
        return this.balance; 
    }

    public static double getAnnualInterestRate() {
        return annualInterestRate; 
    }

    public String getDateCreated() {
        return this.dateCreated.toString();
    }

    public void setId(int id) {
        this.id = id; 
    }

    protected void setBalance(double balance) {
        this.balance = balance; 
    }

    public static void setAnnualInterestRate(double annualInterestRate1) {
        annualInterestRate = annualInterestRate1/100;
    }

    public double getMonthlyInterestRate() {
        return (annualInterestRate / 100) / 12 ; 
    }

    public double getMonthlyInterest() {
        return balance * getMonthlyInterestRate(); //
    }

    public void withdraw(double amount) {
        this.balance -= amount; //
    }

    public void deposit(double amount) {
        this.balance += amount; //
    }
	@Override
	public String toString(){
		 System.out.println("Account Number              Balance");
		 String TheOutput = String.format("%14d%21.1f", getId(), getBalance()) + ("\n--------------------------------------------------");
		 
		 return TheOutput;
	}
	@Override
	public boolean equals(Object o){
		if (o instanceof Account){
			Account a = (Account)o;
			return (this.getId() == a.getId());
			}
		return false;
		}
}