package edu.mum.cs.asd.framework.model.command;

import edu.mum.cs.asd.framework.model.IAccount;
import edu.mum.cs.asd.framework.model.predicate.IPredicate;

public class Withdraw implements ICommand {

    private IAccount account;
    private double amount;
    private IPredicate<IAccount> predicate;
    
    private boolean executed;
    
    public Withdraw(IAccount account, double amount) {
    	this.account = account;
    	this.amount = amount;
    	this.predicate = account.getInsufficientPredicate();
    	executed = false;
    }

    @Override
    public void execute() {
    	if (predicate.check(account)) {
    		account.withdraw(amount);
    		executed = true;
    	}
    }

	@Override
	public void undo() {
		if (executed) {
			account.deposit(amount);
			executed = false;
		}
	}
}
