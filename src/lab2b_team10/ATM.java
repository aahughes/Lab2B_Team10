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
    
    public ATM(int accountNum){
        account = Bank.getAccount(accountNum);
    }
    
    public void withdraw (double amount) {
        account.setBalance(account.getBalance() - amount);
    }
    
    public void deposit (double amount) {
        account.setBalance(account.getBalance() + amount);
    }
    
    public double checkBalance () {
        return account.getBalance();
    }
}

