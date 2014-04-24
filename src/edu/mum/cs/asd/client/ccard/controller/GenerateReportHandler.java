package edu.mum.cs.asd.client.ccard.controller;

import edu.mum.cs.asd.framework.controller.EventHandler;
import edu.mum.cs.asd.framework.controller.FinancialCompany;
import edu.mum.cs.asd.framework.model.Account;
import edu.mum.cs.asd.framework.model.Customer;
import edu.mum.cs.asd.framework.view.GUI;
import edu.mum.cs.asd.framework.view.ReportDialog;
import java.awt.event.ActionEvent;

public class GenerateReportHandler implements EventHandler {

    @Override
    public void handle(GUI gui, FinancialCompany fCompany, ActionEvent event) {
        StringBuilder sb = new StringBuilder();
        for (Customer customer : fCompany.getCustomers()) {
            for (Account acct : customer.getAccounts()) {
                sb.append(acct.generateMonthlyReport()).append('\n');
            }
        }
        ReportDialog rd = new ReportDialog(gui, "Report", sb.toString());
        rd.setVisible(true);
    }
}
