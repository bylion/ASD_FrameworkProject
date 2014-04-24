package edu.mum.cs.asd.framework.controller;

import edu.mum.cs.asd.framework.model.Account;
import edu.mum.cs.asd.framework.model.Customer;
import edu.mum.cs.asd.framework.model.Entry;
import edu.mum.cs.asd.framework.model.Factory;
import edu.mum.cs.asd.framework.model.TransactionTypeEnum;
import edu.mum.cs.asd.framework.model.command.CommandManager;
import edu.mum.cs.asd.framework.model.command.ICommand;
import edu.mum.cs.asd.framework.view.*;
import java.awt.event.ActionEvent;

public class TransactionHandler implements EventHandler {

    private int type;
    private int accountCol;
    private int customerCol;
    private int balanceCol;
    private TransactionDialog txDialog;

    public TransactionHandler(int type, int accountCol, int customerCol, int balanceCol) {
        this.type = type;
        this.accountCol = accountCol;
        this.customerCol = customerCol;
        this.balanceCol = balanceCol;
    }

    @Override
    public void handle(GUI gui, FinancialCompany fCompany, ActionEvent event) {
        Account a = (Account) gui.getSelectedCell(accountCol);
        Customer c = (Customer) gui.getSelectedCell(customerCol);
        if (a == null || c == null) {
            return;
        }
        TransactionTypeEnum txType = TransactionTypeEnum.DEPOSIT;
        switch (type) {
            case ICommand.DEPOSIT:
                txDialog = new TransactionDialog(gui, "Deposit", a.getVal("accountNumber"));
                txType = TransactionTypeEnum.DEPOSIT;
                break;

            case ICommand.WITHDRAW:
                txDialog = new TransactionDialog(gui, "Withdraw", a.getVal("accountNumber"));
                txType = TransactionTypeEnum.WITHDRAW;
                break;
        }
        txDialog.setVisible(true);

        if (txDialog.getUserAction() == TransactionDialog.OK_ACTION) {
            Entry entry = Factory.getInstance().createEntry(a, txDialog.getAmount(), txType);

            ICommand transaction = Factory.getInstance().createTransaction(entry, type);
            CommandManager.getInstance().submit(transaction);
            gui.updateCell(a.getBalance(), balanceCol);
        }
    }
}
