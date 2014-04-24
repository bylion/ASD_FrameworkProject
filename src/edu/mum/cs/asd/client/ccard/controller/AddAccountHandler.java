package edu.mum.cs.asd.client.ccard.controller;

import edu.mum.cs.asd.client.ccard.view.CCardAccountDialog;
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

    private AccountDialog accountDialog;

    @Override
    public void handle(GUI gui, FinancialCompany controller, ActionEvent event) {
        accountDialog = new CCardAccountDialog(gui, "Add Credit-Card Account");
        accountDialog.setVisible(true);
        if (accountDialog.getUserAction() == AccountDialog.OK_ACTION) {
            Map<String, String> fields = accountDialog.getAccountFields();
            Customer c;
            if (controller.isCustomerExist(fields.get("name"))) {
                c = controller.getCustomer(fields.get("name"));
            } else {
                c = Factory.getInstance().createCustomer(fields);
                controller.addCustomer(c);
            }
            Account account = Factory.getInstance().createAccount(fields, c);
            c.addAccount(account);
            gui.updateData(c, account);
        }
    }
}
