package app;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

public class MiddlewareHandler implements Runnable {
    
    private Socket client;
    
    public MiddlewareHandler(Socket client) {
        this.client = client;
    }

	@Override
	public void run() {
        try {
            Scanner s = new Scanner(client.getInputStream());
            
            while(s.hasNextLine()) {
                String message = s.nextLine();

                System.out.println("Mensagem recebida: " + message);

                if (message.equalsIgnoreCase("disconnect")) break;

                String response = getResponses(message);

                PrintStream out = new PrintStream(client.getOutputStream());

                System.out.println("Response: " + response);
                out.println(response);
            }
            
            s.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    private String getResponses(String message) {
        try {
            CountDownLatch countDownLatch = new CountDownLatch(2);

            Mean mean = new Mean(countDownLatch, message);
            Thread t1 = new Thread(mean);

            Median median = new Median(countDownLatch, message);
            Thread t2 = new Thread(median);

            t1.start();
            t2.start();

            countDownLatch.await();

            return String.format("%f;%f", mean.getResult(), median.getResult());
        } catch (Exception e) {
            e.printStackTrace();
            return "ERROR";
        }
    }
}