
package homework5service.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * This class was generated by Apache CXF 3.5.11
 * Thu Mar 20 12:00:25 CET 2025
 * Generated source version: 3.5.11
 */

@XmlRootElement(name = "checkETicketValidity", namespace = "http://homework5service/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "checkETicketValidity", namespace = "http://homework5service/")

public class CheckETicketValidity {

    @XmlElement(name = "eTicketId")
    private int eTicketId;

    public int getETicketId() {
        return this.eTicketId;
    }

    public void setETicketId(int newETicketId)  {
        this.eTicketId = newETicketId;
    }

}

