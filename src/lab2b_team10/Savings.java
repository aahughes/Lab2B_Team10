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
public class Savings extends Account {
    private double interestRate;
    
    public Savings() {
        super();
    }
    
    public Savings(double balance) {
        super(balance);
    }
    
    // set interest rate as well
    public Savings(double balance, double interestRate) {
        super(balance);
        this.interestRate = interestRate;
    }
    
    // accessor for interest rate
    public double getInterestRate() {
        return this.interestRate;
    }
    
    // mutator for interest rate
    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }
}
