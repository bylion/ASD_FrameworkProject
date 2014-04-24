package edu.mum.cs.asd.framework.model;

import java.util.List;

public interface ICustomer {

    public void addAccount(Account account);

    public void removeAccount(Account account);

    public List<Account> getAccounts();

    public void sendEmail(String email);
    
    public String getType();
    
    public String getVal(String key);
}
