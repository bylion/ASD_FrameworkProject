/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.mum.cs.asd.client;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.StringStack;
import edu.mum.cs.asd.framework.controller.FinancialCompany;
import edu.mum.cs.asd.framework.model.Account;
import edu.mum.cs.asd.framework.model.ApplicationNatureEnum;
import edu.mum.cs.asd.framework.model.Customer;
import edu.mum.cs.asd.framework.view.AccountDialog;
import edu.mum.cs.asd.framework.view.GUI;
import edu.mum.cs.asd.framework.view.ReportDialog;
import edu.mum.cs.asd.framework.view.TransactionDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author whassan
 */
public class Test extends GUI{

    public Test(FinancialCompany controller, String title, ApplicationNatureEnum nature) {
        super(controller, title, nature);
    }

//    public Test() {
//        super(null, "Test");
//    }

    

    
//    @Override
    public JPanel createExtraFields() {
        JPanel panel = new JPanel();
        panel.add(new JLabel("Test1"));
        return panel;
    }

//    @Override
    public JPanel createTypes() {
        JPanel panel = new JPanel();
        panel.add(new JLabel("Test2"));
        return panel;
    }
    
    public static void main(String[] args){
//        Test test = new Test(null, "Test", ApplicationNatureEnum.CREDIT);
//        test.setVisible(true);
//        test.setResizable(true);
        
//        ReportDialog dialog = new ReportDialog(null, "Report", "Here is my first report man");
//        dialog.setVisible(true);
        
        TransactionDialog dialog = new TransactionDialog(null, "Test", "223233");
        dialog.setVisible(true);
    }

    @Override
    public void addToDataModel(Customer customer, Account account, DefaultTableModel model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public JPanel createActionButtons() {
        JPanel panel = new JPanel();
        panel.add(new JLabel("Test2"));
        return panel;
    }

    @Override
    public DefaultTableModel createModel() {
        return new DefaultTableModel(new Object[][]{}, new String[]{"Name", "Age"});
    }

    @Override
    public void updateModel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
