
package homework5service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for checkETicketValidity complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="checkETicketValidity"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="eTicketId" type="{http://www.w3.org/2001/XMLSchema}int" form="qualified"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "checkETicketValidity", propOrder = {
    "eTicketId"
})
public class CheckETicketValidity {

    protected int eTicketId;

    /**
     * Gets the value of the eTicketId property.
     * 
     */
    public int getETicketId() {
        return eTicketId;
    }

    /**
     * Sets the value of the eTicketId property.
     * 
     */
    public void setETicketId(int value) {
        this.eTicketId = value;
    }

}
