package edu.mum.cs.asd.framework.model.test;

import edu.mum.cs.asd.framework.model.Account;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import edu.mum.cs.asd.framework.model.Customer;
import edu.mum.cs.asd.framework.model.Entry;
import edu.mum.cs.asd.framework.model.Person;
import edu.mum.cs.asd.framework.model.TransactionTypeEnum;
import edu.mum.cs.asd.framework.model.command.CommandManager;
import edu.mum.cs.asd.framework.model.command.Deposit;
import edu.mum.cs.asd.framework.model.command.ICommand;

public class DepositTest {

    @Test
    public void depositTest() {
        Customer c = new Person(null, null, null, null, null, null, null);
        Account acc = new AlwaysInsufficientAccount(c);
        c.addAccount(acc);
        CommandManager mgr = new CommandManager();
        Entry entry = new Entry(acc, 50, TransactionTypeEnum.DEPOSIT);
        ICommand deposit = new Deposit(entry);
        mgr.submit(deposit);
        assertEquals("Balance of account should be 0 + deposit (" + entry.getAmount() + ").", (int) acc.getBalance(), (int) entry.getAmount());
    }
}
