package edu.mum.cs.asd.framework.model;

import java.util.Date;

public class Person extends Customer implements IPerson {

	private Date birthDate;
	
    public Person(String name, String street, String city, String state,
			String zipcode, String email, Date birthDate) {
    	
		super(name, street, city, state, zipcode, email);
		this.birthDate = birthDate;
	}
    
    public Date getBirthDate() {
    	return birthDate;
    }
	
}
