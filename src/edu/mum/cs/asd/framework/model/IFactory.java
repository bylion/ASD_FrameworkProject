package edu.mum.cs.asd.framework.model;

import edu.mum.cs.asd.framework.model.command.ICommand;

public interface IFactory {	
	
	public ICustomer createCustomer();
    public IAccount createAccount();
    public IEntry createEntry(IAccount account, double amount);
    public ICommand createTransaction(IAccount account, double amount);
}
