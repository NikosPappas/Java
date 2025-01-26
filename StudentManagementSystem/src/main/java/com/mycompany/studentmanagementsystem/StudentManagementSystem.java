/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.studentmanagementsystem;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author nikos-pappas
 */
public class StudentManagementSystem {
    private static final String DATA_FILE = "students.json";
    private static final StudentFileManager fileManager = new StudentFileManager(DATA_FILE);
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Student> students = fileManager.loadStudentsFromFile();
        boolean running = true;

        System.out.println("Welcome to the Student Management System!");

        while(running){
          displayMenu();
          System.out.print("Enter your choice: ");
          String choice = scanner.nextLine();

          switch (choice){
            case "1":
                addStudent(scanner,students);
                break;
            case "2":
                listStudents(students);
                break;
            case "3":
                searchStudent(scanner, students);
                break;
            case "4":
              updateStudentGrade(scanner, students);
              break;
            case "5":
                deleteStudent(scanner, students);
                break;
            case "6":
              running = false;
                System.out.println("Saving data and exiting...");
                fileManager.saveStudentsToFile(students);
                System.out.println("Goodbye!");
              break;
            default:
              System.out.println("Invalid choice. Please try again.");
          }
        }
        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. Add Student");
        System.out.println("2. List Students");
        System.out.println("3. Search Student");
        System.out.println("4. Update Student Grade");
        System.out.println("5. Delete Student");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void addStudent(Scanner scanner, List<Student> students) {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        System.out.print("Enter student ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter student grade: ");
        String grade = scanner.nextLine();
        Student student = new Student(name, id, grade);
        students.add(student);
        System.out.println("Student added: " + name + "\n");
    }

    private static void listStudents(List<Student> students) {
      if (students.isEmpty()) {
        System.out.println("No students found.\n");
          return;
        }
      System.out.println("Students:");
      for (Student student : students) {
        System.out.println("Name: " + student.getName() + ", ID: " + student.getId() + ", Grade: " + student.getGrade());
      }
        System.out.println("");
    }

    private static void searchStudent(Scanner scanner, List<Student> students) {
      if (students.isEmpty()) {
          System.out.println("No students found to search.\n");
          return;
        }
        System.out.print("Enter student ID or name to search: ");
        String searchTerm = scanner.nextLine().trim().toLowerCase();
        boolean found = false;
        System.out.println("Search results:");
        for (Student student : students) {
            if (student.getId().toLowerCase().contains(searchTerm) || student.getName().toLowerCase().contains(searchTerm)) {
                System.out.println("Name: " + student.getName() + ", ID: " + student.getId() + ", Grade: " + student.getGrade());
                found = true;
            }
        }
        if(!found) {
            System.out.println("No student found with that ID or Name.\n");
        }
    }
    private static void updateStudentGrade(Scanner scanner, List<Student> students) {
      if (students.isEmpty()) {
          System.out.println("No students found to update.\n");
          return;
      }

      System.out.print("Enter the ID of the student to update the grade: ");
        String id = scanner.nextLine();
        boolean found = false;
        for (int i = 0; i < students.size(); i++) {
           Student student = students.get(i);
           if (student.getId().equals(id)) {
              System.out.print("Enter the new grade: ");
                String newGrade = scanner.nextLine();
                students.set(i, new Student(student.getName(),student.getId(), newGrade));
                System.out.println("Grade updated for student " + student.getName() + ".\n");
                found = true;
                break;
           }
        }
        if(!found){
          System.out.println("No student found with that ID.\n");
        }

    }
    private static void deleteStudent(Scanner scanner, List<Student> students) {
      if (students.isEmpty()) {
          System.out.println("No students found to delete.\n");
          return;
      }

        System.out.print("Enter the ID of the student to delete: ");
        String id = scanner.nextLine();
        for(int i =0; i < students.size(); i++){
            if(students.get(i).getId().equals(id)){
               students.remove(i);
               System.out.println("Student deleted.\n");
                return;
            }
        }
      System.out.println("No student found with that ID.\n");
    }
}
