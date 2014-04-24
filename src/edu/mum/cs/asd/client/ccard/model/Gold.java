package edu.mum.cs.asd.client.ccard.model;

import edu.mum.cs.asd.framework.model.Entry;
import edu.mum.cs.asd.framework.model.Account;
import edu.mum.cs.asd.framework.model.Customer;
import edu.mum.cs.asd.framework.model.predicate.IPredicate;
import edu.mum.cs.asd.framework.model.predicate.InsufficientPredicate;

public class Gold extends CreditCardAccount {

    public double minPayment = 0.1;

    public Gold(String ccNumber, String expDate, Customer customer) {
        this.customer = customer;
        this.accountNumber = ccNumber;
        this.expireDate = expDate;
        interestRate = 0.05;
    }

    @Override
    public double getMonthlyAmountDue() {
        return minPayment * this.getNewMonthlyBalance();
    }

    @Override
    public String getAcctType() {
        return "Gold";
    }

    @Override
    public double getInterestRate() {
        return interestRate;
    }

    @Override
    public IPredicate<Account> getInsufficientPredicate() {
        return new InsufficientPredicate();
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
