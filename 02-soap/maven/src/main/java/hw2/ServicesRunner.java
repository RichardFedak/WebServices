package hw2;

import javax.xml.ws.Endpoint;

public class ServicesRunner {

	public static void main(String[] args) {
        Endpoint.publish("http://127.0.0.1:8001/VerificationService", new VerificationServiceImpl());
        Endpoint.publish("http://127.0.0.1:8001/ETicketService", new ETicketServiceImpl());
	}
}
