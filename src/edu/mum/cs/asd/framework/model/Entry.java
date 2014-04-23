package edu.mum.cs.asd.framework.model;

import java.util.Date;

public class Entry implements IEntry {

    private IAccount account;
    private double amount;
    private Date date;
    private double balanceBefore;
    private double balanceAfter;
    private String type;

    /**
     * Create an entry before doing the actual transaction, as when creating an
     * entry, it calls account.getBalance() for the balanceBefore.
     *
     * The date of the entry is when the constructor is called.
     *
     * @param account The account to which to add the amount.
     * @param amount The amount to add to the account.
     */
    public Entry(IAccount account, double amount) {
        this.account = account;
        this.amount = amount;
        date = new Date();
        balanceBefore = account.getBalance();
        balanceAfter = balanceBefore + amount;
    }

    @Override
    public IAccount getAccount() {
        return account;
    }

    @Override
    public double getAmount() {
        return amount;
    }

    @Override
    public Date getDate() {
        return date;
    }

    @Override
    public double getBalanceBefore() {
        return balanceBefore;
    }

    @Override
    public double getBalanceAfter() {
        return balanceAfter;
    }

	public final String getType() {
		return type;
	}

	public final void setType(String type) {
		this.type = type;
	}

}
