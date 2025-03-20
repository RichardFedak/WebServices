package homework5service;

import java.util.Date;

import javax.jws.WebService;

@WebService(targetNamespace = "http://homework5service/", endpointInterface = "homework5service.ETicketService", portName = "ETicketServiceImplPort", serviceName = "ETicketServiceImplService")
public class ETicketServiceImpl implements ETicketService {

    public ETicket generateETicket(int athleteId) {
    	int base = (int) (Math.random() * 909) + 1;
        int ticketId = base * 11; 
        Date ticketDate = new Date();

        return new ETicket(ticketId, ticketDate, athleteId);
    }
    
    public boolean checkETicketValidity(int eTicketId) {
        return eTicketId % 11 == 0;
    }
}
