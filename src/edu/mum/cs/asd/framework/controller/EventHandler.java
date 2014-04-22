package edu.mum.cs.asd.framework.controller;
import edu.mum.cs.asd.framework.model.*;
import edu.mum.cs.asd.framework.view.*;

public interface EventHandler {
	public void handle(Factory factory, GUI gui, FinancialCompany fCompany);
}
