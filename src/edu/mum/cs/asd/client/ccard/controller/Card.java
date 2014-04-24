package edu.mum.cs.asd.client.ccard.controller;

import edu.mum.cs.asd.client.bank.controller.Bank;
import edu.mum.cs.asd.client.ccard.model.CCardFactory;
import edu.mum.cs.asd.client.ccard.view.CCardGUI;
import edu.mum.cs.asd.framework.controller.FinancialCompany;
import edu.mum.cs.asd.framework.model.Factory;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


public class Card extends FinancialCompany {
    public static void main(String[] args){
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Bank.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Bank.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Bank.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Bank.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Card card = new Card();
    }

    public Card() {
        gui = new CCardGUI(this);
        gui.setVisible(true);
        Factory.setFactory(new CCardFactory());
    }
    
}
