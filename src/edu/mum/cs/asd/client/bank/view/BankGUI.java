package edu.mum.cs.asd.client.bank.view;

import edu.mum.cs.asd.client.bank.controller.AddAccountHandler;
import edu.mum.cs.asd.client.bank.controller.Bank;
import edu.mum.cs.asd.framework.controller.AddInterestHandler;
import edu.mum.cs.asd.framework.model.Account;
import edu.mum.cs.asd.framework.model.ApplicationNatureEnum;
import edu.mum.cs.asd.framework.model.Customer;
import edu.mum.cs.asd.framework.model.PropertiesEnum;
import edu.mum.cs.asd.framework.view.ActionButton;
import edu.mum.cs.asd.framework.view.GUI;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

public class BankGUI extends GUI {

    public ActionButton addPersonalAcctBtn;
    public ActionButton addCompanyAcctBtn;
    public ActionButton addInterestBtn;

    public BankGUI(Bank application) {
        super(application, "Bank Application", ApplicationNatureEnum.DEBIT);
    }

    @Override
    public JPanel createActionButtons() {
        JPanel actionsPanel = new JPanel();
        
        addPersonalAcctBtn = new ActionButton(PropertiesEnum.ADD_PERSONAL_ACCT.getVal(), new AddAccountHandler("PERSONAL"));
        addCompanyAcctBtn = new ActionButton(PropertiesEnum.ADD_COMPANY_ACCT.getVal(), new AddAccountHandler("COMPANY"));
        addInterestBtn = new ActionButton(PropertiesEnum.ADD_INTEREST.getVal(), new AddInterestHandler());
        
        actionsPanel.add(addPersonalAcctBtn);
        actionsPanel.add(addCompanyAcctBtn);
        actionsPanel.add(addInterestBtn);
        
        return actionsPanel;
    }

    @Override
    public DefaultTableModel createModel() {
        return new DefaultTableModel(new Object[][]{}, new String[]{"Acct Nr", "Name", "Street", "City", "State", "Zip", "P/C", "Ch/S", "Amount"});
    }

    @Override
    public void addToDataModel(Customer customer, Account account, DefaultTableModel model) {
        model.addRow(new Object[]{customer, customer.getStreet(), customer.getCity(), 
            customer.getState(), customer.getZipcode(), customer.getType(), account, account.getBalance()});
    }

    @Override
    public void updateModel() {
        for (int i = 0; i < getModel().getRowCount(); i++) {
            Account account = (Account)getModel().getValueAt(i, getModel().getColumnCount()-2);
            getModel().setValueAt(account.getBalance(), i, getModel().getColumnCount()-1);
        }
    }
}
