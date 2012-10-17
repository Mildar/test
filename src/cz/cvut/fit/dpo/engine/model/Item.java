/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.cvut.fit.dpo.engine.model;

/**
 *
 * @author Hanz
 */
public class Item {
    
    private String name;
    private Integer weight;

    Item(String name, Integer weight){
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public Integer getWeight() {
        return weight;
    }
    
}
        
