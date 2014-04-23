package edu.mum.cs.asd.client.ccard.model;

import edu.mum.cs.asd.framework.model.Account;

public abstract class CreditCardAccount extends Account {

    private String expireDate;
    private double lastMonthBalance;

    public double getLastMonthBalance() {
        return 0.0;
    }

    public double getTotalMonthlyCredits() {
        return 0.0;
    }

    public double getTotalMonthlyCharges() {
        return 0.0;
    }

    @Override
    public String getVal(String key) {
        switch (key) {
            case "expireDate":
                return expireDate;
            default:
                return super.getVal(key);
        }
    }

    public abstract double getNewMonthlyBalance();

    public abstract double getMonthlyAmountDue();
}
