package homework5service;

import java.util.Date;

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
