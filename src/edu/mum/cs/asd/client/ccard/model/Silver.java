package edu.mum.cs.asd.client.ccard.model;

import edu.mum.cs.asd.framework.model.Customer;

public class Silver extends CreditCardAccount {

    public double minPayment = 0.12;

    public Silver(String ccNumber, String expDate, Customer customer) {
        super(customer);
        this.accountNumber = ccNumber;
        this.expireDate = expDate;
        interestRate = 0.055;
    }

    @Override
    public double getMonthlyAmountDue() {
    	return minPayment * this.getNewMonthlyBalance();
    }

    @Override
    public String getAcctType() {
        return "Silver";
    }

    @Override
    public double getInterestRate() {
        return interestRate;
    }
}
