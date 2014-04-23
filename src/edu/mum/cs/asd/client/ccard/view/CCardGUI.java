package edu.mum.cs.asd.client.ccard.view;

import edu.mum.cs.asd.client.ccard.controller.AddAccountHandler;
import edu.mum.cs.asd.client.ccard.controller.GenerateReportHandler;
import edu.mum.cs.asd.framework.controller.FinancialCompany;
import edu.mum.cs.asd.framework.model.Account;
import edu.mum.cs.asd.framework.model.ApplicationNatureEnum;
import edu.mum.cs.asd.framework.model.Customer;
import edu.mum.cs.asd.framework.model.PropertiesEnum;
import edu.mum.cs.asd.framework.view.ActionButton;
import edu.mum.cs.asd.framework.view.GUI;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

public class CCardGUI extends GUI {
    public ActionButton addCardAccountBtn;
    public ActionButton generateMonthlyBillsBtn;

    public CCardGUI(FinancialCompany controller) {
        super(controller, "Credit-Card Processing Application", ApplicationNatureEnum.CREDIT);
    }
    
    public CCardGUI(FinancialCompany controller, String title, ApplicationNatureEnum nature) {
        super(controller, title, nature);
    }

    @Override
    public JPanel createActionButtons() {
        JPanel actionsPanel = new JPanel();
        
        addCardAccountBtn = new ActionButton(PropertiesEnum.ADD_CREDIT_CARD_ACCOUNT.getVal(), new AddAccountHandler());
        generateMonthlyBillsBtn = new ActionButton(PropertiesEnum.GENERATE_MONTHLY_BILLS.getVal(), new GenerateReportHandler());
        
        addCardAccountBtn.addActionListener(controller);
        generateMonthlyBillsBtn.addActionListener(controller);
        actionsPanel.add(addCardAccountBtn);
        actionsPanel.add(generateMonthlyBillsBtn);
        
        return actionsPanel;
    }

    @Override
    public DefaultTableModel createModel() {
        return new DefaultTableModel(new Object[][]{}, new String[]{"Name", "CC Number", "Expired date", "Type", "Balance"});
    }

    @Override
    public void addToDataModel(Customer customer, Account account, DefaultTableModel model) {
        model.addRow(new Object[]{customer, account.getVal("accountNumbr"), account.getVal("expireDate"), account, account.getVal("balance")});
    }

    @Override 
    public void updateModel() {
        for (int i = 0; i < getModel().getRowCount(); i++) {
            Account account = (Account)getModel().getValueAt(i, getModel().getColumnCount()-2);
            getModel().setValueAt(account.getBalance(), i, getModel().getColumnCount()-1);
        }
    }

}
