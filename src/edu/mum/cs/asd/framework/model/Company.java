package edu.mum.cs.asd.framework.model;

import java.util.ArrayList;
import java.util.List;

public class Company extends Customer implements ICompany {

    private int numOfEmployees;
    private List<IPerson> employees;

    public Company(String name, String street, String city, String state,
            String zipcode, String email, int numOfEmployees) {

        super(name, street, city, state, zipcode, email);
        this.numOfEmployees = numOfEmployees;
        employees = new ArrayList<>();
    }

    @Override
    public void addEmployee(IPerson person) {
        employees.add(person);
    }

    @Override
    public void removeEmployee(IPerson person) {
        employees.remove(person);
    }

    @Override
    public List<IPerson> getEmployees() {
        return employees;
    }

    @Override
    public int getNumOfEmployees() {
        return numOfEmployees;
    }

    @Override
    public String getType() {
        return "C";
    }

    @Override
    public String getVal(String key) {
        if ("noOfEmployees".equals(key)) {
            return "" + numOfEmployees;
        }
        return super.getVal(key);
    }

}
