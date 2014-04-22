package edu.mum.cs.asd.framework.controller;

import edu.mum.cs.asd.framework.model.Factory;
import edu.mum.cs.asd.framework.model.functor.AddInterestFunctor;
import edu.mum.cs.asd.framework.model.functor.IFunctor;
import edu.mum.cs.asd.framework.view.GUI;

public class AddInterestHandler implements EventHandler {
    @Override
    public void handle(Factory factory, GUI gui, FinancialCompany fCompany) {
        //Create add Interest functor
        IFunctor functor = new AddInterestFunctor();
        fCompany.doAll(functor);
    }
}
