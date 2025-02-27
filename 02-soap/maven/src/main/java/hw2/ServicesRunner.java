package hw2;

import jakarta.xml.ws.Endpoint;

public class ServicesRunner {

	public static void main(String[] args) {
        Endpoint.publish("http://127.0.0.1:8000/VerificationService", new VerificationServiceImpl());
        Endpoint.publish("http://127.0.0.1:8000/ETicketService", new ETicketServiceImpl());
	}
}
