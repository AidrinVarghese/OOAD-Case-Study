package com.ilp.service;

import java.util.ArrayList;
import java.util.Scanner;

import com.ilp.entity.Service;

public class BankService {
    public static ArrayList<Service> createService() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Service> serviceList = new ArrayList<Service>();
        System.out.println("\nPLEASE USE SERVICE CODE AND SERVICE NAME AS PROVIDED \n");
        System.out.println("SC001 - CASH DEPOSIT\n"
        		+ "SC002 - ATM WITHDRAWAL\n"
        		+ "SC003 - ONLINE BANKING\n"
        		+ "SC004 - MOBILE BANKING\n"
        		+ "SC005 - Cheque Deposit\n");        

        char serviceChoice = 0;
        do {
        	 System.out.println("ENTER SERVICE CODE: ");
             String serviceCode = scanner.nextLine();             
             if (isServiceCodeExists(serviceList, serviceCode)) {
                 System.out.println("\n SERVICE WITH THIS CODE ALREADY EXISTS.\n"
                 		+ "PLEASE ENTER A UNIQUE CODE! \n");
                 continue;
             }     
             System.out.println("ENTER SERVICE NAME:");
             String serviceName = scanner.nextLine();
             if (isServiceNameExists(serviceList, serviceName)) {
                 System.out.println("SERVICE WITH THIS NAME ALREADY EXISTS. PLEASE ENTER A UNIQUE NAME");
                 continue;
             }
             System.out.println("ENTER THE RATE:");
             double rate = scanner.nextDouble();
             scanner.nextLine();
             
             Service service = new Service(serviceCode, serviceName, rate);
             
             serviceList.add(service);
             System.out.println("CREATE MORE SERVICES ? (Y/N)");
             serviceChoice = scanner.next().charAt(0);
             scanner.nextLine();     	
        }
        while(serviceChoice == 'y' || serviceChoice == 'Y');        
        return serviceList;   
    }
    
    private static boolean isServiceCodeExists(ArrayList<Service> serviceList, String serviceCode) {
        for (Service service : serviceList) {
            if (service.getServiceCode().equals(serviceCode)) {
                return true;
            }
        }
        return false; 
    }
    private static boolean isServiceNameExists(ArrayList<Service> serviceList, String serviceName) {
        for (Service service : serviceList) {
            if (service.getServiceName().equals(serviceName)) {
                return true; 
            }
        }
        return false;
    }
    
    
}
