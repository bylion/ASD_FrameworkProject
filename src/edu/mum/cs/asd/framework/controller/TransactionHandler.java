package edu.mum.cs.asd.framework.controller;

import edu.mum.cs.asd.framework.model.command.*;
import edu.mum.cs.asd.framework.view.*;
import java.awt.event.ActionEvent;

public class TransactionHandler implements EventHandler {

    private CommandManager cmdManager;
    private TransactionDialog txDialog;

    @Override
    public void handle(GUI gui, FinancialCompany fCompany, ActionEvent event) {
        //TODO: Create Dialog

        //TODO: Check Ok button
        //TODO: Create check existing account
        //IEntry entry = factory.createEntry();
        //ICommand cmd = factory.createTransaction(entry);
//        cmdManager.submit(cmd);
    }
}
