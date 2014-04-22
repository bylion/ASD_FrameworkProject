package edu.mum.cs.asd.framework.model.functor;

import edu.mum.cs.asd.framework.model.Customer;

public class EmailCustomer implements IFunctor<Customer, Void> {

	private String message;
	
	public EmailCustomer(String message) {
		this.message = message;
	}
	
    @Override
    public void compute(Customer c) {
    	c.sendEmail(message);
    }

    @Override
    public Void getValue() {
        return null;
    }
}
