package app;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientTest {
    public static void main(String[] args) {
        try {
            Scanner s = new Scanner(System.in);
            
            int port = 333;

            Socket client = new Socket("localhost", port);

            PrintStream out = new PrintStream(client.getOutputStream());

            Scanner in = new Scanner(client.getInputStream());

            while(true) {
                System.out.print(":>");
                String cmd = s.nextLine();

                out.println(cmd);

                System.out.println(in.nextLine());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}