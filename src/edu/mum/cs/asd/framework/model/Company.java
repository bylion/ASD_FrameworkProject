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

    public void addEmployee(IPerson person) {
        employees.add(person);
    }

    public void removeEmployee(IPerson person) {
        employees.remove(person);
    }

    public List<IPerson> getEmployees() {
        return employees;
    }

    public int getNumOfEmployees() {
        return numOfEmployees;
    }

    @Override
    public String getType() {
        return "C";
    }

}
