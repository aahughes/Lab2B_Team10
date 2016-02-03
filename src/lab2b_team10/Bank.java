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
    static Scanner scan = new Scanner(System.in);
    static Scanner doublescan = new Scanner(System.in);
    static double defaultInterestRate = 0.75;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double currentInterestRate = defaultInterestRate;
        Customer customer = createCustomer(createAccount(currentInterestRate));
        System.out.println("New Customer Created: " + customer.getName() + ", Account: " + customer.getAccountNum());
        
    }
    
    // Run to create a new account
    public static Account createAccount(double currentInterestRate){
        boolean accountCreated = false;
        double newBalance;
        Account newAccount = null;
        while (!accountCreated){
            System.out.println("Please specify account type: Checking or Savings.");
            String accountType = scan.nextLine();
            switch (accountType) {
                case "Checking":
                    System.out.println("Please enter initial balance.");
                    newBalance = doublescan.nextDouble();
                    newAccount = new Checking(newBalance);
                    accountCreated = true;
                    break;
                case "Savings":
                    System.out.println("Please enter initial balance.");
                    newBalance = doublescan.nextDouble();
                    newAccount = new Savings(newBalance, currentInterestRate);
                    accountCreated = true;
                    break;
                default:
                    System.out.println("Invalid account type.");
                    break;
            }
        }
        return newAccount;
    }
    
    // Run to create a new Customer when given an Account (create Account first)
    public static Customer createCustomer(Account customerAccount){
        boolean customerCreated = false;
        Customer newCustomer = null;
        while (!customerCreated){
            System.out.println("Please specify customer type: Business or Personal.");
            String customerType = scan.nextLine();
                switch (customerType) {
                    case "Personal":
                        System.out.println("Please enter first name, then last name.");
                        String first = scan.nextLine();
                        String last = scan.nextLine();
                        newCustomer = new Personal(customerAccount.getNumber(),first,last);
                        customerCreated = true;
                        break;
                    case "Business":
                        System.out.println("Please enter business name.");
                        String name = scan.nextLine();
                        newCustomer = new Business(customerAccount.getNumber(),name);
                        customerCreated = true;
                        break;
                    default:
                        System.out.println("Invalid type.");
                        break;
                }
        }
        return newCustomer;
    }
    
    
    
}
