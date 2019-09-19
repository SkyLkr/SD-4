package app;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MiddlewareServer {
    public static void main(String[] args) {
        
        try {
            ServerSocket server = new ServerSocket(333);
            System.out.println("Server is running at address " + server.getInetAddress().getHostAddress() + " port " + server.getLocalPort());

            while(true) {
                Socket client = server.accept();

                System.out.println("Client " + client.getInetAddress() + " connected.");
                
                MiddlewareHandler handler = new MiddlewareHandler(client);

                Thread t = new Thread(handler);
                t.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}