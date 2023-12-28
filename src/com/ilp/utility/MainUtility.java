package com.ilp.utility;

import java.util.ArrayList;
import java.util.Scanner;
import com.ilp.entity.Account;
import com.ilp.entity.Customer;
import com.ilp.entity.Product;
import com.ilp.entity.Service;
import com.ilp.service.AccountService;
import com.ilp.service.BankService;
import com.ilp.service.CustomerService;
import com.ilp.service.ManageAccount;
import com.ilp.service.ProductService;

public class MainUtility {

		public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<Service> serviceList = new ArrayList<Service>();
		ArrayList<Product> productList = new ArrayList<Product>();
		
		Account account = null;
		Customer customer = null;
		char mainChoice = 0;
		
		do {
			
			System.out.println("******************************************************************");
			System.out.println("*                   WELCOME TO YES BANK MANAGEMENT                *");
			System.out.println("******************************************************************\n");

			System.out.println("Options:");
			System.out.println("1. CREATE A SERVICE");
			System.out.println("2. CREATE A PRODUCT");
			System.out.println("3. CREATE A CUSTOMER");
			System.out.println("4. MANAGE YOUR ACCOUNTS");
			System.out.println("5. DISPLAY CUSTOMER DETAILS");
			System.out.println("6. EXIT FROM THE FACILITY\n");

			System.out.println("Please choose from the above options :)\n");
			System.out.println("******************************************************************");
	
			
			int bankMenuOption = scanner.nextInt();
			
			switch(bankMenuOption) {			
			case 1:
				serviceList.addAll(BankService.createService());
				for(Service service: serviceList) {
					System.out.println(service);
				}
				break;
				
			case 2: 
				if(serviceList.size()==0) {
					System.out.println("\nCREATE A SERVICE FIRST!\n");
					break;
				}
				ProductService.createProduct(serviceList,productList);
				break;
				
			case 3:
				if(productList.size()==0) {
					System.out.println("\nCREATE A PRODUCT FIRST!\n");
					break;
				}
				
				if(customer == null)
				{
					account = AccountService.createAccount(productList);
					customer = CustomerService.createCustomer(account);
				}
				else
				{
					account = AccountService.createAccount(productList);
					ArrayList<Account> tempAccountList=customer.getAccountList();
					tempAccountList.add(account);
					customer.setAccountList(tempAccountList);
				}
				break;
				
			case 4:
				if(customer==null) {
					System.out.println("\nCREATE A CUSTOMER FIRST!\n");
					break;
				}
				 ManageAccount.manageAccounts(customer);
                 break;
                 
			case 5:
				if(customer==null) {
					System.out.println("\nCREATE A CUSTOMER FIRST!\n");
					break;
				}
				CustomerService.displayCustomerInfo(customer);
				break;
			case 6:
				System.out.println("THANK YOU FOR USING OUR SERVICES! EXITING.........");
				System.exit(0);
				
			default :
				System.out.println("INVALID CHOICE, PLEASE CHOOSE CORRECT OPTION");
				
			}
			System.out.println("WELCOME TO BANK MAIN MENU: \n WOULD YOU LIKE TO CONTINUE ?");
			mainChoice=scanner.next().charAt(0);
			
		}while( mainChoice == 'y' || mainChoice == 'Y'); 
	}

}
