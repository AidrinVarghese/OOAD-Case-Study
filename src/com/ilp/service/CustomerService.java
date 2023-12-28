package com.ilp.service;

import java.util.ArrayList;
import java.util.Scanner;

import com.ilp.entity.Account;
import com.ilp.entity.Customer;
import com.ilp.entity.Service;

public class CustomerService {
	public static Customer createCustomer(Account account) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("ENTER CUSTOMER CODE: ");
		String customerCode = scanner.next();
		
		System.out.print("ENTER CUSTOMER NAME: ");
		String customerName = scanner.next();
		
		ArrayList<Account> accountList = new ArrayList<Account>();
		accountList.add(account);
		
		Customer customer = new Customer(customerCode, customerName, accountList);
		return customer;
	}
	
	public static void displayCustomerInfo(Customer customer) {
        System.out.println("CUSTOMER CODE: " + customer.getCustomerCode());
        System.out.println("CUSTOMER NAME: " + customer.getCustomerName());

        for (Account account : customer.getAccountList()) {
            System.out.println("ACCOUNT TYPE: " + account.getAccountType());
            System.out.println("ACCOUNT BALANCE: " + account.getBalance());
            // Display services within the account
            ArrayList<Service> serviceList = account.getProduct().getServiceList();          

            for (Service service : serviceList) {
                System.out.println("SERVICE NAME: " + service.getServiceName());
                // Add other relevant service information as needed
            }

            System.out.println(); // Add a newline for better readability
        }
    }


}
