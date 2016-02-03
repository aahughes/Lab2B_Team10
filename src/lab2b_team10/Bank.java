/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2b_team10;

import java.util.Scanner;

/**
 *
 * @author antonizoon, aahughes
 */

public class Bank {
    Scanner scan = new Scanner(System.in);
    double currentInterestRate = 0.75;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
    }
    
    
    public Account createAccount(){
        boolean accountCreated = false;
        double newBalance = 0;
        Account newAccount;
        while (!accountCreated){
            System.out.println("Please specify account type.");
            String type = scan.nextLine();
            if (type.equals("Checking")){
                System.out.println("Please enter initial balance.");
                newBalance = scan.nextDouble();
                newAccount = new Checking(newBalance);
                accountCreated = true;
            }
            else if (type.equals("Savings"))  {
                System.out.println("Please enter initial balance.");
                newBalance = scan.nextDouble();
                newAccount = new Savings(newBalance, currentInterestRate);
                accountCreated = true;
            }  
            else{
                System.out.println("Invalid account type. Could not create account.");
            }
        }
        return newAccount;
    }
}
