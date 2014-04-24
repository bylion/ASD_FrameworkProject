package edu.mum.cs.asd.client.ccard.model;

import edu.mum.cs.asd.framework.model.Customer;


public class Bronze extends CreditCardAccount {

    private double minPayment = 0.14;

    public Bronze(String ccNumber, String expDate, Customer customer) {
        super(customer);
        this.accountNumber = ccNumber;
        this.expireDate = expDate;
        interestRate = 0.06;
    }

    @Override
    public double getMonthlyAmountDue() {
    	return minPayment * this.getNewMonthlyBalance();
    }

    @Override
    public String getAcctType() {
        return "Bronze";
    }

    @Override
    public double getInterestRate() {
        return interestRate;
    }
}
