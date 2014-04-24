package edu.mum.cs.asd.framework.model.command;

import java.util.Stack;

public class CommandManager {

    private Stack<ICommand> commandsExecuted;
    private Stack<ICommand> commandsUndone;
    
    private static CommandManager manager;
    
    public static CommandManager getInstance(){
        if(manager == null){
            manager = new CommandManager();
        }
        return manager;
    }
    
    public CommandManager() {
    	commandsExecuted = new Stack<>();
    	commandsUndone = new Stack<>();
    }

    public void submit(ICommand command) {
    	commandsExecuted.push(command);
    	commandsUndone.clear();
    	command.execute();
    }

    public void undo() {
    	if (!commandsExecuted.isEmpty()) {
    		ICommand cmd = commandsExecuted.pop();
    		commandsUndone.push(cmd);
    		cmd.undo();
    	}
    }
    
    public void redo(){
    	if (!commandsUndone.isEmpty()) {
    		ICommand cmd = commandsUndone.pop();
    		commandsExecuted.push(cmd);
    		cmd.execute();
    	}
    }
}
