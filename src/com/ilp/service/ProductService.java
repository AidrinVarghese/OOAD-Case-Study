package com.ilp.service;

import java.util.ArrayList;
import java.util.Scanner;

import com.ilp.entity.CurrentAccount;
import com.ilp.entity.LoanAccount;
import com.ilp.entity.Product;
import com.ilp.entity.SavingsMaxAccount;
import com.ilp.entity.Service;

public class ProductService{
	static Scanner scanner = new Scanner(System.in);

	
public static void createProduct(ArrayList<Service> serviceList,ArrayList<Product> productList) {
		System.out.println("PLEASE USE THE PRODUCT CODE AND NAME GIVEN BELOW \n"
				+ "PR001 - SAVINGS MAX ACCOUNT \n"
				+ "PR002 - CURRENT ACCOUNT\n"
				+ "PR003 - LOAN ACCOUNT");		
	
			ArrayList<Service> temporaryServiceList = new ArrayList<Service>(); 
			System.out.println("\nENTER PRODUCT CODE:");
			String productCode = scanner.nextLine();
			System.out.println("\nENTER PRODUCT NAME:");
			String productName = scanner.nextLine();						
			linkServices(serviceList,temporaryServiceList);
				
			switch(productCode)
			{
			case "PR001" :
   				SavingsMaxAccount savingsMaxAccount = new SavingsMaxAccount(productCode, productName, temporaryServiceList, 1000);
				productList.add(savingsMaxAccount);
				break;
				
			case "PR002" :
				CurrentAccount currentAccount = new CurrentAccount(productCode,productName, temporaryServiceList);
				productList.add(currentAccount);
				break;
				
			case "PR003" :
				LoanAccount loanAccount = new LoanAccount(productCode, productName, temporaryServiceList, 0.03);
				productList.add(loanAccount);
				break;
			default:
				System.out.println("INVALID, TRY AGAIN !");
				break;
			}
}
			public static void linkServices(ArrayList<Service> mainServiceList, ArrayList<Service> serviceList) {
		        char menuChoice;
		        String serviceChoice;
		        Service currentService = null;
		        ArrayList<Service> localMainServiceList = (ArrayList<Service>) mainServiceList.clone();
		 
		        do {
		            for (Service service : localMainServiceList) {
		                System.out.println(service.toString());
		            }
		            System.out.println("\nENTER THE SERVICE CODE TO LINK TO THE PRODUCT:");
		            serviceChoice = scanner.nextLine();
		 
		            for (Service service : localMainServiceList) {
		                if (serviceChoice.equals(service.getServiceCode())) {
		                    currentService = service;
		                    serviceList.add(currentService);
		                }
		            }
		 
		            if (currentService != null)
		                localMainServiceList.remove(currentService);
		            if(localMainServiceList.isEmpty())
		            	return;
		            System.out.println("CONTINUE LINKING SERVICES (Y/N):");
		            menuChoice = scanner.next().charAt(0);
		        } while (menuChoice =='y' || menuChoice == 'Y');
		    }	
}
