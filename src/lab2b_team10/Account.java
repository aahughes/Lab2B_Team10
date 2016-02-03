/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2b_team10;
import java.util.Random;

/**
 *
 * @author antonizoon, aahughes
 */
public class Account {
    // class variables
    private double balance;
    
    // generate random account number
    private int accountNum;
    //final int max = 0;
    //final int min = 10000;
    private static int currentAccountNum = 1;
    
    public Account() {
        //Random rand = new Random();
       // this.accountNum = rand.nextInt((max - min) + 1) + min;
        this.accountNum = currentAccountNum;
        currentAccountNum++;
        this.balance = 0.0;     // start at $0.0
    }
    
    public Account(double balance) {
        //Random rand = new Random();
        //this.accountNum = rand.nextInt((max - min) + 1) + min;
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
