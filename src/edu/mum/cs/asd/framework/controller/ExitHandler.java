package edu.mum.cs.asd.framework.controller;

import edu.mum.cs.asd.framework.model.Account;
import edu.mum.cs.asd.framework.model.Customer;
import edu.mum.cs.asd.framework.view.GUI;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ExitHandler implements EventHandler {

    @Override
    public void handle(GUI gui, FinancialCompany fCompany, ActionEvent event) {
        ObjectOutputStream objectOutputStream = null;
        try {
            File file = new File("financialData");
            if (file.exists()) {
                file.mkdirs();
            }
            
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
            objectOutputStream.writeObject(fCompany.getCustomers());
            //objectOutputStream.writeObject(gui.getModel());
            
        } catch (IOException ex) {
            Logger.getLogger(ExitHandler.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (objectOutputStream != null) {
                    objectOutputStream.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(ExitHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        System.exit(0);
    }
}
