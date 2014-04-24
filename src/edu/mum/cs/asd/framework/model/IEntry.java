package edu.mum.cs.asd.framework.model;

import java.util.Date;

public interface IEntry {

    public Account getAccount();

    public double getAmount();

    public Date getDate();

    public double getBalanceBefore();

    public double getBalanceAfter();
    
    public void setType(TransactionTypeEnum type);
    
    public TransactionTypeEnum getType();
}
