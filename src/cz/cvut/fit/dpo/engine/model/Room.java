/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.cvut.fit.dpo.engine.model;

import java.util.Collection;

/**
 *
 * @author Hanz
 */
public class Room {
    
        private String name;
        private String description;
        private boolean isLocked;
        private Item unlockItem;
        private Collection <NPC> NPCs;
        private Collection <Item> items;
        private Collection <String> neighbours;
        
        public Item removeItem(String itemName){
            for (Item item : items){
                if (item.getName().equalsIgnoreCase(itemName)){
                    items.remove(item);
                    return item;
                }
            }
            return null;
        }
        public void addItem(Item item){
            items.add(item);
        }
}
