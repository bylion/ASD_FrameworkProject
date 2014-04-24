package edu.mum.cs.asd.framework.model;

public class Person extends Customer implements IPerson {

    private String birthDate;

    public Person(String name, String street, String city, String state,
            String zipcode, String email, String birthDate) {

        super(name, street, city, state, zipcode, email);
        this.birthDate = birthDate;
    }

    @Override
    public String getBirthDate() {
        return birthDate;
    }

    @Override
    public String getType() {
        return "P";
    }

    @Override
    public String getVal(String key) {
        if("noOfEmployees".equals(key))
            return birthDate;
        return super.getVal(key);
    }

}
