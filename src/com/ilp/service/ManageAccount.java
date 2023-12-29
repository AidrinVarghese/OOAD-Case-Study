package com.ilp.service;

import java.util.Scanner;

import com.ilp.entity.Account;
import com.ilp.entity.Customer;
import com.ilp.entity.LoanAccount;
import com.ilp.entity.SavingsMaxAccount;

public class ManageAccount {
	static Scanner scanner = new Scanner(System.in);
	public static void manageAccounts(Customer customer) {
		Account account = ChooseAccount(customer);
		
		char loopchoice = 0;
		do {
			
			System.out.println("*******MANAGE YOUR ACCOUNTS******\n"
					+ "\t Choose an option\n"
					+ "1.Deposit\n"
					+ "2.Withdraw\n"
					+ "3.Display Balance\n"
					+ "4.Exit");
			int choice = scanner.nextInt();
			
			if(account == null) {
				continue;
			}
			
			switch(choice) {
			case 1:
				System.out.println("Enter the amount to deposit:");
				double depositAmount = scanner.nextDouble();
				deposit(account,depositAmount);
				break;
			case 2:
				System.out.print("Enter the amount to be withdrawn: ");
                double withdrawAmount = scanner.nextDouble();
                withdraw(account,withdrawAmount);
                break;
			case 3:
				System.out.println(account.toString());
				break;
			case 4:
				 System.out.println("****TRANSACTION HAS BEEN CANCELLED*****8");
                 break;
			case 5:
				System.out.println("Invalid Input, Please check again!");
			}
			System.out.println("Do you want to continue?");
			loopchoice =scanner.next().charAt(0);

		}while(loopchoice=='y' || loopchoice == 'Y');
	}	
	
	
	
	
	
	
	private static Account ChooseAccount(Customer customer) {
		System.out.println("Select an account:");
		int i = 1;
		for(Account account : customer.getAccountList()) {
			System.out.println(i + " . " + account.getAccountType());
			i++;
		}
		int choice = scanner.nextInt();
		scanner.nextLine();
		
		if (choice>=1 && choice <= customer.getAccountList().size()) {
			return customer.getAccountList().get(choice-1);
		}
		else {
			System.out.println("Invalid Choice");
			return null;
		}
	}
	private static void deposit(Account account, double depositAmount) {
		if (account.getProduct() instanceof LoanAccount)
		{
			System.out.println("Select deposit type :\n"
					+ "1.Cash\n"
					+ "2.Check");
			int depositTypeChoice = scanner.nextInt();
			scanner.nextLine();
			
			if (depositTypeChoice ==1) {
				account.setBalance(account.getBalance()+depositAmount);
				System.out.println("****YOUR TRANSACTION IS SUCCESSFUL*****\n"
						+ "ACCOUNT BALANCE:" + account.getBalance());
			}
			else if(depositTypeChoice == 2) {
				depositAmount -= depositAmount*0.03;
				account.setBalance(account.getBalance()+depositAmount);
				System.out.println("****YOUR TRANSACTION IS SUCCESSFUL*****\n"
						+ "ACCOUNT BALANCE:" + account.getBalance());
				
			}
		}
		
		else {
			account.setBalance(account.getBalance()+depositAmount);
			System.out.println("****YOUR TRANSACTION IS SUCCESSFUL*****\n"
					+ "ACCOUNT BALANCE:" + account.getBalance());
		}
		
		
	}
	private static void withdraw(Account account, double withdrawAmount) {
		if(account.getProduct() instanceof SavingsMaxAccount) {
			if(account.getBalance()>=withdrawAmount+1000) {
				account.setBalance(account.getBalance()-withdrawAmount);
				System.out.println("****YOUR TRANSACTION IS SUCCESSFUL*****\n"
						+ "ACCOUNT BALANCE:" + account.getBalance());			
			}
			else {
				System.out.println("***CANNOT WITHDRAW INSUFFICIENT FUNDS***");
			}
			
		}
		else {
			if(account.getBalance()>=withdrawAmount) {
				account.setBalance(account.getBalance()-withdrawAmount);
				System.out.println("****YOUR TRANSACTION IS SUCCESSFUL*****\n"
						+ "ACCOUNT BALANCE:" + account.getBalance());
			}
			else {
				System.out.println("***CANNOT WITHDRAW INSUFFICIENT FUNDS***");
			}
		}
		
	}
	
	
	

}


