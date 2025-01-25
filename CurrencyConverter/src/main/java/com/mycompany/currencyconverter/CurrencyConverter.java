/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.currencyconverter;

import java.util.Scanner;

/**
 *
 * @author nikos-pappas
 */
public class CurrencyConverter {

    public static void main(String[] args) {
        System.out.println("Welcome to the terminal currency converter.");
        System.out.println("1 Ruppe");
        System.out.println("2 Dollar");
        System.out.println("3 Euro");
        Scanner sc=new Scanner(System.in);
        int choice=sc.nextInt();
        System.out.println("Enter the amount: ");
        double amount=sc.nextDouble();
        switch(choice){
            case 1:
                RuppeToOther(amount);
                break;
            case 2:
                DollarToOther(amount);
                break;
            case 3:
                EuroToOther(amount);
                break;
            default:
                System.out.println("Wrong choice.");
                break;
        }
        sc.close();
    }
    public static void RuppeToOther(double amt) {
    System.out.println("1 Ruppe = " + 0.013 + " Dollar");
    System.out.println();
    System.out.println(amt+" Ruppe = " + (amt*0.013) + " Dollar");
    System.out.println();
    System.out.println("1 Ruppe = " + 0.012 + " Euro");
    System.out.println();
    System.out.println(amt+" Ruppe = " + (amt*0.012) + " Euro");
    System.out.println();
    }
    static void DollarToOther(double amt) {
    System.out.println("1 Dollar = " + 79.37 + " Ruppe");
    System.out.println();
    System.out.println(amt+" Dollar = " + (amt*79.37) + " Ruppe");
    System.out.println();
    System.out.println("1 Dollar= " + 0.98 + " Euro");
    System.out.println();
    System.out.println(amt+" Dollar = " + (amt*0.98) + " Euro");
    }
    static void EuroToOther(double amt){
    System.out.println("1 Euro = " + 80.85 + " Ruppe");
    System.out.println();
    System.out.println(amt+" Euro = " + (amt*80.85) + " Ruppe");
    System.out.println();

    System.out.println("1 Euro = " + 1.02 + " Dollar");
    System.out.println();

    System.out.println(amt+" Euro = " + (amt*1.02) + " Dollar");
}
}
