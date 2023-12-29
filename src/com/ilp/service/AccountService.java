package com.ilp.service;

import java.util.ArrayList;
import java.util.Scanner;

import com.ilp.entity.Account;
import com.ilp.entity.Product;
import com.ilp.entity.SavingsMaxAccount;

public class AccountService {
    public static Account createAccount(ArrayList<Product> productList) {
        Scanner scanner = new Scanner(System.in);
        double balanceAmount;
        int i = 0;
        
        System.out.println("*------------------------------------------------*");
        System.out.println("************LIST OF AVAILABLE PRODUCTS************");
        System.out.println("*------------------------------------------------*");
        for (Product product : productList) {
            System.out.println(i + ". " + product.getProductName());
            System.out.println();
            i++;
        }
        System.out.println("*------------------------------------------------*");
        System.out.println("*******SELECT A PRODUCT NUMBER FROM THE LIST******");
        System.out.println("*------------------------------------------------*");
        int productChoice = scanner.nextInt();
        scanner.nextLine();


        if (productChoice < 0 || productChoice >= productList.size()) {
            System.out.println("\t \tINVALID PRODUCT CHOICE!");
            return null; 
        }

 
        Product selectedProduct = productList.remove(productChoice);
        String productName = selectedProduct.getProductName();

        System.out.print("\n \tENTER ACCOUNT NUMBER: ");
        String accountNo = scanner.nextLine();
        System.out.println("\n \tCREDIT CASH TO YOUR ACCOUNT:");
        balanceAmount = scanner.nextDouble();

        if (selectedProduct instanceof SavingsMaxAccount) {
            SavingsMaxAccount savingsMaxAccount = (SavingsMaxAccount) selectedProduct;
            while (balanceAmount < savingsMaxAccount.getMinBalance()) {
                System.out.println("\tINSUFFICIENT ACCOUNT BALANCE! \n\t MINIMUM BALANCE MUST NOT GO BELOW:"
                        + savingsMaxAccount.getMinBalance());
                System.out.println("\tRE-ENTER CREDIT CASH:");
                balanceAmount = scanner.nextDouble();
            }
        }

        Account account = new Account(accountNo, productName, balanceAmount, selectedProduct);
        return account;
    }
}


