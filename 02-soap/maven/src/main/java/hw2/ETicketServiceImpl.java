package hw2;

import java.util.Date;
import jakarta.jws.WebService;

@WebService(endpointInterface = "hw2.ETicketService")
public class ETicketServiceImpl implements ETicketService {

    @Override
    public ETicket generateETicket(int athleteId) {
    	int base = (int) (Math.random() * 909) + 1;
        int ticketId = base * 11; 
        Date ticketDate = new Date();

        return new ETicket(ticketId, ticketDate, athleteId);
    }
    
    @Override
    public boolean checkETicketValidity(int eTicketId) {
        return eTicketId % 11 == 0;
    }
}
