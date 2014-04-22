package edu.mum.cs.asd.framework.model;

import edu.mum.cs.asd.framework.model.command.Deposit;
import edu.mum.cs.asd.framework.model.command.ICommand;
import edu.mum.cs.asd.framework.model.command.Withdraw;

public abstract class Factory implements IFactory {
	
	@Override
	public ICustomer createCustomer() {
		return null;
	}

	@Override
	public abstract IAccount createAccount();

	@Override
	public IEntry createEntry(IAccount account, double amount) {
		return new Entry(account, amount);
	}

	@Override
	public ICommand createTransaction(IAccount account, double amount) {
		if (amount >= 0) {
			return new Deposit(account, amount);
		} else {
			return new Withdraw(account, amount);
		}
	}

}
