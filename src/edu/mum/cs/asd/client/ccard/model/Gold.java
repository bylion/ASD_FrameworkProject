package edu.mum.cs.asd.client.ccard.model;


public class Gold extends CreditCardAccount {

    public double minPayment = 0.1;

    public Gold() {
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
