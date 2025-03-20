
package homework5service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for generateETicket complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="generateETicket"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="athleteId" type="{http://www.w3.org/2001/XMLSchema}int" form="qualified"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "generateETicket", propOrder = {
    "athleteId"
})
public class GenerateETicket {

    protected int athleteId;

    /**
     * Gets the value of the athleteId property.
     * 
     */
    public int getAthleteId() {
        return athleteId;
    }

    /**
     * Sets the value of the athleteId property.
     * 
     */
    public void setAthleteId(int value) {
        this.athleteId = value;
    }

}
