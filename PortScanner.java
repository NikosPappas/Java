
package portscanner;
import java.net.*;
import java.io.*;
import java.util.Scanner;
/**
 *
 * @author npappas
 */
public class PortScanner {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws UnknownHostException {
        // TODO code application logic here
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the lower port:");
        int lowerPort = input.nextInt();
        System.out.print("Enter upper port: ");
        int  upperPort = input.nextInt();
        String host="localhost";
        InetAddress inetAddress = InetAddress.getByName(host);
        String hostName = inetAddress.getHostName();
        for(int port=lowerPort; port<=upperPort;port++){
            
            try{
                Socket socket = new Socket(hostName,port);
                String text = hostName + " is listening on port "+ port;
                System.out.println(text);
                socket.close();
            }
            catch(IOException e){
                
            }
            
        }
        input.close();
    }
}
