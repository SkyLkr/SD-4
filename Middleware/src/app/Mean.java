package app;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

public class Mean implements Runnable {

    private final String MEAN_IP = "http://10.180.84.141:8080/";

    private CountDownLatch countDownLatch;
    private String message;
    private double result;

    public Mean(CountDownLatch countDownLatch, String message) {
        this.countDownLatch = countDownLatch;
        this.message = message;
    }

    public double getResult() {
        return result;
    }

    @Override
    public void run() {
        try {
            URL objUrl = new URL(MEAN_IP + "MeanServer/mean/calculate;" + message);

            HttpURLConnection connection = (HttpURLConnection) objUrl.openConnection();
            connection.setRequestMethod("GET");

            System.out.println("Mean server response message: " + connection.getResponseMessage());

            Scanner s = new Scanner(connection.getInputStream());

            result = Double.parseDouble(s.nextLine());

            s.close();

            countDownLatch.countDown();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}