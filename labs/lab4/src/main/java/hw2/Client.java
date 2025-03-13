package hw2;

import java.net.URL;
import javax.xml.namespace.QName;

import jakarta.xml.soap.MessageFactory;
import jakarta.xml.soap.SOAPBody;
import jakarta.xml.soap.SOAPBodyElement;
import jakarta.xml.soap.SOAPConnection;
import jakarta.xml.soap.SOAPConnectionFactory;
import jakarta.xml.soap.SOAPElement;
import jakarta.xml.soap.SOAPEnvelope;
import jakarta.xml.soap.SOAPMessage;
import jakarta.xml.soap.SOAPPart;
import jakarta.xml.ws.Service;


public class Client {

	public static void main(String[] args) throws Exception {
		   URL url = new URL("http://127.0.0.1:8000/ETicketService?wsdl");
		   QName qname = new QName("http://hw2/", "ETicketServiceImplService");
		   Service service = Service.create(url, qname);
		   ETicketService generator = service.getPort(ETicketService.class);
		   System.out.println(generator.generateETicket(37).id);
		   
		   SOAPConnectionFactory soapcf = SOAPConnectionFactory.newInstance();
		   SOAPConnection soapc = soapcf.createConnection();

		   MessageFactory mf = MessageFactory.newInstance();
		   SOAPMessage soapm = mf.createMessage();
		      
		   SOAPPart soapp = soapm.getSOAPPart();
		   SOAPEnvelope soape = soapp.getEnvelope();
		   SOAPBody soapb = soape.getBody();

		   soape.getHeader().detachNode();
		   QName name = new QName("http://tempuri.org/", "Add", "temp");
		   SOAPElement soapel = soapb.addBodyElement(name);

		   soapel.addChildElement(
		       new QName("http://tempuri.org/", "intA", "temp")).addTextNode("3");
		   soapel.addChildElement(
		       new QName("http://tempuri.org/", "intB", "temp")).addTextNode("4");
		   String endpoint = "http://localhost:8080/TestInter/ServletTest";
		   
		   SOAPMessage response = soapc.call(soapm, endpoint);
		   soapc.close();
		   
		   SOAPBody responseBody = response.getSOAPBody();
		   if (responseBody.hasFault()) {
		       System.out.println(responseBody.getFault().getFaultString());
		   } else {
		      
		   QName AddResponseName = new QName("http://tempuri.org/", "AddResponse");
		   QName AddResultName = new QName("http://tempuri.org/", "AddResult");

		   SOAPBodyElement AddResponse = (SOAPBodyElement)
		          responseBody.getChildElements(AddResponseName).next();
		   SOAPBodyElement AddResult = (SOAPBodyElement)
		          AddResponse.getChildElements(AddResultName).next();

		   System.out.println(AddResult.getValue());
		   }

		  }

}
