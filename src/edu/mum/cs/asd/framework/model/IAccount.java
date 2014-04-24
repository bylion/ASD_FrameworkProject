package edu.mum.cs.asd.framework.model;

import edu.mum.cs.asd.framework.model.functor.IFunctor;
import edu.mum.cs.asd.framework.model.predicate.IPredicate;

public interface IAccount {

    public String getAccountNumber();

    public void addEntry(Entry entry);

    public double getBalance();

    public void notifyCustomer(String message);

    public double getInterestValue();

    public <R> R searchEntries(IPredicate<Entry> predicate, IFunctor<Entry, R> functor);

    public String getAcctType();

    public void withdraw(Entry e);

    public void deposit(Entry e);

    public IPredicate<Account> getInsufficientPredicate();
    
    public String getVal(String key);
}
