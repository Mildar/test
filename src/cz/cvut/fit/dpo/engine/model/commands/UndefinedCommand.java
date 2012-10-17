/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.cvut.fit.dpo.engine.model.commands;

import cz.cvut.fit.dpo.engine.View;

/**
 *
 * @author Martin
 */
public class UndefinedCommand implements CommandInterface{

    protected String commandType;
    protected String [] commandArguments;
    

    public UndefinedCommand() {
        this.commandType = "Undefined Command";
    }
    
    @Override
    public String getCommandType() {
        return commandType;
    }
   
    @Override
    public String execute() {
        return "Promin, ale tohle neumime,zkus to jinak";
    }    

    @Override
    public void setCommandArguments(String[] commandArguments) {
        this.commandArguments = commandArguments;
    }
}
