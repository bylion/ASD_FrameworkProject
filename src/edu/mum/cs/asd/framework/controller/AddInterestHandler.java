package edu.mum.cs.asd.framework.controller;

import edu.mum.cs.asd.framework.model.functor.AddInterestFunctor;
import edu.mum.cs.asd.framework.model.functor.IFunctor;
import edu.mum.cs.asd.framework.view.GUI;
import java.awt.event.ActionEvent;

public class AddInterestHandler implements EventHandler {

    @Override
    public void handle(GUI gui, FinancialCompany fCompany, ActionEvent event) {
        //Create add Interest functor
        IFunctor functor = new AddInterestFunctor();
        fCompany.doAll(functor);
        
        gui.updateModel();
    }
}
