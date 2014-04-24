package edu.mum.cs.asd.client.bank.model;

import edu.mum.cs.asd.framework.model.Account;
import edu.mum.cs.asd.framework.model.Factory;
import edu.mum.cs.asd.framework.model.Customer;
import java.util.Map;

public class BankFactory extends Factory {

    @Override
    public Account createAccount(Map<String, String> attributes, Customer customer) {
        //Produce account by fields in GUI
        
        switch (attributes.get("type")) {
            case "checking":
                return new CheckingAccount(customer);
            case "saving":
                return new SavingAccount(customer);
        }
        
        System.out.println("System does not support this type of account.");
        return null;
    }
}
