package edu.mum.cs.asd.framework.controller;

import edu.mum.cs.asd.framework.view.*;
import java.awt.event.ActionEvent;

public interface EventHandler {

    public void handle(GUI gui, FinancialCompany fCompany, ActionEvent event);
}
