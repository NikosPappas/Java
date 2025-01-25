package datetimeserver;

/**
 *
 * @author nikolaosgp
 */
import java.io.*;
import java.net.*;
import java.util.Date;
public class DateTimeServer {

    /**
     * @param args the command line arguments
     */
    private ServerSocket socketServer;
    private Socket connection;
    private final static int port =1234;
    private BufferedReader in;
    private PrintWriter out;
    
    public DateTimeServer() throws IOException{
        socketServer = new ServerSocket(port);
        System.out.println("Connected on port :"+port);
    }
    
    public void start() throws IOException{
        
        try{
            connection = socketServer.accept();
            System.out.println("Waiting for connections....");
            in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            out = new PrintWriter(connection.getOutputStream());
            Date date = new Date();
            String message = date.toString();
            out.println(message);  
        }
        finally{
            out.close();
            in.close();
            connection.close();
            socketServer.close();
        }
    }
    
    public static void main(String[] args) throws IOException{
        // TODO code application logic here
        while(true){
            DateTimeServer server = new DateTimeServer();
            server.start();
        }
    }
    
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
