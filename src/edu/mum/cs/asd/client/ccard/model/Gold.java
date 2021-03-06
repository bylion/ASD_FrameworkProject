package edu.mum.cs.asd.client.ccard.model;

import edu.mum.cs.asd.framework.model.Customer;


public class Gold extends CreditCardAccount {

    public double minPayment = 0.1;

    public Gold(String ccNumber, String expDate, Customer customer) {
        super(customer);
        this.accountNumber = ccNumber;
        this.expireDate = expDate;
        interestRate = 0.05;
    }

    @Override
    public double getMonthlyAmountDue() {
        return minPayment * this.getNewMonthlyBalance();
    }

    @Override
    public String getAcctType() {
        return "Gold";
    }

    @Override
    public double getInterestRate() {
        return interestRate;
    }

}
