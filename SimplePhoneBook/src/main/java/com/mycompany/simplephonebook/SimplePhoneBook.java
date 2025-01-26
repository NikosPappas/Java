/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.simplephonebook;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author nikos-pappas
 */
public class SimplePhoneBook {
    private static final String DATA_FILE = "contacts.json";
    private static final ContactFileManager fileManager = new ContactFileManager(DATA_FILE);

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        List<Contact> contacts = fileManager.loadContactsFromFile();
        boolean running = true;
        System.out.println("Welcome to the Contact Book App");
        while(running){
            displayMenu();
            System.out.println("Enter your choice");
            String choice=scan.nextLine();
            System.out.println("");
            switch(choice){
                case "1" -> addContacts(scan,contacts);
                case "2" -> listContacts(contacts);
                case "3" -> searchContacts(scan,contacts);
                case "4" -> updateContact(scan,contacts);
                case "5" -> deleteContact(scan,contacts);
                case "6" -> {
                    running=false;
                    System.out.println("Saving the data and exiting....");
                    fileManager.saveContactsToFile(contacts);
                    System.out.println("Goodbye");
                }
                default -> System.out.println("Invalid choice.Please try again.");
            }
        }
        scan.close();
    }
    static void deleteContact(Scanner scan,List<Contact> contacts){
        if(contacts.isEmpty()){
            System.out.println("Phone is empty nothing to delete.");
            return;
        }
        var found=false;
        System.out.println("Type the first or the last name of the contact that will be deleted: ");
        String searchName=scan.next();
        for(int i=0;i<contacts.size();i++){
            Contact temp=contacts.get(i);
            if(temp.getFirstName().equalsIgnoreCase(searchName)||temp.getLastName().equalsIgnoreCase(searchName)){
                found=true;
                contacts.remove(i);
                break;
            }
        }
        if(!found){
            System.out.println("No contact found with that name.");
        }
        
    }
static void updateContact(Scanner scanner, List<Contact> contacts) {
      if(contacts.isEmpty()){
           System.out.println("No contacts found to update.\n");
            return;
        }
        System.out.print("Enter the first or last name of the contact to update: ");
        String searchName = scanner.nextLine();
        boolean found = false;

        for (int i = 0; i < contacts.size(); i++) {
            Contact contact = contacts.get(i);
            if(contact.getFirstName().equalsIgnoreCase(searchName) || contact.getLastName().equalsIgnoreCase(searchName)) {
                System.out.println("Enter new details (leave blank to keep current):");
                System.out.print("New First Name (" + contact.getFirstName() +"): ");
                String newFirstName = scanner.nextLine();
                if (newFirstName.isEmpty()) newFirstName = contact.getFirstName();

                System.out.print("New Last Name (" + contact.getLastName() +"): ");
                String newLastName = scanner.nextLine();
                if (newLastName.isEmpty()) newLastName = contact.getLastName();

                System.out.print("New Phone Number (" + contact.getPhoneNumber() +"): ");
                String newPhoneNumber = scanner.nextLine();
                 if (newPhoneNumber.isEmpty()) newPhoneNumber = contact.getPhoneNumber();

                System.out.print("New Email ("+ contact.getEmail()+"): ");
                String newEmail = scanner.nextLine();
                if (newEmail.isEmpty()) newEmail = contact.getEmail();

               contacts.set(i, new Contact(newFirstName,newLastName,newPhoneNumber,newEmail));
               System.out.println("Contact updated.\n");
               found = true;
               break;
            }
        }
        if(!found){
             System.out.println("No contact found with that name.\n");
        }
    }
    static void searchContacts(Scanner scan,List<Contact> contacts){
       if(contacts.isEmpty()){
           System.out.println("Contact list is empty.");
           return;
       }
       else{
           System.out.println("Type the firsname or the lastname of the contact:");
           String input=scan.next();
           boolean found=false;
           for(Contact con:contacts){
               if(con.getFirstName().contains(input) || con.getLastName().contains(input)){
               System.out.println("First Name: " + con.getFirstName() + ", Last Name: " +con.getLastName() + ", Phone: " +con.getPhoneNumber() + ", Email: " +con.getEmail());
                 found = true;
               }
           }
           if(!found){
               System.out.println("No contact found with that name.");
           }
       }
    }
    static void listContacts(List<Contact>contacts){
        if(contacts.isEmpty()){
            System.out.println("The list of contacts is empty.");
            return ;
        }
        else{
            System.out.println("Printing Contact list...");
            for(Contact con:contacts){
                System.out.println("Firstname:"+con.getFirstName());
                System.out.println("Lastname:"+con.getLastName());
                System.out.println("Phone number:"+con.getPhoneNumber());
                System.out.println("Email:"+con.getEmail());
            }
        }
    }
    static void addContacts(Scanner scan,List<Contact> contacts){
        System.out.println("Enter the first name: ");
        String firstname=scan.next();
        System.out.println("Enter the last name:");
        String lastname=scan.next();
        System.out.println("Enter the phone number:");
        String pn=scan.next();
        System.out.println("Enter the email: ");
        String email=scan.next();
        Contact con=new Contact(firstname,lastname,pn,email);
        contacts.add(con);
        System.out.println("Contact "+firstname+" "+lastname+" added");
    }
    static void displayMenu(){
        System.out.println("Menu: ");
        System.out.println("1.  Add    contact");
        System.out.println("2.  List   contact");
        System.out.println("3.  Search contact");
        System.out.println("4.  Update contact");
        System.out.println("5.  Delete contact");
        System.out.println("6.  Exit");
    }
}
