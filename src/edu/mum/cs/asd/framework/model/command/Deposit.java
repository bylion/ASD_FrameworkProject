package edu.mum.cs.asd.framework.model.command;

import edu.mum.cs.asd.framework.model.Entry;
import edu.mum.cs.asd.framework.model.TransactionTypeEnum;

public class Deposit implements ICommand {

    private static final TransactionTypeEnum TYPE = TransactionTypeEnum.DEPOSIT;
    private Entry entry;
    private boolean executed;
    
    public Deposit(Entry entry) {
        this.entry = entry;
        entry.setType(TYPE);
        executed = false;
    }

    @Override
    public void execute() {
        entry.getAccount().deposit(entry);
        executed = true;
    }

    @Override
    public void undo() {
        entry.getAccount().withdraw(entry);
        executed = false;
    }
}
