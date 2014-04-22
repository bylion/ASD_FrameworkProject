package edu.mum.cs.asd.framework.model;

import edu.mum.cs.asd.framework.model.functor.IFunctor;
import edu.mum.cs.asd.framework.model.predicate.IPredicate;

public interface IAccount {
	
	public void addEntry(IEntry entry);
	public double getBalance();
	public void notifyCustomer();
	public double getInterestValue();
	public <R> R searchEntries(IPredicate<IEntry> predicate, IFunctor<IEntry, R> functor);
	public String getAcctType();
	public void withdraw(double amount);
	public void deposit(double amount);
	public IPredicate<IAccount> getInsufficientPredicate();
}
