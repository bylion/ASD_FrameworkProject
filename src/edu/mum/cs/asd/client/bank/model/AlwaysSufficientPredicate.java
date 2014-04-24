package edu.mum.cs.asd.client.bank.model;

import edu.mum.cs.asd.framework.model.Account;
import edu.mum.cs.asd.framework.model.predicate.InsufficientPredicate;

public class AlwaysSufficientPredicate extends InsufficientPredicate {
	
	@Override
	public boolean check(Account a) {
		return true;
	}
}
