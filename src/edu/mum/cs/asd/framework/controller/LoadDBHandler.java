package edu.mum.cs.asd.framework.controller;

import edu.mum.cs.asd.framework.view.GUI;
import java.awt.event.ActionEvent;
import java.io.File;

public class LoadDBHandler implements EventHandler {

    @Override
    public void handle(GUI gui, FinancialCompany fCompany, ActionEvent event) {
        File file = new File("financialData");
        
    }
}
