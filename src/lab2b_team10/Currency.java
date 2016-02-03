/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2b_team10;

/**
 *
 * @author Ed Reinoso
 */
public class Currency {
    private String name;
    private String id;
    private double convRate;
    
    Currency(String name, String id, double convRate){
        this.name = name;
        this.id = id;
        this. convRate = convRate;
    }
    
    public String getName(){
        return name;
    }
}
