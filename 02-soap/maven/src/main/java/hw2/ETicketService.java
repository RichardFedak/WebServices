package hw2;

@javax.jws.WebService
public interface ETicketService {
    
	@javax.jws.WebMethod
    public ETicket generateETicket(int athleteId);
    
	@javax.jws.WebMethod
    public boolean checkETicketValidity(int eTicketId);
}