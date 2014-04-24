package edu.mum.cs.asd.client.ccard.model;

import edu.mum.cs.asd.framework.model.Account;
import edu.mum.cs.asd.framework.model.Factory;
import edu.mum.cs.asd.framework.model.Customer;
import java.util.Map;

public class CCardFactory extends Factory{

    @Override
    public Account 
        createAccount(Map<String, String> attributes, Customer customer) {
        switch (attributes.get("type")) {
            case "gold":
                return new Gold();
            case "silver":
                return new Silver();
            case "bronze":
                return new Bronze();
        }
        
        System.out.println("System does not support this type of account.");
        return null;
    }
}
