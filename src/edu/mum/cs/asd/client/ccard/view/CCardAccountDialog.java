package edu.mum.cs.asd.client.ccard.view;

import edu.mum.cs.asd.framework.view.AccountDialog;
import java.util.Map;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class CCardAccountDialog extends AccountDialog {

    private ButtonGroup btnGroup;
    private JRadioButton goldBtn;
    private JRadioButton silverBtn;
    private JRadioButton bronzeBtn;
    
    private JTextField ccNumberField;
    private JTextField expiredDateField;
    
    private JLabel ccNumberLabel;
    private JLabel expiredDateLabel;

    public CCardAccountDialog(JFrame parent, String title) {
        super(parent, title);
    }

    @Override
    public JPanel createExtraFields() {
        JPanel jPanel = new JPanel();
        
        jPanel.setLayout(null);
        ccNumberLabel = new JLabel("CC Number");
        ccNumberLabel.setBounds(0, 0, 96,24);
        expiredDateLabel = new JLabel("Exp. Date");
        expiredDateLabel.setBounds(0, 24, 96,24);
        
        ccNumberField = new JTextField();
        ccNumberField.setBounds(110, 0, 156,20);
        expiredDateField = new JTextField();
        expiredDateField.setBounds(110, 24, 156,20);
        
        jPanel.add(ccNumberLabel);
        jPanel.add(ccNumberField);
        jPanel.add(expiredDateLabel);
        jPanel.add(expiredDateField);
        
        return jPanel;
    }

    @Override
    public JPanel createTypes() {
        JPanel jPanel = new JPanel();
        jPanel.setLayout(null);
        
        btnGroup = new ButtonGroup();
        
        goldBtn = new JRadioButton("Gold");
        goldBtn.setBounds(0, 0, 150, 24);
        btnGroup.add(goldBtn);
        
        silverBtn = new JRadioButton("Silver");
        silverBtn.setBounds(0, 24, 150, 24);
        btnGroup.add(silverBtn);
        
        bronzeBtn = new JRadioButton("Bronze");
        bronzeBtn.setBounds(0, 48, 150, 24);
        btnGroup.add(bronzeBtn);
        
        jPanel.add(goldBtn);
        jPanel.add(silverBtn);
        jPanel.add(bronzeBtn);
        
        return jPanel;
    }

    @Override
    public Map<String, String> getAccountFields() {
        Map<String, String> map = super.getAccountFields();
        map.put("ccNumber", ccNumberField.getText());
        map.put("expireDate", expiredDateField.getText());
        map.put("type", goldBtn.isSelected() ? "gold" : (silverBtn.isSelected() ? "silver" : "bronze"));
        return map;
    }
}
