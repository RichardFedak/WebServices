package hw2;

import java.util.Date;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ETicket {
    public int id;
    public Date date;
    public int athleteId;

    public ETicket() {
    }

    public ETicket(int id, Date date, int athleteId) {
        this.id = id;
        this.date = date;
        this.athleteId = athleteId;
    }
}
