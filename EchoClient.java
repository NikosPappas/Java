package echoclient;

/**
 *
 * @author nikolaosgp
 */
import java.net.Socket;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.UnknownHostException;
import java.util.Scanner;
public class EchoClient {
    public static void main(String[] args) throws IOException {

        String serverHostname = new String ("127.0.0.1");
        Socket echoSocket = null;
        PrintWriter out = null;
        BufferedReader in = null;

        try {
            
            echoSocket = new Socket(serverHostname, 1234);
            out = new PrintWriter(echoSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(
                                        echoSocket.getInputStream()));
            //System.out.println(in.readLine());
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host: " + serverHostname);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for "
                               + "the connection to: " + serverHostname);
            System.exit(1);
        }

	BufferedReader stdIn = new BufferedReader(
                                   new InputStreamReader(System.in));
	String userInput;
        System.out.println(in.readLine());
        System.out.print (">:");
	while ((userInput = stdIn.readLine()).compareToIgnoreCase("Bye")!=0) {
	    out.println(userInput);
	    System.out.println("Echo Response:"+in.readLine());
            System.out.print (">: ");
	}

	out.close();
	in.close();

	echoSocket.close();
    }
}
