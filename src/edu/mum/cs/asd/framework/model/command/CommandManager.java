package edu.mum.cs.asd.framework.model.command;

import java.util.Stack;

public class CommandManager {

    private Stack<ICommand> commandsExecuted;
    
    public CommandManager() {
    	commandsExecuted = new Stack<ICommand>();
    }

    public void submit(ICommand command) {
    	commandsExecuted.push(command);
    	command.execute();
    }

    public void undo() {
    	if (!commandsExecuted.isEmpty()) {
    		commandsExecuted.pop().undo();
    	}
    }
}
