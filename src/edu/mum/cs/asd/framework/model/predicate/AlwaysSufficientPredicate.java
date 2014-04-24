package edu.mum.cs.asd.framework.model.predicate;

import edu.mum.cs.asd.framework.model.Account;

public class AlwaysSufficientPredicate extends InsufficientPredicate {
	
	@Override
	public boolean check(Account a) {
		return true;
	}
}
