package edu.mum.cs.asd.framework.model;

import java.util.ArrayList;
import java.util.List;

public abstract class Customer implements ICustomer {

    private String name;
    private String street;
    private String city;
    private String state;
    private String zipcode;
    private String email;
    private List<IAccount> accounts;

    public Customer(String name, String street, String city, String state,
            String zipcode, String email) {

        this.name = name;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.email = email;
        accounts = new ArrayList<>();
    }

    @Override
    public void addAccount(IAccount account) {
        accounts.add(account);
    }

    @Override
    public void removeAccount(IAccount account) {
        accounts.remove(account);
    }

    @Override
    public List<IAccount> getAccounts() {
        return accounts;
    }

    @Override
    public void sendEmail(String s) {
        System.out.println("Sending email to: " + name);
    }

    /* Getters */
    public final String getName() {
        return name;
    }

    public final String getStreet() {
        return street;
    }

    public final String getCity() {
        return city;
    }

    public final String getState() {
        return state;
    }

    public final String getZipcode() {
        return zipcode;
    }

    public final String getEmail() {
        return email;
    }

    @Override
    public abstract String getType();

    @Override
    public String toString() {
        return name;
    }

    @Override
    public String getVal(String key) {
        switch (key) {
            case "name":
                return name;
            case "street":
                return street;
            case "city":
                return city;
            case "zip":
                return zipcode;
            case "state":
                return state;
            default:
                return null;
        }
    }

}
