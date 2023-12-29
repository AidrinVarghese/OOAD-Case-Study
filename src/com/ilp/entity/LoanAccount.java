package com.ilp.entity;

import java.util.ArrayList;

public class LoanAccount extends Product {
	private double checkDeposit;

	public double getCheckDeposit() {
		return checkDeposit;
	}

	public void setCheckDeposit(double checkDeposit) {
		this.checkDeposit = checkDeposit;
	}

	public LoanAccount(String productCode, String productName, ArrayList<Service> serviceList, double checkDeposit) {
		super(productCode, productName, serviceList);
		this.checkDeposit = checkDeposit;
	}

	@Override
	public String toString() {
		return "LoanAccount [checkDeposit=" + checkDeposit + "]";
	}

	

}
