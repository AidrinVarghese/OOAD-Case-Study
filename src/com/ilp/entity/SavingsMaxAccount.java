package com.ilp.entity;

import java.util.ArrayList;

public class SavingsMaxAccount extends Product {
	public SavingsMaxAccount(String productCode, String productName, ArrayList<Service> serviceList, double minBalance) {
		super(productCode, productName, serviceList);
		// TODO Auto-generated constructor stub
	}
	
	private double minBalance = 1000.00;
	
	public double getMinBalance() {
		return minBalance;
	}

	public void setMinBalance(double minBalance) {
		this.minBalance = minBalance;
	}

	@Override
	public String toString() {
		return "SavingsMaxAccount [minBalance=" + minBalance + "]";
	}

	

}
