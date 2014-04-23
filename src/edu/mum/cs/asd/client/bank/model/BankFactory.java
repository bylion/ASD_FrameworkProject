package edu.mum.cs.asd.client.bank.model;

import edu.mum.cs.asd.framework.model.Account;
import edu.mum.cs.asd.framework.model.Factory;
import edu.mum.cs.asd.framework.model.ICustomer;
import java.util.Map;

public class BankFactory extends Factory {

    @Override
    public Account createAccount(Map<String, String> attributes, ICustomer customer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
