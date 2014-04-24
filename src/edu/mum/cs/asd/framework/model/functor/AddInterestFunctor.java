package edu.mum.cs.asd.framework.model.functor;

import edu.mum.cs.asd.framework.model.Account;
import edu.mum.cs.asd.framework.model.Customer;
import edu.mum.cs.asd.framework.model.Entry;
import edu.mum.cs.asd.framework.model.Factory;
import edu.mum.cs.asd.framework.model.TransactionTypeEnum;
import edu.mum.cs.asd.framework.model.command.CommandManager;
import edu.mum.cs.asd.framework.model.command.ICommand;

public class AddInterestFunctor implements IFunctor<Customer, Void> {

    
    @Override
    public void compute(Customer cust) {
        for (Account account : cust.getAccounts()) {
            double interestVal = account.getInterestValue();
            Entry entry = Factory.getInstance().createEntry(account, interestVal, TransactionTypeEnum.INTEREST);
            ICommand command = Factory.getInstance().createTransaction(entry, ICommand.INTEREST);
            CommandManager.getInstance().submit(command);
        }
    }

    @Override
    public Void getValue() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
