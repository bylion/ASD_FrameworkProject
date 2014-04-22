package edu.mum.cs.asd.client.bank.view;

import edu.mum.cs.asd.client.bank.controller.BankApplication;
import edu.mum.cs.asd.framework.controller.FinancialCompany;
import edu.mum.cs.asd.framework.model.Account;
import edu.mum.cs.asd.framework.model.ApplicationNatureEnum;
import edu.mum.cs.asd.framework.model.Customer;
import edu.mum.cs.asd.framework.view.ActionButton;
import edu.mum.cs.asd.framework.view.GUI;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

public class BankGUI extends GUI {

    public ActionButton addPersonalAcctBtn;
    public ActionButton addCompanyAcctBtn;
    public BankApplication Unnamed4;

    public BankGUI(BankApplication application) {
        super(application, "Bank Application", ApplicationNatureEnum.DEBIT);
    }

    @Override
    public JPanel createActionButtons() {
        JPanel actionsPanel = new JPanel();
        
        return actionsPanel;
    }

    @Override
    public DefaultTableModel createModel() {
        return new DefaultTableModel(new Object[][]{}, new String[]{"Name", "Street", "City", "State", "Zip", "P/C", "Ch/S", "Amount"});
    }

    @Override
    public void addToDataModel(Customer customer, Account account, DefaultTableModel model) {
//        model.addRow(new Object[]{customer.});
    }

    @Override
    public void updateModel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
