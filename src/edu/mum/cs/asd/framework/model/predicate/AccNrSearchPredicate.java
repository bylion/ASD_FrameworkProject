package edu.mum.cs.asd.framework.model.predicate;

import edu.mum.cs.asd.framework.model.IAccount;

public class AccNrSearchPredicate implements IPredicate<IAccount> {

	private String accNr;
	
	public AccNrSearchPredicate(String accNr) {
		this.accNr = accNr;
	}
	
    @Override
    public boolean check(IAccount a) {
    	return a.getAccountNumber().equals(accNr);
    }
}
