package edu.mum.cs.asd.framework.model.command;

import edu.mum.cs.asd.framework.model.Entry;
import edu.mum.cs.asd.framework.model.TransactionTypeEnum;

public class AddInterest implements ICommand {

    private static final TransactionTypeEnum TYPE = TransactionTypeEnum.INTEREST;
    private Entry entry;

    public AddInterest(Entry entry) {
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
