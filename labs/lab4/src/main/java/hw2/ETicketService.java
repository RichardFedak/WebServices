package hw2;

@jakarta.jws.WebService
public interface ETicketService {
    
    @jakarta.jws.WebMethod
    public ETicket generateETicket(int athleteId);
    
    @jakarta.jws.WebMethod
    public boolean checkETicketValidity(int eTicketId);
}
