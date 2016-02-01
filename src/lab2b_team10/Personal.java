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
    
    
    Personal(int accountNum, String first, String last){
        super(accountNum);
        firstName = first;
        lastName = last;
    }
}
