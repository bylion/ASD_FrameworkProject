package edu.mum.cs.asd.framework.model.test;

import edu.mum.cs.asd.framework.model.Account;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import edu.mum.cs.asd.framework.model.Customer;
import edu.mum.cs.asd.framework.model.Entry;
import edu.mum.cs.asd.framework.model.Person;
import edu.mum.cs.asd.framework.model.TransactionTypeEnum;
import edu.mum.cs.asd.framework.model.command.CommandManager;
import edu.mum.cs.asd.framework.model.command.ICommand;
import edu.mum.cs.asd.framework.model.command.Withdraw;

public class WithdrawTest {

    @Test
    public void withdrawInsufficientTest() {
        Customer c = new Person(null, null, null, null, null, null, null);
        Account acc = new AlwaysInsufficientAccount(c);
        c.addAccount(acc);
        CommandManager mgr = new CommandManager();
        Entry entry = new Entry(acc, 50, TransactionTypeEnum.WITHDRAW);
        ICommand withdraw = new Withdraw(entry);
        mgr.submit(withdraw);
        assertEquals("Balance of account should be 0.", (int) acc.getBalance(), 0);
    }

    @Test
    public void withdrawSufficientTest() {
        Customer c = new Person(null, null, null, null, null, null, null);
        Account acc = new AlwaysSufficientAccount(c);
        c.addAccount(acc);
        CommandManager mgr = new CommandManager();
        Entry entry = new Entry(acc, 50, TransactionTypeEnum.WITHDRAW);
        ICommand withdraw = new Withdraw(entry);
        mgr.submit(withdraw);
        assertEquals("Balance of account should be 0 - withdraw (" + entry.getAmount() + ").", (int) acc.getBalance(), (int) entry.getAmount());
    }
}
