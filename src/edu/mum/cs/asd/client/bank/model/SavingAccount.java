package edu.mum.cs.asd.client.bank.model;

import edu.mum.cs.asd.framework.model.Account;
import edu.mum.cs.asd.framework.model.Customer;
import edu.mum.cs.asd.framework.model.Entry;
import edu.mum.cs.asd.framework.model.Account;
import edu.mum.cs.asd.framework.model.predicate.IPredicate;

public class SavingAccount extends Account {

    public SavingAccount() {
        super();
        init();
    }

    public SavingAccount(Customer customer) {
        super(customer);
        init();
    }

    private void init() {
        interestRate = 0.05;
    }

    @Override
    public String getAcctType() {
        return "S";
    }

    @Override
    public double getInterestRate() {
        return interestRate;
    }

    @Override
    public String createNotification(Entry e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String generateMonthlyReport() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void withdraw(Entry e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deposit(Entry e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IPredicate<Account> getInsufficientPredicate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
