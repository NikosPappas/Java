/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.todolist;

/**
 *
 * @author nikos-pappas
 */
public class Task {
    private String task_name;
    private boolean is_done;
    
    public Task(){
        task_name="";
        is_done=false;
    }
    public Task(String tn,boolean id){
        this.task_name=tn;
        this.is_done=id;
    }
    public boolean getIsDone(){
        return this.is_done;
    }
    public String getTaskName(){
        return this.task_name;
    }
    public void setTaskName(String s){
        this.task_name=s;
    }
    public void setIsDone(boolean b){
        this.is_done=b;
    }
}
