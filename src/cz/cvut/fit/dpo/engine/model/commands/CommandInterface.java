/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.cvut.fit.dpo.engine.model.commands;

/**
 *
 * @author Hanz
 */
public interface CommandInterface {
    
        //public enum commandType {GO , DROP, PICKUP, USE, TALK, UNDEFINED};
        public String execute();
        public String getCommandType();
        public void setCommandArguments(String [] commandArguments);
}
