package lab2b_team10;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ed Reinoso
 */
public class Check {
    private int checkNumber;
    private static int currentCheckNum = 1;  // static variable that increments each time an instance is made.
    private int accountNumber;
    
    private double amount;
    private String writtenTo;
    private Currency currency;
    
    public Check(int accountNumber, double amount, String writtenTo, Currency currency) {
        this.checkNumber = currentCheckNum;
        currentCheckNum++;  // add one for the next check
        this.accountNumber = accountNumber;
        
        this.amount = amount;
        this.writtenTo = writtenTo;
        this.currency = currency;
    }
    
    // accessors, no mutators because checks cannot be changed once written
    public int checkNumber() {
        return checkNumber;
    }
    
    public int accountNumber() {
        return accountNumber;
    }
    
    public double getAmount() {
        return amount;
    }
    
    public String writtenTo() {
        return writtenTo;
    }
    
    public Currency currency() {
        return currency;
    }
}
