package edu.mum.cs.asd.framework.model.test;

import edu.mum.cs.asd.framework.model.Account;
import edu.mum.cs.asd.framework.model.Entry;
import edu.mum.cs.asd.framework.model.IAccount;
import edu.mum.cs.asd.framework.model.predicate.IPredicate;

/**
 * The account never has enough money to withdraw, because of the 
 * AlwaysInsufficientPredicate
 * @author Soerian
 *
 */
public class AlwaysInsufficientAccount extends Account {

	private double balance;
	private static final double INTEREST_RATE = 0.05;
	
	public AlwaysInsufficientAccount() {
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
	public String createNotification(Entry e) {
		return "Notification";
	}

	@Override
	public void generateMonthlyReport() {
		System.out.println("Generated monthly report");
	}

	@Override
	public void withdraw(Entry e) {
		balance -= e.getAmount();
	}

	@Override
	public void deposit(Entry e) {
		balance += e.getAmount();
	}

	@Override
	public IPredicate<IAccount> getInsufficientPredicate() {
		return new AlwaysInsufficientPredicate();
	}

}
