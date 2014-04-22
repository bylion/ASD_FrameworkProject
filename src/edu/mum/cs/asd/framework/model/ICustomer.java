package edu.mum.cs.asd.framework.model;

import java.util.List;

public interface ICustomer {

    public void addAccount(IAccount account);

    public void removeAccount(IAccount account);

    public List<IAccount> getAccounts();

    public void sendEmail(String email);
}
