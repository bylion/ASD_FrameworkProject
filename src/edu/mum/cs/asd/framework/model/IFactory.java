package edu.mum.cs.asd.framework.model;

import java.util.Map;

import edu.mum.cs.asd.framework.model.command.ICommand;

public interface IFactory {	
	
	public ICustomer createCustomer(Map<String, String> attributes);
    public IAccount createAccount();
    public IEntry createEntry(IAccount account, double amount);
    public ICommand createTransaction(IAccount account, double amount);
}
