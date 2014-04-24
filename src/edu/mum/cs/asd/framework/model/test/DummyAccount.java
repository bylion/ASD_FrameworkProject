package edu.mum.cs.asd.framework.model.test;

import edu.mum.cs.asd.framework.model.Account;
import edu.mum.cs.asd.framework.model.Customer;
import edu.mum.cs.asd.framework.model.Entry;
import edu.mum.cs.asd.framework.model.predicate.IPredicate;

/**
 * The DummyAccount never has enough money to withdraw, because of the
 * AlwaysInsufficientPredicate
 *
 * @author Soerian
 *
 */
public class DummyAccount extends Account {

    private double balance;
    private static final double INTEREST_RATE = 0.05;

    public DummyAccount(Customer customer) {
    	super(customer);
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
    public String generateMonthlyReport() {
        System.out.println("Generated monthly report");
        return "Generated monthly report";
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
    public IPredicate<Account> getInsufficientPredicate() {
        return new AlwaysInsufficientPredicate();
    }

}
