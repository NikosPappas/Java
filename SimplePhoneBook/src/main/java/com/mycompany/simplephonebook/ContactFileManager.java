/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.simplephonebook;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author nikos-pappas
 */
public class ContactFileManager {
    private final String filePath;
    private final ObjectMapper mapper;
    
    public ContactFileManager(String filePath){
        this.filePath=filePath;
        this.mapper=new ObjectMapper();
    }
    public List<Contact> loadContactsFromFile(){
        File f=new File(filePath);
        if(!f.exists()){
            return new ArrayList<Contact>();
        }
        try{
            return mapper.readValue(f,new TypeReference<List<Contact>>(){});
        }
        catch(IOException e){
            e.printStackTrace();
            return new ArrayList<Contact>();
        }
    }
    public void saveContactsToFile(List<Contact> contacts){
        try {
            mapper.writeValue(new File(filePath), contacts);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
