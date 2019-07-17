/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gserver;

/**
 *
 * @author nikolaosgp
 * guess the number game 
 * Server send greeting message.
 * Client receives the message.
 * Client start guessing the number.
 * connection terminates when the number
 * is found.
 */
import java.net.ServerSocket;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.IOException;

public class GServer {
     ServerSocket ss;
     Socket s;
     BufferedReader in;
     PrintWriter out;
     final static int port=1234;
     
     
     public GServer(){
         try{
             ss = new ServerSocket(port);
             s = ss.accept();
             in = new BufferedReader(new InputStreamReader(s.getInputStream()));
             out = new PrintWriter(s.getOutputStream(),true);
             System.out.println("Server created on port: "+ss);
             System.out.println("New connection: "+s);
         }
         catch(IOException ioe){
             System.out.println(ioe);
         }
     }
     
     public int generateNumber(){
         return (int)(Math.random()*1000);
     }
     public void start(){
         int number = generateNumber();
         System.out.println(number);
         try{
             out.println("Welcome!!!Guess a number between 0 and 1000 and be the winner");
             while(true){
                 int userInput=Integer.valueOf(in.readLine());
             
                 if(userInput<number){
                     out.println("Too low");
                 }
                 else if(userInput>number){
                     out.println("Too high");
                 }
                 else{
                     out.println("Congratulation you won!!!!!");
                     break;
                 }
             }
         }
         catch(IOException ioe){
             System.out.println(ioe);
         }
         try{
                 s.close();
                 ss.close();
                 in.close();
                 out.close();
             }
             catch(IOException ioe){
                 System.out.println(ioe);
             }
     }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        GServer gs = new GServer();
        gs.start();
    }
    
}
