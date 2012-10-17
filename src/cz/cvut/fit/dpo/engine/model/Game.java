/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.cvut.fit.dpo.engine.model;

import cz.cvut.fit.dpo.engine.model.commands.CommandInterface;
import cz.cvut.fit.dpo.engine.View;
import java.util.ArrayList;
import java.util.Collection;
/**
 *
 * @author Hanz
 */
public class Game {
    
        private Player player;
        private Collection<Room> listRooms;
        private Room actualRoom;
        //private Collection<CommandInterface> history = new ArrayList<>();
        private static volatile Game GAME = null;
        
        static public Game getGame(){
            if (GAME == null ) {
                synchronized( Game.class ) {
                if (GAME == null ) {
                    GAME = new Game();
                        }
                    }
                }
            return GAME;

        }
        
        public String proccedCommand(CommandInterface executedCommand){
            //history.add(executedCommand);
            
            return executedCommand.execute();
            
        }
        public boolean TransferItemFromPlayer(String itemName){
            Item item = player.removeItem(itemName);
            if (item == null) {
                return false;
            }
            actualRoom.addItem(item);
            return true;            
        }
        public boolean TransferItemToPlayer(String itemName){
            Item item = actualRoom.removeItem(itemName);
            if (item == null) {
                return false;
            }
            if (player.addItem(item)){
                return true;
            }
            return false;   
        }
}
