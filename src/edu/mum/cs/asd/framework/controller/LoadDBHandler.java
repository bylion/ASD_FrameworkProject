package edu.mum.cs.asd.framework.controller;

import edu.mum.cs.asd.framework.model.Account;
import edu.mum.cs.asd.framework.model.Customer;
import edu.mum.cs.asd.framework.view.GUI;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.table.DefaultTableModel;

public class LoadDBHandler implements EventHandler {

    @Override
    public void handle(GUI gui, FinancialCompany fCompany, ActionEvent event) {
        File file = new File("financialData");
        List<Customer> customers = null;
        try {
            if (file.exists()) {
                ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
                customers = (List<Customer>) objectInputStream.readObject();

                if (customers != null) {
                    fCompany.getCustomers().addAll(customers);
                    for (Customer cust : fCompany.getCustomers()) {
                        for (Account acct : cust.getAccounts()) {
                            gui.updateData(cust, acct);
                        }
                    }
                }

            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(LoadDBHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(LoadDBHandler.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (customers == null) {
                file.delete();
            }
        }
    }
}
