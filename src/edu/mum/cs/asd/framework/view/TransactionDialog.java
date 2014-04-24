package edu.mum.cs.asd.framework.view;

import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class TransactionDialog extends JDialog {

    //Labels
    private JLabel acctNumberLabel;
    private JLabel amountLabel;
    //Inputs
    private JTextField acctNumberField;
    private JTextField amountField;
    //buttons
    private JButton cancelButton;
    private JButton okButton;

    private String accountNumber;

    private int userAction = CANCEL_ACTION;

    //Action indicator for cancel button click
    public static final int CANCEL_ACTION = 0;

    //Action indicator for cancel button click
    public static final int OK_ACTION = 1;

    public TransactionDialog(JFrame parent, String title, String accountNumber) {
        super(parent, title, true);
        this.accountNumber = accountNumber;

        initComponents();
    }

    private void initComponents() {
        acctNumberLabel = new JLabel("Acct Nr");
        amountLabel = new JLabel("Amount");

        acctNumberField = new JTextField(accountNumber);
        amountField = new JTextField();

        okButton = new JButton("Ok");
        cancelButton = new JButton("Cancel");

        setModal(true);
        setVisible(false);
        setResizable(false);
        getContentPane().setLayout(null);
        setSize(277, 140);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog();
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

        acctNumberLabel.setBounds(12, 12, 48, 24);
        amountLabel.setBounds(12, 36, 48, 24);

        acctNumberField.setBounds(84, 12, 156, 20);
        amountField.setBounds(84, 36, 156, 20);

        okButton.setBounds(48, 84, 84, 24);
        cancelButton.setBounds(156, 84, 84, 24);

        getContentPane().add(acctNumberLabel);
        getContentPane().add(acctNumberField);
        getContentPane().add(amountLabel);
        getContentPane().add(amountField);
        getContentPane().add(okButton);
        getContentPane().add(cancelButton);

    }

    private void okButtonAction(ActionEvent event) {
        userAction = OK_ACTION;

        closeDialog();
    }

    private void cancelButtonAction(ActionEvent event) {
        userAction = CANCEL_ACTION;
        closeDialog();
    }

    private void closeDialogAction(WindowEvent event) {
        userAction = CANCEL_ACTION;
        closeDialog();
    }

    public int getUserAction() {
        return userAction;
    }

    private void closeDialog() {
        setVisible(false);
        dispose();
    }

    public Double getAmount() {
        Double amount = null;
        try {
            amount = Double.parseDouble(amountField.getText());
        } catch (NumberFormatException e) {
            //do nothing
        }
        return amount;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

}
