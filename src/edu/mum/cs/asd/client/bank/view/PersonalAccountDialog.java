package edu.mum.cs.asd.client.bank.view;

import edu.mum.cs.asd.framework.view.AccountDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PersonalAccountDialog extends AccountDialog {

    public PersonalAccountDialog(JFrame parent, String title) {
        super(parent, title);
    }

    @Override
    public JPanel createExtraFields() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public JPanel createTypes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
