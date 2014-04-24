package edu.mum.cs.asd.framework.model;

import java.util.Map;

import edu.mum.cs.asd.framework.model.command.ICommand;

public interface IFactory {

    public Customer createCustomer(Map<String, String> attributes);

    public Account createAccount(Map<String, String> attributes, ICustomer customer);

    public Entry createEntry(IAccount account, double amount);

    public ICommand createTransaction(Entry entry, int type);
}
