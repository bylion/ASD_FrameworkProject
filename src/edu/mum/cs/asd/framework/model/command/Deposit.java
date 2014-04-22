package edu.mum.cs.asd.framework.model.command;

import edu.mum.cs.asd.framework.model.IEntry;

public class Deposit implements ICommand {

    private IEntry entry;
    
    public Deposit(IEntry entry) {
    	this.entry = entry;
    }

    @Override
    public void execute() {
    	entry.getAccount().deposit(entry.getAmount());
    }

	@Override
	public void undo() {
		entry.getAccount().withdraw(entry.getAmount());
	}
}
