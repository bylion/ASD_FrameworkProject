package edu.mum.cs.asd.framework.view;

import java.util.HashMap;
import java.util.Hashtable;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AccountDialog extends JDialog {

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
    
    private HashMap<String, String> accountFields;

    public AccountDialog(JFrame parent, String title) {
        super(parent, title, true);
    }

    public HashMap<String, String> getAccountFields() {
        return accountFields;
    }

    public int getUserAction() {
        return userAction;
    }

    public void createExtraFields() {

    }

    public void createTypes() {

    }
}
