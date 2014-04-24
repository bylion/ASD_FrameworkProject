package edu.mum.cs.asd.framework.model;

import java.util.Map;

import edu.mum.cs.asd.framework.model.command.Deposit;
import edu.mum.cs.asd.framework.model.command.ICommand;
import edu.mum.cs.asd.framework.model.command.Withdraw;

public abstract class Factory implements IFactory {

    protected static Factory factory;

    public static void setFactory(Factory factory) {
        Factory.factory = factory;
    }

    public static Factory getInstance() {
        if (factory == null) {
            throw new NullPointerException("Not initialized");
        }
        return factory;
    }

    @Override
    /**
     * @param attributes all the attributes entered by the user: - name - city -
     * state - zipcode - email
     *
     * and one of the following: - numOfEmployees - birthDate (formatted
     * mm/dd/yyyy)
     *
     * The keys of the attributes have to match the above, and should be
     * verified, meaning that numOfEmployees should be an integer, and birthDate
     * should be formatted as stated.
     */
    public Customer createCustomer(Map<String, String> attributes) {
        String name = attributes.get("name");
        String street = attributes.get("street");
        String city = attributes.get("city");
        String state = attributes.get("state");
        String zipcode = attributes.get("zipcode");
        String email = attributes.get("email");

        if (attributes.get("numOfEmployees") != null) {
            return new Company(name, street, city, state, zipcode, email, Integer.parseInt(attributes.get("numOfEmployees")));
        } else {
            return new Person(name, street, city, state, zipcode, email, attributes.get("birthDate"));
        }
//        System.out.println("Creating a null customer because of wrong input formatting.");
//        return null;
    }

    @Override
    public abstract Account createAccount(Map<String, String> attributes, Customer customer);

    @Override
    public Entry createEntry(Account account, double amount, TransactionTypeEnum type) {
        return new Entry(account, amount, type);
    }

    @Override
    public ICommand createTransaction(Entry entry, int type) {
        switch (type) {
            case ICommand.DEPOSIT:
                return new Deposit(entry);
            case ICommand.INTEREST:
                return new Deposit(entry);
            case ICommand.WITHDRAW:
                return new Withdraw(entry);
            default:
                return null;
        }
    }

}
