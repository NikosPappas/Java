/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.simplephonebook;

/**
 *
 * @author nikos-pappas
 */
public class Contact {
    private String first_name;
    private String last_name;
    private String phone_number;
    private String email;
    
    public Contact(){
        first_name="";
        last_name="";
        phone_number="";
        email="";
    }
    public Contact(String fn,String ln,String pn,String email){
        this.first_name=fn;
        this.last_name=ln;
        this.phone_number=pn;
        this.email=email;
    }
    public void setFirstName(String fn){
        this.first_name=fn;
    }
    public String getFirstName(){
        return this.first_name;
    }
    public void setLastName(String ln){
        this.last_name=ln;
    }
    public String getLastName(){
        return this.last_name;
    }
    public void setPhoneNumber(String pn){
        this.phone_number=pn;
    }
    public String getPhoneNumber(){
        return this.phone_number;
    }
    public void setEmail(String email){
        this.email=email;
    }
    public String getEmail(){
        return this.email;
    }
}
