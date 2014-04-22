package edu.mum.cs.asd.framework.model;

import java.util.Date;

public interface IEntry {

    public IAccount getAccount();

    public double getAmount();

    public Date getDate();

    public double getBalanceBefore();

    public double getBalanceAfter();
}
