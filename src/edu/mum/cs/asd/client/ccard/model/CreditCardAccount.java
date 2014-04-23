package edu.mum.cs.asd.client.ccard.model;

import edu.mum.cs.asd.framework.model.Account;
import java.util.Date;

public abstract class CreditCardAccount extends Account {

    private Date expireDate;
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

    public abstract double getNewMonthlyBalance();

    public abstract double getMonthlyAmountDue();
}
