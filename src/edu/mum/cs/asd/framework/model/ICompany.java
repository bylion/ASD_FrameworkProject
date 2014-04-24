package edu.mum.cs.asd.framework.model;

import java.util.List;

public interface ICompany extends ICustomer {

    public void addEmployee(IPerson person);

    public void removeEmployee(IPerson person);

    public List<IPerson> getEmployees();

    public int getNumOfEmployees();
}
