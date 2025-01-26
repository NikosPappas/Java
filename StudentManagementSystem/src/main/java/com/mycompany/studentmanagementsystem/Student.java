/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.studentmanagementsystem;

/**
 *
 * @author nikos-pappas
 */
public class Student {
    private String name;
    private String id;
    private String grade;
    
    public Student(){
        name="";
        id="";
        grade="";
    }
    public Student(String name,String id,String grade){
        this.name=name;
        this.id=id;
        this.grade=grade;
    }
    public void setName(String n){
        name=n;
    }
    public void setId(String i){
        id=i;
    }
    public void setGrade(String g){
        grade=g;
    }
    public String getName(){
        return name;
    }
    public String getId(){
        return id;
    }
    public String getGrade(){
        return grade;
    }
}
