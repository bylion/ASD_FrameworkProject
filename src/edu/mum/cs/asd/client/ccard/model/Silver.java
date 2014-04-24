package edu.mum.cs.asd.client.ccard.model;


public class Silver extends CreditCardAccount {

    public double minPayment = 0.12;

    public Silver() {
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
