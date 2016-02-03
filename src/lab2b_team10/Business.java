/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2b_team10;

/**
 *
 * @author aahughes
 */
public class Business extends Customer{
    private String businessName;
    
    Business(int accountNum, double accountBalance, String name){
        super(accountNum, accountBalance);
        businessName = name;
    }
    
    @Override
    public String getName(){
        return businessName;
    }
}
