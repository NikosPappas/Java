package com.mycompany.contactlistapp;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.mycompany.contactlistapp.Contact;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.lang.reflect.Type;
public class ContactListApp {

    private static ArrayList<Contact> contacts = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static final String DATA_FILE = "contacts.json";
    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    
    public static void main(String[] args) {
      loadContacts();
        boolean running = true;

        while (running) {
            printMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline left over from nextInt

            switch (choice) {
                case 1:
                    addContact();
                    break;
                case 2:
                    viewContacts();
                    break;
                case 3:
                  searchContacts();
                  break;
                case 4:
                    deleteContact();
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        System.out.println("Exiting the application.");
        scanner.close(); // Important to close the scanner
        saveContacts();
    }

    private static void printMenu() {
        System.out.println("\nContact List Application");
        System.out.println("1. Add Contact");
        System.out.println("2. View Contacts");
        System.out.println("3. Search Contacts");
        System.out.println("4. Delete Contact");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }
    
    private static void addContact() {
        System.out.print("Enter contact name: ");
        String name = scanner.nextLine();
        System.out.print("Enter phone number: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Enter email address: ");
        String email = scanner.nextLine();
        
        Contact newContact = new Contact(name, phoneNumber, email);
        contacts.add(newContact);
        System.out.println("Contact added successfully.");
        saveContacts();
    }
    
    private static void viewContacts() {
      if (contacts.isEmpty()) {
        System.out.println("No contacts to display.");
        return;
      }
    
      System.out.println("\n--- Contacts ---");
      for (Contact contact : contacts) {
        System.out.println(contact);
      }
      System.out.println("---------------\n");
    }
    
    private static void loadContacts() {
      try {
        Reader reader = Files.newBufferedReader(Paths.get(DATA_FILE));
        Type listType = new TypeToken<List<Contact>>(){}.getType();
        List<Contact> loadedContacts = gson.fromJson(reader, listType);
        if (loadedContacts != null){
           contacts.addAll(loadedContacts);
        }
        reader.close();
        System.out.println("Contacts loaded from file.");
      } catch(IOException e) {
         System.out.println("Could not load contacts from file. Creating a new file.");
      }
    }
    
    private static void saveContacts() {
      try {
        Writer writer = Files.newBufferedWriter(Paths.get(DATA_FILE));
        gson.toJson(contacts, writer);
        writer.close();
        System.out.println("Contacts saved to file.");
      } catch (IOException e){
        System.out.println("Could not save contacts to file: " + e.getMessage());
      }
    }
    
    private static void searchContacts() {
      System.out.print("Enter name to search for: ");
      String searchTerm = scanner.nextLine();
      
      boolean found = false;
      System.out.println("\n--- Search Results ---");
      for (Contact contact : contacts) {
        if (contact.getName().toLowerCase().contains(searchTerm.toLowerCase())) {
          System.out.println(contact);
          found = true;
        }
      }
      
      if (!found) {
        System.out.println("No contacts found matching that name.");
      }
      System.out.println("----------------------\n");
    }
    
    private static void deleteContact() {
      System.out.print("Enter the name of the contact to delete: ");
      String nameToDelete = scanner.nextLine();
      
      boolean removed = false;
      for (int i = 0; i < contacts.size(); i++) {
        if (contacts.get(i).getName().equalsIgnoreCase(nameToDelete)) {
           contacts.remove(i);
           removed = true;
           System.out.println("Contact '" + nameToDelete + "' deleted successfully.");
           break; // Exit the loop as it is not needed anymore
        }
      }
      
      if (!removed) {
          System.out.println("Contact '" + nameToDelete + "' not found.");
      }
      
      saveContacts();
    }
}