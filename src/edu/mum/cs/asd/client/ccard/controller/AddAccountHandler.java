package edu.mum.cs.asd.client.ccard.controller;

import edu.mum.cs.asd.client.bank.model.BankFactory;
import edu.mum.cs.asd.client.bank.view.CompanyAccountDialog;
import edu.mum.cs.asd.client.bank.view.PersonalAccountDialog;
import edu.mum.cs.asd.framework.controller.EventHandler;
import edu.mum.cs.asd.framework.controller.FinancialCompany;
import edu.mum.cs.asd.framework.model.Factory;
import edu.mum.cs.asd.framework.view.GUI;


public class AddAccountHandler implements EventHandler {
	public Factory Unnamed1;
	public PersonalAccountDialog Unnamed2;
	public CompanyAccountDialog Unnamed3;
	public BankFactory Unnamed4;

    @Override
    public void handle(Factory factory, GUI gui, FinancialCompany fCompany) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
