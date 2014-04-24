package edu.mum.cs.asd.client.ccard.model;

import java.util.Date;
import java.util.List;

import edu.mum.cs.asd.framework.model.Account;
import edu.mum.cs.asd.framework.model.Customer;
import edu.mum.cs.asd.framework.model.Entry;
import edu.mum.cs.asd.framework.model.TransactionTypeEnum;
import edu.mum.cs.asd.framework.model.functor.EntryListFunctor;
import edu.mum.cs.asd.framework.model.functor.IFunctor;
import edu.mum.cs.asd.framework.model.predicate.AlwaysSufficientPredicate;
import edu.mum.cs.asd.framework.model.predicate.CurrentMonthPredicate;
import edu.mum.cs.asd.framework.model.predicate.IPredicate;

public abstract class CreditCardAccount extends Account {

    protected String expireDate;

    public CreditCardAccount(Customer customer) {
        super(customer);
    }

    public double getLastMonthBalance(List<Entry> entrys) {
        double lastBalance = 0;
        for (Entry entry : entrys) {
            switch (entry.getType()) {
                case DEPOSIT:
                case INTEREST:
                    lastBalance -= entry.getAmount();
                case WITHDRAW:
                    lastBalance += entry.getAmount();
                    break;
            }
        }
        return lastBalance;
    }

    public double getTotalMonthlyCredits(List<Entry> entrys) {
        double totalmonthlycredits = 0;

        for (Entry e : (List<Entry>) entrys) {
            if (e.getType() == TransactionTypeEnum.DEPOSIT || e.getType() == TransactionTypeEnum.INTEREST) {
                totalmonthlycredits += Math.abs(e.getAmount());
            }
        }
        return totalmonthlycredits;
    }

    public double getTotalMonthlyCharges(List<Entry> entrys) {
        double totalmonthlycharges = 0;

        for (Entry e : (List<Entry>) entrys) {
            if (e.getType() == TransactionTypeEnum.WITHDRAW) {
                totalmonthlycharges += Math.abs(e.getAmount());
            }
        }
        return totalmonthlycharges;
    }

    @Override
    public String getVal(String key) {
        switch (key) {
            case "expireDate":
                return expireDate;
            default:
                return super.getVal(key);
        }
    }

    @Override
    public String generateMonthlyReport() {
        IPredicate<Entry> predicate = new CurrentMonthPredicate(new Date().getMonth());
        IFunctor<Entry, List<Entry>> functor = new EntryListFunctor();
        // where is the Deposit and withdrawal difference
        searchEntries(predicate, functor);

        StringBuilder sb = new StringBuilder();
        sb.append("Customer: ").append(customer.getVal("name")).append('\n');
        sb.append("Account Type: ").append(getAcctType()).append('\n');
        sb.append("Previous Balance: ").append(this.getLastMonthBalance(functor.getValue())).append("\n");
        sb.append("Total Charges: ").append(this.getTotalMonthlyCharges(functor.getValue())).append("\n");
        sb.append("Total Credits: ").append(this.getTotalMonthlyCredits(functor.getValue())).append("\n");
        sb.append("New Balance: ").append(this.getNewMonthlyBalance()).append("\n");
        sb.append("Total Due: ").append(this.getMonthlyAmountDue()).append("\n");
        return sb.toString();
    }

    @Override
    public String createNotification(Entry e) {
        switch (customer.getType()) {
            case "P":
                if (e.getAmount() > 400) {
                    return "transaction amount greater than 400";
                } else if (getBalance() < 0) {
                    return "Your balance less than 0.";
                }
                break;
            case "C":
                return "Transaction is done.";
        }
        return null;
    }

    public double getNewMonthlyBalance() {
        IPredicate<Entry> predicate = new CurrentMonthPredicate(new Date().getMonth());
        IFunctor<Entry, List<Entry>> functor = new EntryListFunctor();
        // where is the Deposit and withdrawal difference
        searchEntries(predicate, functor);

        double previousbalance = this.getLastMonthBalance(functor.getValue());
        double totalcredits = this.getTotalMonthlyCredits(functor.getValue());
        double totalcharges = this.getTotalMonthlyCharges(functor.getValue());
        return previousbalance - totalcredits + totalcharges + interestRate * (previousbalance - totalcredits);
    }

    @Override
    public void withdraw(Entry e) {
        balance -= e.getAmount();
        if (balance < 0 || e.getAmount() > 400) {
            notifyCustomer(createNotification(e));
        }
    }

    @Override
    public void deposit(Entry e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IPredicate<Account> getInsufficientPredicate() {
        return new AlwaysSufficientPredicate();
    }

    public abstract double getMonthlyAmountDue();
}
