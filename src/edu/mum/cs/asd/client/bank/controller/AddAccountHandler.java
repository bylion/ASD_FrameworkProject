package edu.mum.cs.asd.client.bank.controller;

import edu.mum.cs.asd.client.bank.view.CompanyAccountDialog;
import edu.mum.cs.asd.client.bank.view.PersonalAccountDialog;
import edu.mum.cs.asd.framework.controller.EventHandler;
import edu.mum.cs.asd.framework.controller.FinancialCompany;
import edu.mum.cs.asd.framework.model.Account;
import edu.mum.cs.asd.framework.model.Customer;
import edu.mum.cs.asd.framework.model.Factory;
import edu.mum.cs.asd.framework.view.AccountDialog;
import edu.mum.cs.asd.framework.view.GUI;
import java.awt.event.ActionEvent;
import java.util.Map;

public class AddAccountHandler implements EventHandler {

    public Factory factory;
    public AccountDialog accountDialog;
    protected String type;

    public AddAccountHandler(String type) {
        this.type = type;
    }

    @Override
    public void handle(GUI gui, FinancialCompany fCompany, ActionEvent event) {
        switch (type) {
            case "PERSONAL":
                accountDialog = new PersonalAccountDialog(gui, "Add Personal Account");
                break;
            case "COMPANY":
                accountDialog = new CompanyAccountDialog(gui, "Add Company Account");
                break;
        }
        accountDialog.setVisible(true);
        if (accountDialog.getUserAction() == AccountDialog.OK_ACTION) {
            Map<String, String> fields = accountDialog.getAccountFields();
            System.out.println("fields = "+fields);
            Customer c;
            if (fCompany.isCustomerExist(fields.get("name"))) {
                c = fCompany.getCustomer(fields.get("name"));
            } else {
                c = Factory.getInstance().createCustomer(fields);
                fCompany.addCustomer(c);
            }
            Account account = Factory.getInstance().createAccount(fields, c);
            
            c.addAccount(account);
            gui.updateData(c, account);
        }
    }
}
