package lab2b_team10;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ed Reinoso, aahughes
 */
public class ATM {
    private Account account;
    private Check check;
    private double amount;
    
    // edit when accounts are accessible by accountNumber

    public void withdraw (int accountNumber, double amount) {
        //account = account with accountNumber
        account.setBalance(account.getBalance() - amount);
    }
    
    public void deposit (int accountNumber, double amount) {
        //account = account with accountNumber
        account.setBalance(account.getBalance() + amount);
    }
    
    public double checkBalance (int accountNumber) {
        //accountNumber = account with accountNumber
        return account.getBalance();
    }
}

