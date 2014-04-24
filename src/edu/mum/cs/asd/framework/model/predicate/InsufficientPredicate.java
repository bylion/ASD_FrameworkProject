package edu.mum.cs.asd.framework.model.predicate;

import edu.mum.cs.asd.framework.model.Account;

public class InsufficientPredicate implements IPredicate<Account> {

    @Override
    public boolean check(Account a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
