//1601890
//ramy fekry

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;


public class Banking {

	public static void main(String[] args) throws Exception {
		String fileName;
		int id = 0;
		double balance;
		int duration;
		int choice = 0;
		String accountKind = "";
		Scanner in = new Scanner(System.in);
		Random rnd = new Random();
		ArrayList<Account> list = new ArrayList<Account>();
		
		System.out.print("Enter File Name: ");
		fileName = in.nextLine();

		File file = new File(fileName);
		
		if(file.exists()) {
			System.out.println("This file exists");
			System.exit(1);
		}
		
		PrintWriter output = new PrintWriter(fileName); //Create a file
		
		do{
			id = rnd.nextInt(1000);
			output.print(id+ "     ");
			Account.setAnnualInterestRate(3.0); //set Annual Interest rate
			balance = getDouble(in, "Enter intial Deposit Amount$: "); //taking balance

			output.print(balance+ "     "); //output Balance
			
			duration = getNonNegativeInt(in, "Enter Duration (Months), or 0 for checking or saving account: ");
			//taking duration
				if(duration == 0) {
					choice = getNonNegativeInt(in, "Enter 1 for checking or 2 for saving: " );
					
						if(choice == 1) {
							accountKind = "Checking";
							CheckingAccount ch = new CheckingAccount(id,balance);
							CheckingAccount.setAnnualInterestRate(0);
							output.print(CheckingAccount.getAnnualInterestRate()*100+ "     ");
						}
						if(choice == 2) {
							accountKind = "Saving";
							SavingAccount sa = new SavingAccount(id,balance);
							SavingAccount.setAnnualInterestRate(3);
							output.print(SavingAccount.getAnnualInterestRate()*100+ "     ");
						}
				}else {
					accountKind = "CDAccount";
					CDAccount CD = new CDAccount(id,balance,duration);
					output.print(CD.getCDAnnualInterestRate() * 100 + "     ");
		     	}			
				
				output.println(accountKind);// write Account kind
				choice = getNonNegativeInt(in, "Enter 1 for a new Account or any other number to end");
		}while(choice == 1);
		output.close(); //close file, end of writing
		
		Scanner input = new Scanner(file); //open a file

		System.out.println("ID    Balance     Interest Rate%  Account Type");
		while(input.hasNext()) {
			id = input.nextInt();
			balance = input.nextDouble();
			double interest = input.nextDouble();
			accountKind = input.next();
			System.out.printf("%2d%10.1f%17.2f%14s\n",id,balance,interest, accountKind);
		}
		input.close();//close file
		}

public static double getDouble(Scanner in, String prompt) {
	double ToReturn = 0;
	boolean isValid = false;
	while(!isValid) {
		System.out.print(prompt);
		if(in.hasNextDouble())
		{
			ToReturn = in.nextDouble();
			isValid = true;
		}else {
			System.out.println("Error! Invalid Entry, Only Double entry!");
		}
		in.nextLine();
	}
		
	return ToReturn;
}
public static int getNonNegativeInt(Scanner in, String prompt) {
	int ToReturn = 0;
	boolean isValid = false;
	while(!isValid) {
		System.out.print(prompt);
		if(in.hasNextInt())
		{
			ToReturn = in.nextInt();
			isValid = true;
		}else {
			System.out.println("Error! Invalid Entry, Only integer entry!");
		}
		in.nextLine();
	}
		
	return ToReturn;
}
}