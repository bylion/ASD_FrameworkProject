package edu.mum.cs.asd.client.bank.model;

import edu.mum.cs.asd.framework.model.Account;
import edu.mum.cs.asd.framework.model.Customer;
import edu.mum.cs.asd.framework.model.Entry;
import edu.mum.cs.asd.framework.model.Account;
import edu.mum.cs.asd.framework.model.predicate.AlwaysSufficientPredicate;
import edu.mum.cs.asd.framework.model.predicate.IPredicate;

public class CheckingAccount extends Account {



    public CheckingAccount(Customer customer) {
        super(customer);
        init();
    }

    private void init() {
        interestRate = 0.055;
    }

    @Override
    public String getAcctType() {
        return "Ch";
    }

    @Override
    public double getInterestRate() {
        return interestRate;
    }

    @Override
    public String createNotification(Entry e) {
    	if (balance < 0) {
    		return "Balance below 0: " + balance;
    	} else {
    		return "Big transaction: " + e.getAmount();
    	}
    }

    @Override
    public String generateMonthlyReport() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void withdraw(Entry e) {
    	balance -= e.getAmount();
        if (balance < 0 || e.getAmount() > 500) {
            notifyCustomer(createNotification(e));
        }
    }

    @Override
    public void deposit(Entry e) {
        balance += e.getAmount();
        notifyCustomer(createNotification(e));
    }

    @Override
    public IPredicate<Account> getInsufficientPredicate() {
    	return new AlwaysSufficientPredicate();
    }
}
