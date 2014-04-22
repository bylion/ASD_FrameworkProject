package edu.mum.cs.asd.framework.model.test;

import edu.mum.cs.asd.framework.model.Account;
import edu.mum.cs.asd.framework.model.IAccount;
import edu.mum.cs.asd.framework.model.predicate.IPredicate;

/**
 * The DummyAccount never has enough money to withdraw, because of the 
 * AlwaysInsufficientPredicate
 * @author Soerian
 *
 */
public class DummyAccount extends Account {

	private double balance;
	private static final double INTEREST_RATE = 0.05;
	
	public DummyAccount() {
		balance = 0;
	}
	
	@Override
	public double getBalance() {
		return balance;
	}

	@Override
	public String getAcctType() {
		return "Account type";
	}

	@Override
	public double getInterestRate() {
		return INTEREST_RATE;
	}

	@Override
	public String createNotification() {
		return "Notification";
	}

	@Override
	public void generateMonthlyReport() {
		System.out.println("Generated monthly report");
	}

	@Override
	public void withdraw(double amount) {
		balance -= amount;
	}

	@Override
	public void deposit(double amount) {
		balance += amount;
	}

	@Override
	public IPredicate<IAccount> getInsufficientPredicate() {
		return new AlwaysInsufficientPredicate();
	}

}
