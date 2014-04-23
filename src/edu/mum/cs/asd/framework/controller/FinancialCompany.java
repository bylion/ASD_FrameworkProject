package edu.mum.cs.asd.framework.controller;

import edu.mum.cs.asd.framework.model.*;
import edu.mum.cs.asd.framework.model.functor.IFunctor;
import edu.mum.cs.asd.framework.model.predicate.IPredicate;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;

public class FinancialCompany implements ActionListener {

    private List<ICustomer> customers;
    private FinancialProperties fProperties;

    public FinancialCompany() {
        customers = new LinkedList<>();
    }
    
    public void addCustomer(ICustomer customer) {
        customers.add(customer);
    }

    public boolean isCustomerExist(String name) {
        for (ICustomer customer : customers) {
            if (customer.toString().equals(name)) 
                return true;
        }
        return false;
    }

    public void addAccount() {
        //
    }

    public void addEntry() {
        //
    }

    public void doAll(IFunctor functor) {
        for(ICustomer customer : customers) {
            functor.compute(customer);
        }
    }

    public IAccount searchBy(IPredicate predicate) {
        for(ICustomer customer : customers) {
            for (IAccount account : customer.getAccounts()) {
                if (predicate.check(account))
                    return account;
            }
        }
        return null;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO: 
    }

    public List<ICustomer> getCustomers() {
        return customers;
    }
    
    
}
