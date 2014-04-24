package edu.mum.cs.asd.framework.model.command;

import edu.mum.cs.asd.framework.model.Entry;

public class Deposit implements ICommand {

    private static final String TYPE = "Deposit";
    private Entry entry;

    public Deposit(Entry entry) {
        this.entry = entry;
        entry.setType(TYPE);
    }

    @Override
    public void execute() {
        entry.getAccount().deposit(entry);
    }

    @Override
    public void undo() {
        entry.getAccount().withdraw(entry);
    }
}
