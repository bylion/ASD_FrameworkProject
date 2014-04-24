package edu.mum.cs.asd.framework.model.command;

public interface ICommand {

    public void execute();
    public void undo();
    
    public static final int DEPOSIT = 1;
    public static final int WITHDRAW = 2;
    public static final int INTEREST = 3;
}
