/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.cvut.fit.dpo.engine.model;

import java.util.List;
/**
 *
 * @author Hanz
 */
public class Player {
    
        private Integer maxLoad;
        private List<Item> load;
        
        Player(List<Item> load, Integer maxLoad){
            this.load = load;
            this.maxLoad = maxLoad;
        }
        
        public Item removeItem(String itemName){
            for (Item item : load){
                if (item.getName().equalsIgnoreCase(itemName)){
                    load.remove(item);
                    return item;
                }
            }
            return null;
        }
        public boolean addItem(Item item){
            if (countWeight() + item.getWeight() <= maxLoad){
                load.add(item);
                return true;
            }
            return false;
        }
        private int countWeight(){
            int weight=0;
            for (Item item : load){
                weight +=item.getWeight();
            }
            return weight;
        }
}
