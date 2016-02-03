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
    private Account account;
    private int accountNumber;
    
    
    Customer(Account newAccount){
        this.account = newAccount;
        accountNumber = account.getNumber();
    }
    
    abstract public String getName();
    
    public int getAccountNum(){
        return accountNumber;
    }
    
    public Account getAccount(){
        return account;
    }
}
