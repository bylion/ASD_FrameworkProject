package edu.mum.cs.asd.framework.model.test;

import edu.mum.cs.asd.framework.model.Account;
import edu.mum.cs.asd.framework.model.predicate.IPredicate;

public class AlwaysSufficientPredicate implements IPredicate<Account> {

	@Override
	public boolean check(Account t) {
		return true;
	}

}
