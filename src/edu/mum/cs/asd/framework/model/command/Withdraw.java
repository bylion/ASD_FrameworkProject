package edu.mum.cs.asd.framework.model.command;

import edu.mum.cs.asd.framework.model.IAccount;
import edu.mum.cs.asd.framework.model.IEntry;
import edu.mum.cs.asd.framework.model.predicate.IPredicate;

public class Withdraw implements ICommand {

    private IEntry entry;
    private IPredicate<IAccount> predicate;
    
    private boolean executed;
    
    public Withdraw(IEntry entry) {
    	this.entry = entry;
    	this.predicate = entry.getAccount().getInsufficientPredicate();
    	executed = false;
    }

    @Override
    public void execute() {
    	if (predicate.check(entry.getAccount())) {
    		entry.getAccount().withdraw(Math.abs(entry.getAmount()));
    		executed = true;
    	}
    }

	@Override
	public void undo() {
		if (executed) {
			entry.getAccount().deposit(Math.abs(entry.getAmount()));
			executed = false;
		}
	}
}
