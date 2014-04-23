package edu.mum.cs.asd.framework.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import edu.mum.cs.asd.framework.model.functor.EntryListFunctor;
import edu.mum.cs.asd.framework.model.functor.IFunctor;
import edu.mum.cs.asd.framework.model.predicate.CurrentMonthPredicate;
import edu.mum.cs.asd.framework.model.predicate.IPredicate;
import edu.mum.cs.asd.framework.model.predicate.InsufficientPredicate;

public abstract class Account implements IAccount {

    protected String accountNumber;
    protected double balance;
    protected Customer customer;
    protected List<IEntry> entries;

    public InsufficientPredicate Unnamed6;
    public CurrentMonthPredicate Unnamed7;
    public EntryListFunctor Unnamed8;

    public Account() {
        accountNumber = UUID.randomUUID().toString();
        balance = 0;
        entries = new ArrayList<>();
    }

    @Override
    public void addEntry(IEntry entry) {
        entries.add(entry);
    }

    public double getCustomerBalance() {
        return balance;
    }

    @Override
    public void notifyCustomer() {
        customer.sendEmail(createNotification());
    }

    @Override
    public double getInterestValue() {
        return getInterestRate() * balance;
    }

    @Override
    public <R> R searchEntries(IPredicate<IEntry> predicate, IFunctor<IEntry, R> functor) {
        for (IEntry e : entries) {
            if (predicate.check(e)) {
                functor.compute(e);
            }
        }
        return functor.getValue();
    }

    @Override
    public String getAccountNumber() {
        return accountNumber;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public abstract String getAcctType();

    public abstract double getInterestRate();

    public abstract String createNotification();

    public abstract void generateMonthlyReport();

    @Override
    public abstract void withdraw(double amount);

    @Override
    public abstract void deposit(double amount);

    @Override
    public abstract IPredicate<IAccount> getInsufficientPredicate();

    @Override
    public String toString() {
        return getAcctType();
    }
    
}
