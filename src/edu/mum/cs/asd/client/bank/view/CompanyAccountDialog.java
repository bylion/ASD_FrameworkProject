package edu.mum.cs.asd.client.bank.view;

import edu.mum.cs.asd.framework.view.AccountDialog;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class CompanyAccountDialog extends AccountDialog {
    
    private ButtonGroup btnGroup;
    private JRadioButton checkingBtn;
    private JRadioButton savingBtn;
    
    private JLabel employeesNoLabel;
    private JTextField employeesNoField;
    
    public CompanyAccountDialog(JFrame parent, String title) {
        super(parent, title);
    }

    @Override
    public JPanel createExtraFields() {
        JPanel jPanel = new JPanel();
        
        jPanel.setLayout(null);
        employeesNoLabel = new JLabel("No of Employees");
        employeesNoLabel.setBounds(0, 0, 96,24);
        
        employeesNoField = new JTextField();
        employeesNoField.setBounds(110, 0, 156,20);
        
        jPanel.add(employeesNoLabel);
        jPanel.add(employeesNoField);
        
        return jPanel;
    }

    @Override
    public JPanel createTypes() {
        JPanel jPanel = new JPanel();
        jPanel.setLayout(null);
        
        btnGroup = new ButtonGroup();
        
        checkingBtn = new JRadioButton("Checkings");
        checkingBtn.setBounds(0, 0, 150, 24);
        btnGroup.add(checkingBtn);
        
        savingBtn = new JRadioButton("Savings");
        savingBtn.setBounds(0, 24, 150, 24);
        btnGroup.add(savingBtn);
        
        jPanel.add(checkingBtn);
        jPanel.add(savingBtn);
        
        return jPanel;
    }
}
