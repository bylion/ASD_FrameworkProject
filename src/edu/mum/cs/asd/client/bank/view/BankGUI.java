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


public class BankGUI extends GUI{
	public ActionButton Unnamed2;
	public ActionButton Unnamed3;
	public BankApplication Unnamed4;

    public BankGUI(FinancialCompany controller, String title, ApplicationNatureEnum nature) {
        super(controller, title, nature);
    }

    @Override
    public JPanel createActionButtons() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DefaultTableModel createModel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addToDataModel(Customer customer, Account account, DefaultTableModel model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateModel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
