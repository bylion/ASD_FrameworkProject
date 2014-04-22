package edu.mum.cs.asd.framework.model;

import java.util.Date;

public class Entry implements IEntry {

	private IAccount account;
    private double amount;
    private Date date;
    private double balanceBefore;
    private double balanceAfter;
    
    /**
     * When creating an Entry object, the Entry deposits the amount to the 
     * account in the constructor immediately.
     * The date of the entry is when the constructor is called.
     * @param account The account to which to add the amount.
     * @param amount The amount to add to the account.
     */
    public Entry(IAccount account, double amount) {
    	this.account = account;
    	this.amount = amount;
    	date = new Date();
    	balanceBefore = account.getBalance();
    	account.deposit(amount);
    	balanceAfter = account.getBalance();
    }

	public IAccount getAccount() {
		return account;
	}

	public double getAmount() {
		return amount;
	}

	public Date getDate() {
		return date;
	}

	public double getBalanceBefore() {
		return balanceBefore;
	}

	public double getBalanceAfter() {
		return balanceAfter;
	}
    
}
