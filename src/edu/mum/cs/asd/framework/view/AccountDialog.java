package edu.mum.cs.asd.framework.view;

import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

public abstract class AccountDialog extends JDialog {

    //Labels
    private JLabel nameLabel;
    private JLabel emailLabel;
    private JLabel streetLabel;
    private JLabel cityLabel;
    private JLabel stateLabel;
    private JLabel zipLabel;
    //Inputs
    private JTextField nameField;
    private JTextField emailField;
    private JTextField streetField;
    private JTextField cityField;
    private JTextField stateField;
    private JTextField zipField;
    //specific panel (change per application)
    private JPanel extraFieldsPanel;
    private JPanel typePanel;
    //buttons
    private JButton cancelButton;
    private JButton okButton;
    
    private int userAction = CANCEL_ACTION;
    
    //Action indicator for cancel button click
    public static final int CANCEL_ACTION = 0;
    
    //Action indicator for cancel button click
    public static final int OK_ACTION = 1;
    
    private Map<String, String> accountFields;

    public AccountDialog(JFrame parent, String title) {
        super(parent, title, true);
        accountFields = new HashMap<>();
        
        initComponents();
    }
    
    private void initComponents() {
        
        nameLabel = new JLabel("Name");
        emailLabel = new JLabel("Email");
        streetLabel = new JLabel("Street");
        cityLabel = new JLabel("City");
        stateLabel = new JLabel("State");
        zipLabel = new JLabel("Zip");
        
        nameField = new JTextField();
        emailField = new JTextField();
        streetField = new JTextField();
        cityField = new JTextField();
        stateField = new JTextField();
        zipField = new JTextField();
        
        cancelButton = new JButton("Cancel");
        okButton = new JButton("Ok");
        
        extraFieldsPanel = createExtraFields();
        extraFieldsPanel.setBounds(12, 252, 156, 50);
        
        typePanel = createTypes();
        typePanel.setBounds(36, 12, 84, 72);
        
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialogAction(evt);
            }

        });

        okButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonAction(evt);
            }

        });

        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonAction(evt);
            }

        });
        
        getContentPane().setLayout(null);
        setSize(300, 380);
        setVisible(false);
        setResizable(false);
        setModal(true);
        nameLabel.setBounds(12, 108, 48, 24);
        emailLabel.setBounds(12, 132, 48, 24);
        streetLabel.setBounds(12, 156, 48, 24);
        cityLabel.setBounds(12, 180, 48, 24);
        stateLabel.setBounds(12, 204, 48, 24);
        zipLabel.setBounds(12, 228, 96, 24);
        
        nameField.setBounds(84, 108, 156, 20);
        emailField.setBounds(84, 132, 156, 20);
        streetField.setBounds(84, 156, 156, 20);
        cityField.setBounds(84, 180, 156, 20);
        stateField.setBounds(84, 204, 156, 20);
        zipField.setBounds(84, 228, 156, 20);
        
        okButton.setBounds(48, 312, 84, 24);
        cancelButton.setBounds(156, 312, 84, 24);
        
        getContentPane().add(typePanel);

        getContentPane().add(nameLabel);
        getContentPane().add(nameField);

        getContentPane().add(streetLabel);
        getContentPane().add(streetField);

        getContentPane().add(cityLabel);
        getContentPane().add(cityField);

        getContentPane().add(stateLabel);
        getContentPane().add(stateField);
        
        getContentPane().add(zipLabel);
        getContentPane().add(zipField);

        getContentPane().add(emailLabel);
        getContentPane().add(emailField);

        getContentPane().add(extraFieldsPanel);

        getContentPane().add(okButton);
        getRootPane().setDefaultButton(okButton);
        getContentPane().add(cancelButton);
        
    }
    
    private void okButtonAction(ActionEvent event){
        userAction = OK_ACTION;
        accountFields.put("name", nameField.getText());
        accountFields.put("email", emailField.getText());
        accountFields.put("street", streetField.getText());
        accountFields.put("city", cityField.getText());
        accountFields.put("state", stateField.getText());
        accountFields.put("zip", zipField.getText());
        
        closeDialog();
    }
    
    private void cancelButtonAction(ActionEvent event){
        userAction = CANCEL_ACTION;
        closeDialog();
    }
    
    private void closeDialogAction(WindowEvent event){
        userAction = CANCEL_ACTION;
        closeDialog();
    }
    
    private void closeDialog(){
        setVisible(false);
        dispose();
    }

    public Map<String, String> getAccountFields() {
        return accountFields;
    }

    public int getUserAction() {
        return userAction;
    }

    public abstract JPanel createExtraFields();

    public abstract JPanel createTypes();
}
