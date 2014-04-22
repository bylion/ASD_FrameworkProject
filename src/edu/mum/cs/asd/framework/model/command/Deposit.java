package edu.mum.cs.asd.framework.model.command;

import edu.mum.cs.asd.framework.model.Account;
import edu.mum.cs.asd.framework.model.IAccount;
import edu.mum.cs.asd.framework.model.predicate.AccNrSearchPredicate;

public class Deposit implements ICommand {

    public Account Unnamed1;
    public AccNrSearchPredicate Unnamed2;
    
    public Deposit(IAccount account, double amount) {
    	
    }

    @Override
    public void execute() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
