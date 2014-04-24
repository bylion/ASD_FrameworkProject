package edu.mum.cs.asd.framework.model.predicate;

import edu.mum.cs.asd.framework.model.Account;

public class AccNrSearchPredicate implements IPredicate<Account> {

	private String accNr;
	
	public AccNrSearchPredicate(String accNr) {
		this.accNr = accNr;
	}
	
    @Override
    public boolean check(Account a) {
    	return a.getAccountNumber().equals(accNr);
    }
}
