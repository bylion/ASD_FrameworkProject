package edu.mum.cs.asd.framework.model.command;

import edu.mum.cs.asd.framework.model.IAccount;

public class Deposit implements ICommand {

    private IAccount account;
    private double amount;
    
    public Deposit(IAccount account, double amount) {
    	this.account = account;
    	this.amount = amount;
    }

    @Override
    public void execute() {
    	account.deposit(amount);
    }

	@Override
	public void undo() {
		account.withdraw(amount);
	}
}
