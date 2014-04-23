package edu.mum.cs.asd.framework.model.command;

import edu.mum.cs.asd.framework.model.IEntry;

public class AddInterest implements ICommand{

	private static final String TYPE = "Interest";
	private IEntry entry;
	
	public AddInterest(IEntry entry) {
		this.entry = entry;
		entry.setType(TYPE);
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
