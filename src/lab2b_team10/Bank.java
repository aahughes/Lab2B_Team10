/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2b_team10;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author antonizoon, aahughes
 */

public class Bank {
    static Scanner scan = new Scanner(System.in);
    static Scanner doublescan = new Scanner(System.in);
    static Scanner intscan = new Scanner(System.in);
    static double defaultInterestRate = 0.75;
    private static Map<Integer, Account> accountMap;
    private static Map<Integer, Customer> customerMap;
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double currentInterestRate = defaultInterestRate;
        String command;
        int num;
        ATM atm;
        
        initializeAccounts();
        initializeCustomers();
        
        System.out.println("Would you like to create a new account? Y/N");
        command = scan.nextLine();
        if (command.equals("Y")){
            Customer currentCustomer = createCustomer(createAccount(currentInterestRate));
            System.out.println("New Customer Created: " + currentCustomer.getName() + ", Account: " + currentCustomer.getAccountNum() + ", Current balance: " + getAccount(currentCustomer.getAccountNum()).getBalance());
        }
        else
            System.out.println("Exiting account creation.");
        
        System.out.println("To access ATM, enter account number.");
        num = intscan.nextInt();
        if (getAccount(num) != null)
            atm = new ATM(num);
        
    }
    
    private static void initializeAccounts(){
        accountMap = new HashMap<Integer, Account>();
    }
    
    private static void initializeCustomers(){
        customerMap = new HashMap<Integer, Customer>();
    }
    
    public static Account getAccount(int accountNum){
        return accountMap.get(accountNum);
    }
    
    // Run to create a new account
    public static int createAccount(double currentInterestRate){
        boolean accountCreated = false;
        double newBalance;
        Account newAccount = null;
        //Account settingBalance = new Account();
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
        accountMap.put(newAccount.getNumber(),newAccount);
        return newAccount.getNumber();
    }
    
    // Run to create a new Customer when given an account number (create Account first)
    public static Customer createCustomer(int accountNum){
        boolean customerCreated = false;
        Customer newCustomer = null;
        while (!customerCreated){
            System.out.println("Please specify customer type: Business or Personal.");
            String customerType = scan.nextLine();
                switch (customerType) {
                    case "Personal":
                        System.out.print("Please enter\nfirst name: ");
                        String first = scan.nextLine();
                        System.out.print("Last name: ");
                        String last = scan.nextLine();
                        newCustomer = new Personal(accountNum, first,last);
                        customerCreated = true;
                        break;
                    case "Business":
                        System.out.println("Please enter business name.");
                        String name = scan.nextLine();
                        newCustomer = new Business(accountNum, name);
                        customerCreated = true;
                        break;
                    default:
                        System.out.println("Invalid type.");
                        break;
                }
        }
        customerMap.put(accountNum, newCustomer);
        return newCustomer;
    } 
}
