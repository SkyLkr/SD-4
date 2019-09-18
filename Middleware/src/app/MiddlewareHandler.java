package app;

import java.net.Socket;

public class MiddlewareHandler implements Runnable {
    
    Socket client;
    private final String MEAN_URL = "http://localhost:8080/MeanServer/get/mean";

    public MiddlewareHandler(Socket client) {
        this.client = client;
    }

	@Override
	public void run() {
		
	}
}