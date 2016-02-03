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
public class Personal extends Customer{
    private String firstName;
    private String lastName;
    
    
    Personal(Account account, String first, String last){
        super(account);
        firstName = first;
        lastName = last;
    }
    
    @Override
    public String getName(){
        return firstName + " " + lastName;
    }
}
