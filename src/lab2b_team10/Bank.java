/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2b_team10;

import java.util.HashMap;
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
        
        initializeAccounts();
        initializeCustomers();
        
        System.out.println("Welcome to the banking interface.");
        
        //create new account or not
        System.out.println("Would you like to open a new account? Y/N");
        command = scan.nextLine();
        if (command.equals("Y") || command.equals("y")){
            Customer currentCustomer = createCustomer(createAccount(currentInterestRate));
            System.out.println("New Customer Created: " + currentCustomer.getName() + ", Account: " + currentCustomer.getAccountNum() + ", Current balance: " + getAccount(currentCustomer.getAccountNum()).getBalance());
        }
        else
            System.out.println("Exiting account creation.");
        
        // use ATM after creating account
        System.out.println("To access ATM, enter account number.");
        num = intscan.nextInt();
        if (getAccount(num) != null)
            useATM(num);
        else
            System.out.println("Invalid account number.");
        
    }
    
    
    // method prompts user for commands and execute ATM transactions until user quits
    public static void useATM(int accountNum){
        double amount = 0;
        ATM atm = new ATM(accountNum);
        System.out.println("Please input command: Withdraw, Deposit, CheckBalance, or Quit.");
        String command = scan.nextLine();
        while (!command.equals("Quit")){
            if (command.equals("CheckBalance")){
                System.out.println(atm.checkBalance());
            }
            else if (command.equals("Deposit")){
                System.out.println("Please enter deposit amount.");
                amount = doublescan.nextDouble();
                atm.deposit(amount);
            }
            else if (command.equals("Withdraw")){
                System.out.println("Please enter withdrawal amount.");          
                amount = doublescan.nextDouble();
                if (atm.checkBalance() >= amount)
                    atm.withdraw(amount);
                else
                    System.out.println("Insufficient funds.");
            }
            else if (!command.equals("Quit")){
                System.out.println("Invalid command.");
            }
            System.out.println("Please input new command: Withdraw, Deposit, CheckBalance, or Quit.");
            command = scan.nextLine();
        }
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
