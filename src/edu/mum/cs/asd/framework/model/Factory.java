package edu.mum.cs.asd.framework.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

import edu.mum.cs.asd.framework.model.command.Deposit;
import edu.mum.cs.asd.framework.model.command.ICommand;
import edu.mum.cs.asd.framework.model.command.Withdraw;

public abstract class Factory implements IFactory {
	
	@Override
	/**
	 * @param attributes all the attributes entered by the user:
	 * - name
	 * - city
	 * - state
	 * - zipcode
	 * - email
	 * 
	 * and one of the following:
	 * - numOfEmployees
	 * - birthDate (formatted mm/dd/yyyy)
	 * 
	 * The keys of the attributes have to match the above, and should be verified,
	 * meaning that numOfEmployees should be an integer, and 
	 * birthDate should be formatted as stated.
	 */
	public ICustomer createCustomer(Map<String, String> attributes) {
		String name = attributes.get("name");
		String street = attributes.get("street");
		String city = attributes.get("city");
		String state = attributes.get("state");
		String zipcode = attributes.get("zipcode");
		String email = attributes.get("email");
		
		if (attributes.get("numOfEmployees") != null) {
			return new Company(name, street, city, state, zipcode, email, Integer.parseInt(attributes.get("numOfEmployees")));
		} else {
			try {
				Date birthDate = new SimpleDateFormat("mm/dd/yyyy", Locale.ENGLISH).parse(attributes.get("birthDate"));
				return new Person(name, street, city, state, zipcode, email, birthDate);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Creating a null customer because of wrong input formatting.");
		return null;
	}

	@Override
	public abstract IAccount createAccount();

	@Override
	public IEntry createEntry(IAccount account, double amount) {
		return new Entry(account, amount);
	}

	@Override
	public ICommand createTransaction(IAccount account, double amount) {
		if (amount >= 0) {
			return new Deposit(account, amount);
		} else {
			return new Withdraw(account, amount);
		}
	}

}
