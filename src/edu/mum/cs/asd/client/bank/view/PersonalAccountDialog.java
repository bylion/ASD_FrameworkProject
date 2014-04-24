package edu.mum.cs.asd.client.bank.view;

import edu.mum.cs.asd.framework.view.AccountDialog;
import java.util.Map;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class PersonalAccountDialog extends AccountDialog {

    private ButtonGroup btnGroup;
    private JRadioButton checkingBtn;
    private JRadioButton savingBtn;
    
    private JLabel birthdateLabel;
    private JTextField birthdateField;
    
    public PersonalAccountDialog(JFrame parent, String title) {
        super(parent, title);
    }

    @Override
    public JPanel createExtraFields() {
        JPanel jPanel = new JPanel();
        
        jPanel.setLayout(null);
        birthdateLabel = new JLabel("Birthdate");
        birthdateLabel.setBounds(0, 0, 96,24);
        
        birthdateField = new JTextField();
        birthdateField.setBounds(110, 0, 156,20);
        
        jPanel.add(birthdateLabel);
        jPanel.add(birthdateField);
        
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
    
    @Override
    public Map<String, String> getAccountFields() {
        Map<String, String> map = super.getAccountFields();
        map.put("birthdate", birthdateField.getText());
        map.put("type", savingBtn.isSelected() ? "saving" : "checking");
        return map;
    }
}
