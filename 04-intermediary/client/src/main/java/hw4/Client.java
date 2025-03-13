package hw4;

import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPBodyElement;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;
import javax.xml.ws.Service;


public class Client {

	public static void main(String[] args) throws Exception {
		// TEST...
		URL url = new URL("http://127.0.0.1:8000/ETicketService?wsdl");
		QName qname = new QName("http://hw4/", "ETicketServiceImplService");
		Service service = Service.create(url, qname);
		ETicketService generator = service.getPort(ETicketService.class);
		System.out.println("Ticket ID: " + generator.generateETicket(37).id);
		
		// HW SAAJ
		
		SOAPConnectionFactory soapcf = SOAPConnectionFactory.newInstance();
        SOAPConnection soapc = soapcf.createConnection();

        MessageFactory mf = MessageFactory.newInstance();
        SOAPMessage soapm = mf.createMessage();
        
        SOAPPart soapp = soapm.getSOAPPart();
        SOAPEnvelope soape = soapp.getEnvelope();
        SOAPBody soapb = soape.getBody();

        soape.getHeader().detachNode();

        QName generateETicketName = new QName("http://hw4/", "generateETicket", "ns2");
        SOAPElement generateETicketElement = soapb.addBodyElement(generateETicketName);

        generateETicketElement.addChildElement(new QName("http://hw4/", "arg0", "ns2")).addTextNode("37");

        String endpoint = "http://127.0.0.1:8000/ETicketService";
        
        SOAPMessage response = soapc.call(soapm, endpoint);
        soapc.close();

        SOAPBody responseBody = response.getSOAPBody();

        if (responseBody.hasFault()) {
            System.out.println("SOAP Fault: " + responseBody.getFault().getFaultString());
        } else {
            QName generateETicketResponseName = new QName("http://hw4/", "generateETicketResponse", "ns2");
            QName returnName = new QName("return");
            QName ticketIdName = new QName("id");

            SOAPBodyElement generateETicketResponse = (SOAPBodyElement) responseBody.getChildElements(generateETicketResponseName).next();
            
            SOAPBodyElement returnElement = (SOAPBodyElement) generateETicketResponse.getChildElements(returnName).next();
            
            SOAPElement ticketIdElement = (SOAPElement) returnElement.getChildElements(ticketIdName).next();

            System.out.println("Generated Ticket ID: " + ticketIdElement.getValue());
        }
	}
}
