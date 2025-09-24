package heartbeat;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class EchoServer implements Runnable {
    Socket client;
    PrintWriter writer;
    Scanner scanner; 

    public EchoServer(Socket client) {
        this.client = client; 
        try {
            this.writer = new PrintWriter(client.getOutputStream());
            this.scanner = new Scanner(client.getInputStream());
        } catch ( IOException e ) {
            e.getMessage();
        }

    }

    @Override
    public void run() {
        while (true) {
            String message = scanner.nextLine();
            System.out.println(message);
            writer.println("ECHO: " + message);
            writer.flush();
            if (message.equals("quit")) {
                break;
            }
        }

        try {
            writer.close();
            scanner.close();
            client.close(); 
        } catch(IOException e) {
            e.getMessage();
        }

    }

    public static void main(String [] args) throws IOException {
        /*
        System.out.println("Server starting .... ");
        Socket client = server.accept();
        System.out.println("Client Connected!");

        InputStream in = client.getInputStream();
        Scanner scanner = new Scanner(in);
        
        String message = scanner.nextLine();
        System.out.println(message);

        OutputStream out = client.getOutputStream();
        PrintWriter writer = new PrintWriter(out);
        writer.println("ECHO: " + message);
        writer.flush();       

        server.close();
        client.close();
        scanner.close();         
         */
        try (ServerSocket server = new ServerSocket(33075)) {
            while (true) {
                Socket client = server.accept();
                EchoServer echo = new EchoServer(client);
                
                Thread thread = new Thread(echo);
                thread.start();
                

            }
        }

    }

}
