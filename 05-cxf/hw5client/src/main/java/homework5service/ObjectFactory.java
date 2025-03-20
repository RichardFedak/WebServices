
package homework5service;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the homework5service package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _CheckETicketValidity_QNAME = new QName("http://homework5service/", "checkETicketValidity");
    private final static QName _CheckETicketValidityResponse_QNAME = new QName("http://homework5service/", "checkETicketValidityResponse");
    private final static QName _GenerateETicket_QNAME = new QName("http://homework5service/", "generateETicket");
    private final static QName _GenerateETicketResponse_QNAME = new QName("http://homework5service/", "generateETicketResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: homework5service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CheckETicketValidity }
     * 
     */
    public CheckETicketValidity createCheckETicketValidity() {
        return new CheckETicketValidity();
    }

    /**
     * Create an instance of {@link CheckETicketValidityResponse }
     * 
     */
    public CheckETicketValidityResponse createCheckETicketValidityResponse() {
        return new CheckETicketValidityResponse();
    }

    /**
     * Create an instance of {@link GenerateETicket }
     * 
     */
    public GenerateETicket createGenerateETicket() {
        return new GenerateETicket();
    }

    /**
     * Create an instance of {@link GenerateETicketResponse }
     * 
     */
    public GenerateETicketResponse createGenerateETicketResponse() {
        return new GenerateETicketResponse();
    }

    /**
     * Create an instance of {@link ETicket }
     * 
     */
    public ETicket createETicket() {
        return new ETicket();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckETicketValidity }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CheckETicketValidity }{@code >}
     */
    @XmlElementDecl(namespace = "http://homework5service/", name = "checkETicketValidity")
    public JAXBElement<CheckETicketValidity> createCheckETicketValidity(CheckETicketValidity value) {
        return new JAXBElement<CheckETicketValidity>(_CheckETicketValidity_QNAME, CheckETicketValidity.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckETicketValidityResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CheckETicketValidityResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://homework5service/", name = "checkETicketValidityResponse")
    public JAXBElement<CheckETicketValidityResponse> createCheckETicketValidityResponse(CheckETicketValidityResponse value) {
        return new JAXBElement<CheckETicketValidityResponse>(_CheckETicketValidityResponse_QNAME, CheckETicketValidityResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GenerateETicket }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GenerateETicket }{@code >}
     */
    @XmlElementDecl(namespace = "http://homework5service/", name = "generateETicket")
    public JAXBElement<GenerateETicket> createGenerateETicket(GenerateETicket value) {
        return new JAXBElement<GenerateETicket>(_GenerateETicket_QNAME, GenerateETicket.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GenerateETicketResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GenerateETicketResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://homework5service/", name = "generateETicketResponse")
    public JAXBElement<GenerateETicketResponse> createGenerateETicketResponse(GenerateETicketResponse value) {
        return new JAXBElement<GenerateETicketResponse>(_GenerateETicketResponse_QNAME, GenerateETicketResponse.class, null, value);
    }

}
