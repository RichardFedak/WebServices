

import java.io.IOException;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.namespace.QName;
import javax.xml.soap.*;

/**
 * Servlet implementation class ServletTest
 */
@WebServlet("/ServletTest")
public class ServletTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletTest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
            MessageFactory messageFactory = MessageFactory.newInstance();
            SOAPMessage clientRequest = messageFactory.createMessage(null, request.getInputStream());

            int divisionFactor = 1;
            SOAPHeader header = clientRequest.getSOAPHeader();
            if (header != null) {
                Iterator<?> headerElements = header.getChildElements();
                while (headerElements.hasNext()) {
                    Object next = headerElements.next();
                    if (next instanceof SOAPElement) {
                        SOAPElement element = (SOAPElement) next;
                        if ("tweak".equals(element.getLocalName()) && "http://tweaks.com/".equals(element.getNamespaceURI())) {
                            String divisibilityFactor = element.getAttribute("divisibilityFactor");
                            if (divisibilityFactor != null && !divisibilityFactor.isEmpty()) {
                                divisionFactor = Integer.parseInt(divisibilityFactor);
                            }
                        }
                    }
                }
            }

            SOAPConnectionFactory soapcf = SOAPConnectionFactory.newInstance();
            SOAPConnection soapc = soapcf.createConnection();
            String endpoint = "http://127.0.0.1:8000/ETicketService";
            SOAPMessage serviceResponse = soapc.call(clientRequest, endpoint);
            soapc.close();

            SOAPBody responseBody = serviceResponse.getSOAPBody();
            if (responseBody.hasFault()) {
            	System.out.println(responseBody.getFault().getFaultString());
            }

            QName generateETicketResponseName = new QName("http://hw4/", "generateETicketResponse", "ns2");
            QName returnName = new QName("return");
            QName ticketIdName = new QName("id");

            SOAPBodyElement generateETicketResponse = (SOAPBodyElement) responseBody.getChildElements(generateETicketResponseName).next();
            SOAPBodyElement returnElement = (SOAPBodyElement) generateETicketResponse.getChildElements(returnName).next();
            SOAPElement ticketIdElement = (SOAPElement) returnElement.getChildElements(ticketIdName).next();

            int ticketId = Integer.parseInt(ticketIdElement.getTextContent());
            int modifiedTicketId = ticketId * divisionFactor;

            ticketIdElement.setTextContent(String.valueOf(modifiedTicketId));
            
            String tweakNamespace = "http://tweaks.com/";
            SOAPHeader newHeader = serviceResponse.getSOAPPart().getEnvelope().getHeader();
            if (newHeader == null) {
                newHeader = serviceResponse.getSOAPPart().getEnvelope().addHeader();
            }
            newHeader.addNamespaceDeclaration("tweaks", tweakNamespace);

            SOAPElement tweakedHeader = newHeader.addChildElement("tweaked", "tweaks", tweakNamespace);
            tweakedHeader.setTextContent("ID divisible by: " + divisionFactor);

            response.setContentType("text/xml; charset=UTF-8");
            serviceResponse.writeTo(response.getOutputStream());

        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(500);
        }
	}

}
