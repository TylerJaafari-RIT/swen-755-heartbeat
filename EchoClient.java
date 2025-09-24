package heartbeat;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class EchoClient {

    public static void main(String [] args) throws IOException {
        InetAddress local = InetAddress.getLocalHost();
        String hostname = local.getHostName();

        // some other process using port or you because forgot to kill server.
        Socket socket = new Socket(hostname, 33075); // switchboard? 
        
        OutputStream out = socket.getOutputStream();
        PrintWriter pw = new PrintWriter(out); 

        pw.println("hello from the other side~"); // buffers
        pw.flush(); // sends the data (finally)
        
        InputStream in = socket.getInputStream();

        Scanner scanner = new Scanner(in);
        String response = scanner.nextLine();
        System.out.println(response);

        pw.println("quit");
        pw.flush();

        socket.close();
        scanner.close();

    }
    
}
