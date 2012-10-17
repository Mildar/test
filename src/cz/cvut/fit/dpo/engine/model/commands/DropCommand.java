/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.cvut.fit.dpo.engine.model.commands;

import cz.cvut.fit.dpo.engine.model.Game;

/**
 *
 * @author Martin
 */
public class DropCommand extends UndefinedCommand{

    @Override
    public String execute() {
        String itemName = "";
        for (String partialName : commandArguments){
            itemName += partialName;
        }  
            if (Game.getGame().TransferItemFromPlayer(itemName)){
                return "Položil jsi "+itemName;
            }
            return itemName + " se ti nepovedlo položit";
    }

    public DropCommand() {
        this.commandType = "Drop";
    }    
    
}
