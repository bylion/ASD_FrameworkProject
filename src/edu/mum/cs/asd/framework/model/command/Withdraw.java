package edu.mum.cs.asd.framework.model.command;

import edu.mum.cs.asd.framework.model.Account;
import edu.mum.cs.asd.framework.model.IAccount;
import edu.mum.cs.asd.framework.model.predicate.AccNrSearchPredicate;
import edu.mum.cs.asd.framework.model.predicate.InsufficientPredicate;

public class Withdraw implements ICommand {

    public Account Unnamed1;
    public InsufficientPredicate Unnamed2;
    public AccNrSearchPredicate Unnamed3;
    
    public Withdraw(IAccount account, double amount) {
    	
    }

    @Override
    public void execute() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
