package edu.mum.cs.asd.framework.model.command;

import edu.mum.cs.asd.framework.model.Entry;
import edu.mum.cs.asd.framework.model.IAccount;
import edu.mum.cs.asd.framework.model.predicate.IPredicate;

public class Withdraw implements ICommand {

    private static final String TYPE = "Withdrawal";
    private Entry entry;
    private IPredicate<IAccount> predicate;

    private boolean executed;

    public Withdraw(Entry entry) {
        this.entry = entry;
        entry.setType(TYPE);
        this.predicate = entry.getAccount().getInsufficientPredicate();
        executed = false;
    }

    @Override
    public void execute() {
        if (predicate.check(entry.getAccount())) {
            entry.getAccount().withdraw(entry);
            executed = true;
        }
    }

    @Override
    public void undo() {
        if (executed) {
            entry.getAccount().deposit(entry);
            executed = false;
        }
    }
}
