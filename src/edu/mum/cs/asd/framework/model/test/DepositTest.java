package edu.mum.cs.asd.framework.model.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import edu.mum.cs.asd.framework.model.Customer;
import edu.mum.cs.asd.framework.model.Entry;
import edu.mum.cs.asd.framework.model.IAccount;
import edu.mum.cs.asd.framework.model.IEntry;
import edu.mum.cs.asd.framework.model.Person;
import edu.mum.cs.asd.framework.model.command.CommandManager;
import edu.mum.cs.asd.framework.model.command.Deposit;
import edu.mum.cs.asd.framework.model.command.ICommand;

public class DepositTest {
	
	@Test
	public void depositTest() {
		Customer c = new Person(null, null, null, null, null, null, null);
		IAccount acc = new DummyAccount();
		c.addAccount(acc);
		CommandManager mgr = new CommandManager();
		IEntry entry = new Entry(acc, 50);
		ICommand deposit = new Deposit(entry);
		mgr.submit(deposit);
		assertEquals("Balance of account should be 0 + deposit (" + entry.getAmount() + ").", (int) acc.getBalance(), (int) entry.getAmount());
	}
}
