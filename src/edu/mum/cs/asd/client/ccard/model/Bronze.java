package edu.mum.cs.asd.client.ccard.model;

import edu.mum.cs.asd.framework.model.Entry;
import edu.mum.cs.asd.framework.model.Account;
import edu.mum.cs.asd.framework.model.predicate.IPredicate;

public class Bronze extends CreditCardAccount {

    private double minPayment = 0.14;

    public Bronze() {
        interestRate = 0.06;
    }

    @Override
    public double getNewMonthlyBalance() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double getMonthlyAmountDue() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getAcctType() {
        return "Bronze";
    }

    @Override
    public double getInterestRate() {
        return interestRate;
    }

    @Override
    public String generateMonthlyReport() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IPredicate<Account> getInsufficientPredicate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String createNotification(Entry e) {
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
}
