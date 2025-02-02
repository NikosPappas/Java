/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.contactlistapp;

/**
 *
 * @author nikos-pappas
 */
public class Contact {
    private String name;
    private String phoneNumber;
    private String email;
    
    public Contact(String n,String pn,String eM){
        this.name=n;
        this.phoneNumber=pn;
        this.email=eM;
    }
    public void setName(String n){
        this.name=n;
    }
    public void setPhoneNumber(String pn){
        this.phoneNumber=pn;
    }
    public void setEmail(String s){
        this.email=s;
    }
    public String getName(){
        return this.name;
    }
    public String getPhoneNumber(){
        return this.phoneNumber;
    }
    public String getEmail(){
        return this.email;
    }
    @Override
    public String toString(){
        return String.format("Name: %s, Phone:%s, Email:%s",this.name,this.phoneNumber,this.email);
    }
}
