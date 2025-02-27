package hw2;

import java.util.Date;
import jakarta.jws.WebService;

@WebService(endpointInterface = "hw2.ETicketService")
public class ETicketServiceImpl implements ETicketService {

    @Override
    public ETicket generateETicket(int athleteId) {
        int ticketId = (int) (Math.random() * 10000);
        Date ticketDate = new Date();

        return new ETicket(ticketId, ticketDate, athleteId);
    }
}
