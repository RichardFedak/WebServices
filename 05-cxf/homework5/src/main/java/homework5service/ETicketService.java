package homework5service;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(name = "ETicketService", targetNamespace = "http://homework5service/")
public interface ETicketService {
    
    @WebMethod(operationName = "generateETicket", action = "urn:GenerateETicket")
	public ETicket generateETicket(int athleteId);
    
    @WebMethod(operationName = "checkETicketValidity", action = "urn:CheckETicketValidity")
	public boolean checkETicketValidity(int eTicketId);
}