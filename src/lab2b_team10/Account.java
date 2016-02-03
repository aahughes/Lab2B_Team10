/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2b_team10;

/**
 *
 * @author antonizoon, aahughes
 */
public class Account {
    // class variables
    private double balance;
    private int accountNum;
    private static int currentAccountNum = 1;
    
    public Account() {
        this.accountNum = currentAccountNum;
        currentAccountNum++;
    }
    
    public Account(double balance) {
        this.accountNum = currentAccountNum;
        currentAccountNum++;
        this.balance = balance;
    }
    
    // accessor for balance
    public double getBalance() {
        return this.balance;
    }
    
    // mutator for balance
    public void setBalance(double balance) {
        this.balance = balance;
    }
    
    public int getNumber(){
        return accountNum;
    }
    
}
