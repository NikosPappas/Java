package datetimeclient;

/**
 *
 * @author nikolaosgp
 */
import java.net.Socket;
import java.net.InetAddress;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.UnknownHostException;
public class DateTimeClient {

    /**
     * @param args the command line arguments
     */
    
    private Socket socket;
    private String address;
    private BufferedReader in;
    private PrintWriter out;
    private static final int port = 1234;
    
    public DateTimeClient() throws IOException,UnknownHostException{
        
        address = new String("127.0.0.1");
        socket = new Socket(address,port);
        System.out.println("Connected on server: "+address+" on port: "+port+".");
        in = new BufferedReader( new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream());
  
    }
    public void start() throws UnknownHostException,IOException{
        
        try{   
             String message = in.readLine();
             System.out.println("Received from server: "+message);
            
        }
        finally{
            out.close();
            in.close();
            socket.close();
        }
    }
    public static void main(String[] args) throws IOException,UnknownHostException {
        // TODO code application logic here
        
        DateTimeClient client = new DateTimeClient();
        client.start();
       
    }
    
}
