/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gclient;

/**
 *
 * @author nikolaosgp
 */
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.InetAddress;
import java.util.Scanner;
public class GClient {

    private BufferedReader in;
    private PrintWriter out;
    private Socket s;
    private InetAddress ad;
    private final static int port=1234;
    private Scanner sc;
    public GClient(){
        //In real life ad=InetAddress(Server IP)
        //the above statement is between try-catch block and
        //throws IOException 
        ad=InetAddress.getLoopbackAddress();
        try{
            s = new Socket(ad,port);
            in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            out = new PrintWriter(s.getOutputStream(),true);
            sc = new Scanner(System.in);
        }
        catch(IOException ioe){
            System.out.println(ioe);
        }
     
    }
    
    public void start(){
        int userInput;
        
        try{
            String fromServer=in.readLine();
            System.out.println(fromServer);
             while(true){
                 System.out.print("Enter guess: ");
                 userInput = sc.nextInt();
                 out.println(String.valueOf(userInput));
                 fromServer=in.readLine();
                 if(fromServer.contains("won")){
                     System.out.println(fromServer);
                     break;
                 }
                 System.out.println(fromServer);
             }
            
        }
        catch(IOException ioe){
            System.out.println(ioe);
        }
        try{
            in.close();
            out.close();
            s.close();
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
        GClient gc = new GClient();
        gc.start();
    }
    
}
