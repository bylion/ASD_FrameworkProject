package edu.mum.cs.asd.framework.model;

import edu.mum.cs.asd.framework.model.functor.IFunctor;
import edu.mum.cs.asd.framework.model.predicate.IPredicate;

public interface IAccount {

    public String getAccountNumber();

    public void addEntry(IEntry entry);

    public double getBalance();

    public void notifyCustomer(String message);

    public double getInterestValue();

    public <R> R searchEntries(IPredicate<IEntry> predicate, IFunctor<IEntry, R> functor);

    public String getAcctType();

    public void withdraw(Entry e);

    public void deposit(Entry e);

    public IPredicate<IAccount> getInsufficientPredicate();
    
    public String getVal(String key);
}
