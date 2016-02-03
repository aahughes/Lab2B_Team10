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
public abstract class Customer {
    private int accountNumber;
    private double accountBalance; 
    
    
    Customer(int accountNum, double accountBalance){
        this.accountNumber = accountNum;
        this.accountBalance = accountBalance;
    }
    
    abstract public String getName();
    
    public double getAccountBalance() {
        return accountBalance;
    }
    
    public int getAccountNum(){
        return accountNumber;
    }
}
